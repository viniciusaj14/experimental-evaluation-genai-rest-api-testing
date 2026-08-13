# Metodologia

## Natureza e objetivo do estudo

O estudo Petstore é relatado como uma **avaliação exploratória** de três abordagens para implementação de testes automatizados de API REST com Behavior-Driven Development (BDD): desenvolvimento Manual, desenvolvimento auxiliado por GitHub Copilot e desenvolvimento auxiliado por ChatGPT.

O objetivo analítico compatível com os dados disponíveis é descrever a implementação e a executabilidade do mesmo subconjunto de cinco cenários nas três abordagens. O estudo não estabelece superioridade de produtividade ou qualidade quando tempos, retrabalho, verificações ou rubricas necessários para essas comparações não estão preservados.

## Fases do estudo

1. **Piloto preliminar:** comparação das três abordagens em cinco cenários de uma API veicular pública cuja identidade e cujo contrato não foram preservados. Seus resultados não são combinados numericamente com a fase Petstore.
2. **Piloto de viabilidade Petstore:** verificação técnica dos ambientes público e controlado, executada em 12 de julho de 2026. Suas observações de viabilidade não integram as métricas da execução observada.
3. **Avaliação exploratória Petstore:** implementação, nas três abordagens, de um subconjunto observacional de cinco cenários registrado em `results/`.

A separação histórica entre as fases está documentada em [`Registro_de_Decisao_Piloto_e_Experimento_Final.md`](Registro_de_Decisao_Piloto_e_Experimento_Final.md). Os desvios identificados após a execução estão em [`Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md`](Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md).

## Planejamento e protocolo de referência

O protocolo v1.1 foi congelado antes das execuções e permanece preservado como registro histórico do planejamento. Ele previa cinco cenários normativos, cinquenta verificações por abordagem, seis métricas e a ordem Manual → GitHub Copilot → ChatGPT.

A preservação do protocolo não significa que ele tenha sido executado integralmente. Nenhuma regra, cenário ou resultado histórico foi reescrito retrospectivamente para fazer coincidir planejamento e execução.

## Objeto e ambiente tecnológico

A fase exploratória utilizou a Swagger Petstore OpenAPI 3.0. O contrato preservado está em [`docs/api-specification/swagger-petstore-openapi.json`](../api-specification/swagger-petstore-openapi.json), e a configuração do serviço controlado está em `datasets/petstore-feasibility-pilot/config/docker-compose.yml`.

Os artefatos utilizam Java 21, Maven, REST Assured, Cucumber e JUnit. A execução Manual original foi registrada por meio de `runner.TestRunner` na IntelliJ IDEA. As execuções ChatGPT e GitHub Copilot têm comandos específicos documentados no `EXPERIMENT_LOG.md`. Versões ou identificadores não preservados não são inferidos.

## Subconjunto de cenários executado

O conjunto efetivamente observado foi aplicado nas três abordagens:

| ID | Cenário observado |
|---|---|
| C01 | Criar um pet válido. |
| C02 | Consultar um pet pelo identificador. |
| C03 | Atualizar um pet existente. |
| C04 | Excluir um pet existente e verificar sua indisponibilidade. |
| C05 | Consultar um pet inexistente e esperar HTTP 404. |

Esse conjunto totaliza quinze unidades cenário-abordagem. Os arquivos de resultado preservam `PASS` para as cinco unidades de cada abordagem.

O subconjunto observado não equivale aos cinco cenários normativos do protocolo v1.1: o caso negativo C01/V10 não possui evidência consolidada, C04 substituiu a consulta por status pela exclusão e C05 substituiu a exclusão pela consulta de pet inexistente.

## Unidade e alcance da análise

A unidade documental observada é um cenário sob uma abordagem. A equivalência do subconjunto implementado entre as três abordagens permite descrever seus status e a executabilidade atual das suítes.

Os quinze registros `PASS` não demonstram, isoladamente:

- aplicação das cinquenta verificações V01–V50;
- correção inicial conforme a matriz normativa;
- reúso de código;
- aderência ao BDD segundo rubrica;
- qualidade estrutural segundo rubrica;
- produtividade ou retrabalho comparáveis.

## Dados e análise

Os arquivos em `results/manual`, `results/chatgpt` e `results/copilot` são preservados como registros existentes e não foram normalizados retrospectivamente. Os tempos Manual registrados aguardam validação para consolidação; os tempos ChatGPT e GitHub Copilot permanecem `PENDENTE`. Duração do Maven ou dos testes automatizados não é usada como tempo de implementação.

Não foram localizados registros completos de V01–V50, consolidações das rubricas, timestamps por unidade, contagens completas de ajustes, commits por cenário ou interações completas com as ferramentas assistidas. Ausência de registro não é tratada como zero, aprovação ou ausência de intervenção.

A análise permitida é descritiva e limitada aos status e artefatos efetivamente preservados. Não são produzidas métricas, pontuações ou comparações quantitativas sem evidência correspondente, e não são combinados dados do piloto veicular, do piloto de viabilidade e da avaliação exploratória Petstore.

## Limitações e adaptações metodológicas

1. A execução Petstore é caracterizada como avaliação exploratória de um subconjunto de cinco cenários, e não como execução integral do protocolo v1.1.
2. C01/V10, C04 e C05 apresentam divergências entre planejamento e execução.
3. A ordem prevista não é auditável com os registros temporais disponíveis.
4. Tempos de implementação das abordagens assistidas e contagens completas de retrabalho não estão disponíveis.
5. As cinquenta verificações e as rubricas de reúso, aderência ao BDD e qualidade estrutural não foram consolidadas.
6. Parte das versões de ferramentas, prompts, interações, commits e evidências audiovisuais não está disponível no repositório versionado.
7. Os resultados permitem conclusões apenas sobre o subconjunto, ambiente e artefatos observados; não sustentam generalização ampla sobre as ferramentas.

Essas adaptações modificam somente a interpretação documental. O protocolo congelado, o código, as features, os runners e os resultados experimentais permanecem preservados.

## Relato

O texto do TCC deve distinguir o planejamento v1.1 da avaliação exploratória executada, apresentar as divergências e ausências de evidência e limitar suas conclusões ao subconjunto observado. Nenhum tempo, métrica, resultado, versão ou procedimento ausente pode ser reconstruído por suposição.
