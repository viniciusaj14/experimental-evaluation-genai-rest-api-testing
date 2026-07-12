# Avaliação Experimental da Inteligência Artificial Generativa na Automação de Testes de APIs REST com Behavior-Driven Development (BDD)

[English](README.md) | [Português (Brasil)](README.pt-BR.md)

Repositório científico do Trabalho de Conclusão de Curso do MBA USP/ESALQ.

## Status da pesquisa

O estudo piloto preliminar foi concluído utilizando uma API REST pública diferente, do domínio veicular.

O protocolo Swagger Petstore documentado neste repositório define o experimento final controlado, que ainda não foi executado. O delineamento experimental versão 1.0 está formalmente congelado em [`docs/pt-BR/Protocolo_Congelado_v1.0.md`](docs/pt-BR/Protocolo_Congelado_v1.0.md).

Os datasets experimentais e as análises consolidadas ainda não foram publicados.

## Fases do estudo

### Fase 1 — Piloto preliminar

- realizado com outra API REST pública do domínio veicular;
- contrato original da API não foi preservado;
- existem resultados do piloto;
- utilizado para refinar métricas, protocolo e instrumentos de avaliação;
- resultados não são diretamente comparáveis aos do experimento final.

### Fase 2 — Experimento final controlado

- adota Swagger Petstore OpenAPI 3;
- utiliza o protocolo versão 1.0 formalmente congelado;
- utiliza cinco cenários BDD funcionalmente distintos, aplicados de forma idêntica às três abordagens;
- planeja cinquenta verificações de validação;
- aplica o mesmo protocolo ao desenvolvimento manual, GitHub Copilot e ChatGPT.

Toda documentação orientada ao futuro refere-se à Fase 2, salvo quando identificada explicitamente como material do piloto.

## Status do repositório

- Protocolo científico versão 1.0 congelado
- Piloto preliminar concluído
- Experimento final controlado pendente
- Artefatos experimentais ainda não publicados
- Publicação do dataset pendente
- DOI pendente

## Objetivo

Avaliar experimentalmente a produtividade e a qualidade da automação de testes de API REST com Behavior-Driven Development (BDD) em três abordagens:

- desenvolvimento manual;
- desenvolvimento assistido pelo GitHub Copilot;
- desenvolvimento assistido pelo ChatGPT.

## Escopo confirmado

- cinco cenários funcionalmente distintos, cada um aplicado de forma idêntica às três abordagens;
- cinquenta verificações de validação para cada abordagem;
- Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA;
- métricas de tempo de desenvolvimento, retrabalho, correção inicial das validações, reúso de código, aderência ao BDD e qualidade estrutural.

O experimento final adota a **Swagger Petstore OpenAPI 3**. Consulte [`docs/pt-BR/Selecao_da_API.md`](docs/pt-BR/Selecao_da_API.md). O contrato JSON oficial está preservado em [`docs/api-specification/swagger-petstore-openapi.json`](docs/api-specification/swagger-petstore-openapi.json), com origem, data de obtenção, versões declaradas e checksum em [`docs/api-specification/README.md`](docs/api-specification/README.md). O subconjunto de endpoints e os detalhes executáveis dos cenários estão congelados no protocolo versão 1.0.

## Questões de pesquisa

A questão principal compara produtividade e qualidade entre as três abordagens. Duas questões auxiliares tratam de:

1. tempo de desenvolvimento e retrabalho;
2. correção inicial das validações, reúso de código, aderência ao BDD e qualidade estrutural.

Consulte [`docs/pt-BR/Questoes_de_Pesquisa.md`](docs/pt-BR/Questoes_de_Pesquisa.md).

## Métricas por fase

| Dimensão | Métrica | Interpretação |
| --- | --- | --- |
| Produtividade | Tempo de desenvolvimento | Piloto: tempo ativo; unidade e regras finais congeladas no protocolo v1.0 |
| Produtividade | Retrabalho | Número de correções manuais individuais realizadas após a primeira versão executável, conforme definido no estudo piloto |
| Qualidade | Correção inicial das validações | Piloto: validações corretas na primeira execução; escopo final congelado no protocolo v1.0 |
| Qualidade | Reúso de código | Piloto registrou percentual sem procedimento de cálculo preservado; rubrica final deve ser congelada |
| Qualidade | Aderência ao BDD | Piloto registrou cenários aderentes entre cinco e percentual; rubrica final deve ser congelada |
| Qualidade | Qualidade estrutural | Avaliada qualitativamente no piloto preliminar e planejada para avaliação quantitativa no experimento final com a rubrica documentada |

As definições históricas e decisões para a Fase 2 estão em [`docs/pt-BR/Metricas.md`](docs/pt-BR/Metricas.md). Métricas das duas fases não podem ser combinadas.

## Delineamento

Cada abordagem deve implementar os mesmos cinco cenários e ser submetida às mesmas verificações planejadas para cada cenário. A comparabilidade é exigida entre as três abordagens dentro de um mesmo cenário; não se presume complexidade idêntica entre operações HTTP funcionalmente diferentes. Requisitos, materiais, ambiente e critérios de conclusão devem permanecer iguais entre abordagens, exceto pela forma de desenvolvimento que define cada condição.

O estudo piloto utilizou cinco cenários veiculares confirmados: consulta de marcas, consulta de modelos por marca, consulta de ano/modelo, consulta de detalhes de veículo e consulta com parâmetro inválido. O nome oficial, URL, contrato e paths exatos da API histórica não foram preservados e não devem ser inferidos. Os cenários e verificações Petstore constituem um protocolo novo e não podem ser associados retroativamente aos resultados do piloto.

A execução operacional do protocolo final é regida pelo [Plano de Execução](docs/pt-BR/Plano_de_Execucao.md), pelo [Checklist de Execução](docs/pt-BR/Checklist_Pre_Execucao.md) e pelo [Plano de Controle Experimental](docs/pt-BR/Plano_de_Controle_Experimental.md).

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
- [`Matriz_de_Rastreabilidade.md`](docs/pt-BR/Matriz_de_Rastreabilidade.md);
- [`Piloto_de_Viabilidade.md`](docs/pt-BR/Piloto_de_Viabilidade.md);
- [`Estudo_Preliminar.md`](docs/pt-BR/Estudo_Preliminar.md);
- [`Registro_de_Decisao_Piloto_e_Experimento_Final.md`](docs/pt-BR/Registro_de_Decisao_Piloto_e_Experimento_Final.md).

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
│   ├── pilot/                 # Áreas raw e processed exclusivas do piloto
│   └── final-experiment/      # Áreas raw e processed exclusivas do experimento final
├── results/                   # Tabelas, gráficos, relatórios e análises
├── EXPERIMENT_LOG.md          # Registro cronológico do experimento
├── REPRODUCIBILITY.md         # Instruções institucionais de reprodução
└── pom.xml                    # Configuração Maven com Java 21
```

## Prompts e idioma

Prompts, instruções, contexto, respostas e históricos devem permanecer no idioma exato utilizado durante o experimento. Esses registros não devem ser traduzidos ou reconstruídos posteriormente.

## Reprodutibilidade e dados

O procedimento de reprodução está em [`REPRODUCIBILITY.md`](REPRODUCIBILITY.md). Dados brutos não devem ser sobrescritos, e toda transformação deve manter vínculo com sua fase. Os dados do piloto não estão publicados neste repositório, e o experimento final Petstore ainda não foi executado.

## Citação e DOI

Os metadados de citação estão em [`CITATION.cff`](CITATION.cff). **Nenhum DOI foi emitido para este repositório.** Um DOI somente poderá ser informado após sua emissão efetiva.

## Licença

O código-fonte e a documentação são disponibilizados sob a [`MIT License`](LICENSE). Materiais de terceiros e conjuntos de dados futuros poderão ter termos próprios, que deverão ser documentados.
