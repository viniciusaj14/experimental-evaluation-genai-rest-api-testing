# Reproducibility Guide

This document defines the minimum procedure for reproducing the experiment. Update it before data collection whenever the protocol changes.

## Prerequisites

- Java 21
- Maven
- Access to the study materials permitted by their licenses and access policies

Record the exact Maven, operating system, REST Assured, Cucumber, JUnit, GitHub Copilot, and ChatGPT versions or identifiers actually used in `EXPERIMENT_LOG.md`. Do not infer or backfill unknown versions.

## Procedure

1. Check out the exact Git commit or archived release associated with the study.
2. Verify that Java 21 is active with `java -version`.
3. Record the execution environment and timestamp in `EXPERIMENT_LOG.md`.
4. Follow `docs/Experimental_Protocol.md` without changing condition-specific inputs.
5. Store untouched observations in `datasets/raw/`.
6. Transform data only through documented procedures and place outputs in `datasets/processed/`.
7. Generate tables, graphs, reports, and statistical analysis under `results/`.
8. Record deviations, failures, exclusions, and reruns in `EXPERIMENT_LOG.md`.

## Build check

```bash
mvn test
```

No target API endpoint or experimental command is specified yet. Add those instructions only after the protocol and study subject are finalized.

## Integrity and provenance

- Never overwrite raw observations.
- Give each run a stable identifier shared across logs, datasets, and results.
- Record checksums for released datasets and generated artifacts.
- Keep prompts and relevant model interaction records with their condition.
- Report all manual corrections and analysis decisions.
- Use a tagged release for any archived study snapshot.

## Expected outputs

The final reproduction package should identify the input dataset, processed dataset, analysis artifacts, generated tables and graphs, and a report connecting each output to its generating procedure. These artifacts do not exist at repository initialization.
