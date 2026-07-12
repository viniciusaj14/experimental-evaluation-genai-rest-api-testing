# Ameaças à Validade

## Validade de constructo

As métricas do piloto operacionalizam dimensões de produtividade e qualidade, mas não esgotam esses conceitos. Tempo ativo e ajustes representam esforço; correção inicial, reúso e aderência BDD representam dimensões específicas da qualidade. Qualidade estrutural foi discutida qualitativamente, sem pontuação objetiva consolidada confirmada. No experimento final, definições e rubricas devem ser congeladas antes da execução.

## Validade interna

Diferenças de entrada, configuração ou aplicação das verificações podem afetar a comparação. Embora os cinco cenários sejam funcionalmente distintos, cada cenário, seus materiais e seus critérios devem ser aplicados de forma idêntica às três abordagens. Alterações corretivas, impedimentos e desvios precisam ser registrados. Variações inerentes ao GitHub Copilot e ao ChatGPT devem ser reconhecidas, sem atribuir automaticamente toda diferença observada à abordagem.

A revisão histórica confirmou divergência entre o piloto veicular e o protocolo Petstore. O principal risco retrospectivo é atribuir ao piloto uma API, contrato, endpoints, prompts ou artefatos que não foram preservados, ou recalcular seus valores com verificações Petstore. A mitigação é classificá-lo como piloto, preservar seus registros originais e reexecutar o experimento final sob o protocolo Petstore congelado.

## Validade externa

Os resultados do piloto estão vinculados à API veicular não identificada e aos cinco cenários históricos. Os futuros resultados finais estarão vinculados à Swagger Petstore, aos novos cenários, verificações, ferramentas e contexto do TCC. Não se deve generalizar automaticamente entre as duas fases nem para outras APIs, tarefas, IDEs, Large Language Models (LLMs) ou contextos profissionais.

## Validade de conclusão

Comparações com poucas implementações e tarefas específicas sustentam apenas conclusões compatíveis com a fase observada. Piloto e experimento final devem ter análises separadas, sem combinação numérica. Não serão presumidos testes inferenciais, significância estatística ou poder estatístico.

## Reprodutibilidade

Ferramentas assistidas por IA podem mudar e produzir respostas diferentes. Devem ser preservados, quando permitido, prompts no idioma original, interações, datas, configurações, identificadores observados, commits e artefatos. Versões desconhecidas não devem ser reconstruídas por suposição.

O ambiente público acrescenta interferência de terceiros, resets e indisponibilidade. Mesmo com contrato local preservado, o runtime pode divergir em códigos, autenticação, persistência ou schemas. Uma instância local/conteinerizada controlada reduz esses riscos e é recomendada para o experimento final, sem que sua configuração esteja incluída nesta alteração.

## Decisões pendentes

A Swagger Petstore - OpenAPI 3.0 está selecionada para o experimento final e seu contrato foi preservado localmente. Permanecem pendentes o ambiente, o subconjunto de operações, o congelamento dos cinco cenários e cinquenta verificações e os instrumentos finais. A fórmula histórica de retrabalho foi identificada, mas sua reutilização no experimento final exige aprovação prévia. A qualidade estrutural do piloto não possui pontuação numérica consolidada confirmada.
