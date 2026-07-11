# Protocolo Experimental

## Objetivo

Orientar uma comparação controlada e auditável entre três abordagens de desenvolvimento de testes automatizados de API REST com Behavior-Driven Development (BDD): desenvolvimento manual, desenvolvimento assistido pelo GitHub Copilot e desenvolvimento assistido pelo ChatGPT.

## Escopo confirmado

- três abordagens: manual, GitHub Copilot e ChatGPT;
- cinco cenários de teste equivalentes em cada abordagem;
- cinquenta verificações de validação em cada abordagem;
- Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA;
- métricas de tempo de desenvolvimento, retrabalho, cobertura de validação, reúso de código, aderência ao BDD e qualidade estrutural.

O nome da API e seus endpoints permanecem pendentes enquanto não forem formalmente definidos. Nenhuma API ou endpoint deve ser inferido.

## Unidade de comparação

Cada abordagem deve produzir uma implementação dos mesmos cinco cenários e ser submetida ao mesmo conjunto de cinquenta verificações. Os requisitos, materiais de entrada, critérios de conclusão e ambiente devem ser equivalentes entre as abordagens, exceto pela forma de desenvolvimento que caracteriza cada condição.

## Abordagens

1. **Desenvolvimento manual:** implementação sem assistência de IA generativa.
2. **GitHub Copilot:** implementação com assistência do GitHub Copilot, respeitando o registro definido em `prompts/github-copilot.md`.
3. **ChatGPT:** implementação com assistência do ChatGPT, respeitando o registro definido em `prompts/chatgpt.md`.

## Preparação

Antes da execução, devem ser registrados:

- a API e os endpoints efetivamente selecionados;
- a especificação dos cinco cenários equivalentes;
- a lista fixa das cinquenta verificações e seus critérios de aprovação;
- as regras de início, pausa e término da medição de tempo;
- os instrumentos de avaliação de reúso de código, aderência ao BDD e qualidade estrutural;
- as versões e identificadores de ferramentas efetivamente observados;
- os critérios para registrar retrabalho e tratar impedimentos ou falhas técnicas.

Decisões ainda pendentes devem permanecer identificadas como pendentes e ser resolvidas antes da coleta correspondente.

## Procedimento

1. Registrar a abordagem, o commit, o ambiente e os materiais de entrada.
2. Implementar os cinco cenários conforme as regras da abordagem.
3. Registrar o tempo de desenvolvimento e cada ocorrência de retrabalho de acordo com `Metricas.md`.
4. Preservar os prompts e as interações permitidas no idioma exato em que ocorreram.
5. Aplicar as mesmas cinquenta verificações à implementação concluída.
6. Avaliar reúso de código, aderência ao BDD e qualidade estrutural com os instrumentos definidos previamente.
7. Armazenar os registros originais em `datasets/raw/`, sem sobrescrita.
8. Documentar correções, exclusões, impedimentos e qualquer desvio do protocolo em `EXPERIMENT_LOG.md`.

## Tratamento dos dados

Transformações documentadas podem gerar arquivos em `datasets/processed/`. Tabelas, gráficos, relatórios e análises devem ser derivados desses registros sem alterar os dados brutos. A comparação prevista é descritiva e deve apresentar os valores das seis métricas para as três abordagens. Este protocolo não pressupõe testes estatísticos inferenciais.

## Resultados

Nenhum resultado experimental está registrado neste documento. Valores somente poderão ser apresentados após a execução e a validação da coleta.
