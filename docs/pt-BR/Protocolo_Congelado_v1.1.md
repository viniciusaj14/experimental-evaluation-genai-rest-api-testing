# Protocolo Congelado v1.1

Este documento declara a revisão e o congelamento da versão 1.1 antes do início do experimento final. Nenhuma unidade final foi executada antes desta revisão: `0 de 15` unidades.

## Identificação do protocolo

| Campo | Valor |
| --- | --- |
| Versão | `1.1` |
| Data de congelamento | 13 de julho de 2026 |
| Commit-base científico | `d626e1b95f979e33a3e41d6d4489b5b3ad54191f` |
| Branch | `research/select-swagger-petstore-api` |
| Repositório | `viniciusaj14/experimental-evaluation-genai-rest-api-testing` |
| Tag proposta | `protocol-v1.1` — proposta somente; não criada |

O commit-base científico acima identifica o primeiro commit da revisão v1.1, que contém os componentes científicos alterados antes desta declaração formal de congelamento.

## Relação com a versão 1.0

A [`versão 1.0`](Protocolo_Congelado_v1.0.md) permanece preservada integralmente como histórico metodológico. A versão 1.1 substitui a versão 1.0 como única versão válida para a execução do experimento final.

Nenhum dado de treino ou teste de viabilidade pode ser incorporado às métricas, aos registros observacionais ou aos resultados das unidades finais.

## Única alteração metodológica

A única alteração metodológica entre as versões 1.0 e 1.1 é o caso negativo oficial de C01/V10:

- **versão 1.0:** V10 ainda permitia selecionar posteriormente uma violação de requisito obrigatório, com resposta `400` ou `422`;
- **versão 1.1:** V10 fixa o envio de corpo JSON sintaticamente malformado com `Content-Type: application/json`, com resposta esperada HTTP `400`.

A decisão foi tomada porque, em treino fora da coleta oficial, um payload sem o campo obrigatório `name` retornou HTTP `200`, enquanto outro teste de viabilidade com JSON sintaticamente malformado retornou HTTP `400`. Essas observações não constituem resultados experimentais. A revisão ocorreu antes de qualquer unidade final.

## Componentes preservados

Permanecem inalterados e congelados:

- objetivo e questões de pesquisa;
- contrato Swagger Petstore OpenAPI e seu checksum;
- ambiente controlado, imagem, digest, plataforma, porta e configuração;
- cinco cenários e sua ordem C01–C05, exceto pela especificação do caso negativo de C01 descrita acima;
- total de cinquenta verificações, dez por cenário;
- seis métricas e respectivos níveis de análise;
- templates das rubricas;
- políticas de prompts e evidências;
- planos, checklist, rastreabilidade, regras de interrupção e gestão de desvios;
- separação entre piloto, treino, viabilidade e experimento final.

## Ordem de execução preservada

A ordem permanece:

1. desenvolvimento manual;
2. GitHub Copilot;
3. ChatGPT.

A pré-randomização registrada na versão 1.0 permanece válida e não foi repetida.

## Aplicabilidade

Todas as quinze unidades de execução — cinco cenários em cada uma das três abordagens — devem usar exclusivamente a versão 1.1. É proibido executar ou combinar unidades finais sob a versão 1.0.

Para C01/V10, todas as abordagens devem receber o mesmo corpo JSON sintaticamente malformado, o mesmo header `Content-Type: application/json`, o mesmo oráculo HTTP `400` e a mesma política de evidências definida na matriz de validações.

## Alterações posteriores

Permanecem válidas as restrições de mudança do protocolo congelado. Correções sem impacto metodológico podem abranger somente bugs documentais, ortografia, links quebrados e manutenção do repositório. Qualquer nova mudança em cenário, verificação, métrica, prompt, ordem ou ambiente exige interromper a execução, preservar os registros e declarar nova versão antes de continuar.

## Histórico de versões

| Versão | Data | Commit-base | Situação | Descrição |
| --- | --- | --- | --- | --- |
| 1.0 | 2026-07-12 | `25ab46ee0314abcc74a9d7fc30ff5cb3888c3b6e` | Histórica; substituída para execução | Primeira versão formal congelada. |
| 1.1 | 2026-07-13 | `d626e1b95f979e33a3e41d6d4489b5b3ad54191f` | Congelada; válida para execução | Substituição exclusiva do caso negativo C01/V10 antes de qualquer unidade final. |

## Status do protocolo

**Congelado — versão válida para execução: 1.1.**

**Experimento final iniciado: não. Unidades finais executadas: 0 de 15.**

A tag `protocol-v1.1` permanece apenas proposta e não foi criada.
