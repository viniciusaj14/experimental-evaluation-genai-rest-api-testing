# Protocolo do Experimento Final Petstore

> **Nota de adequação posterior:** este documento preserva o planejamento prospectivo que originou o protocolo v1.1. Os artefatos posteriormente observados correspondem a uma avaliação exploratória de cinco cenários e não demonstram execução integral deste protocolo. O estado executado está descrito em [`Metodologia.md`](Metodologia.md) e no [`Registro de Desvios`](Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md).

## Objetivo

Orientar a comparação controlada e auditável planejada entre três abordagens de desenvolvimento de testes automatizados da Swagger Petstore com Behavior-Driven Development (BDD): desenvolvimento manual, desenvolvimento assistido pelo GitHub Copilot e desenvolvimento assistido pelo ChatGPT. Na data de elaboração, este protocolo ainda não havia sido executado.

## Escopo confirmado

- três abordagens: manual, GitHub Copilot e ChatGPT;
- Swagger Petstore - OpenAPI 3.0 como API selecionada, conforme [contrato preservado](../api-specification/swagger-petstore-openapi.json);
- cinco cenários funcionalmente distintos, cada um aplicado de forma idêntica às três abordagens;
- cinquenta verificações de validação em cada abordagem;
- Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA;
- métricas de tempo de desenvolvimento, retrabalho, correção inicial das validações, reúso de código, aderência ao BDD e qualidade estrutural.

O objeto do estudo é a Swagger Petstore - OpenAPI 3.0. O subconjunto final de endpoints e os detalhes executáveis dos cinco cenários ainda dependem da revisão das matrizes de [endpoints](Inventario_de_Endpoints.md), [cenários](Matriz_de_Cenarios.md) e [validações](Matriz_de_Validacoes.md).

## Unidades e níveis de análise

- **Unidade de execução:** um cenário implementado sob uma abordagem de desenvolvimento.
- **Total de unidades de execução:** `5 cenários × 3 abordagens = 15`.
- **Registro observacional:** evidências e medições produzidas por uma unidade de execução.
- **Coleta por unidade de execução:** tempo de desenvolvimento, retrabalho e correção inicial das validações.
- **Consolidação por abordagem completa:** reúso de código, aderência ao BDD e qualidade estrutural, avaliados somente depois que os cinco cenários da abordagem estiverem concluídos.

Não se permite agregar dados entre o nível da unidade de execução e o nível da abordagem completa sem regra explícita aprovada e congelada antes da execução.

## Unidade de comparação

Cada abordagem deve produzir uma implementação dos mesmos cinco cenários e ser submetida às mesmas verificações planejadas para cada cenário. A comparabilidade é estabelecida entre manual, GitHub Copilot e ChatGPT dentro de cada cenário. Não se pressupõe que criação, consulta, atualização, filtro e exclusão tenham complexidade idêntica entre si. Requisitos, materiais de entrada, critérios de conclusão e ambiente devem ser iguais entre abordagens, exceto pela forma de desenvolvimento que caracteriza cada condição.

> **SEPARAÇÃO HISTÓRICA:** o estudo preliminar concluído utilizou uma API veicular pública não identificada e cinco cenários diferentes. Ele é classificado como piloto. Nenhum resultado desse piloto pode ser mapeado para a Swagger Petstore. Este protocolo define um experimento final novo que deverá ser executado após congelamento.

## Abordagens

1. **Desenvolvimento manual:** implementação sem assistência de IA generativa.
2. **GitHub Copilot:** implementação com assistência do GitHub Copilot, respeitando o registro definido em `prompts/github-copilot.md`.
3. **ChatGPT:** implementação com assistência do ChatGPT, respeitando o registro definido em `prompts/chatgpt.md`.

## Preparação

Antes da execução, devem ser registrados:

- a integridade da especificação local e sua correspondência com a [seleção da API](Selecao_da_API.md);
- a conclusão do [piloto de viabilidade](Piloto_de_Viabilidade.md), cujos valores não integram o experimento final;
- a aprovação do subconjunto final de endpoints e dos cinco cenários candidatos;
- a revisão e o congelamento das cinquenta verificações planejadas e de seus critérios;
- as regras de início, pausa e término da medição de tempo;
- os instrumentos de avaliação de reúso de código, aderência ao BDD e qualidade estrutural;
- as versões e identificadores de ferramentas efetivamente observados;
- os critérios para registrar retrabalho e tratar impedimentos ou falhas técnicas.
- o registro da pré-randomização que define a ordem de GitHub Copilot e ChatGPT após a condição manual.

Decisões ainda pendentes devem permanecer identificadas como pendentes e ser resolvidas antes da coleta correspondente.

## Procedimento

1. Registrar a abordagem, o commit, o ambiente e os materiais de entrada.
2. Executar primeiro a condição manual e, depois, GitHub Copilot e ChatGPT na ordem pré-randomizada e preservada antes do congelamento.
3. Implementar os cinco cenários conforme as regras da abordagem, produzindo um registro observacional por unidade de execução.
4. Registrar tempo de desenvolvimento, retrabalho e correção inicial das validações por unidade de execução, conforme `Metricas.md`.
5. Preservar os prompts e as interações permitidas no idioma exato em que ocorreram.
6. Aplicar as dez verificações correspondentes durante cada unidade de execução, totalizando cinquenta por abordagem, sem apagar o estado da primeira execução.
7. Somente após os cinco cenários de uma abordagem, avaliar reúso de código, aderência ao BDD e qualidade estrutural com os instrumentos definidos previamente.
8. Armazenar os registros originais em `datasets/final-experiment/raw/`, sem sobrescrita.
9. Documentar correções, exclusões, impedimentos e qualquer desvio do protocolo em `EXPERIMENT_LOG.md`.

A [matriz de rastreabilidade](Matriz_de_Rastreabilidade.md) conecta objetivo, questões, API, cenários, validações, métricas e futuros resultados.

## Tratamento dos dados

Transformações documentadas podem gerar arquivos em `datasets/final-experiment/processed/`. Tabelas, gráficos, relatórios e análises devem ser derivados desses registros sem alterar os dados brutos. A comparação prevista é descritiva e deve apresentar os valores das métricas aprovadas para as três abordagens. Este protocolo não pressupõe testes estatísticos inferenciais e não admite combinação com valores do piloto veicular.

## Status dos resultados e artefatos

O piloto veicular possui resultados históricos e é documentado separadamente. O [piloto de viabilidade Petstore](Relatorio_do_Piloto_de_Viabilidade.md) foi concluído e recomendou o ambiente controlado; na data deste registro, o experimento Petstore ainda não havia sido executado. Naquele momento permaneciam pendentes: aceitação formal da configuração controlada e de seus riscos, revisão do subconjunto de operações, congelamento das matrizes, aprovação das fórmulas e consolidação dos instrumentos de avaliação.
