# Relatório do Piloto de Viabilidade Swagger Petstore

## Escopo e separação metodológica

O piloto de viabilidade foi executado em 12 de julho de 2026 para verificar condições técnicas anteriores ao congelamento do protocolo. Ele não implementou as três suítes comparativas, não iniciou o experimento final e não calculou tempo de desenvolvimento, retrabalho, correção inicial das validações, reúso de código, aderência ao BDD ou qualidade estrutural. Seus artefatos permanecem em `datasets/petstore-feasibility-pilot/`, separados de `datasets/final-experiment/`.

## Ambientes avaliados

| Ambiente | Base URL | Configuração observada |
| --- | --- | --- |
| Público | `https://petstore3.swagger.io/api/v3` | Serviço público oficial; observações entre `2026-07-12T14:46:17-0300` e `2026-07-12T14:46:28-0300`. |
| Controlado | `http://127.0.0.1:18080/api/v3` | Docker `29.4.0`; imagem oficial `swaggerapi/petstore3:1.0.27@sha256:749432676c31cd05256f0d9e878302164debb94daa1c1223e193747e1b34e7d1`; `linux/amd64` em host Docker `linux/arm64/v8`; observações entre `2026-07-12T14:48:14-0300` e `2026-07-12T14:48:17-0300`. |

A configuração completa está em [`datasets/petstore-feasibility-pilot/config/`](../../datasets/petstore-feasibility-pilot/config/). O container foi removido após a coleta. Nenhum segredo ou credencial real foi usado.

## Procedimentos executados

Em cada ambiente foi usado um ID inteiro exclusivo do piloto. O roteiro recuperou o contrato servido, consultou recurso inexistente sem credencial e com `api_key` deliberadamente inválida, criou um recurso em estado `available`, confirmou sua persistência, atualizou nome e estado para `pending`, confirmou a atualização, consultou o filtro duas vezes, exercitou status inválido e ID não inteiro, excluiu o recurso, confirmou `404` após a exclusão e repetiu o `DELETE`.

O registro processado contém ambiente, timestamp, base URL, método, endpoint, resumo, comportamento contratual esperado, comportamento observado, evidência, impacto e decisão proposta para cada observação: [`observations.csv`](../../datasets/petstore-feasibility-pilot/processed/observations.csv).

## Disponibilidade e códigos HTTP

As operações previstas ficaram disponíveis nos dois ambientes durante as janelas registradas. Ambos apresentaram a mesma sequência de códigos: contrato `200`; recurso ausente `404`; criação `200`; leitura criada `200`; atualização `200`; leitura atualizada `200`; duas consultas por filtro `200`; status inválido `400`; ID não inteiro `400`; exclusão `200`; leitura após exclusão `404`; segunda exclusão `200`.

Essas constatações valem somente para a coleta registrada e não demonstram disponibilidade contínua.

## Divergências entre contrato e runtime

1. **Autenticação não aplicada:** o contrato declara `petstore_auth` em `POST /pet`, `PUT /pet`, `GET /pet/findByStatus` e `DELETE /pet/{petId}`, e `api_key` ou OAuth em `GET /pet/{petId}`. Nos dois ambientes, criação, leitura, atualização, filtro e exclusão foram aceitos sem credencial. Uma `api_key` deliberadamente inválida não produziu `401` ou `403`; a consulta do recurso ausente retornou `404`.
2. **Contrato servido:** os documentos obtidos em `/openapi.json` nos dois ambientes foram byte a byte iguais à cópia normativa, com SHA-256 `00441c05add60f28da55eb4563d3fb6bbda364ba8eb7b381e2e2c98613005c82`.
3. **Exclusão repetida:** o segundo `DELETE` retornou `200` nos dois ambientes. Isso não contradiz uma resposta documentada, mas impede usar o status do `DELETE` repetido como oráculo de inexistência; a confirmação deve usar `GET` posterior com `404`.

## Persistência, atualização e limpeza

Nos dois ambientes, o recurso criado foi recuperado com os campos enviados; após `PUT`, nome e status atualizados foram recuperados por `GET`; após `DELETE`, o `GET` retornou `404`. A limpeza dos dois IDs exclusivos foi, portanto, confirmada na janela do piloto. A persistência não foi avaliada entre reinicializações do serviço e não deve ser inferida além da janela registrada.

## Estabilidade do filtro

O ID exclusivo apareceu em duas consultas consecutivas por `status=pending` em cada ambiente. O tamanho observado da coleção permaneceu 4 nas duas amostras públicas e 3 nas duas amostras controladas. A única regra considerada viável é localizar o ID exclusivo sem afirmar quantidade, ordem ou exclusividade global. Duas amostras em janela curta não eliminam risco de instabilidade prolongada.

## Oráculos negativos

| Oráculo | Decisão | Evidência |
| --- | --- | --- |
| `GET` de ID numérico ausente retorna `404` | Confirmado nos dois ambientes. | Registros 02 e 13. |
| Status fora do enum em `findByStatus` retorna `400` | Confirmado nos dois ambientes. | Registro 10. |
| ID não inteiro retorna `400` | Confirmado nos dois ambientes. | Registro 11. |
| Ausência pode ser inferida por segundo `DELETE` | Rejeitado; retornou `200`. | Registro 14. |
| Credencial ausente ou inválida produz erro de autenticação | Rejeitado para estes runtimes; não houve `401` ou `403`. | Registros 03–12 e tabela de observações. |

## Endpoints mantidos ou rejeitados

- **Mantidos como candidatos:** `POST /pet`, `GET /pet/{petId}`, `PUT /pet`, `GET /pet/findByStatus` e `DELETE /pet/{petId}`.
- **Nenhum endpoint candidato foi rejeitado** por indisponibilidade nesta coleta.
- **Rejeitados como critérios:** autenticação obrigatória no runtime; quantidade ou ordem global do filtro; segundo `DELETE` como prova de ausência.

## Limitações operacionais e riscos não resolvidos

- a instância pública permanece sujeita a terceiros, resets e indisponibilidade fora da janela curta;
- a imagem oficial `1.0.27` está publicada para `linux/amd64` e foi executada por emulação no host `linux/arm64/v8`;
- o container registrou ausência de binding SLF4J e depreciação do `jetty-runner`, embora tenha atendido às requisições;
- uma primeira invocação local, feita em contexto de execução restrito, retornou status de transporte `000`; a repetição com acesso autorizado ao loopback funcionou e a tentativa inicial foi preservada;
- não foi avaliada persistência após reinicialização;
- duas amostras de filtro não demonstram estabilidade prolongada;
- o runtime não aplica a segurança declarada no contrato.

## Recomendação explícita

**Recomenda-se o ambiente controlado para o futuro experimento final.** A recomendação se baseia no ciclo funcional observado equivalente ao público, no contrato servido idêntico à cópia normativa, na limpeza confirmada e, sobretudo, na possibilidade de isolar dados e evitar interferência de terceiros. Antes do congelamento, devem ser aceitos e documentados o uso da imagem fixada por digest, a emulação `linux/amd64` neste host e a exclusão de autenticação como oráculo do experimento. O experimento final permanece não executado.
