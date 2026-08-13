# Reproducibility Guide

This document defines the minimum procedure for technically reproducing the suites currently preserved in the repository. It does not provide a reproduction of the complete v1.1 protocol or of missing experimental observations.

The preliminary pilot and the final experiment are intentionally documented as separate study phases to preserve methodological traceability.

## Prerequisites

- Java 21
- Maven
- IntelliJ IDEA
- Docker with Docker Compose
- Access to the study materials permitted by their licenses and access policies

The final-experiment API is Swagger Petstore - OpenAPI 3.0. The contract is preserved at `docs/api-specification/swagger-petstore-openapi.json`; verify its SHA-256 against `docs/api-specification/README.md` before using it. The controlled service is defined in `datasets/petstore-feasibility-pilot/config/docker-compose.yml` and exposes `http://127.0.0.1:18080/api/v3`. The completed preliminary vehicle-domain pilot remains a separate phase and cannot be reproduced as Petstore.

Record the exact Maven, operating system, REST Assured, Cucumber, JUnit 5, IntelliJ IDEA, GitHub Copilot, and ChatGPT versions or identifiers actually observed in `EXPERIMENT_LOG.md`. Do not infer or backfill unknown versions.

## Procedure

1. Check out the exact Git commit or archived release associated with the study.
2. Verify that Java 21 is active with `java -version`.
3. Record the execution environment and timestamp in `EXPERIMENT_LOG.md`.
4. Start or reconcile the controlled Petstore with the Compose command below and verify HTTP 200 plus the served-contract checksum.
5. Use the approach-specific runner commands below. These commands validate the current suites; they do not reconstruct missing experimental timing or interaction evidence.
6. Preserve untouched final-experiment observations in `datasets/final-experiment/raw/` when available.
7. Transform final data only through documented procedures and place outputs in `datasets/final-experiment/processed/`.
8. Generate documented tables, graphs, reports, and descriptive analysis under `results/`.
9. Record deviations, failures, exclusions, reruns, and unavailable evidence in `EXPERIMENT_LOG.md`.
10. Read `docs/pt-BR/Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md` and interpret C01–C05 only as the exploratory subset actually observed.

## Controlled API

```bash
docker compose -f datasets/petstore-feasibility-pilot/config/docker-compose.yml up -d
curl -i http://127.0.0.1:18080/api/v3/openapi.json
```

The expected local base URL is `http://127.0.0.1:18080/api/v3`. The preserved local contract SHA-256 is documented in `docs/api-specification/README.md`; equality with the served contract must be verified for any new reproduction run.

## Approach-specific suite checks

### Manual

The original Manual execution was performed through `runner.TestRunner` in IntelliJ IDEA. No exact Maven command was preserved for that historical execution. The current runner can be checked technically with:

```bash
mvn -Dtest=runner.TestRunner test
```

This command is a post-hoc technical validation and must not be reported as the original Manual timing or execution command.

### ChatGPT

```bash
mvn -Dtest=chatgpt.runner.ChatGPTTestRunner test
```

### GitHub Copilot

```bash
mvn -Dtest=copilot.runner.CopilotTestRunner test
```

The generic command `mvn test` is not the authoritative record for separating the three conditions. Use the explicit runners above and keep outputs associated with the correct approach.

## Integrity and provenance

- Never overwrite raw observations.
- Give each run a stable identifier shared across logs, datasets, and results.
- Record checksums for released datasets and generated artifacts.
- Keep prompts and relevant model interaction records in the exact language used during the experiment.
- Report all manual corrections and analysis decisions.
- Use a tagged release for any archived study snapshot.
- Record live-service availability and any divergence from the preserved OpenAPI contract; never rewrite the preserved file to match an observation.

## Current reproducibility limitations

- The reproducible technical object is the current five-scenario suite under each approach, not the complete v1.1 protocol.
- The executed scenario mapping differs from the v1.1 frozen matrix; see `docs/pt-BR/Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md`.
- ChatGPT and GitHub Copilot implementation times are pending and cannot be inferred from Maven output.
- Complete V01–V50 evidence, rubric consolidations, per-unit timestamps/commits, and assisted-interaction records are not published.
- `datasets/final-experiment/raw/` and `datasets/final-experiment/processed/` currently contain no experimental observations beyond placeholders.
- Manual videos referenced by historical result files are not tracked in Git and are unavailable from the repository alone.
- The original Manual Maven command and exact IDE/library versions were not preserved.

## Expected outputs

The vehicle-domain pilot has results, but its data are not published here. The repository contains textual Manual, ChatGPT, and GitHub Copilot results for an exploratory Petstore subset, subject to the documented deviations and missing evidence. A technical rerun can confirm current executability but cannot recreate implementation effort, tool interactions, execution order, or absent validation evidence. Any reproduction package must identify its phase, keep pilot and Petstore artifacts separate, and avoid numerical combination across phases.
