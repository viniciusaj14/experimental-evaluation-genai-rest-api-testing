# Matriz de Rastreabilidade

## Finalidade

Conectar decisões e artefatos desde o objetivo da pesquisa até os futuros resultados, sem antecipar valores observados. A matriz deve ser atualizada quando os cenários e instrumentos forem congelados e quando artefatos forem efetivamente publicados.

| Camada | Elemento | Rastreia para | Evidência no repositório | Status |
| --- | --- | --- | --- | --- |
| Fase histórica | Piloto veicular com API pública não identificada | Cinco cenários históricos e métricas do piloto | [`Estudo_Preliminar.md`](Estudo_Preliminar.md) | Concluído; dados não publicados |
| Decisão de separação | Proibir mapeamento ou combinação entre piloto e Petstore | Árvores de dados e execução nova | [`Registro_de_Decisao_Piloto_e_Experimento_Final.md`](Registro_de_Decisao_Piloto_e_Experimento_Final.md) | Confirmada |
| Fase preparatória | Piloto de viabilidade Petstore | Ambiente, códigos, autenticação, persistência, limpeza, filtro e divergências | [`Piloto_de_Viabilidade.md`](Piloto_de_Viabilidade.md) | Proposto; não executado |
| Objetivo | Comparar produtividade e qualidade entre desenvolvimento manual, GitHub Copilot e ChatGPT na automação de testes de API REST com BDD | Questão principal e questões auxiliares | [`Questoes_de_Pesquisa.md`](Questoes_de_Pesquisa.md) | Confirmado |
| Questão principal | Comparação conjunta de produtividade e qualidade | API selecionada, cinco cenários, cinquenta verificações e seis métricas | [`Questoes_de_Pesquisa.md`](Questoes_de_Pesquisa.md) | Confirmada |
| QA1 — produtividade | Comparar tempo de desenvolvimento e retrabalho | Métricas 1 e 2 aplicadas às três abordagens | [`Metricas.md`](Metricas.md) | Fórmula do piloto confirmada; reutilização final pendente de aprovação |
| QA2 — qualidade | Comparar correção inicial, reúso de código, aderência ao BDD e qualidade estrutural | Métricas 3 a 6 e respectivos instrumentos | [`Metricas.md`](Metricas.md), [`instrumentos/`](instrumentos/) | Piloto parcialmente quantitativo; rubricas finais pendentes |
| API selecionada | Swagger Petstore - OpenAPI 3.0 | Operações candidatas e contrato congelado | [`Selecao_da_API.md`](Selecao_da_API.md), [OpenAPI local](../api-specification/swagger-petstore-openapi.json) | Confirmada |
| Cenário C01 | Criação de recurso | V01–V10 | [`Matriz_de_Cenarios.md`](Matriz_de_Cenarios.md), [`Matriz_de_Validacoes.md`](Matriz_de_Validacoes.md) | Proposto; revisão pendente |
| Cenário C02 | Consulta de recurso existente | V11–V20 | Mesmas matrizes | Proposto; revisão pendente |
| Cenário C03 | Atualização de recurso | V21–V30 | Mesmas matrizes | Proposto; revisão pendente |
| Cenário C04 | Consulta por filtro de status | V31–V40 | Mesmas matrizes | Proposto; fragilidade pública documentada |
| Cenário C05 | Exclusão de recurso | V41–V50 | Mesmas matrizes | Proposto; revisão pendente |
| Cinquenta verificações | Dez verificações por cenário em três categorias explícitas | Evidências por abordagem e decisão pendente sobre a métrica de cobertura | [`Matriz_de_Validacoes.md`](Matriz_de_Validacoes.md), [`Metricas.md`](Metricas.md) | Planejadas; agregação percentual não confirmada |
| Métricas do piloto | Tempo ativo, ajustes, correção inicial, reúso, aderência BDD e qualidade estrutural qualitativa | Relato histórico sem valores neste repositório | [`Metricas.md`](Metricas.md), [`Estudo_Preliminar.md`](Estudo_Preliminar.md) | Definições históricas registradas |
| Métricas finais | Fórmulas e rubricas a congelar antes da nova execução | Comparação Petstore das três abordagens | [`Metricas.md`](Metricas.md), [`instrumentos/`](instrumentos/) | Aprovação pendente |
| Experimento final | Nova execução Petstore das três abordagens | Resultados finais separados do piloto | `datasets/final-experiment/` e `results/` | Não executado |

## Fluxo resumido

```text
Objetivo da pesquisa
  → questões de pesquisa
    → Swagger Petstore OpenAPI 3 selecionada
      → cinco cenários funcionalmente distintos, aplicados igualmente às três abordagens
        → cinquenta verificações planejadas
          → seis métricas confirmadas
            → futuros artefatos consolidados e respostas às questões
```

Nenhum valor experimental é apresentado nesta matriz.
