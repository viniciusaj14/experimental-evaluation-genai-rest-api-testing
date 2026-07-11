# Experimental Evaluation of Generative Artificial Intelligence for REST API Test Automation Using Behavior-Driven Development (BDD)

[English](README.md) | [Português (Brasil)](README.pt-BR.md)

Scientific repository for the USP/ESALQ MBA capstone study comparing manual development, GitHub Copilot, and ChatGPT in REST API test automation using Behavior-Driven Development (BDD).

> **Research status:** the study has preliminary results. Experimental data and consolidated results are not yet published in this repository. No result may be inferred, invented, or published from this documentation alone.

## Research objective

The study evaluates productivity and quality across three development approaches:

1. manual development without generative AI assistance;
2. development assisted by GitHub Copilot;
3. development assisted by ChatGPT.

The five BDD scenarios are functionally distinct. Each same scenario and its planned checks are applied identically to manual development, GitHub Copilot, and ChatGPT. Comparability is required across approaches for a given scenario; identical complexity across different HTTP operations is neither assumed nor required.

## Research questions

The main research question asks how manual development, GitHub Copilot, and ChatGPT compare in productivity and quality when automating REST API tests with BDD.

The auxiliary questions compare:

- **productivity:** development time and rework;
- **quality:** validation coverage, code reuse, BDD adherence, and structural quality.

The authoritative wording is maintained in Brazilian Portuguese in [`docs/pt-BR/Questoes_de_Pesquisa.md`](docs/pt-BR/Questoes_de_Pesquisa.md).

## Experimental design

The same requirements, five scenarios, fifty planned validation checks, environment, and completion criteria apply across the three approaches. The planned difference is the development approach itself. Source artifacts, prompts and permitted interactions, timing records, rework records, validation evidence, and deviations provide traceability.

The selected study API is **Swagger Petstore - OpenAPI 3.0**. Its official JSON contract is preserved at [`docs/api-specification/swagger-petstore-openapi.json`](docs/api-specification/swagger-petstore-openapi.json), with source, retrieval date, declared versions, and checksum documented in [`docs/api-specification/README.md`](docs/api-specification/README.md). The final endpoint subset and executable scenario details remain under methodological review.

> **Methodological consistency warning:** the selected API, proposed scenarios, and validation matrix must be checked against the original preliminary experiment records. They must not be described as procedures already performed unless those records confirm them. If they differ materially, the preliminary results must be classified as a pilot or the experiment must be rerun under the frozen design.

Detailed scientific documentation is maintained in Brazilian Portuguese, consistently with the USP/ESALQ capstone text:

- [Experimental protocol](docs/pt-BR/Protocolo_Experimental.md);
- [Methodology](docs/pt-BR/Metodologia.md);
- [Metrics](docs/pt-BR/Metricas.md);
- [Research questions](docs/pt-BR/Questoes_de_Pesquisa.md);
- [Threats to validity](docs/pt-BR/Ameacas_a_Validade.md).

API and experimental-design artifacts:

- [API selection](docs/pt-BR/Selecao_da_API.md);
- [candidate endpoint inventory](docs/pt-BR/Inventario_de_Endpoints.md);
- [five-scenario matrix](docs/pt-BR/Matriz_de_Cenarios.md);
- [fifty-check validation matrix](docs/pt-BR/Matriz_de_Validacoes.md);
- [research traceability matrix](docs/pt-BR/Matriz_de_Rastreabilidade.md).
- [feasibility pilot protocol](docs/pt-BR/Piloto_de_Viabilidade.md).

Full English translations will be created only after the protocol is frozen. See [`docs/en/README.md`](docs/en/README.md).

## Confirmed metrics

| Dimension | Metric | Study interpretation |
| --- | --- | --- |
| Productivity | Development time | Active minutes required under the documented timing rules |
| Productivity | Rework | Collected rework value; its exact meaning and unit require confirmation against the preliminary records |
| Quality | Validation coverage | Transparent outcome of the fifty planned checks, with impeded checks reported separately and never counted as passed |
| Quality | Code reuse | Reuse assessed with the study's confirmed evaluation instrument |
| Quality | BDD adherence | Conformance assessed with the study's confirmed BDD instrument |
| Quality | Structural quality | Conformance assessed with the study's confirmed structural-quality instrument |

Operational definitions, formulas, inclusion rules, exclusions, and pending confirmations are documented in [`docs/pt-BR/Metricas.md`](docs/pt-BR/Metricas.md). The rework metric must not be retroactively redefined before checking whether the preliminary records represent corrective cycles, individual manual adjustments, or a rework rate.

Structured rubric templates are available under [`docs/pt-BR/instrumentos/`](docs/pt-BR/instrumentos/). They contain no invented final criteria or scores and must be completed from the instruments actually used in the study.

## Technology stack

- Java 21
- Maven
- REST Assured
- Cucumber
- JUnit 5
- IntelliJ IDEA

The Maven project is configured in [`pom.xml`](pom.xml). Exact versions or identifiers not already confirmed must be recorded as actually observed during the experiment and must not be reconstructed by assumption.

## Repository structure

```text
.
├── docs/
│   ├── pt-BR/                 # Authoritative scientific documentation and instrument templates
│   ├── en/                    # English translation status
│   └── api-specification/     # Preserved official Swagger Petstore contract and provenance
├── prompts/                   # Language-preserving records for each approach
├── manual/                    # Manual-development artifacts
├── github-copilot/            # GitHub Copilot artifacts
├── chatgpt/                   # ChatGPT artifacts
├── datasets/
│   ├── raw/                   # Location reserved for original observations
│   └── processed/             # Location reserved for documented transformations
├── results/                   # Location reserved for published result artifacts
├── EXPERIMENT_LOG.md          # Experiment-record structure and publication status
├── REPRODUCIBILITY.md         # Reproduction and provenance guidance
├── CITATION.cff               # Citation metadata
└── pom.xml                    # Java 21 Maven configuration
```

## Prompt language preservation

Prompts, instructions, context, responses, and interaction histories must remain in the exact language used during the experiment. Experimental records must not be translated, normalized, or reconstructed after collection. Condition-specific rules are maintained under [`prompts/`](prompts/).

## Reproducibility and data availability

Follow [`REPRODUCIBILITY.md`](REPRODUCIBILITY.md), preserve original observations without modification when they are published, and record transformations, corrections, exclusions, and deviations. The basic project check is:

```bash
mvn test
```

Preliminary results exist, but experimental data and consolidated results are not yet published in this repository. Future availability will be documented subject to legal, ethical, licensing, privacy, and repository-size constraints. This publication status is separate from protocol decisions that remain pending.

## Citation and DOI status

Citation metadata are available in [`CITATION.cff`](CITATION.cff). **No DOI has been issued for this repository.** A DOI must not be reported unless it is actually issued.

## License

Source code and documentation are available under the [`MIT License`](LICENSE). Third-party materials and future datasets may have separate terms that must be documented alongside them.
