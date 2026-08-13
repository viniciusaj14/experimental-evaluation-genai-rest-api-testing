# Piloto de Viabilidade Petstore — Executado

## Natureza e objetivo

Este documento define o piloto pré-experimental executado em 12 de julho de 2026 para verificar se os ambientes Petstore e as operações candidatas sustentam o desenho proposto. Ele não é o estudo piloto veicular já concluído nem o experimento final. O piloto de viabilidade não mediu produtividade ou qualidade das três abordagens; suas observações **não podem integrar os resultados do experimento final**. O relato e as evidências estão no [relatório do piloto](Relatorio_do_Piloto_de_Viabilidade.md).

> **Consistência histórica:** o estudo preliminar usou uma API veicular diferente e já está classificado como piloto. Não usar seus resultados como baseline numérico do piloto Petstore, não mapear os cenários antigos para operações Petstore e não reinterpretar registros originais.

## Alternativas de ambiente

### A. Instância pública Swagger Petstore

- acesso em `https://petstore3.swagger.io`;
- estado compartilhado com terceiros;
- possibilidade de resets, interferência, indisponibilidade e mudança de runtime;
- útil para avaliar os riscos reais do serviço público, mas menos controlável.

### B. Instância local ou conteinerizada controlada

- baseada no projeto oficial Swagger Petstore e no contrato preservado;
- estado conhecido, dados isolados e limpeza repetível;
- menor exposição a alterações de terceiros e resets externos;
- **recomendada para o experimento final** com base nas evidências coletadas, condicionada ao congelamento da configuração e dos riscos residuais.

O piloto executou temporariamente a imagem oficial `swaggerapi/petstore3:1.0.27@sha256:749432676c31cd05256f0d9e878302164debb94daa1c1223e193747e1b34e7d1`, fixada por digest e removida após a coleta. A configuração está preservada em [`datasets/petstore-feasibility-pilot/config/`](../../datasets/petstore-feasibility-pilot/config/).

## Preparação do piloto

1. Verificar o checksum da [especificação normativa](../api-specification/swagger-petstore-openapi.json).
2. Selecionar e registrar qual alternativa de ambiente será avaliada.
3. Registrar data, horário, base URL, commit e configuração observada.
4. Usar identificadores exclusivos de piloto, distinguíveis de dados experimentais.
5. Manter logs e evidências em área identificada como piloto, sem incorporá-los ao dataset final.

## Verificações de viabilidade

| ID | Aspecto | Procedimento planejado | Evidência | Decisão produzida |
| --- | --- | --- | --- | --- |
| P01 | Disponibilidade | Verificar se cada operação candidata pode ser alcançada no ambiente escolhido, sem medir desempenho. | Data, base URL, método, path e resultado técnico. | Operação disponível, indisponível ou intermitente. |
| P02 | Códigos documentados | Exercitar casos mínimos controlados para comparar os códigos observados com os códigos do contrato, sem convertê-los em resultado experimental. | Requisição, status observado e referência OpenAPI. | Oráculo confirmado ou divergência a tratar. |
| P03 | Autenticação | Verificar como o runtime trata `petstore_auth` e `api_key`, sem inventar credenciais ou assumir aplicação integral do contrato. | Configuração, headers não secretos e comportamento observado. | Regra de autenticação a congelar ou impedimento. |
| P04 | Persistência | Criar dado exclusivo de piloto e verificar se permanece consultável durante a janela necessária. | Identificador, timestamps e consultas de confirmação. | Persistência suficiente, instável ou ausente. |
| P05 | Limpeza | Excluir somente dados do piloto e verificar o estado posterior conforme operações documentadas. | DELETE, consulta posterior e log de resíduos. | Limpeza confiável, parcial ou impedida. |
| P06 | Estabilidade do filtro | Avaliar se `findByStatus` permite localizar o recurso exclusivo sem depender de quantidade ou ordem global. | Status usado, ID procurado, amostras em momentos definidos. | Cenário de filtro viável, instável ou inadequado. |
| P07 | Divergência contrato/runtime | Consolidar diferenças de path, mídia, schema, código, autenticação ou persistência. | Tabela de divergências com contrato e observação. | Manter cenário, ajustar desenho antes do congelamento ou rejeitar operação. |

## Registro de divergências

| ID | Operação | Elemento do contrato | Comportamento observado | Ambiente | Impacto metodológico | Decisão pendente |
| --- | --- | --- | --- | --- | --- | --- |
| D01 | Operações protegidas | `security` com OAuth ou `api_key` | Operações aceitas sem credencial; chave inválida não produziu `401/403` | Público e controlado | Autenticação não é oráculo determinístico | Excluir autenticação das validações finais |
| D02 | `DELETE /pet/{petId}` repetido | Respostas `200`, `400` e `default`; sem `404` | Segundo `DELETE` retornou `200` | Público e controlado | O status do segundo `DELETE` não comprova ausência | Confirmar limpeza por `GET` posterior com `404` |

Os contratos servidos pelos dois ambientes foram byte a byte iguais à cópia normativa. As divergências e limitações completas constam no [relatório](Relatorio_do_Piloto_de_Viabilidade.md) e no [registro processado](../../datasets/petstore-feasibility-pilot/processed/observations.csv).

## Critérios de saída

O piloto é concluído somente quando houver informação suficiente para decidir:

- ambiente final e sua configuração reproduzível;
- operações mantidas ou substituídas;
- regras de autenticação efetivamente usadas;
- estratégia de persistência, isolamento e limpeza;
- viabilidade ou substituição do cenário de filtro;
- oráculos ajustados antes do congelamento, sem alterar o contrato preservado;
- separação inequívoca entre dados do piloto e dados do experimento final.

Com base nas observações registradas, a recomendação explícita foi usar a instância controlada na fase Petstore planejada. A decisão reduzia interferência externa, mas exigia congelar a imagem por digest, registrar a emulação `linux/amd64` no host ARM e não usar autenticação nem segundo `DELETE` como oráculos. Na data do piloto, essa fase ainda não havia sido executada.
