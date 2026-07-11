# Métricas

Este estudo utiliza exatamente seis métricas. As mesmas regras devem ser aplicadas ao desenvolvimento manual, ao GitHub Copilot e ao ChatGPT. Não fazem parte da coleta medidas de estabilidade de execução, consumo de recursos, detecção de falhas, mutation testing ou outras métricas não descritas aqui.

## 1. Tempo de desenvolvimento

- **Definição operacional:** tempo ativo decorrido entre o início da implementação e a conclusão da abordagem, incluindo implementação, depuração, ajustes e retrabalho necessários para atingir o critério de conclusão.
- **Unidade:** minutos.
- **Regra de coleta:** registrar horário de início, pausas, retomadas e término. O cronômetro deve ser pausado durante interrupções alheias à tarefa, conforme regra definida antes da execução.
- **Fórmula:** `tempo de desenvolvimento = horário de término − horário de início − duração das pausas excluídas`.
- **Inclusão:** análise da tarefa durante a janela medida, escrita e edição de código, execução de testes, depuração e correções relacionadas aos cinco cenários.
- **Exclusão:** pausas registradas por motivos externos, preparação geral do ambiente concluída antes do início comum e atividades posteriores ao critério de término.
- **Relação:** indicador de produtividade; menor tempo representa menor esforço temporal somente quando os critérios de conclusão e qualidade são igualmente atendidos.

## 2. Retrabalho

> **TODO — confirmação obrigatória nos registros preliminares:** antes de consolidar esta métrica, verificar nos registros já coletados se o valor representa (a) ciclos corretivos, (b) ajustes manuais individuais ou (c) uma taxa de retrabalho. A definição, a unidade, a fórmula e os critérios abaixo não podem ser fixados retroativamente sem essa conferência.

- **Definição operacional:** pendente de confirmação com base no significado efetivamente usado durante a coleta preliminar.
- **Unidade:** pendente; poderá ser contagem de ciclos, contagem de ajustes individuais ou taxa, conforme os registros originais.
- **Regra de coleta:** preservar os valores e rótulos originais e documentar como foram produzidos. Não converter entre as três interpretações sem evidência rastreável.
- **Fórmula:** pendente de confirmação. Se o registro representar uma taxa, seu numerador e denominador deverão ser identificados nos artefatos originais; se representar contagem, não deverá ser transformado em taxa por suposição.
- **Inclusão e exclusão:** devem reproduzir a regra efetivamente aplicada na coleta preliminar, a ser documentada após a conferência dos registros.
- **Relação:** indicador de produtividade associado ao esforço corretivo, cuja interpretação comparativa depende da confirmação da unidade coletada.

## 3. Cobertura de validação

- **Definição operacional:** proporção das cinquenta verificações predefinidas que são atendidas pela implementação de cada abordagem.
- **Unidade:** quantidade de verificações atendidas e percentual.
- **Regra de coleta:** registrar individualmente as mesmas cinquenta verificações planejadas para cada abordagem. Cada verificação deve ser classificada como atendida, não atendida ou impedida, com evidência ou justificativa correspondente.
- **Fórmula:** `cobertura de validação (%) = (verificações atendidas ÷ 50) × 100`. O denominador planejado permanece 50. A quantidade de verificações impedidas deve ser apresentada separadamente para tornar transparente a parcela que não pôde ser avaliada.
- **Inclusão:** todas as cinquenta verificações fixadas antes da avaliação.
- **Exclusão:** nenhuma das cinquenta verificações pode ser retirada silenciosamente do estudo ou do denominador planejado. Uma verificação impedida deve ser reportada separadamente, com justificativa, e nunca pode ser contada como atendida.
- **Relação:** indicador de qualidade funcional em relação ao conjunto de validação confirmado; maior percentual indica atendimento mais amplo aos critérios definidos.

## 4. Reúso de código

- **Definição operacional:** grau em que componentes de automação — como métodos auxiliares, configurações, steps ou abstrações — são utilizados por mais de um ponto dos cinco cenários, evitando duplicação equivalente.
- **Unidade:** percentual de componentes reutilizáveis efetivamente reutilizados, acompanhado das contagens usadas no cálculo.
- **Regra de coleta:** aplicar às três abordagens o mesmo inventário e a mesma regra de classificação, definidos antes da avaliação. Registrar cada componente classificado e suas referências.
- **Fórmula:** `reúso de código (%) = (componentes reutilizáveis usados em mais de um ponto ÷ componentes reutilizáveis identificados) × 100`.
- **Inclusão:** componentes do código de teste e do suporte à automação relacionados aos cinco cenários.
- **Exclusão:** dependências de terceiros, código gerado pela ferramenta de build, arquivos de configuração sem lógica reutilizável e ocorrências apenas textualmente semelhantes sem função comum.
- **Relação:** indicador de qualidade estrutural e manutenibilidade; maior reúso controlado pode reduzir duplicação e esforço de manutenção, sem premiar abstrações desnecessárias.

## 5. Aderência ao BDD

- **Definição operacional:** grau de conformidade da implementação com os critérios de BDD definidos previamente para os cenários, a linguagem de comportamento e a ligação entre especificação e automação executável.
- **Unidade:** pontos atendidos e percentual do instrumento de aderência.
- **Regra de coleta:** avaliar cada abordagem com a mesma lista de critérios, congelada antes da análise, registrando pontuação e evidência para cada item.
- **Fórmula:** `aderência ao BDD (%) = (pontos obtidos ÷ pontos aplicáveis do instrumento) × 100`.
- **Inclusão:** arquivos de feature, cenários, steps e sua relação com o comportamento esperado nos cinco cenários.
- **Exclusão:** preferências de estilo que não constem do instrumento e itens realmente não aplicáveis, que devem ser justificados e tratados da mesma forma entre as abordagens.
- **Relação:** indicador de qualidade metodológica; maior aderência representa melhor conformidade com a abordagem BDD definida para o estudo.

## 6. Qualidade estrutural

- **Definição operacional:** grau de atendimento aos critérios estruturais previamente definidos para organização, separação de responsabilidades, legibilidade, nomenclatura e manutenção do código de teste.
- **Unidade:** pontos atendidos e percentual do instrumento de qualidade estrutural.
- **Regra de coleta:** aplicar o mesmo instrumento às três implementações e registrar a evidência de cada item. O instrumento e sua ponderação devem ser fixados antes da avaliação.
- **Fórmula:** `qualidade estrutural (%) = (pontos obtidos ÷ pontos aplicáveis do instrumento) × 100`.
- **Inclusão:** estrutura do projeto de testes, classes, steps, recursos e código de suporte diretamente relacionados aos cinco cenários.
- **Exclusão:** código de dependências, artefatos gerados pelo build e critérios não previstos no instrumento; itens não aplicáveis exigem justificativa consistente entre abordagens.
- **Relação:** indicador de qualidade interna e manutenibilidade; maior pontuação indica melhor atendimento à estrutura definida, sem representar resultado funcional por si só.

## Registro de dados ausentes ou impedidos

Dados ausentes, verificações impedidas e itens não aplicáveis devem ser registrados explicitamente com justificativa. O relatório deve apresentar, para cada abordagem, as contagens de verificações atendidas, não atendidas e impedidas, mantendo visível o total planejado de cinquenta. Esses registros não podem ser estimados, substituídos por valores inventados, removidos silenciosamente ou convertidos em aprovação.
