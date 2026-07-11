# Experimental Evaluation of Generative AI for REST API Testing

Scientific repository for an MBA capstone project at USP/ESALQ.

## Research objective

This study aims to experimentally evaluate how generative AI-assisted development affects the construction of automated REST API tests. It compares test suites produced under three development conditions: manual development, GitHub Copilot assistance, and ChatGPT assistance.

The study does not assume that one condition is superior. Conclusions will be based only on the evidence collected according to the documented protocol.

## Comparison conditions

- **Manual development:** tests are produced without generative AI assistance.
- **GitHub Copilot:** tests are produced with GitHub Copilot assistance under a recorded prompt and interaction protocol.
- **ChatGPT:** tests are produced with ChatGPT assistance under a recorded prompt and interaction protocol.

Each condition has a dedicated directory for its test artifacts and a prompt record in `prompts/`. The experimental protocol is designed to keep the task inputs, evaluation procedure, and execution environment comparable across conditions.

## Experimental design

The experiment uses a controlled, repeated procedure for the three development conditions. Inputs, prompts, generated or manually written artifacts, execution logs, and measurements are retained separately. Raw observations are preserved before processing, and derived results are generated from those observations. The detailed design is maintained in [docs/Experimental_Protocol.md](docs/Experimental_Protocol.md) and [docs/Methodology.md](docs/Methodology.md).

No experimental results or target API endpoints are included at this initialization stage.

## Metrics

Planned metric families include functional correctness, test effectiveness, code quality and maintainability, development effort, and execution characteristics. Operational definitions, units, aggregation rules, and treatment of missing data must be finalized before data collection. See [docs/Metrics.md](docs/Metrics.md).

## Technology

The test project uses Java 21, Maven, REST Assured, Cucumber, and JUnit 5. Dependency coordinates are pinned in `pom.xml` using versions verified from Maven Central when this repository was initialized.

## Repository structure

```text
.
├── docs/                    # Protocol, methodology, metrics, questions, and validity threats
├── prompts/                 # Prompt and interaction protocols for each condition
├── manual/                  # Artifacts from manual development
├── github-copilot/          # Artifacts from the GitHub Copilot condition
├── chatgpt/                 # Artifacts from the ChatGPT condition
├── datasets/
│   ├── raw/                 # Immutable observations collected by the experiment
│   └── processed/           # Derived, cleaned, or transformed datasets
├── results/
│   ├── tables/              # Result tables
│   ├── graphs/              # Generated figures
│   ├── reports/             # Narrative and generated reports
│   └── statistical-analysis/# Analysis artifacts
├── EXPERIMENT_LOG.md        # Chronological execution log
├── REPRODUCIBILITY.md       # Instructions for reproducing the study
└── pom.xml                  # Maven project configuration
```

## Reproducibility

Use Java 21 and Maven, retain raw data unchanged, record every experimental run in `EXPERIMENT_LOG.md`, and follow `REPRODUCIBILITY.md`. The repository should record the exact environment and tool versions actually used at the start of data collection rather than anticipating them here.

## Data availability

No experimental dataset has been collected or published yet. When data become available, raw and processed data will be documented under `datasets/`, subject to legal, ethical, licensing, privacy, and repository-size constraints. Any unavailable material and the reason for its restriction will be documented explicitly.

## Citation and DOI status

Citation metadata are provided in `CITATION.cff`. **No Zenodo DOI has been issued yet.** A DOI must not be cited until a repository release has been archived and Zenodo has issued one.

## License

Repository source code and documentation are provided under the MIT License. Third-party materials and future datasets may have separate terms, which must be documented alongside those materials.
