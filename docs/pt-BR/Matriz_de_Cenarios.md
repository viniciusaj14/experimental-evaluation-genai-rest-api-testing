# Matriz de Cenários Candidatos

## Status

Os cinco cenários abaixo são propostas baseadas no [contrato preservado](../api-specification/swagger-petstore-openapi.json) e no [inventário de endpoints](Inventario_de_Endpoints.md). Eles ainda requerem revisão e congelamento metodológico antes da implementação das três suítes finais. Nenhum cenário desta matriz representa execução ou resultado observado.

Os cenários são funcionalmente distintos e não precisam ter complexidade idêntica entre operações HTTP. A exigência metodológica é que cada mesmo cenário seja aplicado com entradas, critérios e verificações idênticos ao desenvolvimento manual, ao GitHub Copilot e ao ChatGPT, permitindo comparação entre abordagens.

> **SEPARAÇÃO CONFIRMADA:** estes cenários Petstore não são os cinco cenários veiculares do piloto concluído. Eles pertencem somente ao futuro experimento final, que ainda não foi executado. É proibido mapear ou comparar numericamente os resultados históricos com esta matriz.

Os valores entre `<...>` são marcadores de dados a serem gerados por execução; não são valores reais nem exemplos de respostas da API.

## C01 — Criar um pet

- **Propósito de negócio:** cadastrar um novo recurso `Pet` com identidade controlada.
- **Endpoint e método:** `POST /pet` (`addPet`).
- **Precondições:** serviço acessível; estratégia de identificador exclusivo disponível; contrato local íntegro.
- **Dados de requisição:** JSON conforme schema `Pet`, com `id=<id-exclusivo>`, `name=<nome-exclusivo>`, `photoUrls=[<url-controlada>]` e `status=<status-permitido>`.
- **Comportamento esperado:** para payload válido, resposta `200` com representação compatível com `Pet`; no caso negativo oficial, um corpo JSON sintaticamente malformado, enviado com `Content-Type: application/json`, deve receber resposta HTTP `400`.
- **Aspectos positivos e negativos:** criação válida; rejeição de corpo JSON sintaticamente malformado.
- **Isolamento:** identificador e campos textuais com prefixo exclusivo da execução; não reutilizar registros públicos existentes.
- **Limpeza:** `DELETE /pet/{petId}` após coleta das evidências; registrar impedimento se a limpeza não puder ser confirmada.
- **Dependências:** nenhuma anterior; fornece dado somente para sua própria validação e limpeza.
- **Complexidade relativa estimada:** média, considerando payload, schema, caso negativo e limpeza.
- **Comparabilidade entre abordagens:** C01 deve usar os mesmos dados parametrizados, critérios e dez verificações nas três abordagens; sua complexidade não é usada como padrão obrigatório para outras operações.

### Decisão do caso negativo de C01

Durante um treino realizado fora da coleta oficial, a instância controlada retornou HTTP `200` para um payload de criação sem o campo obrigatório `name`. Em outro teste de viabilidade, um corpo JSON sintaticamente malformado, enviado com `Content-Type: application/json`, retornou HTTP `400`.

Essas observações de treino não integram o experimento final e são proibidas nas métricas experimentais. Como nenhuma das quinze unidades finais havia sido executada, a revisão foi realizada antes do início do experimento e fixou o JSON sintaticamente malformado como único caso negativo oficial de C01/V10 na versão 1.1.

## C02 — Recuperar um pet existente

- **Propósito de negócio:** consultar por identificador um recurso criado para a própria execução.
- **Endpoint e método:** `GET /pet/{petId}` (`getPetById`).
- **Precondições:** criar um `Pet` exclusivo por `POST /pet` e confirmar seu identificador antes da consulta principal.
- **Dados de requisição:** `petId=<id-exclusivo>` no path; sem body.
- **Comportamento esperado:** `200` e schema `Pet` para o recurso controlado; `400` para formato de ID inválido; `404` somente para um caso de ausência controlável e imediatamente verificado.
- **Aspectos positivos e negativos:** recuperação e correspondência de identidade; ID inválido e ausência documentada.
- **Isolamento:** recurso exclusivo deste cenário, sem compartilhamento com C01, C03 ou C05.
- **Limpeza:** excluir o recurso exclusivo ao final.
- **Dependências:** setup técnico por `POST /pet`, pertencente ao próprio cenário.
- **Complexidade relativa estimada:** média, pois inclui setup, consulta, negativo e limpeza.
- **Comparabilidade entre abordagens:** C02 deve ter setup, consulta, negativos, limpeza e dez verificações idênticas nas três abordagens; não se afirma que sua complexidade seja igual à de C01–C05.

## C03 — Atualizar um pet

- **Propósito de negócio:** alterar campos de um recurso existente e verificar a representação atualizada.
- **Endpoint e método:** `PUT /pet` (`updatePet`).
- **Precondições:** criar um `Pet` exclusivo e preservar sua representação anterior.
- **Dados de requisição:** JSON `Pet` com o mesmo `id` e valores atualizados, mantendo `name` e `photoUrls` obrigatórios e `status` dentro do enum.
- **Comportamento esperado:** `200` com schema `Pet` e identidade preservada para atualização válida; rejeições avaliadas conforme `400`, `404` ou `422` documentados para a condição negativa escolhida.
- **Aspectos positivos e negativos:** atualização controlada; payload, ID ou existência inválidos conforme caso final a congelar.
- **Isolamento:** recurso criado exclusivamente para C03 e valores anterior/novo exclusivos.
- **Limpeza:** excluir o recurso após a validação; registrar interferência se a representação mudar externamente.
- **Dependências:** setup técnico por `POST /pet` e, se necessário, confirmação por `GET /pet/{petId}`.
- **Complexidade relativa estimada:** média.
- **Comparabilidade entre abordagens:** C03 deve preservar o mesmo estado inicial, alterações e verificações nas três abordagens; diferenças de complexidade em relação a GET ou DELETE são esperadas.

## C04 — Recuperar pets por status

- **Propósito de negócio:** consultar a coleção filtrada por um status permitido.
- **Endpoint e método:** `GET /pet/findByStatus` (`findPetsByStatus`).
- **Precondições:** criar um `Pet` exclusivo com status conhecido para permitir validação por identidade sem depender da quantidade global.
- **Dados de requisição:** query `status` com um valor do enum `available`, `pending` ou `sold`; o valor definitivo deve ser congelado antes da implementação.
- **Comportamento esperado:** `200` com array de `Pet`; cada item retornado deve ser compatível com o schema e com o filtro; status fora do enum possui resposta contratual `400`.
- **Aspectos positivos e negativos:** filtro permitido e presença do recurso exclusivo; valor de status inválido.
- **Isolamento:** validar o item criado pela execução e propriedades individuais, nunca tamanho total, ordem ou exclusividade da coleção.
- **Limpeza:** excluir o recurso criado para o cenário.
- **Dependências:** setup técnico por `POST /pet`.
- **Complexidade relativa estimada:** média-alta devido à interferência da coleção compartilhada.
- **Comparabilidade entre abordagens:** C04 deve usar o mesmo status, preparação e verificações nas três abordagens. Sua maior sensibilidade ao ambiente deve ser controlada e relatada, não tratada como complexidade idêntica aos demais cenários.

## C05 — Excluir um pet

- **Propósito de negócio:** remover um recurso controlado e verificar sua indisponibilidade posterior.
- **Endpoint e método:** `DELETE /pet/{petId}` (`deletePet`).
- **Precondições:** criar e confirmar um `Pet` exclusivo imediatamente antes da exclusão.
- **Dados de requisição:** `petId=<id-exclusivo>` no path; o header opcional `api_key` somente será usado se a regra de segurança efetivamente adotada for confirmada.
- **Comportamento esperado:** `200` para exclusão conforme o contrato, sem presumir schema de body; consulta posterior por `GET /pet/{petId}` deve ser avaliada contra o `404` documentado nessa operação de consulta. Valor de pet inválido possui resposta `400` no DELETE.
- **Aspectos positivos e negativos:** exclusão e confirmação posterior; valor de path inválido.
- **Isolamento:** excluir apenas recurso criado pelo próprio cenário; nunca usar identificador público preexistente.
- **Limpeza:** a operação principal já remove o recurso; executar verificação final e registrar se limpeza adicional foi necessária ou impedida.
- **Dependências:** setup por `POST /pet` e confirmação por GET.
- **Complexidade relativa estimada:** média.
- **Comparabilidade entre abordagens:** C05 deve repetir setup, exclusão, confirmação e verificações de forma idêntica nas três abordagens; não se presume equivalência de complexidade com criação, atualização ou filtro.

## Revisão crítica

| Critério | Avaliação preliminar | Risco ou ajuste necessário |
| --- | --- | --- |
| Comparabilidade entre abordagens | Atendida no desenho, pendente de conferência histórica | Cada cenário é repetido igualmente nas três abordagens; C04 sofre mais interferência, mas não precisa ter complexidade igual às outras operações. |
| Independência | Atendida no desenho | Cada cenário deve criar seu próprio recurso; uma execução encadeada compartilhando o mesmo pet reduziria a independência. |
| Reprodutibilidade | Parcialmente atendida | Contrato local é estável, mas o serviço público não; registrar data, disponibilidade e divergências. |
| Complexidade comparável | Plausível, pendente de piloto/revisão | Não usar contagem bruta de chamadas como único indicador; setup e limpeza variam. |
| Validação determinística | Forte em C01, C02, C03 e C05; mais fraca em C04 | C04 não deve validar tamanho ou ordem global; somente contrato, status e identidade criada pela execução. |
| Interferência pública | Presente em todos; maior em C04 | Identificadores únicos, janela curta e classificação explícita de verificações impedidas. |
| Limpeza | Planejada | DELETE pode falhar por interferência ou indisponibilidade; a falha deve ser registrada separadamente. |
| Adequação ao BDD | Atendida no nível de intenção | A redação final Given/When/Then ainda deve ser congelada sem acoplar steps a detalhes técnicos desnecessários. |

### Cenário metodologicamente mais fraco

C04 é o candidato mais fraco por consultar uma coleção compartilhada. A mitigação proposta evita quantidade e ordem globais e procura apenas o recurso exclusivo dentro do conjunto compatível. Se o futuro piloto de viabilidade Petstore demonstrar que nem essa presença é estável, a alternativa preferível é executar o mesmo endpoint contra uma instância controlada do projeto oficial Swagger Petstore, mantendo o contrato preservado. Se o estudo exigir exclusivamente o ambiente público, o cenário deve ser substituído ou classificado como impedido conforme regra prévia; a fragilidade não deve ser ocultada.
