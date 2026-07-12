#!/usr/bin/env bash

set -euo pipefail

if [[ $# -ne 3 ]]; then
  echo "usage: $0 <environment> <base-url> <pilot-id>" >&2
  exit 2
fi

environment="$1"
base_url="${2%/}"
pilot_id="$3"
evidence_dir="datasets/petstore-feasibility-pilot/raw/${environment}"
mkdir -p "$evidence_dir"

request_number=0

record_request() {
  local label="$1"
  local method="$2"
  local endpoint="$3"
  local payload_file="${4:-}"
  local auth_mode="${5:-none}"
  local prefix
  local observed_at
  local status

  request_number=$((request_number + 1))
  prefix=$(printf "%02d_%s" "$request_number" "$label")
  observed_at=$(date '+%Y-%m-%dT%H:%M:%S%z')

  local curl_args=(--silent --show-error --connect-timeout 15 --max-time 45
    --request "$method" --header 'Accept: application/json'
    --dump-header "$evidence_dir/${prefix}.headers.txt"
    --output "$evidence_dir/${prefix}.body.json")

  if [[ -n "$payload_file" ]]; then
    curl_args+=(--header 'Content-Type: application/json' --data-binary "@$payload_file")
  fi
  if [[ "$auth_mode" == "invalid-api-key" ]]; then
    curl_args+=(--header 'api_key: pilot-invalid-api-key')
  fi

  status=$(curl "${curl_args[@]}" --write-out '%{http_code}' "${base_url}${endpoint}" || true)
  printf '%s\t%s\t%s\t%s\t%s\t%s\t%s\n' \
    "$request_number" "$observed_at" "$environment" "$method" "$endpoint" "$auth_mode" "$status" \
    >> "$evidence_dir/requests.tsv"
}

cat > "$evidence_dir/create-pet.json" <<EOF
{"id":${pilot_id},"name":"tcc-petstore-feasibility-${pilot_id}","photoUrls":["https://example.invalid/pilot/${pilot_id}"],"status":"available"}
EOF

cat > "$evidence_dir/update-pet.json" <<EOF
{"id":${pilot_id},"name":"tcc-petstore-feasibility-${pilot_id}-updated","photoUrls":["https://example.invalid/pilot/${pilot_id}"],"status":"pending"}
EOF

printf 'sequence\tobserved_at\tenvironment\tmethod\tendpoint\tauth_mode\thttp_status\n' > "$evidence_dir/requests.tsv"
cat > "$evidence_dir/metadata.txt" <<EOF
environment=${environment}
base_url=${base_url}
pilot_id=${pilot_id}
started_at=$(date '+%Y-%m-%dT%H:%M:%S%z')
timezone=$(date '+%Z %z')
git_commit=$(git rev-parse HEAD)
openapi_sha256=$(shasum -a 256 docs/api-specification/swagger-petstore-openapi.json | awk '{print $1}')
EOF

record_request openapi GET /openapi.json
record_request missing_no_auth GET "/pet/${pilot_id}9"
record_request missing_invalid_api_key GET "/pet/${pilot_id}9" "" invalid-api-key
record_request create_no_auth POST /pet "$evidence_dir/create-pet.json"
record_request get_after_create GET "/pet/${pilot_id}"
record_request update_no_auth PUT /pet "$evidence_dir/update-pet.json"
record_request get_after_update GET "/pet/${pilot_id}"
record_request filter_pending_first GET '/pet/findByStatus?status=pending'
sleep 2
record_request filter_pending_second GET '/pet/findByStatus?status=pending'
record_request invalid_status GET '/pet/findByStatus?status=pilot-invalid-status'
record_request invalid_id GET /pet/not-an-integer
record_request delete_no_auth DELETE "/pet/${pilot_id}"
record_request get_after_delete GET "/pet/${pilot_id}"
record_request delete_again DELETE "/pet/${pilot_id}"

printf 'finished_at=%s\n' "$(date '+%Y-%m-%dT%H:%M:%S%z')" >> "$evidence_dir/metadata.txt"
