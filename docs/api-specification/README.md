# Preserved Swagger Petstore OpenAPI specification

This directory preserves the API contract selected for the experimental study.

| Field | Value |
| --- | --- |
| Official source URL | `https://petstore3.swagger.io/api/v3/openapi.json` |
| Official project | `https://github.com/swagger-api/swagger-petstore` |
| Retrieval date | 2026-07-11 |
| Preserved format | JSON, exactly as retrieved from the official endpoint |
| OpenAPI Specification version | `3.0.4` (`openapi` field) |
| API document version | `1.0.27` (`info.version` field) |
| SHA-256 | `00441c05add60f28da55eb4563d3fb6bbda364ba8eb7b381e2e2c98613005c82` |
| Local file | [`swagger-petstore-openapi.json`](swagger-petstore-openapi.json) |

## Why a local copy is stored

The local copy fixes the contract used for endpoint selection, scenario design, validation planning, and future reproducibility checks. It allows every documented decision to be traced to the same bytes even if the public demonstration service or its published contract later changes.

The preserved file is research input, not a specification authored by this project. Its licensing and ownership remain those stated by the official Swagger Petstore project and inside the document.

## Public-environment warning

The public environment at `petstore3.swagger.io` is shared and may change, reset, become temporarily unavailable, or behave differently from this preserved contract. The checksum proves the identity of the local file only; it does not prove that the live service still implements the same behavior at execution time. Any observed divergence must be recorded rather than silently changing this copy or the expected contract.

## Integrity verification

```bash
shasum -a 256 docs/api-specification/swagger-petstore-openapi.json
```
