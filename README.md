# Exploratory Evaluation of Generative Artificial Intelligence in REST API Test Automation Using Behavior-Driven Development (BDD)

[English](README.md) | [Português (Brasil)](README.pt-BR.md)

Scientific repository for the USP/ESALQ MBA capstone study comparing manual development, GitHub Copilot, and ChatGPT in REST API test automation using Behavior-Driven Development (BDD).

## Research status

The preliminary pilot study has been completed using a different public REST API in the vehicle domain.

The Swagger Petstore controlled experiment was designed under protocol version 1.1, formally frozen in [`docs/pt-BR/Protocolo_Congelado_v1.1.md`](docs/pt-BR/Protocolo_Congelado_v1.1.md). The repository now contains execution records for Manual, ChatGPT, and GitHub Copilot, with documented deviations and missing evidence that limit protocol-level claims.

Scenario result files have been published in the repository. Final raw/processed datasets and a complete metric analysis have not been published.

## Study phases

### Phase 1 — Preliminary pilot

- conducted using a different public REST API in the vehicle domain;
- original API contract was not preserved;
- pilot results exist;
- used to refine metrics, protocol, and evaluation instruments;
- results are not directly comparable with the final experiment.

### Phase 2 — Exploratory Petstore study

- adopts Swagger Petstore OpenAPI 3;
- uses the formally frozen protocol version 1.1 as the historical planning reference;
- planned five BDD scenarios and fifty validation checks;
- executed an observational subset of five scenarios per approach, applied equivalently across Manual, GitHub Copilot, and ChatGPT;
- is not a complete execution of protocol v1.1 because C01/V10 was not consolidated and the executed C04/C05 differ from the frozen matrix.

Documents written prospectively for Phase 2 are preserved as historical planning records; later adequacy notes explain their relationship to the observed subset.

## Repository status

- Scientific protocol version 1.1 frozen; version 1.0 preserved as history
- Preliminary pilot completed
- Manual, ChatGPT, and GitHub Copilot scenario results documented
- Execution deviations and evidence gaps formally disclosed
- Implementation-time consolidation and final-dataset publication pending
- DOI pending

The current status and limitations are documented in:

- [`EXPERIMENT_LOG.md`](EXPERIMENT_LOG.md);
- [`docs/pt-BR/Relatorio_Validacao_Final_Experimento.md`](docs/pt-BR/Relatorio_Validacao_Final_Experimento.md);
- [`docs/pt-BR/Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md`](docs/pt-BR/Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md);
- [`docs/pt-BR/Dicionario_de_Dados_Resultados_Experimentais.md`](docs/pt-BR/Dicionario_de_Dados_Resultados_Experimentais.md).

## Exploratory research objective

The study explores the implementation and executability of five REST API test scenarios using BDD across three development approaches:

1. manual development without generative AI assistance;
2. development assisted by GitHub Copilot;
3. development assisted by ChatGPT.

Only preserved results and evidence are described. The study does not establish productivity or quality superiority when implementation times, complete rework records, the fifty checks, or the corresponding rubrics are unavailable.

## Research questions

The original research questions ask how manual development, GitHub Copilot, and ChatGPT compare in productivity and quality. Available evidence does not answer them completely; the exploratory analysis is limited to executability and preserved status records for the observed subset.

The auxiliary questions compare:

- **productivity:** development time and rework;
- **quality:** initial validation correctness, code reuse, BDD adherence, and structural quality.

The authoritative wording is maintained in Brazilian Portuguese in [`docs/pt-BR/Questoes_de_Pesquisa.md`](docs/pt-BR/Questoes_de_Pesquisa.md).

## Experimental design

The observed artifacts implement the same five-scenario set across the three approaches: valid creation, lookup by identifier, update, deletion, and lookup of a nonexistent pet. This supports a descriptive comparison of those scenario statuses. It does not demonstrate application of the fifty checks or full conformance with the normative v1.1 scenarios.

The Petstore phase uses **Swagger Petstore OpenAPI 3**. See [`docs/pt-BR/Selecao_da_API.md`](docs/pt-BR/Selecao_da_API.md). Its official JSON contract is preserved at [`docs/api-specification/swagger-petstore-openapi.json`](docs/api-specification/swagger-petstore-openapi.json), with source, retrieval date, declared versions, and checksum documented in [`docs/api-specification/README.md`](docs/api-specification/README.md). The normative endpoint subset and scenario details are frozen by protocol version 1.1; differences in the executed artifacts are recorded as deviations, not retroactive protocol changes.

The historical review confirmed that the pilot used five vehicle-domain scenarios: brand query, model-by-brand query, year/model query, vehicle-detail query, and invalid-parameter query. Its official API name, URL, contract, and exact endpoint paths were not preserved and must not be inferred. The Petstore scenarios and checks are a new protocol and cannot be mapped retroactively to pilot results.

The planned operational procedure is preserved in the [Execution Plan](docs/pt-BR/Plano_de_Execucao.md), [Pre-execution Checklist](docs/pt-BR/Checklist_Pre_Execucao.md), and [Experimental Control Plan](docs/pt-BR/Plano_de_Controle_Experimental.md). Their existence does not prove complete application.

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
| Productivity | Development time | Pilot: active development time; final unit and timing rules frozen in protocol v1.1 |
| Productivity | Rework | Number of individual manual corrections performed after the first executable version, as defined in the pilot study |
| Quality | Initial validation correctness | Pilot: validations correct in the first execution; final Petstore scope frozen in protocol v1.1 |
| Quality | Code reuse | Pilot recorded a percentage without a preserved calculation procedure; final rubric requires freezing |
| Quality | BDD adherence | Pilot recorded adherent scenarios out of five and a percentage; final rubric requires freezing |
| Quality | Structural quality | Qualitatively assessed in the preliminary pilot and planned for quantitative assessment in the final experiment using the documented evaluation rubric |

Historical definitions, formulas, limitations, and decisions required for the final experiment are documented in [`docs/pt-BR/Metricas.md`](docs/pt-BR/Metricas.md). Pilot and final-experiment measurements must remain separate.

Structured rubric templates are available under [`docs/pt-BR/instrumentos/`](docs/pt-BR/instrumentos/). They contain no final consolidation and are not applied retrospectively to the results.

## Methodological limitations and adaptations

- Protocol v1.1 remains preserved as the historical plan and was not rewritten to match the results.
- The observed execution is documented as an exploratory evaluation of a five-scenario subset, not as complete protocol execution.
- C01/V10 has no consolidated evidence, and the executed C04 and C05 differ from the frozen matrix.
- The fifteen `PASS` records support only the recorded success of the five scenarios actually implemented under each approach.
- ChatGPT/Copilot times, V01–V50 evidence, rubrics, structured final datasets, and part of the traceability remain unavailable or pending and are not inferred.
- No quantitative productivity, rework, or quality conclusion is reported without the corresponding data.

## Technology stack

- Java 21
- Maven
- REST Assured
- Cucumber
- JUnit 5
- IntelliJ IDEA
- Swagger Petstore OpenAPI 3
- Docker with Docker Compose

The Maven project is configured in [`pom.xml`](pom.xml). Exact versions or identifiers not already confirmed must be recorded as actually observed during the experiment and must not be reconstructed by assumption.

## Quick technical execution

Prerequisites: Java 21, Maven, and Docker with Docker Compose.

Start the controlled service and confirm that the contract is available:

```bash
docker compose -f datasets/petstore-feasibility-pilot/config/docker-compose.yml up -d
curl -i http://127.0.0.1:18080/api/v3/openapi.json
```

Run each suite separately:

```bash
mvn -Dtest=runner.TestRunner test
mvn -Dtest=chatgpt.runner.ChatGPTTestRunner test
mvn -Dtest=copilot.runner.CopilotTestRunner test
```

These commands check the current executability of the suites. They do not reproduce implementation time, tool interactions, or the original experimental collection. See [`REPRODUCIBILITY.md`](REPRODUCIBILITY.md) for the complete procedure and its limitations.

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
├── results/                   # Preserved Manual, ChatGPT, and GitHub Copilot result records
├── EXPERIMENT_LOG.md          # Experiment-record structure and publication status
├── REPRODUCIBILITY.md         # Reproduction and provenance guidance
├── CITATION.cff               # Citation metadata
└── pom.xml                    # Java 21 Maven configuration
```

## Prompt language preservation

Prompts, instructions, context, responses, and interaction histories must remain in the exact language used during the experiment. Experimental records must not be translated, normalized, or reconstructed after collection. Condition-specific rules are maintained under [`prompts/`](prompts/).

## Reproducibility and data availability

Follow [`REPRODUCIBILITY.md`](REPRODUCIBILITY.md), preserve original observations without modification, and record transformations, corrections, exclusions, and deviations. The approach-specific validation commands and the limits of reproducing the original Manual execution are documented there.

Textual scenario results are present for all three approaches. ChatGPT and GitHub Copilot implementation times, the V01–V50 evidence, rubric consolidations, and raw/processed final datasets remain unavailable or pending. Manual video evidence is referenced by historical results but is not included in the versioned repository. Pilot and final artifacts must remain separate.

## Citation and DOI status

Citation metadata are available in [`CITATION.cff`](CITATION.cff). **No DOI has been issued for this repository.** A DOI must not be reported unless it is actually issued.

## License

Source code and documentation are available under the [`MIT License`](LICENSE). Third-party materials and future datasets may have separate terms that must be documented alongside them.
