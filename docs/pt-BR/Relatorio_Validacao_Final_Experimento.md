# Relatório de Validação Final do Experimento

## Identificação

| Campo | Valor |
|---|---|
| Data da revisão documental | 9 de agosto de 2026 |
| Versão aplicável do protocolo | `1.1` |
| Commit-base científico registrado | `d626e1b95f979e33a3e41d6d4489b5b3ad54191f` |
| Branch analisada | `experiment/consolidation` |
| Commit `HEAD` analisado | `751587dccec1279bff237652d87bc65497108103` |
| Natureza da validação | Revisão documental do estudo exploratório, complementada por validação técnica pós-consolidação das três suítes, sem integração à coleta oficial |

## Escopo avaliado

O estudo documentado observa exploratoriamente três abordagens para criação de testes automatizados de API REST com BDD:

1. desenvolvimento Manual;
2. implementação auxiliada por ChatGPT;
3. implementação auxiliada por GitHub Copilot.

Cada abordagem possui registros para o mesmo subconjunto de cinco cenários, C01–C05. Portanto, o repositório documenta quinze unidades cenário-abordagem. Esse subconjunto não equivale à execução integral dos cinco cenários normativos e das cinquenta verificações do protocolo v1.1.

## Comandos e formas de execução registrados

| Abordagem | Comando ou forma de execução | Ambiente documentado |
|---|---|---|
| Manual | `runner.TestRunner` executado diretamente pela IntelliJ IDEA. Não foi preservada uma linha de comando Maven específica. | macOS, IntelliJ IDEA, Java, Cucumber + JUnit, Rest Assured e Swagger Petstore local. |
| ChatGPT | `mvn -Dtest=chatgpt.runner.ChatGPTTestRunner test` | OpenJDK 21.0.6, Maven 3.9.11 e Swagger Petstore controlada em `http://127.0.0.1:18080/api/v3`. |
| GitHub Copilot | `mvn -Dtest=copilot.runner.CopilotTestRunner test` | OpenJDK 21.0.6, Maven 3.9.11 e Swagger Petstore controlada em `http://127.0.0.1:18080/api/v3`. |

## Resultado consolidado das execuções documentadas

| Abordagem | Cenários documentados | Testes/cenários com `PASS` | Falhas | Erros | Ignorados | Resultado registrado |
|---|---:|---:|---:|---:|---:|---|
| Manual | 5 | 5 | Não consolidado pelo runner | Não consolidado pelo runner | Não consolidado pelo runner | C01–C05 registrados como `PASS` |
| ChatGPT | 5 | 5 | 0 | 0 | 0 | `BUILD SUCCESS` |
| GitHub Copilot | 5 | 5 | 0 | 0 | 0 | `BUILD SUCCESS` |
| **Total documental** | **15 unidades** | **15 registros `PASS`** | — | — | — | Três abordagens com cinco cenários aprovados nos registros existentes |

Para ChatGPT e GitHub Copilot, o `EXPERIMENT_LOG.md` registra explicitamente `Tests run: 5`, `Failures: 0`, `Errors: 0`, `Skipped: 0` e `BUILD SUCCESS`. Para a abordagem Manual, a contagem de cinco aprovações deriva dos cinco arquivos de resultado preservados, e não de um relatório Maven consolidado.

## Cenários presentes nos resultados consolidados

| ID | Descrição registrada nas execuções | Situação documental nas três abordagens |
|---|---|---|
| C01 | Criar um pet válido | `PASS` |
| C02 | Consultar pet pelo identificador | `PASS` |
| C03 | Atualizar pet existente | `PASS` |
| C04 | Excluir pet existente | `PASS` |
| C05 | Consultar pet inexistente por `GET /pet/{id}` | `PASS` |

## Limitações e adaptações metodológicas

1. Este relatório valida os registros existentes; ele não representa uma nova execução independente das suítes.
2. A fase Petstore é relatada como avaliação exploratória do subconjunto efetivamente implementado, sem alegação de execução integral do protocolo v1.1.
3. O `Protocolo_Congelado_v1.1.md` registra corretamente o estado pré-experimental `0 de 15` na data de congelamento. O `EXPERIMENT_LOG.md` distingue essa fotografia histórica do estado observacional posterior, sem alterar retroativamente o protocolo.
4. Os cenários registrados não coincidem integralmente com a matriz congelada v1.1: a matriz define C04 como filtro por status e C05 como exclusão, além de fixar o caso negativo JSON malformado em C01/V10; os resultados usam C04 para exclusão e C05 para consulta de pet inexistente.
5. Os registros `PASS` por cenário não demonstram, isoladamente, a aplicação e consolidação das cinquenta verificações V01–V50 previstas.
6. A abordagem Manual não preservou um comando Maven específico nem as versões exatas da IDE e das bibliotecas usadas na execução original.
7. Os arquivos Manual não têm formato totalmente uniforme; em particular, o resultado de C02 usa a extensão preservada `resultado.tx`.
8. Os tempos internos do Maven e dos testes automatizados não podem substituir o tempo de implementação informado pelo pesquisador.
9. Não são calculadas produtividade, retrabalho ou qualidade na ausência dos dados e instrumentos correspondentes.
10. A revisão foi feita na branch `experiment/consolidation` e não realizou validação cruzada dos históricos isolados das branches de cada abordagem.

## Pendências dos tempos de implementação

Os arquivos Manual contêm tempos registrados, mas a tabela comparativa do `EXPERIMENT_LOG.md` ainda mantém todas as células como `PENDENTE`. Os tempos ChatGPT e GitHub Copilot permanecem explicitamente pendentes e não devem ser preenchidos com duração do Maven ou dos testes.

| Cenário | Manual | ChatGPT | GitHub Copilot | Ação pendente |
|---|---|---|---|---|
| C01 | 28m02s registrado | `PENDENTE` | `PENDENTE` | Pesquisador deve validar/transcrever o valor Manual e informar os tempos assistidos. |
| C02 | 16m23s registrado | `PENDENTE` | `PENDENTE` | Pesquisador deve validar/transcrever o valor Manual e informar os tempos assistidos. |
| C03 | 1h00m55s registrado | `PENDENTE` | `PENDENTE` | Pesquisador deve validar/transcrever o valor Manual e informar os tempos assistidos. |
| C04 | 34m28s registrado | `PENDENTE` | `PENDENTE` | Pesquisador deve validar/transcrever o valor Manual e informar os tempos assistidos. |
| C05 | 08m09s registrado | `PENDENTE` | `PENDENTE` | Pesquisador deve validar/transcrever o valor Manual e informar os tempos assistidos. |

O tempo de implementação deve representar o esforço desde o início da implementação até a validação final com `PASS`, incluindo geração, ajustes e validação, conforme as regras metodológicas aplicáveis.

## Validação técnica pós-consolidação

Em 9 de agosto de 2026, as três suítes foram reexecutadas somente como checagem técnica do estado consolidado. Essa execução não integra a coleta oficial e não altera resultados ou tempos experimentais.

| Abordagem | Comando | Testes | Falhas | Erros | Ignorados | Resultado |
|---|---|---:|---:|---:|---:|---|
| Manual | `mvn -Dtest=runner.TestRunner test` | 5 | 0 | 0 | 0 | `BUILD SUCCESS` |
| ChatGPT | `mvn -Dtest=chatgpt.runner.ChatGPTTestRunner test` | 5 | 0 | 0 | 0 | `BUILD SUCCESS` |
| GitHub Copilot | `mvn -Dtest=copilot.runner.CopilotTestRunner test` | 5 | 0 | 0 | 0 | `BUILD SUCCESS` |

O resultado confirma a executabilidade atual das suítes, mas não resolve as ausências de V01–V50, rubricas, tempos, prompts, timestamps ou a divergência entre protocolo e cenários executados.

## Conclusão

O repositório contém resultados documentais para três abordagens, cinco cenários observados por abordagem e quinze registros `PASS`. Esses dados sustentam uma descrição exploratória da executabilidade do subconjunto implementado. Não sustentam execução integral do protocolo v1.1 nem conclusões quantitativas de produtividade ou qualidade. Permanecem ausentes ou pendentes tempos assistidos, transcrição validada dos tempos Manual, V01–V50, rubricas e demais evidências metodológicas indicadas neste relatório.
