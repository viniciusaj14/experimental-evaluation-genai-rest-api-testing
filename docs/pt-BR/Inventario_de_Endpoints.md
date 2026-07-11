# Inventário de Endpoints Candidatos

## Fonte e escopo

Este inventário foi extraído da [especificação OpenAPI preservada](../api-specification/swagger-petstore-openapi.json). O recorte abaixo reúne as operações candidatas do domínio `pet` capazes de sustentar criação, consulta, atualização, filtro e exclusão em cinco cenários comparáveis. A seleção final permanece pendente de revisão metodológica.

Este inventário aplica-se somente ao futuro experimento final Petstore. A API veicular do piloto não teve seus endpoints preservados, e nenhum path desta lista pode ser atribuído retrospectivamente ao piloto.

## Resumo

| Método | Path | `operationId` | Finalidade candidata |
| --- | --- | --- | --- |
| POST | `/pet` | `addPet` | Criar recurso |
| GET | `/pet/{petId}` | `getPetById` | Consultar recurso existente ou inexistente |
| PUT | `/pet` | `updatePet` | Atualizar recurso existente |
| GET | `/pet/findByStatus` | `findPetsByStatus` | Consultar coleção por status |
| DELETE | `/pet/{petId}` | `deletePet` | Excluir recurso |

## POST `/pet` — `addPet`

- **Parâmetros:** nenhum parâmetro de path ou query definido pela operação.
- **Request body:** obrigatório; aceita `application/json`, `application/xml` e `application/x-www-form-urlencoded`; schema `Pet`. Para JSON, `Pet` exige `name` e `photoUrls`; `status`, quando informado, admite `available`, `pending` ou `sold`.
- **Respostas previstas:** `200` (operação bem-sucedida, schema `Pet` em JSON ou XML), `400` (entrada inválida), `422` (exceção de validação) e `default` (erro inesperado).
- **Dependências:** nenhuma dependência de dado previamente criado; o identificador e demais valores devem ser exclusivos da execução.
- **Adequação positiva/negativa:** positiva com payload `Pet` válido; negativa com violação documentável do schema, observando que o contrato admite mais de um código de rejeição (`400` ou `422`) conforme a causa.
- **Risco público:** colisão ou alteração do recurso após a criação; exige identidade única e limpeza.

## GET `/pet/{petId}` — `getPetById`

- **Parâmetros:** `petId` obrigatório no path, tipo `integer`, formato `int64`.
- **Request body:** não definido.
- **Respostas previstas:** `200` (schema `Pet` em JSON ou XML), `400` (ID inválido), `404` (pet não encontrado) e `default`.
- **Dependências:** para o caso positivo, requer recurso próprio criado previamente; casos negativos podem usar formato inválido ou identificador válido controlado que não corresponda a recurso da execução.
- **Adequação positiva/negativa:** forte, porque o contrato distingue sucesso, ID inválido e ausência do recurso.
- **Risco público:** um identificador presumido inexistente pode ser criado por terceiro; o caso negativo deve evitar afirmar inexistência sem controle ou evidência imediatamente anterior.

## PUT `/pet` — `updatePet`

- **Parâmetros:** nenhum parâmetro de path ou query definido pela operação.
- **Request body:** obrigatório; aceita JSON, XML e formulário; schema `Pet`, com `name` e `photoUrls` obrigatórios.
- **Respostas previstas:** `200` (schema `Pet`), `400` (ID inválido), `404` (pet não encontrado), `422` (exceção de validação) e `default`.
- **Dependências:** requer recurso próprio previamente criado e seu identificador.
- **Adequação positiva/negativa:** positiva para alteração controlada de campos; negativa para ID inválido, recurso ausente ou payload incompatível, conforme o código previsto pelo contrato.
- **Risco público:** atualização concorrente ou remoção por terceiro entre preparação e chamada; exige janela curta, identificador único e registro do impedimento.

## GET `/pet/findByStatus` — `findPetsByStatus`

- **Parâmetros:** `status` obrigatório em query; string com enum `available`, `pending`, `sold`; valor padrão declarado `available`.
- **Request body:** não definido.
- **Respostas previstas:** `200` (array de `Pet` em JSON ou XML), `400` (status inválido) e `default`.
- **Dependências:** pode consultar o ambiente sem preparação, mas uma validação determinística de presença requer recurso próprio criado com status conhecido.
- **Adequação positiva/negativa:** positiva para cada valor permitido; negativa para valor fora do enum, com expectativa contratual `400`.
- **Risco público:** a coleção inclui dados de terceiros e pode mudar durante a execução. Não é metodologicamente seguro validar quantidade total ou ordem global.

## DELETE `/pet/{petId}` — `deletePet`

- **Parâmetros:** `petId` obrigatório no path (`integer`, `int64`) e `api_key` opcional no header.
- **Request body:** não definido.
- **Respostas previstas:** `200` (`Pet deleted`, sem schema de resposta definido), `400` (valor de pet inválido) e `default`.
- **Dependências:** requer recurso próprio previamente criado para o fluxo positivo. A confirmação posterior de ausência pode usar `GET /pet/{petId}`, cujo contrato prevê `404`.
- **Adequação positiva/negativa:** positiva para remoção controlada; negativa limitada a valor inválido, pois a operação DELETE não documenta `404` para recurso ausente.
- **Risco público:** remoção antecipada por terceiro, repetição não determinística e ausência de schema no sucesso. O cenário deve distinguir falha da limpeza de falha da validação principal.

## Observação sobre segurança

O contrato declara requisitos de segurança para essas operações (`petstore_auth` e, em algumas leituras, `api_key`). A forma efetivamente aceita pelo ambiente público deve ser verificada e registrada antes de congelar os cenários, sem inventar credenciais ou assumir que a demonstração aplica integralmente o esquema declarado.
