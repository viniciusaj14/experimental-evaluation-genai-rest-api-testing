# Piloto de Viabilidade

## Natureza e objetivo

Este documento define um piloto **pré-experimental** para verificar se o ambiente e as operações candidatas sustentam o desenho proposto. O piloto não mede produtividade ou qualidade das três abordagens e seus valores, tempos, ajustes, aprovações ou falhas **não podem integrar os resultados do experimento final**.

> **Consistência histórica:** antes de executar este piloto, conferir a API, o ambiente, os cenários e os checks nos registros originais do experimento preliminar. Se o procedimento preliminar diferir do desenho atual, seus resultados deverão ser classificados como piloto ou o experimento deverá ser reexecutado. Nenhum registro original pode ser reinterpretado retrospectivamente para coincidir com este documento.

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
- **recomendada para o experimento final**, condicionada à confirmação metodológica e ao registro exato da configuração utilizada.

Este repositório não configura nem inicia container ou instância local nesta etapa.

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
| A preencher no piloto | — | — | — | — | — | — |

Não há divergências observadas registradas neste template.

## Critérios de saída

O piloto é concluído somente quando houver informação suficiente para decidir:

- ambiente final e sua configuração reproduzível;
- operações mantidas ou substituídas;
- regras de autenticação efetivamente usadas;
- estratégia de persistência, isolamento e limpeza;
- viabilidade ou substituição do cenário de filtro;
- oráculos ajustados antes do congelamento, sem alterar o contrato preservado;
- separação inequívoca entre dados do piloto e dados do experimento final.

Se a instância pública não oferecer controle suficiente, a recomendação é usar a instância local/conteinerizada controlada. Caso nenhuma alternativa sustente validação determinística, o cenário afetado deve ser redesenhado antes do experimento final.
