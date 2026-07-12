# Petstore feasibility-pilot configuration

This folder is isolated from the final-experiment datasets. It contains the exact configuration and request procedure used only for the Swagger Petstore feasibility pilot.

The controlled environment uses the official `swaggerapi/petstore3` image with version tag `1.0.27` and immutable manifest digest `sha256:749432676c31cd05256f0d9e878302164debb94daa1c1223e193747e1b34e7d1`. The published manifest is `linux/amd64`; that platform is explicit because the pilot host is `linux/arm64/v8` under Docker Desktop and therefore uses emulation. The configuration binds container port `8080` to loopback-only host port `18080`. No secret or credential is configured.

The preserved commands are:

```bash
docker compose -f datasets/petstore-feasibility-pilot/config/docker-compose.yml pull
docker compose -f datasets/petstore-feasibility-pilot/config/docker-compose.yml up -d
bash datasets/petstore-feasibility-pilot/config/run-pilot.sh controlled http://127.0.0.1:18080/api/v3 PILOT_ID
docker compose -f datasets/petstore-feasibility-pilot/config/docker-compose.yml down
```

`PILOT_ID` must be an exclusive integer identifier created for this pilot. The same request procedure is invoked against the public base URL with a different pilot-only identifier.
