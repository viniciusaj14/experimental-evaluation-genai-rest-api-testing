# Reproducibility Guide

This document defines the minimum procedure for reproducing the experiment. Update it before data collection whenever the protocol changes.

## Prerequisites

- Java 21
- Maven
- IntelliJ IDEA
- Access to the study materials permitted by their licenses and access policies

The selected API for the future final experiment is Swagger Petstore - OpenAPI 3.0. The contract is preserved at `docs/api-specification/swagger-petstore-openapi.json`; verify its SHA-256 against `docs/api-specification/README.md` before using it. The completed pilot used a different unidentified vehicle-domain API and cannot be reproduced as Petstore.

Record the exact Maven, operating system, REST Assured, Cucumber, JUnit 5, IntelliJ IDEA, GitHub Copilot, and ChatGPT versions or identifiers actually observed in `EXPERIMENT_LOG.md`. Do not infer or backfill unknown versions.

## Procedure

1. Check out the exact Git commit or archived release associated with the study.
2. Verify that Java 21 is active with `java -version`.
3. Record the execution environment and timestamp in `EXPERIMENT_LOG.md`.
4. After the methodological consistency review and protocol freeze, follow `docs/pt-BR/Protocolo_Experimental.md` without changing the five scenarios, fifty planned checks, or condition-specific rules.
5. Store untouched final-experiment observations in `datasets/final-experiment/raw/`.
6. Transform final data only through documented procedures and place outputs in `datasets/final-experiment/processed/`.
7. Generate documented tables, graphs, reports, and descriptive analysis under `results/`.
8. Record deviations, failures, exclusions, and reruns in `EXPERIMENT_LOG.md`.

## Build check

```bash
mvn test
```

Swagger Petstore OpenAPI 3 is formally selected. The final operation subset, frozen scenario details, and experimental execution command remain pending methodological review. Use only operations documented from the preserved contract; do not infer endpoints or live behavior.

Before the final experiment, follow the proposed Petstore feasibility pilot in `docs/pt-BR/Piloto_de_Viabilidade.md`. Its observations must remain separate from both the completed vehicle pilot and final values. No local or containerized instance is configured by this repository at this stage.

## Integrity and provenance

- Never overwrite raw observations.
- Give each run a stable identifier shared across logs, datasets, and results.
- Record checksums for released datasets and generated artifacts.
- Keep prompts and relevant model interaction records in the exact language used during the experiment.
- Report all manual corrections and analysis decisions.
- Use a tagged release for any archived study snapshot.
- Record live-service availability and any divergence from the preserved OpenAPI contract; never rewrite the preserved file to match an observation.

## Expected outputs

The vehicle-domain pilot has results, but its data are not published here. The final Petstore experiment has not been executed. Any future reproduction package must identify its phase and keep pilot artifacts under `datasets/pilot/` and final artifacts under `datasets/final-experiment/`, with no numerical combination across phases.
