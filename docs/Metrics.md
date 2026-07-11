# Metrics

Metrics must have an operational definition, unit, collection method, aggregation rule, and missing-data policy before data collection.

## Planned metric families

### Functional correctness

Candidate measures include the proportion of predefined acceptance criteria satisfied and the proportion of test executions producing the expected verdict. The oracle and denominator must be frozen in advance.

### Test effectiveness

Candidate measures include detection of predefined faults or behavioral deviations and coverage of predefined requirements. Faults, requirements, and scoring rules must be established independently of the evaluated suites.

### Code quality and maintainability

Candidate measures include independently defined static measures and rubric-based review. Reviewers, rubric, blinding, and inter-rater procedure must be specified before evaluation.

### Development effort

Candidate measures include elapsed time, active development time, number of interactions, and manual interventions. Timing boundaries and interruption handling must be predefined.

### Execution characteristics

Candidate measures include execution duration, flaky outcomes, and resource consumption. Warm-up, repetition, and environment controls must be documented.

## Status

No metric values or experimental results exist yet. Final measures and statistical treatment remain to be specified in the analysis plan.
