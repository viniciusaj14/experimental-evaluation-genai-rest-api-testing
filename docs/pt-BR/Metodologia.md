# Metodologia

> **Nota sobre a evolução deste documento:** este arquivo é um registro metodológico em evolução. Ele deverá ser revisado para refletir exclusivamente os procedimentos efetivamente realizados no estudo. A versão final da seção de Metodologia do TCC USP/ESALQ será redigida de forma impessoal e no tempo passado. Formulações prospectivas ou itens pendentes presentes aqui não devem ser interpretados como procedimentos já executados.

> **ALERTA DE CONSISTÊNCIA METODOLÓGICA:** a revisão histórica confirmou que o estudo preliminar usou uma API pública não identificada do domínio veicular, e não a Swagger Petstore. Por isso, o estudo concluído é classificado como piloto. O protocolo Petstore é novo, ainda não foi executado e deverá ser executado novamente após congelamento. Os registros originais do piloto devem ser preservados sem mapeamento retrospectivo.

## Fases do estudo

1. **Piloto preliminar concluído:** comparação das três abordagens em cinco cenários de uma API veicular pública cuja identidade não foi preservada. Ver [`Estudo_Preliminar.md`](Estudo_Preliminar.md).
2. **Piloto de viabilidade Petstore proposto:** verificação técnica futura de ambiente, contrato, autenticação, persistência, limpeza e filtro. Seus valores não integram o experimento final. Ver [`Piloto_de_Viabilidade.md`](Piloto_de_Viabilidade.md).
3. **Experimento final Petstore futuro:** nova execução das três abordagens após congelamento do protocolo, ainda não realizada.

A separação e sua justificativa estão formalizadas no [`Registro_de_Decisao_Piloto_e_Experimento_Final.md`](Registro_de_Decisao_Piloto_e_Experimento_Final.md).

## Governança operacional

A execução do experimento final é regida pelo [Plano de Execução](Plano_de_Execucao.md), pelo [Checklist de Execução](Checklist_Pre_Execucao.md) e pelo [Plano de Controle Experimental](Plano_de_Controle_Experimental.md). Esses documentos estabelecem, respectivamente, a sequência operacional, as verificações objetivas antes e depois de cada execução e os controles contra vieses e desvios, sem alterar o delineamento, os cenários, as validações ou as métricas definidos neste registro metodológico.

## Delineamento do estudo

O experimento final realizará uma nova comparação entre desenvolvimento manual, GitHub Copilot e ChatGPT na automação de testes de API REST com Behavior-Driven Development (BDD). Cada abordagem implementará os mesmos cinco cenários Petstore e será avaliada pelos mesmos cinquenta checks congelados.

Não são pressupostos múltiplos participantes, avaliadores cegos, randomização, cálculo de poder estatístico ou testes estatísticos inferenciais. Caso alguma dessas decisões venha a integrar efetivamente o TCC, deverá ser documentada antes de sua aplicação; até lá, não faz parte da metodologia.

## Ambiente tecnológico

O protocolo final prevê Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA. O ambiente confirmado do piloto está descrito separadamente em `Estudo_Preliminar.md` e não deve receber ferramentas ou versões por inferência. O ambiente efetivamente usado na execução final deve ser registrado no log experimental.

## Objeto de estudo

A API selecionada para o experimento final é a Swagger Petstore - OpenAPI 3.0, uma aplicação de demonstração oficial do ecossistema Swagger e não desenvolvida por esta pesquisa. A [seleção](Selecao_da_API.md) e o [inventário de endpoints](Inventario_de_Endpoints.md) são fundamentados na [especificação oficial preservada](../api-specification/swagger-petstore-openapi.json). A cópia local fixa o contrato metodológico, mas não elimina mudanças, resets ou interferência de dados no ambiente público. Ela não corresponde à API veicular usada no piloto.

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

Registros publicados do piloto devem permanecer em `datasets/pilot/raw/`, com transformações em `datasets/pilot/processed/`. O futuro experimento final deve usar `datasets/final-experiment/raw/` e `datasets/final-experiment/processed/`. As árvores não podem ser combinadas, e dados brutos não podem ser alterados.

## Métricas

As definições históricas do piloto e as decisões requeridas para o experimento final estão em `Metricas.md`. A qualidade estrutural foi apenas discutida qualitativamente no piloto; não há pontuação numérica objetiva consolidada confirmada. Os templates de [reúso de código](instrumentos/Rubrica_Reuso_de_Codigo.md), [aderência ao BDD](instrumentos/Rubrica_Aderencia_BDD.md) e [qualidade estrutural](instrumentos/Rubrica_Qualidade_Estrutural.md) aplicam-se ao experimento final somente após congelamento, sem reavaliação retroativa do piloto.

## Análise

A análise do piloto e a análise do futuro experimento final devem ser apresentadas separadamente. No piloto, qualidade estrutural permanece qualitativa. No experimento final, somente fórmulas e rubricas aprovadas antes da execução poderão produzir valores. Não serão introduzidas métricas não coletadas, testes estatísticos não previstos ou comparações numéricas entre as fases.

## Relato

O relato deve apresentar todos os valores coletados, registros indisponíveis, impedimentos, correções e desvios relevantes. Nenhum resultado, versão, API, endpoint ou procedimento deve ser reconstruído por suposição.

O piloto preliminar foi executado e possui resultados, mas seus dados e valores consolidados não estão publicados neste repositório. O piloto de viabilidade Petstore e o experimento final Petstore ainda não foram executados. Os relatos e datasets das três fases devem permanecer separados.
