# Avaliação Exploratória da Inteligência Artificial Generativa na Automação de Testes de APIs REST com Behavior-Driven Development (BDD)

[English](README.md) | [Português (Brasil)](README.pt-BR.md)

Repositório científico do Trabalho de Conclusão de Curso do MBA USP/ESALQ.

## Status da pesquisa

O estudo piloto preliminar foi concluído utilizando uma API REST pública diferente, do domínio veicular.

O experimento controlado Swagger Petstore foi delineado sob o protocolo versão 1.1, formalmente congelado em [`docs/pt-BR/Protocolo_Congelado_v1.1.md`](docs/pt-BR/Protocolo_Congelado_v1.1.md). O repositório contém registros de execução Manual, ChatGPT e GitHub Copilot, com desvios e ausências de evidência que limitam afirmações de conformidade integral.

Os arquivos textuais de resultado por cenário estão publicados. Os datasets finais brutos/processados e a análise completa das métricas ainda não foram publicados.

## Fases do estudo

### Fase 1 — Piloto preliminar

- realizado com outra API REST pública do domínio veicular;
- contrato original da API não foi preservado;
- existem resultados do piloto;
- utilizado para refinar métricas, protocolo e instrumentos de avaliação;
- resultados não são diretamente comparáveis aos do experimento final.

### Fase 2 — Estudo exploratório Petstore

- adota Swagger Petstore OpenAPI 3;
- utiliza o protocolo versão 1.1 formalmente congelado como referência histórica do planejamento;
- planejou cinco cenários BDD e cinquenta verificações de validação;
- executou um subconjunto observacional de cinco cenários por abordagem, aplicado de forma equivalente entre Manual, GitHub Copilot e ChatGPT;
- não constitui execução integral do protocolo v1.1, pois C01/V10 não foi consolidado e C04/C05 diferem da matriz congelada.

Documentos redigidos prospectivamente para a Fase 2 são preservados como registros históricos de planejamento; notas de adequação posterior indicam seu relacionamento com o subconjunto observado.

## Status do repositório

- Protocolo científico versão 1.1 congelado; versão 1.0 preservada como histórico
- Piloto preliminar concluído
- Resultados de cenário Manual, ChatGPT e GitHub Copilot documentados
- Desvios de execução e lacunas de evidência formalmente declarados
- Consolidação dos tempos e publicação do dataset final pendentes
- DOI pendente

O estado atual e suas limitações estão documentados em:

- [`EXPERIMENT_LOG.md`](EXPERIMENT_LOG.md);
- [`docs/pt-BR/Relatorio_Validacao_Final_Experimento.md`](docs/pt-BR/Relatorio_Validacao_Final_Experimento.md);
- [`docs/pt-BR/Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md`](docs/pt-BR/Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md);
- [`docs/pt-BR/Dicionario_de_Dados_Resultados_Experimentais.md`](docs/pt-BR/Dicionario_de_Dados_Resultados_Experimentais.md).

## Objetivo exploratório

Examinar exploratoriamente a implementação e a executabilidade de cinco cenários de testes de API REST com Behavior-Driven Development (BDD) em três abordagens:

- desenvolvimento manual;
- desenvolvimento assistido pelo GitHub Copilot;
- desenvolvimento assistido pelo ChatGPT.

O estudo descreve somente os resultados e as evidências efetivamente preservados. Ele não estabelece superioridade de produtividade ou qualidade quando os tempos, registros de retrabalho, cinquenta verificações ou rubricas correspondentes estão ausentes.

## Escopo planejado e escopo observado

- **Planejado no protocolo v1.1:** cinco cenários normativos, cinquenta verificações por abordagem e seis métricas;
- **Observado:** cinco cenários implementados de forma equivalente nas três abordagens, totalizando quinze registros cenário-abordagem com `PASS`;
- **Não demonstrado:** execução de C01/V10, das cinquenta verificações, das rubricas de qualidade ou das métricas completas;
- Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA;
- tempos de ChatGPT/Copilot, contagens completas de retrabalho e avaliações de qualidade permanecem ausentes ou pendentes.

A fase Petstore utiliza a **Swagger Petstore OpenAPI 3**. Consulte [`docs/pt-BR/Selecao_da_API.md`](docs/pt-BR/Selecao_da_API.md). O contrato JSON oficial está preservado em [`docs/api-specification/swagger-petstore-openapi.json`](docs/api-specification/swagger-petstore-openapi.json), com origem, data de obtenção, versões declaradas e checksum em [`docs/api-specification/README.md`](docs/api-specification/README.md). O subconjunto normativo de endpoints e os cenários estão congelados no protocolo versão 1.1; diferenças nos artefatos executados são registradas como desvios, não como mudanças retroativas.

## Tecnologias

- Java 21;
- Maven;
- REST Assured;
- Cucumber;
- JUnit 5;
- Swagger Petstore OpenAPI 3;
- Docker com Docker Compose.

## Execução técnica rápida

Pré-requisitos: Java 21, Maven e Docker com Docker Compose.

Inicie a instância controlada e confirme a disponibilidade do contrato:

```bash
docker compose -f datasets/petstore-feasibility-pilot/config/docker-compose.yml up -d
curl -i http://127.0.0.1:18080/api/v3/openapi.json
```

Execute cada suíte de forma isolada:

```bash
mvn -Dtest=runner.TestRunner test
mvn -Dtest=chatgpt.runner.ChatGPTTestRunner test
mvn -Dtest=copilot.runner.CopilotTestRunner test
```

Esses comandos verificam a executabilidade atual das suítes. Eles não reproduzem os tempos de implementação, as interações com as ferramentas nem a coleta experimental original. O procedimento completo e suas limitações estão em [`REPRODUCIBILITY.md`](REPRODUCIBILITY.md).

## Questões de pesquisa

A questão principal e as questões auxiliares foram formuladas para comparar produtividade e qualidade. Com os dados disponíveis, elas funcionam como orientação do estudo, mas não podem ser respondidas integralmente. A análise exploratória limita-se à executabilidade e aos status preservados para o subconjunto observado. As questões tratam de:

1. tempo de desenvolvimento e retrabalho;
2. correção inicial das validações, reúso de código, aderência ao BDD e qualidade estrutural.

Consulte [`docs/pt-BR/Questoes_de_Pesquisa.md`](docs/pt-BR/Questoes_de_Pesquisa.md).

## Métricas por fase

| Dimensão | Métrica | Interpretação |
| --- | --- | --- |
| Produtividade | Tempo de desenvolvimento | Piloto: tempo ativo; unidade e regras finais congeladas no protocolo v1.1 |
| Produtividade | Retrabalho | Número de correções manuais individuais realizadas após a primeira versão executável, conforme definido no estudo piloto |
| Qualidade | Correção inicial das validações | Piloto: validações corretas na primeira execução; escopo final congelado no protocolo v1.1 |
| Qualidade | Reúso de código | Piloto registrou percentual sem procedimento de cálculo preservado; rubrica final deve ser congelada |
| Qualidade | Aderência ao BDD | Piloto registrou cenários aderentes entre cinco e percentual; rubrica final deve ser congelada |
| Qualidade | Qualidade estrutural | Avaliada qualitativamente no piloto preliminar e planejada para avaliação quantitativa no experimento final com a rubrica documentada |

As definições históricas e decisões para a Fase 2 estão em [`docs/pt-BR/Metricas.md`](docs/pt-BR/Metricas.md). Métricas das duas fases não podem ser combinadas.

## Delineamento

Nos artefatos observados, cada abordagem implementou o mesmo conjunto de cinco cenários: criação válida, consulta por identificador, atualização, exclusão e consulta de pet inexistente. Essa equivalência permite comparação descritiva dos status desses cenários. Ela não comprova aplicação das cinquenta verificações nem conformidade integral com os cenários normativos da v1.1.

O estudo piloto utilizou cinco cenários veiculares confirmados: consulta de marcas, consulta de modelos por marca, consulta de ano/modelo, consulta de detalhes de veículo e consulta com parâmetro inválido. O nome oficial, URL, contrato e paths exatos da API histórica não foram preservados e não devem ser inferidos. Os cenários e verificações Petstore constituem um protocolo novo e não podem ser associados retroativamente aos resultados do piloto.

O procedimento operacional planejado está registrado no [Plano de Execução](docs/pt-BR/Plano_de_Execucao.md), no [Checklist de Execução](docs/pt-BR/Checklist_Pre_Execucao.md) e no [Plano de Controle Experimental](docs/pt-BR/Plano_de_Controle_Experimental.md). A existência desses instrumentos não comprova sua aplicação integral.

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

Os templates dos instrumentos de avaliação estão em [`docs/pt-BR/instrumentos/`](docs/pt-BR/instrumentos/). Eles não contêm consolidações finais e não são aplicados retrospectivamente aos resultados.

## Limitações e adaptações metodológicas

- O protocolo v1.1 permanece preservado como planejamento histórico e não foi reescrito para coincidir com os resultados.
- A execução observada foi reclassificada documentalmente como avaliação exploratória de um subconjunto de cinco cenários, não como execução integral do protocolo.
- C01/V10 não possui evidência consolidada; C04 e C05 executados diferem da matriz congelada.
- Os quinze status `PASS` sustentam somente a aprovação registrada dos cinco cenários efetivamente implementados em cada abordagem.
- Tempos ChatGPT/Copilot, V01–V50, rubricas, dados finais estruturados e parte da rastreabilidade permanecem ausentes ou pendentes e não são inferidos.
- Não são apresentadas conclusões quantitativas de produtividade, retrabalho ou qualidade sem os respectivos dados.

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
├── results/                   # Registros preservados Manual, ChatGPT e GitHub Copilot
├── EXPERIMENT_LOG.md          # Registro cronológico do experimento
├── REPRODUCIBILITY.md         # Instruções institucionais de reprodução
└── pom.xml                    # Configuração Maven com Java 21
```

## Prompts e idioma

Prompts, instruções, contexto, respostas e históricos devem permanecer no idioma exato utilizado durante o experimento. Esses registros não devem ser traduzidos ou reconstruídos posteriormente.

## Reprodutibilidade e dados

O procedimento de reprodução está em [`REPRODUCIBILITY.md`](REPRODUCIBILITY.md). Dados brutos não devem ser sobrescritos, e toda transformação deve manter vínculo com sua fase. Há resultados textuais para as três abordagens; tempos ChatGPT/Copilot, evidências V01–V50, consolidações das rubricas e datasets finais brutos/processados permanecem ausentes ou pendentes. Os vídeos Manual citados historicamente não integram o repositório versionado.

## Citação e DOI

Os metadados de citação estão em [`CITATION.cff`](CITATION.cff). **Nenhum DOI foi emitido para este repositório.** Um DOI somente poderá ser informado após sua emissão efetiva.

## Licença

O código-fonte e a documentação são disponibilizados sob a [`MIT License`](LICENSE). Materiais de terceiros e conjuntos de dados futuros poderão ter termos próprios, que deverão ser documentados.
