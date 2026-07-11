# Protocolo Experimental

## Objetivo

Orientar uma comparação controlada e auditável entre três abordagens de desenvolvimento de testes automatizados de API REST com Behavior-Driven Development (BDD): desenvolvimento manual, desenvolvimento assistido pelo GitHub Copilot e desenvolvimento assistido pelo ChatGPT.

## Escopo confirmado

- três abordagens: manual, GitHub Copilot e ChatGPT;
- Swagger Petstore - OpenAPI 3.0 como API selecionada, conforme [contrato preservado](../api-specification/swagger-petstore-openapi.json);
- cinco cenários funcionalmente distintos, cada um aplicado de forma idêntica às três abordagens;
- cinquenta verificações de validação em cada abordagem;
- Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA;
- métricas de tempo de desenvolvimento, retrabalho, cobertura de validação, reúso de código, aderência ao BDD e qualidade estrutural.

O objeto do estudo é a Swagger Petstore - OpenAPI 3.0. O subconjunto final de endpoints e os detalhes executáveis dos cinco cenários ainda dependem da revisão das matrizes de [endpoints](Inventario_de_Endpoints.md), [cenários](Matriz_de_Cenarios.md) e [validações](Matriz_de_Validacoes.md).

## Unidade de comparação

Cada abordagem deve produzir uma implementação dos mesmos cinco cenários e ser submetida às mesmas verificações planejadas para cada cenário. A comparabilidade é estabelecida entre manual, GitHub Copilot e ChatGPT dentro de cada cenário. Não se pressupõe que criação, consulta, atualização, filtro e exclusão tenham complexidade idêntica entre si. Requisitos, materiais de entrada, critérios de conclusão e ambiente devem ser iguais entre abordagens, exceto pela forma de desenvolvimento que caracteriza cada condição.

> **ALERTA DE CONSISTÊNCIA METODOLÓGICA:** a API, os cenários e a matriz de validações desta proposta devem ser confrontados com os registros originais do experimento preliminar. Somente procedimentos confirmados nesses registros podem ser descritos como executados. Se houver divergência material, os resultados preliminares devem ser classificados como piloto ou o experimento deve ser reexecutado com o protocolo congelado.

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

Decisões ainda pendentes devem permanecer identificadas como pendentes e ser resolvidas antes da coleta correspondente.

## Procedimento

1. Registrar a abordagem, o commit, o ambiente e os materiais de entrada.
2. Implementar os cinco cenários conforme as regras da abordagem.
3. Registrar o tempo de desenvolvimento e o retrabalho de acordo com os registros originais e com a definição que ainda será confirmada em `Metricas.md`.
4. Preservar os prompts e as interações permitidas no idioma exato em que ocorreram.
5. Aplicar as mesmas cinquenta verificações à implementação concluída.
6. Avaliar reúso de código, aderência ao BDD e qualidade estrutural com os instrumentos definidos previamente.
7. Armazenar os registros originais em `datasets/raw/`, sem sobrescrita.
8. Documentar correções, exclusões, impedimentos e qualquer desvio do protocolo em `EXPERIMENT_LOG.md`.

A [matriz de rastreabilidade](Matriz_de_Rastreabilidade.md) conecta objetivo, questões, API, cenários, validações, métricas e futuros resultados.

## Tratamento dos dados

Transformações documentadas podem gerar arquivos em `datasets/processed/`. Tabelas, gráficos, relatórios e análises devem ser derivados desses registros sem alterar os dados brutos. A comparação prevista é descritiva e deve apresentar os valores das seis métricas para as três abordagens. Este protocolo não pressupõe testes estatísticos inferenciais.

## Status dos resultados e artefatos

O estudo possui resultados preliminares. Os dados experimentais e os resultados consolidados ainda não estão publicados neste repositório e, portanto, nenhum valor deve ser reproduzido, estimado ou inventado neste documento. Essa condição é distinta das decisões ainda pendentes: revisão final do subconjunto de operações, congelamento das matrizes de cenários e validações, confirmação da interpretação de retrabalho e consolidação dos instrumentos de avaliação.
