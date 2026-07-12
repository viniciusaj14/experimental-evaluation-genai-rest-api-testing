# Protocolo Congelado v1.0

Este documento declara formalmente que o delineamento do experimento final Swagger Petstore foi congelado antes de qualquer unidade de execução. Nenhum resultado do experimento final foi observado no momento do congelamento.

## Identificação do protocolo

| Campo | Valor |
| --- | --- |
| Versão | `1.0` |
| Data de congelamento | 12 de julho de 2026 |
| Commit-base científico | `25ab46ee0314abcc74a9d7fc30ff5cb3888c3b6e` |
| Branch | `research/select-swagger-petstore-api` |
| Repositório | `viniciusaj14/experimental-evaluation-genai-rest-api-testing` |
| Tag proposta | `protocol-v1.0` — proposta somente; não criada por esta alteração |

O commit-base contém os componentes científicos tal como aprovados imediatamente antes desta declaração. O commit que adiciona este documento não modifica objetivo, questões, métricas, cenários, verificações, prompts, ambiente ou regras de execução.

## Componentes congelados

Os seguintes componentes ficam congelados na versão 1.0:

| Componente | Artefato normativo congelado |
| --- | --- |
| Objetivo de pesquisa | [`README.pt-BR.md`](../../README.pt-BR.md) e [`Metodologia.md`](Metodologia.md) |
| Questões de pesquisa | [`Questoes_de_Pesquisa.md`](Questoes_de_Pesquisa.md) |
| Contrato Swagger Petstore OpenAPI | [`swagger-petstore-openapi.json`](../api-specification/swagger-petstore-openapi.json), SHA-256 `00441c05add60f28da55eb4563d3fb6bbda364ba8eb7b381e2e2c98613005c82` |
| Ambiente de execução | Instância controlada definida em [`docker-compose.yml`](../../datasets/petstore-feasibility-pilot/config/docker-compose.yml), conforme recomendação do [piloto de viabilidade](Relatorio_do_Piloto_de_Viabilidade.md) |
| Imagem e digest | `swaggerapi/petstore3:1.0.27@sha256:749432676c31cd05256f0d9e878302164debb94daa1c1223e193747e1b34e7d1`, plataforma `linux/amd64` |
| Cinco cenários | C01–C05 em [`Matriz_de_Cenarios.md`](Matriz_de_Cenarios.md) |
| Cinquenta verificações | V01–V50 em [`Matriz_de_Validacoes.md`](Matriz_de_Validacoes.md) |
| Seis métricas | Tempo de desenvolvimento, retrabalho, correção inicial das validações, reúso de código, aderência ao BDD e qualidade estrutural, conforme [`Metricas.md`](Metricas.md) |
| Templates das rubricas | [`Rubrica_Reuso_de_Codigo.md`](instrumentos/Rubrica_Reuso_de_Codigo.md), [`Rubrica_Aderencia_BDD.md`](instrumentos/Rubrica_Aderencia_BDD.md) e [`Rubrica_Qualidade_Estrutural.md`](instrumentos/Rubrica_Qualidade_Estrutural.md) |
| Plano de execução | [`Plano_de_Execucao.md`](Plano_de_Execucao.md) |
| Plano de controle experimental | [`Plano_de_Controle_Experimental.md`](Plano_de_Controle_Experimental.md) |
| Checklist de execução | [`Checklist_Pre_Execucao.md`](Checklist_Pre_Execucao.md) |
| Política de prompts | Arquivos em [`prompts/`](../../prompts/) e regra de preservação no idioma exato usado |
| Política de evidências | [`Plano_de_Execucao.md`](Plano_de_Execucao.md) e [`EXPERIMENT_LOG.md`](../../EXPERIMENT_LOG.md) |
| Matriz de rastreabilidade | [`Matriz_de_Rastreabilidade.md`](Matriz_de_Rastreabilidade.md) |

O congelamento abrange o conteúdo efetivamente presente nesses artefatos no commit-base. Nenhuma lacuna, nota histórica ou placeholder autoriza modificação metodológica depois desta declaração.

## Ordem de execução congelada

A ordem das condições foi definida antes do congelamento e antes de qualquer resultado do experimento final:

1. desenvolvimento manual;
2. GitHub Copilot;
3. ChatGPT.

### Registro da pré-randomização

| Campo | Valor |
| --- | --- |
| Timestamp | `2026-07-12T15:02:41-0300` |
| Fonte | semente aleatória de 256 bits gerada por `openssl rand -hex 32` |
| Semente | `72530fe3593abb56382c208087c8532dfe76c2fd43d3ec94b9096ab2d836bb8d` |
| SHA-256 da semente | `61b0033bc8e761cf1aff8fe25b8fa5f19322110ba77028dd441a8bf0a5a6f1b9` |
| Regra | paridade do primeiro dígito hexadecimal: par = GitHub Copilot primeiro; ímpar = ChatGPT primeiro |
| Primeiro dígito | `6` — par |
| Resultado | GitHub Copilot → ChatGPT |

A condição manual permaneceu em primeiro lugar conforme decisão metodológica anterior. A ordem sorteada não pode ser refeita ou alterada após o congelamento.

## Alterações permitidas após o congelamento

Somente são permitidas alterações que não modifiquem o significado científico ou operacional da versão 1.0:

- correções comprovadas de bugs na documentação;
- correções ortográficas;
- reparo de links quebrados;
- manutenção do repositório sem impacto metodológico.

Toda alteração permitida deve ser descrita no histórico, vinculada a commit e auditada quanto à ausência de impacto metodológico.

## Alterações proibidas após o congelamento

É expressamente proibido alterar, durante a execução da versão 1.0:

- métricas, definições, unidades, fórmulas ou níveis de análise;
- cenários, dados congelados ou critérios de conclusão;
- prompts, contexto, idioma ou política de interação;
- matriz de validações, categorias, oráculos ou tratamento de impedimentos;
- protocolo e regras de execução;
- ordem das condições ou dos cenários;
- ambiente, imagem, digest, plataforma ou configuração controlada.

Uma necessidade de mudança em qualquer item proibido exige interromper a execução, preservar os registros existentes, declarar nova versão do protocolo e impedir combinação automática entre versões.

## Histórico de versões

| Versão | Data | Commit-base | Situação | Descrição |
| --- | --- | --- | --- | --- |
| 1.0 | 2026-07-12 | `25ab46ee0314abcc74a9d7fc30ff5cb3888c3b6e` | Congelada | Primeira versão formal do protocolo do experimento final Swagger Petstore, definida antes da execução. |

## Status do protocolo

**Congelado.**

**Pronto para execução experimental.**

Este status não afirma que o experimento final tenha começado ou produzido resultados. A tag `protocol-v1.0` permanece apenas proposta e deverá ser criada separadamente mediante decisão explícita.
