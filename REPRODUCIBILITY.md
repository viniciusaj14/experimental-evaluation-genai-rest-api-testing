# Reproducibility Guide

This document defines the minimum procedure for reproducing the experiment. Update it before data collection whenever the protocol changes.

## Prerequisites

- Java 21
- Maven
- IntelliJ IDEA
- Access to the study materials permitted by their licenses and access policies

Record the exact Maven, operating system, REST Assured, Cucumber, JUnit 5, IntelliJ IDEA, GitHub Copilot, and ChatGPT versions or identifiers actually observed in `EXPERIMENT_LOG.md`. Do not infer or backfill unknown versions.

## Procedure

1. Check out the exact Git commit or archived release associated with the study.
2. Verify that Java 21 is active with `java -version`.
3. Record the execution environment and timestamp in `EXPERIMENT_LOG.md`.
4. Follow `docs/pt-BR/Protocolo_Experimental.md` without changing the five scenarios, fifty validation checks, or condition-specific rules.
5. Store untouched observations in `datasets/raw/`.
6. Transform data only through documented procedures and place outputs in `datasets/processed/`.
7. Generate documented tables, graphs, reports, and descriptive analysis under `results/`.
8. Record deviations, failures, exclusions, and reruns in `EXPERIMENT_LOG.md`.

## Build check

```bash
mvn test
```

The API name, endpoints, and experimental execution command remain pending. Add them only after they are formally selected; do not infer them.

## Integrity and provenance

- Never overwrite raw observations.
- Give each run a stable identifier shared across logs, datasets, and results.
- Record checksums for released datasets and generated artifacts.
- Keep prompts and relevant model interaction records in the exact language used during the experiment.
- Report all manual corrections and analysis decisions.
- Use a tagged release for any archived study snapshot.

## Expected outputs

The study has preliminary results, but its experimental data and consolidated results are not yet published in this repository. A future reproduction package should identify the input dataset, processed dataset, analysis artifacts, generated tables and graphs, and a report connecting each published output to its generating procedure. Pending protocol decisions must be documented separately from existing but unpublished artifacts.
