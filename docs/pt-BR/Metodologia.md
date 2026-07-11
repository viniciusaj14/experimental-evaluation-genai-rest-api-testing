# Metodologia

> **Nota sobre a evolução deste documento:** este arquivo é um registro metodológico em evolução. Ele deverá ser revisado para refletir exclusivamente os procedimentos efetivamente realizados no estudo. A versão final da seção de Metodologia do TCC USP/ESALQ será redigida de forma impessoal e no tempo passado. Formulações prospectivas ou itens pendentes presentes aqui não devem ser interpretados como procedimentos já executados.

> **ALERTA DE CONSISTÊNCIA METODOLÓGICA:** a seleção da Swagger Petstore, os cinco cenários candidatos e os cinquenta checks planejados devem ser conferidos com os registros originais do experimento preliminar. Eles não podem ser apresentados como procedimentos já executados sem confirmação. Em caso de divergência material, os resultados preliminares devem ser classificados como piloto ou o experimento deve ser reexecutado sob o desenho congelado. Os registros originais devem ser preservados sem redefinição retrospectiva.

## Delineamento do estudo

O estudo realiza uma comparação experimental entre desenvolvimento manual, GitHub Copilot e ChatGPT na automação de testes de API REST com Behavior-Driven Development (BDD). Cada abordagem implementará os mesmos cinco cenários de teste e será avaliada pelas mesmas cinquenta verificações.

Não são pressupostos múltiplos participantes, avaliadores cegos, randomização, cálculo de poder estatístico ou testes estatísticos inferenciais. Caso alguma dessas decisões venha a integrar efetivamente o TCC, deverá ser documentada antes de sua aplicação; até lá, não faz parte da metodologia.

## Ambiente tecnológico

As implementações utilizam Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA. As versões ou identificadores não confirmados não devem ser inferidos. O ambiente observado durante a execução deve ser registrado no log experimental.

## Objeto de estudo

A API selecionada é a Swagger Petstore - OpenAPI 3.0, uma aplicação de demonstração oficial do ecossistema Swagger e não desenvolvida por esta pesquisa. A [seleção](Selecao_da_API.md) e o [inventário de endpoints](Inventario_de_Endpoints.md) são fundamentados na [especificação oficial preservada](../api-specification/swagger-petstore-openapi.json). A cópia local fixa o contrato metodológico, mas não elimina mudanças, resets ou interferência de dados no ambiente público.

## Comparabilidade entre abordagens

Os cinco cenários são funcionalmente distintos. Cada cenário, suas entradas, checks, materiais de apoio e critérios de conclusão devem ser aplicados de forma idêntica ao desenvolvimento manual, ao GitHub Copilot e ao ChatGPT. A diferença planejada dentro de cada cenário é a abordagem de desenvolvimento. Não se exige que operações HTTP diferentes tenham complexidade idêntica; exige-se comparabilidade entre abordagens para a mesma tarefa. Intervenções manuais e desvios devem ser registrados para não serem confundidos com efeitos da abordagem.

Os candidatos estão documentados na [matriz de cenários](Matriz_de_Cenarios.md), com dez checks por cenário na [matriz de validações](Matriz_de_Validacoes.md). O subconjunto final ainda deve ser congelado após revisão crítica de comparabilidade entre abordagens, independência, complexidade relativa, determinismo, limpeza e interferência pública.

## Alternativas de ambiente

1. **Instância pública `petstore3.swagger.io`:** facilita acesso, mas está sujeita a dados de terceiros, resets, indisponibilidade e divergência entre contrato e runtime.
2. **Instância local ou conteinerizada controlada do projeto oficial:** permite estado conhecido, isolamento, repetição e limpeza controlada.

Para o experimento final, recomenda-se a instância controlada, porque reduz interferência externa e resets do serviço. Esta recomendação não significa que um container tenha sido configurado ou iniciado neste repositório. A decisão final deve ser confrontada com o ambiente realmente usado nos registros preliminares.

Antes do experimento final, o [piloto de viabilidade](Piloto_de_Viabilidade.md) deve verificar disponibilidade, códigos de resposta, autenticação, persistência, limpeza, estabilidade do filtro e divergências do contrato. Seus valores não integram o experimento final.

## Coleta de dados

A coleta abrange:

- marcações de início, pausa, retomada e término do desenvolvimento;
- ocorrências de retrabalho;
- resultado individual das cinquenta verificações;
- artefatos necessários para medir reúso de código;
- avaliação de aderência ao BDD;
- avaliação de qualidade estrutural;
- código-fonte, commits, prompts e interações permitidas;
- ambiente, versões efetivamente observadas e desvios.

Os registros originais devem ser armazenados em `datasets/raw/` e não podem ser alterados. Correções ou consolidações devem gerar novos artefatos em `datasets/processed/` com rastreabilidade até a origem.

## Métricas

As seis métricas confirmadas e suas regras operacionais estão em `Metricas.md`. Os templates dos instrumentos de [reúso de código](instrumentos/Rubrica_Reuso_de_Codigo.md), [aderência ao BDD](instrumentos/Rubrica_Aderencia_BDD.md) e [qualidade estrutural](instrumentos/Rubrica_Qualidade_Estrutural.md) devem ser completados somente após conferência dos critérios efetivamente utilizados. A consolidação deve aplicar a mesma regra às três abordagens sem inventar critérios ou pontuações.

## Análise

A análise comparará descritivamente os valores observados nas três abordagens. Tabelas e gráficos devem distinguir produtividade — tempo de desenvolvimento e retrabalho — de qualidade — cobertura de validação, reúso de código, aderência ao BDD e qualidade estrutural. Não serão introduzidas métricas não coletadas nem testes estatísticos não previstos.

## Relato

O relato deve apresentar todos os valores coletados, registros indisponíveis, impedimentos, correções e desvios relevantes. Nenhum resultado, versão, API, endpoint ou procedimento deve ser reconstruído por suposição.

O estudo possui resultados preliminares. Os dados experimentais e os resultados consolidados ainda não estão publicados neste repositório; essa ausência de publicação não significa ausência de execução. Decisões de protocolo ainda pendentes devem permanecer identificadas separadamente.
