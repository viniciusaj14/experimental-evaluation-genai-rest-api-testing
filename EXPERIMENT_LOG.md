# Registro do Experimento

Utilize uma seção para cada execução ou evento de protocolo. Falhas, impedimentos e desvios não devem ser apagados.

## Modelo de registro

- **Identificador da execução/evento:**
- **Unidade de execução:** um cenário sob uma abordagem / não aplicável a evento de protocolo
- **Nível do registro:** unidade de execução / abordagem completa / evento de protocolo
- **Data, horário e fuso:**
- **Fase do estudo:** piloto preliminar / piloto de viabilidade Petstore / experimento final
- **Abordagem:** manual / GitHub Copilot / ChatGPT / protocolo
- **Commit:**
- **Ambiente efetivamente observado:** registrar somente ferramentas presentes na fase correspondente, sem preencher tecnologias por padrão
- **Versões ou identificadores efetivamente observados:**
- **Identificadores dos cinco cenários:**
- **Cenário desta unidade:** preencher somente no registro de unidade de execução
- **Início, pausas, retomadas e término:**
- **Ajustes após a primeira versão executável (contagem por unidade):**
- **Detalhes de cada ajuste:** critério/verificação, descrição, origem da correção (manual / sugestão aceita do GitHub Copilot / conteúdo do ChatGPT aplicado), arquivos, evidência e reexecução
- **Registro das cinquenta verificações:**
- **Artefatos de reúso, aderência ao BDD e qualidade estrutural:**
- **Consolidação das rubricas:** preencher somente no registro de abordagem completa, após os cinco cenários
- **Registro de pré-randomização das condições assistidas:** método, resultado, timestamp, responsável e semente, quando aplicável
- **Entradas e saídas:**
- **Status:** planejado / concluído / impedido / excluído
- **Correções, intervenções ou desvios:**
- **Observações:**

O piloto preliminar possui execuções e resultados, mas seus registros não estão publicados neste repositório. O piloto de viabilidade Petstore foi executado em 12 de julho de 2026; o experimento final ainda não foi iniciado. Ao incorporar registros, identificar obrigatoriamente a fase e preservar o conteúdo original sem reconstrução retrospectiva.

## PV-2026-07-12-PUBLIC

- **Data, horário e fuso:** 2026-07-12, 14:46:17–14:46:28, UTC−03:00
- **Fase do estudo:** piloto de viabilidade Petstore
- **Nível do registro:** evento de protocolo
- **Ambiente:** público
- **Base URL:** `https://petstore3.swagger.io/api/v3`
- **Identificador exclusivo:** `912071200001`
- **Procedimento:** contrato, ausência, autenticação, criação, persistência, atualização, filtro em duas amostras, entradas inválidas, exclusão e confirmação de limpeza
- **Status:** concluído
- **Evidências:** `datasets/petstore-feasibility-pilot/raw/public/`
- **Métricas do experimento final:** não coletadas

## PV-2026-07-12-CONTROLLED

- **Data, horário e fuso:** 2026-07-12, 14:48:14–14:48:17, UTC−03:00
- **Fase do estudo:** piloto de viabilidade Petstore
- **Nível do registro:** evento de protocolo
- **Ambiente:** controlado em `http://127.0.0.1:18080/api/v3`
- **Runtime:** Docker cliente/servidor `29.4.0`; `swaggerapi/petstore3:1.0.27@sha256:749432676c31cd05256f0d9e878302164debb94daa1c1223e193747e1b34e7d1`; imagem `linux/amd64` em host Docker `linux/arm64/v8`
- **Identificador exclusivo:** `912071200002`
- **Procedimento:** mesmo roteiro do ambiente público; container removido após a coleta
- **Status:** concluído
- **Evidências:** `datasets/petstore-feasibility-pilot/raw/controlled/`
- **Limitação preservada:** tentativa anterior em contexto restrito retornou status de transporte `000`; ver `raw/controlled-restricted-context-attempt/`
- **Métricas do experimento final:** não coletadas

## Decisão produzida pelo piloto

Recomenda-se o ambiente controlado para o futuro experimento final, sujeito à aceitação formal da imagem fixada por digest, da emulação de arquitetura e dos riscos residuais. Autenticação e segundo `DELETE` não devem ser usados como oráculos. O relatório completo está em `docs/pt-BR/Relatorio_do_Piloto_de_Viabilidade.md`.

## Revisão pré-experimental do protocolo — v1.1

- **Data:** 13 de julho de 2026
- **Experimento final iniciado:** não
- **Unidades finais executadas:** 0 de 15
- **Observação de treino:** payload de criação sem `name` retornou HTTP `200`
- **Observação de viabilidade:** JSON sintaticamente malformado com `Content-Type: application/json` retornou HTTP `400`
- **Tratamento dos dados:** dados de treino são proibidos nas métricas do experimento final
- **Nova versão aplicável:** `1.1`
- **Novo commit-base:** `d626e1b95f979e33a3e41d6d4489b5b3ad54191f`
- **Tag proposta:** `protocol-v1.1` — não criada

## Execuções Experimentais - Manual

- **Abordagem:** desenvolvimento Manual.
- **Execução:** a abordagem Manual foi executada utilizando o runner `runner.TestRunner` por meio da IDE IntelliJ IDEA.
- **Ambiente experimental:**
  - Sistema operacional: macOS;
  - IDE: IntelliJ IDEA;
  - Linguagem: Java;
  - Framework de testes: Cucumber + JUnit;
  - Biblioteca HTTP: Rest Assured;
  - API: Swagger Petstore local.
- **Limitação:** Não foi preservado um comando Maven específico para a execução Manual, pois a execução original ocorreu diretamente pelo runner da IDE.
- **Observações:** os cinco cenários foram concluídos com `PASS`; ajustes observados durante C01–C03 permanecem descritos nos arquivos de tempo. Os registros manuais não foram normalizados retroativamente.

| ID | Cenário | Resultado esperado | Resultado obtido | Status |
|---|---|---|---|---|
| C01 | Criar um pet válido | HTTP 200 e nome retornado correspondente ao enviado. | Critérios atendidos conforme registro preservado. | PASS |
| C02 | Consultar pet pelo identificador | HTTP 200 e ID retornado correspondente ao consultado. | Critérios atendidos conforme registro preservado. | PASS |
| C03 | Atualizar pet existente | HTTP 200, nome e status atualizados. | Critérios atendidos conforme registro preservado. | PASS |
| C04 | Excluir pet existente | HTTP 200 e pet indisponível após a exclusão. | Critérios atendidos conforme registro preservado. | PASS |
| C05 | Consultar pet inexistente | GET `/pet/{id}` retorna HTTP 404. | Critérios atendidos conforme registro preservado. | PASS |

Evidências documentais:

| ID | Resultado | Tempo |
|---|---|---|
| C01 | `results/manual/C01/resultado.txt` | `results/manual/C01/tempo_execucao.txt` |
| C02 | `results/manual/C02/resultado.tx` | `results/manual/C02/tempo_execucao.txt` |
| C03 | `results/manual/C03/resultado.txt` | `results/manual/C03/tempo_execucao.txt` |
| C04 | `results/manual/C04/resultado.txt` | `results/manual/C04/tempo_execucao.txt` |
| C05 | `results/manual/C05/resultado.txt` | `results/manual/C05/tempo_execucao.txt` |

## Execuções Experimentais - ChatGPT

- **Abordagem:** implementação auxiliada por ChatGPT.
- **Comando:** `mvn -Dtest=chatgpt.runner.ChatGPTTestRunner test`.
- **Ambiente observado:** OpenJDK 21.0.6, Maven 3.9.11 e Swagger Petstore controlada em `http://127.0.0.1:18080/api/v3`.
- **Limitações:** tempos de implementação ainda pendentes de preenchimento pelo pesquisador; tempos internos do Maven e dos testes não podem ser usados como métrica experimental.

| ID | Cenário | Resultado esperado | Resultado obtido | Status |
|---|---|---|---|---|
| C01 | Criar um pet válido | HTTP 200 e nome retornado correspondente ao enviado. | HTTP 200 e nome correspondente ao enviado. | PASS |
| C02 | Consultar pet pelo identificador | HTTP 200 e ID retornado correspondente ao consultado. | HTTP 200 e ID correspondente ao consultado. | PASS |
| C03 | Atualizar pet existente | HTTP 200, nome e status atualizados. | HTTP 200, mesmo ID, novo nome e status atualizado. | PASS |
| C04 | Excluir pet existente | HTTP 200 e consulta posterior retorna HTTP 404. | HTTP 200 na exclusão e HTTP 404 na consulta posterior. | PASS |
| C05 | Consultar pet inexistente por GET `/pet/{id}` | HTTP 404 e body `Pet not found`. | HTTP 404 e body `Pet not found`. | PASS |

Evidências documentais:

| ID | Resultado | Tempo |
|---|---|---|
| C01 | `results/chatgpt/C01/resultado.txt` | `results/chatgpt/C01/tempo_execucao.txt` |
| C02 | `results/chatgpt/C02/resultado.txt` | `results/chatgpt/C02/tempo_execucao.txt` |
| C03 | `results/chatgpt/C03/resultado.txt` | `results/chatgpt/C03/tempo_execucao.txt` |
| C04 | `results/chatgpt/C04/resultado.txt` | `results/chatgpt/C04/tempo_execucao.txt` |
| C05 | `results/chatgpt/C05/resultado.txt` | `results/chatgpt/C05/tempo_execucao.txt` |

Resultado final:

```text
Tests run: 5
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

## Execuções Experimentais - GitHub Copilot

- **Abordagem:** implementação auxiliada por GitHub Copilot.
- **Comando:** `mvn -Dtest=copilot.runner.CopilotTestRunner test`.
- **Ambiente observado:** OpenJDK 21.0.6, Maven 3.9.11 e Swagger Petstore controlada em `http://127.0.0.1:18080/api/v3`.
- **Quantidade de testes executados:** 5.
- **Limitações:** tempos de implementação ainda pendentes de preenchimento pelo pesquisador; tempos internos do Maven e dos testes não podem ser usados como métrica experimental.

| ID | Cenário | Resultado esperado | Resultado obtido | Status |
|---|---|---|---|---|
| C01 | Criar um pet válido | HTTP 200 e nome retornado correspondente ao enviado. | HTTP 200 e nome correspondente ao enviado. | PASS |
| C02 | Consultar pet pelo identificador | HTTP 200 e ID retornado correspondente ao consultado. | HTTP 200 e ID correspondente ao consultado. | PASS |
| C03 | Atualizar pet existente | HTTP 200, nome e status atualizados. | HTTP 200, mesmo ID, novo nome e status atualizado. | PASS |
| C04 | Excluir pet existente | HTTP 200 e consulta posterior retorna HTTP 404. | HTTP 200 na exclusão e HTTP 404 na consulta posterior. | PASS |
| C05 | Consultar pet inexistente por GET `/pet/{id}` | HTTP 404 e body `Pet not found`. | HTTP 404 e body `Pet not found`. | PASS |

Evidências documentais:

| ID | Resultado | Tempo |
|---|---|---|
| C01 | `results/copilot/C01/resultado.txt` | `results/copilot/C01/tempo_execucao.txt` |
| C02 | `results/copilot/C02/resultado.txt` | `results/copilot/C02/tempo_execucao.txt` |
| C03 | `results/copilot/C03/resultado.txt` | `results/copilot/C03/tempo_execucao.txt` |
| C04 | `results/copilot/C04/resultado.txt` | `results/copilot/C04/tempo_execucao.txt` |
| C05 | `results/copilot/C05/resultado.txt` | `results/copilot/C05/tempo_execucao.txt` |

Resultado final:

```text
Tests run: 5
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

## Consolidação experimental para análise comparativa

Os valores abaixo serão preenchidos posteriormente pelo pesquisador a partir dos registros experimentais preservados. `PENDENTE` não representa zero, ausência de esforço ou resultado automático.

| Cenário | Manual | ChatGPT | GitHub Copilot |
|--------|--------|---------|----------------|
| C01 | PENDENTE | PENDENTE | PENDENTE |
| C02 | PENDENTE | PENDENTE | PENDENTE |
| C03 | PENDENTE | PENDENTE | PENDENTE |
| C04 | PENDENTE | PENDENTE | PENDENTE |
| C05 | PENDENTE | PENDENTE | PENDENTE |

## Critérios de comparação

- **Tempo de implementação:** esforço registrado pelo pesquisador desde o início da implementação até a validação final com resultado `PASS`, conforme as regras experimentais; não usar tempo interno do Maven ou dos testes automatizados.
- **Taxa de sucesso da execução:** resultado observado das execuções planejadas, preservando falhas, erros, itens ignorados e reexecuções sem inferir valores ausentes.
- **Necessidade de intervenção humana:** intervenções realizadas pelo pesquisador para interpretar, adaptar, aplicar ou corrigir a solução de cada abordagem.
- **Quantidade de ajustes necessários:** ajustes registrados após a primeira versão executável, conforme a definição metodológica aplicável.
- **Manutenção da qualidade dos testes BDD:** aderência dos cenários e implementações aos critérios BDD e às evidências previstas nos instrumentos do experimento.
