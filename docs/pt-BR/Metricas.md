# Métricas

## Separação entre fases

As definições históricas abaixo pertencem ao **estudo piloto preliminar da API veicular**. O futuro experimento final da Swagger Petstore ainda não foi executado. Fórmulas e instrumentos somente poderão ser reutilizados no experimento final se forem formalmente aprovados antes da execução.

As cinquenta verificações propostas para Petstore não são as mesmas verificações usadas no piloto. Nenhum cálculo pode combinar dados das duas fases.

## Níveis de coleta e análise do experimento final

Uma unidade de execução corresponde a um cenário implementado sob uma abordagem, totalizando `5 × 3 = 15` unidades. Tempo de desenvolvimento, retrabalho e correção inicial das validações são coletados por unidade de execução. Reúso de código, aderência ao BDD e qualidade estrutural são consolidados por abordagem completa, somente depois dos cinco cenários. Não agregar métricas entre esses níveis sem regra explícita aprovada antes da execução.

## 1. Tempo ativo de desenvolvimento

### Piloto preliminar

- **Definição operacional:** tempo de trabalho ativo dedicado ao desenvolvimento da solução em cada abordagem.
- **Unidade:** duração na unidade preservada pelo registro original. Este documento não converte nem infere uma unidade ausente.
- **Regra:** excluir interrupções que não integrem o trabalho ativo, conforme os registros históricos disponíveis.
- **Relação:** indicador de produtividade.

### Experimento final Petstore

A regra de início, pausa, retomada, término e unidade deverá ser congelada antes da execução. O valor do piloto não pode ser reutilizado como valor final.

## 2. Retrabalho

### Piloto preliminar

- **Definição operacional confirmada:** número de correções manuais individuais realizadas após a primeira execução.
- **Unidade:** contagem de ajustes e média de ajustes por cenário.
- **Total de ajustes:** soma das correções manuais individuais registradas nas cinco tarefas.
- **Média por cenário:** `total de ajustes ÷ 5`.
- **Fórmula de taxa usada no piloto:** `taxa de retrabalho (%) = (total de ajustes ÷ total de validações planejadas) × 100`, com cinquenta validações planejadas por abordagem.
- **Inclusão:** ajustes manuais realizados depois da primeira execução para corrigir validações não atendidas.
- **Exclusão:** trabalho anterior à primeira execução e intervenções não classificadas como correção manual no registro original.
- **Relação:** indicador de produtividade associado ao esforço corretivo.

### Experimento final Petstore

- **Definição operacional:** número de intervenções corretivas logicamente identificáveis aplicadas após a primeira versão executável para resolver um critério não atendido.
- **Independência da origem:** conta igualmente quando a mudança é escrita manualmente, sugerida e aceita do GitHub Copilot ou gerada pelo ChatGPT e aplicada; a origem deve ser registrada separadamente.
- **Inclusão:** correção efetivamente aplicada e vinculada a critério, evidência e reexecução.
- **Exclusão:** sugestão não aplicada, alteração anterior à primeira versão executável, formatação sem efeito funcional e refatoração sem finalidade corretiva.
- **Regra de continuidade:** múltiplas edições contíguas para a mesma correção antes da próxima execução contam como um ajuste.
- **Unidade:** contagem de ajustes por unidade de execução; consolidações posteriores devem preservar a rastreabilidade às unidades.

A fórmula histórica somente poderá ser preservada se for formalmente aprovada antes da execução e se seu denominador corresponder ao conjunto de verificações definido para o experimento final. Não é permitido recalcular o piloto com categorias Petstore.

## 3. Correção inicial das validações

### Piloto preliminar

- **Definição operacional confirmada:** proporção das validações corretas na primeira execução.
- **Unidade:** quantidade de validações corretas inicialmente e percentual.
- **Fórmula usada no piloto:** `correção inicial das validações (%) = (validações corretas na primeira execução ÷ 50) × 100`.
- **Tratamento:** validações corrigidas posteriormente não integram o numerador da primeira execução; seus ajustes pertencem à métrica de retrabalho.
- **Relação:** indicador da qualidade funcional inicial da implementação no piloto.

Essa métrica **não é** cobertura de código-fonte, cobertura de branches, cobertura de requisitos ou cobertura de endpoints.

### Experimento final Petstore

A [matriz Petstore](Matriz_de_Validacoes.md) contém validações funcionais executáveis, conformidade de implementação/contrato e controles experimentais. Essas categorias não devem ser agregadas automaticamente na fórmula histórica do piloto. Antes da execução final, deve-se decidir quais verificações representam correção inicial, qual é o denominador e como verificações impedidas serão relatadas.

## 4. Reúso de código

### Piloto preliminar

- **Registro confirmado:** percentual de código reutilizado.
- **Unidade:** percentual.
- **Limite documental:** o numerador, o denominador e o procedimento exato de cálculo não foram confirmados nos achados históricos fornecidos; não devem ser reconstruídos por suposição.
- **Relação:** dimensão de qualidade e manutenibilidade.

### Experimento final Petstore

O cálculo dependerá da [`Rubrica_Reuso_de_Codigo.md`](instrumentos/Rubrica_Reuso_de_Codigo.md), que deverá ser congelada antes da execução. A rubrica final não pode ser aplicada retroativamente aos valores do piloto.

## 5. Aderência ao BDD

### Piloto preliminar

- **Registros confirmados:** quantidade de cenários aderentes ao BDD entre os cinco e percentual de aderência.
- **Unidades:** contagem de `0` a `5` e percentual.
- **Fórmula:** `aderência ao BDD (%) = (cenários aderentes ao BDD ÷ 5) × 100`.
- **Relação:** indicador de conformidade metodológica dos cenários do piloto.

### Experimento final Petstore

Os critérios dependerão da [`Rubrica_Aderencia_BDD.md`](instrumentos/Rubrica_Aderencia_BDD.md), congelada antes da execução final. Não se presume que a classificação histórica usou os mesmos critérios.

## 6. Qualidade estrutural

### Piloto preliminar

- **Registro confirmado:** discussão qualitativa da estrutura das implementações.
- **Unidade:** não se confirmou pontuação numérica objetiva e consolidada.
- **Restrição:** não declarar que qualidade estrutural foi coletada quantitativamente no piloto e não produzir pontuação retrospectiva.
- **Relação:** interpretação qualitativa de organização e manutenção, limitada ao conteúdo histórico preservado.

### Experimento final Petstore

A [`Rubrica_Qualidade_Estrutural.md`](instrumentos/Rubrica_Qualidade_Estrutural.md) será aplicável somente depois de seus critérios e sua regra de pontuação serem congelados antes da execução. Ela não deve ser usada para reavaliar numericamente o piloto.

## Dados ausentes, impedidos e separação analítica

- manter dados do piloto em `datasets/pilot/` e dados finais em `datasets/final-experiment/`;
- não transferir valores entre as fases;
- não reinterpretar as cinquenta verificações veiculares como as cinquenta verificações Petstore;
- registrar verificações Petstore impedidas separadamente, sem aprovação presumida;
- publicar fórmulas finais somente após aprovação prévia e rastreável.
