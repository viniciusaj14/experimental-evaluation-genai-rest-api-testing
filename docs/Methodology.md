# Methodology

## Study design

The project is a controlled empirical comparison of three REST API test development conditions: manual development, GitHub Copilot assistance, and ChatGPT assistance. The unit of analysis, sample size, replication strategy, and condition-order controls must be established before data collection.

## Inputs and controls

All conditions should receive equivalent functional requirements, documentation, starting code, time constraints, and evaluation criteria. Differences that are intrinsic to a tool must be recorded. Prompt histories and manual interventions form part of the experimental evidence.

## Data collection

Collect source artifacts, interaction records permitted by policy, timestamps, execution output, evaluation observations, and environment metadata. Store original observations in `datasets/raw/` and never edit them in place.

## Data processing and analysis

Use documented transformations to create `datasets/processed/`. Define hypotheses, estimands, statistical tests, uncertainty reporting, multiple-comparison handling, and effect-size interpretation before examining comparative outcomes. Keep analysis scripts or notebooks with the statistical-analysis outputs when they are introduced.

## Reporting

Report all conditions, missing data, failed executions, protocol deviations, exclusions, and limitations. Do not report tool-generated claims as measurements unless independently evaluated by the predefined procedure.
