# Ameaças à Validade

## Validade de constructo

As seis métricas operacionalizam produtividade e qualidade, mas não esgotam esses conceitos. Tempo e retrabalho representam o esforço observado; cobertura de validação, reúso de código, aderência ao BDD e qualidade estrutural representam dimensões específicas da qualidade. A mitigação consiste em usar definições e instrumentos fixados antes da avaliação e em não extrapolar as conclusões além dessas medidas.

## Validade interna

Diferenças de entrada, configuração ou aplicação dos checks podem afetar a comparação. Embora os cinco cenários sejam funcionalmente distintos, cada cenário, seus materiais e seus critérios devem ser aplicados de forma idêntica às três abordagens. Alterações manuais, impedimentos e desvios precisam ser registrados. Variações inerentes ao GitHub Copilot e ao ChatGPT devem ser reconhecidas, sem atribuir automaticamente toda diferença observada à abordagem.

Há risco adicional de redefinir retrospectivamente o experimento ao alinhar documentação nova com resultados preliminares. A API, os cenários, os checks, as categorias e as métricas devem ser confirmados nos registros originais. Em caso de divergência material, os resultados devem ser classificados como piloto ou o experimento deve ser reexecutado; os registros originais não podem ser reescritos para se adequar ao protocolo posterior.

## Validade externa

Os resultados preliminares e os resultados consolidados estarão vinculados à API selecionada, aos cinco cenários, às cinquenta verificações, às ferramentas e ao contexto do TCC. Não se deve generalizar automaticamente para outras APIs, tarefas, IDEs, Large Language Models (LLMs) ou contextos profissionais.

## Validade de conclusão

Comparações com poucas implementações e um conjunto específico de tarefas podem sustentar apenas conclusões compatíveis com os dados observados. A análise será descritiva e apresentará os valores das seis métricas. Não serão presumidos testes inferenciais, significância estatística ou poder estatístico.

## Reprodutibilidade

Ferramentas assistidas por IA podem mudar e produzir respostas diferentes. Devem ser preservados, quando permitido, prompts no idioma original, interações, datas, configurações, identificadores observados, commits e artefatos. Versões desconhecidas não devem ser reconstruídas por suposição.

O ambiente público acrescenta interferência de terceiros, resets e indisponibilidade. Mesmo com contrato local preservado, o runtime pode divergir em códigos, autenticação, persistência ou schemas. Uma instância local/conteinerizada controlada reduz esses riscos e é recomendada para o experimento final, sem que sua configuração esteja incluída nesta alteração.

## Decisões pendentes

A Swagger Petstore - OpenAPI 3.0 está selecionada e seu contrato foi preservado localmente. Permanecem pendentes de revisão final o subconjunto de operações, o congelamento dos cinco cenários e cinquenta checks, a interpretação do valor de retrabalho e os instrumentos finais de pontuação de reúso de código, aderência ao BDD e qualidade estrutural. Esses itens devem ser confirmados a partir do desenho e dos registros reais, sem reconstrução por suposição.
