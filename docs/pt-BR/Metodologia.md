# Metodologia

## Delineamento do estudo

O estudo realiza uma comparação experimental entre desenvolvimento manual, GitHub Copilot e ChatGPT na automação de testes de API REST com Behavior-Driven Development (BDD). Cada abordagem implementará os mesmos cinco cenários de teste e será avaliada pelas mesmas cinquenta verificações.

Não são pressupostos múltiplos participantes, avaliadores cegos, randomização, cálculo de poder estatístico ou testes estatísticos inferenciais. Caso alguma dessas decisões venha a integrar efetivamente o TCC, deverá ser documentada antes de sua aplicação; até lá, não faz parte da metodologia.

## Ambiente tecnológico

As implementações utilizam Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA. As versões ou identificadores não confirmados não devem ser inferidos. O ambiente observado durante a execução deve ser registrado no log experimental.

## Equivalência das abordagens

Os cinco cenários, as cinquenta verificações, os requisitos, os materiais de apoio e os critérios de conclusão devem ser equivalentes. A diferença planejada é a abordagem de desenvolvimento: sem IA generativa, com GitHub Copilot ou com ChatGPT. Intervenções manuais e desvios devem ser registrados para não serem confundidos com efeitos da abordagem.

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

As seis métricas confirmadas e suas regras operacionais estão em `Metricas.md`. Os instrumentos de pontuação de reúso, aderência ao BDD e qualidade estrutural devem ser fixados antes da avaliação, para que os mesmos critérios sejam aplicados às três abordagens.

## Análise

A análise comparará descritivamente os valores observados nas três abordagens. Tabelas e gráficos devem distinguir produtividade — tempo de desenvolvimento e retrabalho — de qualidade — cobertura de validação, reúso de código, aderência ao BDD e qualidade estrutural. Não serão introduzidas métricas não coletadas nem testes estatísticos não previstos.

## Relato

O relato deve apresentar todos os valores coletados, registros indisponíveis, impedimentos, correções e desvios relevantes. Nenhum resultado, versão, API, endpoint ou procedimento deve ser reconstruído por suposição.
