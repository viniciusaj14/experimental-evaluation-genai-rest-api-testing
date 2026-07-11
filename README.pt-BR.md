# Avaliação Experimental da Inteligência Artificial Generativa na Automação de Testes de APIs REST com Behavior-Driven Development (BDD)

[English](README.md) | [Português (Brasil)](README.pt-BR.md)

Repositório científico do Trabalho de Conclusão de Curso do MBA USP/ESALQ.

> **Status da pesquisa:** o estudo possui resultados preliminares. Os dados experimentais e os resultados consolidados ainda não estão publicados neste repositório. Nenhum resultado deve ser divulgado por inferência ou invenção. Nenhum DOI foi emitido.

## Objetivo

Avaliar experimentalmente a produtividade e a qualidade da automação de testes de API REST com Behavior-Driven Development (BDD) em três abordagens:

- desenvolvimento manual;
- desenvolvimento assistido pelo GitHub Copilot;
- desenvolvimento assistido pelo ChatGPT.

## Escopo confirmado

- cinco cenários funcionalmente distintos, cada um aplicado de forma idêntica às três abordagens;
- cinquenta verificações de validação para cada abordagem;
- Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA;
- métricas de tempo de desenvolvimento, retrabalho, cobertura de validação, reúso de código, aderência ao BDD e qualidade estrutural.

A API selecionada é a **Swagger Petstore - OpenAPI 3.0**. O contrato JSON oficial está preservado em [`docs/api-specification/swagger-petstore-openapi.json`](docs/api-specification/swagger-petstore-openapi.json), com origem, data de obtenção, versões declaradas e checksum em [`docs/api-specification/README.md`](docs/api-specification/README.md). O subconjunto final de endpoints e os detalhes executáveis dos cenários permanecem em revisão metodológica.

## Questões de pesquisa

A questão principal compara produtividade e qualidade entre as três abordagens. Duas questões auxiliares tratam de:

1. tempo de desenvolvimento e retrabalho;
2. cobertura de validação, reúso de código, aderência ao BDD e qualidade estrutural.

Consulte [`docs/pt-BR/Questoes_de_Pesquisa.md`](docs/pt-BR/Questoes_de_Pesquisa.md).

## Delineamento

Cada abordagem deve implementar os mesmos cinco cenários e ser submetida às mesmas verificações planejadas para cada cenário. A comparabilidade é exigida entre as três abordagens dentro de um mesmo cenário; não se presume complexidade idêntica entre operações HTTP funcionalmente diferentes. Requisitos, materiais, ambiente e critérios de conclusão devem permanecer iguais entre abordagens, exceto pela forma de desenvolvimento que define cada condição.

> **Alerta de consistência metodológica:** a API selecionada, os cenários propostos e a matriz de validações devem ser conferidos com os registros originais do experimento preliminar. Não podem ser apresentados como procedimentos já executados sem confirmação documental. Se houver diferença material, os resultados preliminares deverão ser classificados como piloto ou o experimento deverá ser reexecutado com o desenho congelado.

Documentos metodológicos oficiais:

- [`Protocolo_Experimental.md`](docs/pt-BR/Protocolo_Experimental.md);
- [`Metodologia.md`](docs/pt-BR/Metodologia.md);
- [`Metricas.md`](docs/pt-BR/Metricas.md);
- [`Questoes_de_Pesquisa.md`](docs/pt-BR/Questoes_de_Pesquisa.md);
- [`Ameacas_a_Validade.md`](docs/pt-BR/Ameacas_a_Validade.md).

Documentos de seleção e planejamento experimental:

- [`Selecao_da_API.md`](docs/pt-BR/Selecao_da_API.md);
- [`Inventario_de_Endpoints.md`](docs/pt-BR/Inventario_de_Endpoints.md);
- [`Matriz_de_Cenarios.md`](docs/pt-BR/Matriz_de_Cenarios.md);
- [`Matriz_de_Validacoes.md`](docs/pt-BR/Matriz_de_Validacoes.md);
- [`Matriz_de_Rastreabilidade.md`](docs/pt-BR/Matriz_de_Rastreabilidade.md).
- [`Piloto_de_Viabilidade.md`](docs/pt-BR/Piloto_de_Viabilidade.md).

Os templates dos instrumentos de avaliação estão em [`docs/pt-BR/instrumentos/`](docs/pt-BR/instrumentos/). Eles ainda não contêm critérios nem pontuações finais e deverão ser completados conforme os instrumentos efetivamente utilizados.

As traduções integrais para inglês serão produzidas somente após o congelamento do protocolo, conforme [`docs/en/README.md`](docs/en/README.md).

## Estrutura do repositório

```text
.
├── docs/
│   ├── pt-BR/                 # Documentação científica oficial
│   ├── en/                    # Status das futuras traduções
│   └── api-specification/     # Contrato oficial preservado e proveniência
├── prompts/                   # Regras e registros das três abordagens
├── manual/                    # Artefatos do desenvolvimento manual
├── github-copilot/            # Artefatos da abordagem GitHub Copilot
├── chatgpt/                   # Artefatos da abordagem ChatGPT
├── datasets/
│   ├── raw/                   # Registros originais imutáveis
│   └── processed/             # Transformações documentadas
├── results/                   # Tabelas, gráficos, relatórios e análises
├── EXPERIMENT_LOG.md          # Registro cronológico do experimento
├── REPRODUCIBILITY.md         # Instruções institucionais de reprodução
└── pom.xml                    # Configuração Maven com Java 21
```

## Prompts e idioma

Prompts, instruções, contexto, respostas e históricos devem permanecer no idioma exato utilizado durante o experimento. Esses registros não devem ser traduzidos ou reconstruídos posteriormente.

## Reprodutibilidade e dados

O procedimento de reprodução está em [`REPRODUCIBILITY.md`](REPRODUCIBILITY.md). Os dados brutos não devem ser sobrescritos, e toda transformação deve manter vínculo com sua origem. Os dados experimentais e os resultados consolidados ainda não estão publicados neste repositório.

## Citação e DOI

Os metadados de citação estão em [`CITATION.cff`](CITATION.cff). **Nenhum DOI foi emitido para este repositório.** Um DOI somente poderá ser informado após sua emissão efetiva.

## Licença

O código-fonte e a documentação são disponibilizados sob a [`MIT License`](LICENSE). Materiais de terceiros e conjuntos de dados futuros poderão ter termos próprios, que deverão ser documentados.
