# Registro do Experimento

Utilize uma seção para cada execução ou evento de protocolo. Falhas, impedimentos e desvios não devem ser apagados.

## Modelo de registro

- **Identificador da execução/evento:**
- **Unidade de execução:** um cenário sob uma abordagem / não aplicável a evento de protocolo
- **Nível do registro:** unidade de execução / abordagem completa / evento de protocolo
- **Data, horário e fuso:**
- **Fase do estudo:** piloto preliminar / piloto de viabilidade Petstore / experimento final
- **Abordagem:** manual / GitHub Copilot / ChatGPT / protocolo
- **Commit:**
- **Ambiente efetivamente observado:** registrar somente ferramentas presentes na fase correspondente, sem preencher tecnologias por padrão
- **Versões ou identificadores efetivamente observados:**
- **Identificadores dos cinco cenários:**
- **Cenário desta unidade:** preencher somente no registro de unidade de execução
- **Início, pausas, retomadas e término:**
- **Ajustes após a primeira versão executável (contagem por unidade):**
- **Detalhes de cada ajuste:** critério/verificação, descrição, origem da correção (manual / sugestão aceita do GitHub Copilot / conteúdo do ChatGPT aplicado), arquivos, evidência e reexecução
- **Registro das cinquenta verificações:**
- **Artefatos de reúso, aderência ao BDD e qualidade estrutural:**
- **Consolidação das rubricas:** preencher somente no registro de abordagem completa, após os cinco cenários
- **Registro de pré-randomização das condições assistidas:** método, resultado, timestamp, responsável e semente, quando aplicável
- **Entradas e saídas:**
- **Status:** planejado / concluído / impedido / excluído
- **Correções, intervenções ou desvios:**
- **Observações:**

O piloto preliminar possui execuções e resultados, mas seus registros não estão publicados neste repositório. O piloto de viabilidade Petstore foi executado em 12 de julho de 2026; o experimento final ainda não foi iniciado. Ao incorporar registros, identificar obrigatoriamente a fase e preservar o conteúdo original sem reconstrução retrospectiva.

## PV-2026-07-12-PUBLIC

- **Data, horário e fuso:** 2026-07-12, 14:46:17–14:46:28, UTC−03:00
- **Fase do estudo:** piloto de viabilidade Petstore
- **Nível do registro:** evento de protocolo
- **Ambiente:** público
- **Base URL:** `https://petstore3.swagger.io/api/v3`
- **Identificador exclusivo:** `912071200001`
- **Procedimento:** contrato, ausência, autenticação, criação, persistência, atualização, filtro em duas amostras, entradas inválidas, exclusão e confirmação de limpeza
- **Status:** concluído
- **Evidências:** `datasets/petstore-feasibility-pilot/raw/public/`
- **Métricas do experimento final:** não coletadas

## PV-2026-07-12-CONTROLLED

- **Data, horário e fuso:** 2026-07-12, 14:48:14–14:48:17, UTC−03:00
- **Fase do estudo:** piloto de viabilidade Petstore
- **Nível do registro:** evento de protocolo
- **Ambiente:** controlado em `http://127.0.0.1:18080/api/v3`
- **Runtime:** Docker cliente/servidor `29.4.0`; `swaggerapi/petstore3:1.0.27@sha256:749432676c31cd05256f0d9e878302164debb94daa1c1223e193747e1b34e7d1`; imagem `linux/amd64` em host Docker `linux/arm64/v8`
- **Identificador exclusivo:** `912071200002`
- **Procedimento:** mesmo roteiro do ambiente público; container removido após a coleta
- **Status:** concluído
- **Evidências:** `datasets/petstore-feasibility-pilot/raw/controlled/`
- **Limitação preservada:** tentativa anterior em contexto restrito retornou status de transporte `000`; ver `raw/controlled-restricted-context-attempt/`
- **Métricas do experimento final:** não coletadas

## Decisão produzida pelo piloto

Recomenda-se o ambiente controlado para o futuro experimento final, sujeito à aceitação formal da imagem fixada por digest, da emulação de arquitetura e dos riscos residuais. Autenticação e segundo `DELETE` não devem ser usados como oráculos. O relatório completo está em `docs/pt-BR/Relatorio_do_Piloto_de_Viabilidade.md`.

## Revisão pré-experimental do protocolo — v1.1

- **Data:** 13 de julho de 2026
- **Experimento final iniciado:** não
- **Unidades finais executadas:** 0 de 15
- **Observação de treino:** payload de criação sem `name` retornou HTTP `200`
- **Observação de viabilidade:** JSON sintaticamente malformado com `Content-Type: application/json` retornou HTTP `400`
- **Tratamento dos dados:** dados de treino são proibidos nas métricas do experimento final
- **Nova versão aplicável:** `1.1`
- **Novo commit-base:** `d626e1b95f979e33a3e41d6d4489b5b3ad54191f`
- **Tag proposta:** `protocol-v1.1` — não criada
