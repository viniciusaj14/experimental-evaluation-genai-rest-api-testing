# Matriz de Validações Planejadas

## Regras da matriz

Esta matriz define **exatamente cinquenta checks planejados**, dez para cada cenário candidato. Ela não contém resultados observados. Os critérios derivam do [contrato OpenAPI preservado](../api-specification/swagger-petstore-openapi.json) e dos requisitos da [matriz de cenários](Matriz_de_Cenarios.md).

Todos os cinquenta checks permanecem no estudo. Para checks que dependem do serviço público, a indisponibilidade, interferência externa ou divergência que impeça uma conclusão deve ser registrada como **impedida**, com evidência. Um check impedido nunca é removido, presumido, convertido em aprovação ou contado como atendido. O relatório deve separar atendidos, não atendidos e impedidos, mantendo denominador planejado igual a 50 no total e a 10 por cenário.

Na coluna de impedimento:

- **E1 — estático:** validável no contrato ou artefato local; indisponibilidade pública não impede a análise estática;
- **E2 — público:** registrar como impedida, anexar evidência técnica e não contar como aprovada se o ambiente impedir a execução determinística.

## C01 — Criação

| ID | Cenário | Categoria | Critério/resultado esperado | Evidência exigida | Classe | Obrigatória | Se o ambiente público impedir |
| --- | --- | --- | --- | --- | --- | --- | --- |
| V01 | C01 | Contrato da requisição | Método e path correspondem a `POST /pet` (`addPet`). | Requisição registrada e referência OpenAPI. | Estrutural | Sim | E1 para contrato; E2 para envio. |
| V02 | C01 | Representação | Request body é JSON compatível com schema `Pet`. | Payload e validação contra schema. | Estrutural | Sim | E1 para schema; E2 para envio. |
| V03 | C01 | Campo obrigatório | `name` está presente e é string. | Payload registrado. | Estrutural | Sim | E1. |
| V04 | C01 | Campo obrigatório | `photoUrls` está presente e é array de strings. | Payload registrado. | Estrutural | Sim | E1. |
| V05 | C01 | Domínio | `status`, quando enviado, pertence a `available`, `pending` ou `sold`. | Payload e enum preservado. | Estrutural | Sim | E1. |
| V06 | C01 | Resposta positiva | Criação válida recebe código `200`, conforme contrato. | Status, headers e timestamp. | Funcional | Sim | E2. |
| V07 | C01 | Contrato de resposta | Resposta positiva JSON é compatível com schema `Pet`. | Body e relatório de validação de schema. | Funcional | Sim | E2. |
| V08 | C01 | Identidade | Representação retornada mantém o identificador exclusivo solicitado pelo cenário. | Payload, body e comparação. | Funcional | Sim | E2. |
| V09 | C01 | Persistência do cenário | O recurso criado pode ser consultado pelo identificador exclusivo antes da limpeza. | Requisição GET e evidência do mesmo ID. | Funcional | Sim | E2. |
| V10 | C01 | Negativo | Payload que viole um requisito obrigatório é rejeitado por código documentado para entrada/validação (`400` ou `422`), conforme caso final congelado. | Payload inválido, status e regra do oráculo. | Funcional | Sim | E2. |

## C02 — Consulta por ID

| ID | Cenário | Categoria | Critério/resultado esperado | Evidência exigida | Classe | Obrigatória | Se o ambiente público impedir |
| --- | --- | --- | --- | --- | --- | --- | --- |
| V11 | C02 | Contrato da requisição | Método e path correspondem a `GET /pet/{petId}` (`getPetById`). | Requisição e referência OpenAPI. | Estrutural | Sim | E1 para contrato; E2 para envio. |
| V12 | C02 | Parâmetro | `petId` é obrigatório, inteiro `int64` e usa o ID exclusivo preparado. | Path efetivo e registro do setup. | Estrutural | Sim | E1/E2. |
| V13 | C02 | Precondição | Recurso próprio foi criado e confirmado imediatamente antes da consulta principal. | Evidência do setup com ID. | Funcional | Sim | E2. |
| V14 | C02 | Resposta positiva | Consulta do recurso controlado recebe `200`. | Status e timestamp. | Funcional | Sim | E2. |
| V15 | C02 | Mídia | Resposta avaliada como JSON possui media type compatível com JSON. | Header `Content-Type`. | Funcional | Sim | E2. |
| V16 | C02 | Contrato de resposta | Body é compatível com schema `Pet`. | Body e validação de schema. | Funcional | Sim | E2. |
| V17 | C02 | Identidade | `id` retornado corresponde ao `petId` consultado. | Comparação registrada. | Funcional | Sim | E2. |
| V18 | C02 | Campos obrigatórios | Representação contém `name` e `photoUrls` nos tipos definidos. | Body e assertions. | Funcional | Sim | E2. |
| V19 | C02 | Negativo — formato | ID com formato incompatível é tratado como `400`, conforme contrato. | Requisição inválida e status. | Funcional | Sim | E2. |
| V20 | C02 | Negativo — ausência | Ausência controlada recebe `404`, sem presumir que um ID público arbitrário seja inexistente. | Preparação da ausência, requisição e status. | Funcional | Sim | E2. |

## C03 — Atualização

| ID | Cenário | Categoria | Critério/resultado esperado | Evidência exigida | Classe | Obrigatória | Se o ambiente público impedir |
| --- | --- | --- | --- | --- | --- | --- | --- |
| V21 | C03 | Contrato da requisição | Método e path correspondem a `PUT /pet` (`updatePet`). | Requisição e referência OpenAPI. | Estrutural | Sim | E1 para contrato; E2 para envio. |
| V22 | C03 | Request body | Body JSON obrigatório é compatível com schema `Pet`. | Payload e validação de schema. | Estrutural | Sim | E1/E2. |
| V23 | C03 | Identidade | Payload usa o mesmo ID do recurso exclusivo preparado. | Evidência do setup e payload. | Estrutural | Sim | E2. |
| V24 | C03 | Campos obrigatórios | `name` e `photoUrls` permanecem presentes e tipados corretamente. | Payload registrado. | Estrutural | Sim | E1. |
| V25 | C03 | Domínio | Novo `status`, quando usado, pertence ao enum do contrato. | Payload e enum preservado. | Estrutural | Sim | E1. |
| V26 | C03 | Resposta positiva | Atualização válida recebe `200`. | Status e timestamp. | Funcional | Sim | E2. |
| V27 | C03 | Contrato de resposta | Resposta positiva é compatível com schema `Pet`. | Body e validação de schema. | Funcional | Sim | E2. |
| V28 | C03 | Alteração | Campos escolhidos para atualização apresentam os novos valores e preservam a identidade. | Comparação antes/depois. | Funcional | Sim | E2. |
| V29 | C03 | Persistência | Consulta posterior do mesmo ID apresenta os valores atualizados antes da limpeza. | Requisição GET e body. | Funcional | Sim | E2. |
| V30 | C03 | Negativo | Condição inválida final é rejeitada por um código aplicável documentado (`400`, `404` ou `422`) definido previamente pelo oráculo. | Caso congelado, payload/path e status. | Funcional | Sim | E2. |

## C04 — Filtro por status

| ID | Cenário | Categoria | Critério/resultado esperado | Evidência exigida | Classe | Obrigatória | Se o ambiente público impedir |
| --- | --- | --- | --- | --- | --- | --- | --- |
| V31 | C04 | Contrato da requisição | Método e path correspondem a `GET /pet/findByStatus` (`findPetsByStatus`). | Requisição e referência OpenAPI. | Estrutural | Sim | E1 para contrato; E2 para envio. |
| V32 | C04 | Parâmetro | Query `status` é fornecida e pertence ao enum permitido. | URL/query registrada. | Estrutural | Sim | E1/E2. |
| V33 | C04 | Precondição | Recurso exclusivo com o status consultado foi criado e confirmado. | Evidência do setup. | Funcional | Sim | E2. |
| V34 | C04 | Resposta positiva | Filtro válido recebe `200`. | Status e timestamp. | Funcional | Sim | E2. |
| V35 | C04 | Mídia | Resposta avaliada como JSON possui media type compatível com JSON. | Header `Content-Type`. | Funcional | Sim | E2. |
| V36 | C04 | Tipo de coleção | Body é um array, conforme contrato. | Body e assertion de tipo. | Funcional | Sim | E2. |
| V37 | C04 | Schema dos itens | Cada item avaliado é compatível com schema `Pet`. | Body e validação dos itens. | Funcional | Sim | E2. |
| V38 | C04 | Semântica do filtro | Itens retornados possuem o status solicitado quando o campo está presente conforme schema. | Assertions por item e evidência. | Funcional | Sim | E2. |
| V39 | C04 | Identidade isolada | O recurso exclusivo preparado é localizado sem validar quantidade ou ordem global. | Busca pelo ID exclusivo no array. | Funcional | Sim | E2. |
| V40 | C04 | Negativo | Status fora do enum recebe `400`, conforme contrato. | Query inválida e status. | Funcional | Sim | E2. |

## C05 — Exclusão

| ID | Cenário | Categoria | Critério/resultado esperado | Evidência exigida | Classe | Obrigatória | Se o ambiente público impedir |
| --- | --- | --- | --- | --- | --- | --- | --- |
| V41 | C05 | Contrato da requisição | Método e path correspondem a `DELETE /pet/{petId}` (`deletePet`). | Requisição e referência OpenAPI. | Estrutural | Sim | E1 para contrato; E2 para envio. |
| V42 | C05 | Parâmetro | `petId` obrigatório é inteiro `int64` e identifica somente o recurso do cenário. | Path e registro do setup. | Estrutural | Sim | E1/E2. |
| V43 | C05 | Header | `api_key` é tratado como parâmetro opcional da operação; uso efetivo depende da regra de segurança confirmada. | Configuração e referência OpenAPI. | Estrutural | Sim | E1; divergência pública é E2. |
| V44 | C05 | Precondição | Recurso exclusivo existe imediatamente antes da exclusão. | GET de confirmação e ID. | Funcional | Sim | E2. |
| V45 | C05 | Resposta positiva | Exclusão do recurso controlado recebe `200`. | Status e timestamp. | Funcional | Sim | E2. |
| V46 | C05 | Contrato de resposta | Nenhum schema de body é exigido para `200`, porque o contrato não o define. | Assertion limitada a status e referência OpenAPI. | Estrutural | Sim | E1/E2. |
| V47 | C05 | Estado posterior | Consulta posterior do ID removido recebe `404` conforme contrato de `getPetById`. | Requisição GET e status. | Funcional | Sim | E2. |
| V48 | C05 | Negativo | Valor de pet inválido recebe `400`, conforme contrato do DELETE. | Requisição inválida e status. | Funcional | Sim | E2. |
| V49 | C05 | Isolamento | A exclusão usa somente identificador criado pelo próprio cenário. | Correlação entre setup e DELETE. | Estrutural | Sim | E2. |
| V50 | C05 | Limpeza e rastreabilidade | Estado final, necessidade de limpeza adicional e qualquer impedimento são registrados sem presumir `404` para repetição do DELETE, pois esse código não consta nessa operação. | Log, evidência final e referência OpenAPI. | Estrutural | Sim | E2. |

## Conferência de cardinalidade

| Cenário | Faixa de IDs | Quantidade |
| --- | --- | ---: |
| C01 | V01–V10 | 10 |
| C02 | V11–V20 | 10 |
| C03 | V21–V30 | 10 |
| C04 | V31–V40 | 10 |
| C05 | V41–V50 | 10 |
| **Total** | **V01–V50** | **50** |
