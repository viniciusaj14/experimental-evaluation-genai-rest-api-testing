# Experimental Evaluation of Generative AI for REST API Testing

[English](README.md) | [Português (Brasil)](README.pt-BR.md)

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

The experiment compares implementations of five equivalent BDD test scenarios under the three development conditions. Each implementation is assessed with the same fifty validation checks. Inputs, prompts, artifacts, logs, and measurements are retained separately. The detailed design is maintained in [docs/pt-BR/Protocolo_Experimental.md](docs/pt-BR/Protocolo_Experimental.md) and [docs/pt-BR/Metodologia.md](docs/pt-BR/Metodologia.md).

No experimental results are included at this stage. The API name and endpoints remain pending and must not be inferred.

## Metrics

The confirmed metrics are development time, rework, validation coverage, code reuse, BDD adherence, and structural quality. See [docs/pt-BR/Metricas.md](docs/pt-BR/Metricas.md).

## Technology

The test project uses Java 21, Maven, REST Assured, Cucumber, JUnit 5, and IntelliJ IDEA. Dependency coordinates are pinned in `pom.xml`; observed environment and tool identifiers must be recorded without inference.

## Repository structure

```text
.
├── docs/                    # Authoritative pt-BR documents and English translation status
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
