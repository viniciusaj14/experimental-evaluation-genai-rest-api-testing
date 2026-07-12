# Experimental Evaluation of Generative Artificial Intelligence for REST API Test Automation Using Behavior-Driven Development (BDD)

[English](README.md) | [Português (Brasil)](README.pt-BR.md)

Scientific repository for the USP/ESALQ MBA capstone study comparing manual development, GitHub Copilot, and ChatGPT in REST API test automation using Behavior-Driven Development (BDD).

## Research status

The preliminary pilot study has been completed using a different public REST API in the vehicle domain.

The Swagger Petstore protocol documented in this repository defines the final controlled experiment, which has not yet been executed.

Experimental datasets and consolidated analyses have not yet been published.

## Study phases

### Phase 1 — Preliminary pilot

- conducted using a different public REST API in the vehicle domain;
- original API contract was not preserved;
- pilot results exist;
- used to refine metrics, protocol, and evaluation instruments;
- results are not directly comparable with the final experiment.

### Phase 2 — Final controlled experiment

- adopts Swagger Petstore OpenAPI 3;
- requires a frozen protocol before execution;
- uses five functionally distinct BDD scenarios applied identically across the three development approaches;
- plans fifty validation checks;
- applies the same protocol to manual development, GitHub Copilot, and ChatGPT.

All future-oriented documentation refers to Phase 2 unless explicitly identified as pilot material.

## Repository status

- Scientific protocol available
- Preliminary pilot completed
- Final controlled experiment pending
- Experimental artifacts not yet published
- Dataset publication pending
- DOI pending

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
- **quality:** initial validation correctness, code reuse, BDD adherence, and structural quality.

The authoritative wording is maintained in Brazilian Portuguese in [`docs/pt-BR/Questoes_de_Pesquisa.md`](docs/pt-BR/Questoes_de_Pesquisa.md).

## Experimental design

The same requirements, five scenarios, fifty planned validation checks, environment, and completion criteria apply across the three approaches. The planned difference is the development approach itself. Source artifacts, prompts and permitted interactions, timing records, rework records, validation evidence, and deviations provide traceability.

The final experiment adopts **Swagger Petstore OpenAPI 3**. See [`docs/pt-BR/Selecao_da_API.md`](docs/pt-BR/Selecao_da_API.md). Its official JSON contract is preserved at [`docs/api-specification/swagger-petstore-openapi.json`](docs/api-specification/swagger-petstore-openapi.json), with source, retrieval date, declared versions, and checksum documented in [`docs/api-specification/README.md`](docs/api-specification/README.md). The final endpoint subset and executable scenario details remain under methodological review.

The historical review confirmed that the pilot used five vehicle-domain scenarios: brand query, model-by-brand query, year/model query, vehicle-detail query, and invalid-parameter query. Its official API name, URL, contract, and exact endpoint paths were not preserved and must not be inferred. The Petstore scenarios and checks are a new protocol and cannot be mapped retroactively to pilot results.

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
- [research traceability matrix](docs/pt-BR/Matriz_de_Rastreabilidade.md);
- [feasibility pilot protocol](docs/pt-BR/Piloto_de_Viabilidade.md);
- [confirmed preliminary-study record](docs/pt-BR/Estudo_Preliminar.md);
- [pilot/final-experiment decision record](docs/pt-BR/Registro_de_Decisao_Piloto_e_Experimento_Final.md).

Full English translations will be created only after the protocol is frozen. See [`docs/en/README.md`](docs/en/README.md).

## Metrics by study phase

| Dimension | Metric | Study interpretation |
| --- | --- | --- |
| Productivity | Development time | Pilot: active development time; final unit and timing rules require freezing |
| Productivity | Rework | Number of individual manual corrections performed after the first executable version, as defined in the pilot study |
| Quality | Initial validation correctness | Pilot: validations correct in the first execution; final Petstore scope still requires freezing |
| Quality | Code reuse | Pilot recorded a percentage without a preserved calculation procedure; final rubric requires freezing |
| Quality | BDD adherence | Pilot recorded adherent scenarios out of five and a percentage; final rubric requires freezing |
| Quality | Structural quality | Qualitatively assessed in the preliminary pilot and planned for quantitative assessment in the final experiment using the documented evaluation rubric |

Historical definitions, formulas, limitations, and decisions required for the final experiment are documented in [`docs/pt-BR/Metricas.md`](docs/pt-BR/Metricas.md). Pilot and final-experiment measurements must remain separate.

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
│   ├── pilot/                 # Reserved raw and processed pilot-data areas
│   └── final-experiment/      # Reserved raw and processed final-data areas
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

Pilot results exist, but their data and consolidated values are not published in this repository. The final Petstore experiment has not yet been executed. Future data availability will be documented subject to legal, ethical, licensing, privacy, and repository-size constraints, with pilot and final artifacts kept separate.

## Citation and DOI status

Citation metadata are available in [`CITATION.cff`](CITATION.cff). **No DOI has been issued for this repository.** A DOI must not be reported unless it is actually issued.

## License

Source code and documentation are available under the [`MIT License`](LICENSE). Third-party materials and future datasets may have separate terms that must be documented alongside them.
