# Auditoria Metodológica

## Identificação

- **Data da auditoria:** 2026-07-12
- **Escopo:** consistência documental entre o piloto preliminar veicular e o futuro experimento final Swagger Petstore
- **Natureza:** auditoria científica com incorporação de evidências do piloto técnico de viabilidade; nenhuma unidade do experimento final foi executada

## Arquivos revisados

### Arquivos institucionais e de visão geral

- `README.md`
- `README.pt-BR.md`
- `CHANGELOG.md`
- `REPRODUCIBILITY.md`
- `EXPERIMENT_LOG.md`
- `CITATION.cff` — validado em conjunto com os arquivos Markdown

### Documentação de idioma e especificação

- `docs/en/README.md`
- `docs/api-specification/README.md`
- `docs/api-specification/swagger-petstore-openapi.json` — integridade e referências, sem modificação
- `datasets/petstore-feasibility-pilot/config/`
- `datasets/petstore-feasibility-pilot/raw/`
- `datasets/petstore-feasibility-pilot/processed/observations.csv`
- `results/petstore-feasibility-pilot/README.md`

### Documentação científica autoritativa

- `docs/pt-BR/Ameacas_a_Validade.md`
- `docs/pt-BR/Auditoria_Metodologica.md`
- `docs/pt-BR/Estudo_Preliminar.md`
- `docs/pt-BR/Inventario_de_Endpoints.md`
- `docs/pt-BR/Matriz_de_Cenarios.md`
- `docs/pt-BR/Matriz_de_Rastreabilidade.md`
- `docs/pt-BR/Matriz_de_Validacoes.md`
- `docs/pt-BR/Metodologia.md`
- `docs/pt-BR/Metricas.md`
- `docs/pt-BR/Plano_de_Controle_Experimental.md`
- `docs/pt-BR/Plano_de_Execucao.md`
- `docs/pt-BR/Checklist_Pre_Execucao.md`
- `docs/pt-BR/Piloto_de_Viabilidade.md`
- `docs/pt-BR/Protocolo_Experimental.md`
- `docs/pt-BR/Protocolo_Congelado_v1.0.md`
- `docs/pt-BR/Questoes_de_Pesquisa.md`
- `docs/pt-BR/Registro_de_Decisao_Piloto_e_Experimento_Final.md`
- `docs/pt-BR/Relatorio_do_Piloto_de_Viabilidade.md`
- `docs/pt-BR/Selecao_da_API.md`
- `docs/pt-BR/instrumentos/Rubrica_Reuso_de_Codigo.md`
- `docs/pt-BR/instrumentos/Rubrica_Aderencia_BDD.md`
- `docs/pt-BR/instrumentos/Rubrica_Qualidade_Estrutural.md`

### Documentação das condições

- `prompts/manual-development.md`
- `prompts/github-copilot.md`
- `prompts/chatgpt.md`

## Inconsistências encontradas

1. Os READMEs descreviam a separação histórica, mas não apresentavam as duas fases em seções explícitas e paralelas.
2. O status da pesquisa estava condensado e não distinguia claramente conclusão do piloto, não execução do experimento Petstore e não publicação dos datasets/análises.
3. `CHANGELOG.md` ainda continha uma formulação antiga que atribuía equivalência aos cinco cenários.
4. Os templates de prompts diziam que a API ainda não estava registrada, embora a Swagger Petstore já estivesse selecionada para a Fase 2.
5. O resumo das métricas no README ainda descrevia retrabalho de forma menos precisa que a definição histórica confirmada.
6. Qualidade estrutural precisava ser explicitamente qualitativa no piloto e quantitativa somente como planejamento futuro dependente de rubrica congelada.
7. A página de status das traduções em inglês não explicava a separação piloto/final.
8. As questões de pesquisa ainda usavam o termo genérico “cobertura” sem vinculá-lo à decisão pendente da métrica final.
9. A documentação global precisava de uma regra única: conteúdo orientado ao futuro pertence à Fase 2, salvo identificação explícita como material do piloto.
10. A unidade de execução, o registro observacional e os níveis de análise ainda não estavam definidos de forma uniforme.
11. A definição operacional de retrabalho excluía indevidamente correções originadas de sugestões ou respostas das ferramentas assistidas.
12. O checklist pós-execução misturava medições por cenário com rubricas que só podem ser consolidadas após a abordagem completa.
13. A ordem fixa GitHub Copilot seguida de ChatGPT confundia condição de ferramenta com posição, aprendizagem e fadiga.
14. A seleção do ambiente Petstore ainda mencionava comparação desnecessária com o ambiente histórico veicular não preservado.
15. Permaneciam termos ingleses para “verificação” em documentos científicos em português fora de comandos ou artefatos exatos.
16. O piloto de viabilidade ainda estava descrito como futuro, embora esta revisão tenha produzido evidência observacional dos ambientes público e controlado.
17. A autenticação declarada no contrato não foi exigida por nenhum dos runtimes observados.
18. A exclusão repetida retornou `200`, impedindo seu uso como prova de ausência.

## Correções realizadas

- criadas seções `Study phases` e `Fases do estudo` imediatamente após o status da pesquisa;
- substituído o status por três afirmações explícitas: piloto concluído, protocolo final Petstore não executado e datasets/análises não publicados;
- adicionados status do repositório em inglês e português;
- uniformizada a expressão “cinco cenários funcionalmente distintos, aplicados de forma idêntica às três abordagens”;
- afirmada a adoção da Swagger Petstore OpenAPI 3 no experimento final, com ligação para `Selecao_da_API.md`;
- corrigido o retrabalho para intervenções corretivas após a primeira versão executável, independentemente da origem, com registro separado da origem;
- diferenciada qualidade estrutural qualitativa do piloto e avaliação quantitativa planejada para a Fase 2;
- adicionada ao guia de reprodutibilidade a justificativa explícita da separação entre fases;
- atualizados `CHANGELOG.md`, `docs/en/README.md`, questões de pesquisa e templates de prompts;
- mantidas separadas as árvores de dados do piloto e do experimento final;
- preservada a regra de não combinação numérica entre fases.
- definida a unidade de execução como um cenário sob uma abordagem, totalizando quinze unidades, e o registro observacional como suas evidências e medições;
- separado o nível por unidade — tempo, retrabalho e correção inicial — do nível por abordagem completa — reúso, aderência ao BDD e qualidade estrutural — sem agregação implícita;
- dividido o checklist em pós-cenário e pós-abordagem, proibindo pontuação de rubricas após cenário isolado;
- mantida a condição manual em primeiro lugar e adotada pré-randomização de GitHub Copilot e ChatGPT antes do congelamento, com preservação do registro e proibição de sorteio após resultados;
- vinculada a escolha entre ambiente Petstore público e controlado exclusivamente ao piloto de viabilidade Petstore;
- padronizado o uso de “verificação/verificações” nos documentos científicos em português, preservando comandos e artefatos exatos.
- executado e documentado o piloto de viabilidade em diretórios separados do experimento final, sem calcular métricas de produtividade ou qualidade;
- preservados imagem, tag, digest, plataforma, configuração, requisições, respostas, timestamps e tentativa de acesso restrito;
- confirmados, nas janelas observadas, criação, leitura, atualização, filtro por identidade, limpeza, códigos negativos `400/404` e igualdade byte a byte dos contratos servidos;
- rejeitados autenticação e segundo `DELETE` como oráculos do protocolo final;
- recomendada a instância controlada com base nas evidências, sujeita à aceitação dos riscos antes do congelamento.
- concluída a fase de planejamento e formalizado o congelamento do protocolo versão 1.0 antes de qualquer unidade do experimento final;
- congelados objetivo, questões, contrato, ambiente, imagem, cenários, verificações, métricas, templates das rubricas, planos, checklist, políticas de prompts e evidências e rastreabilidade;
- executada e preservada a pré-randomização das condições assistidas, resultando na ordem manual → GitHub Copilot → ChatGPT;
- registrada `protocol-v1.0` somente como proposta de tag, sem criação automática.

## Situação após a conclusão do planejamento

A fase de planejamento foi concluída com o protocolo versão 1.0 congelado. Durante a execução permanecem obrigatórios apenas registros observacionais previstos, como versões efetivamente exibidas, timestamps, commits, evidências, impedimentos e desvios; esses registros não constituem autorização para redefinir o protocolo. Qualquer necessidade de alteração metodológica exige interromper a versão 1.0 e declarar uma nova versão, sem combinar automaticamente os dados.

A tag `protocol-v1.0` é uma proposta registrada, não uma tag criada por esta alteração.

## Confirmação de integridade científica

Esta auditoria acrescentou somente observações técnicas do piloto de viabilidade, com evidências publicadas e separadas. Não acrescentou resultado do experimento final, valor de suas seis métricas, DOI, identidade da API veicular histórica, endpoint histórico, contrato histórico, prompt histórico ou código-fonte histórico. A Swagger Petstore permanece o objeto do futuro experimento final, que não foi iniciado.

## Validações

| Validação | Resultado |
| --- | --- |
| `mvn -q test` | Aprovada, sem output de erro ou advertência |
| `git diff --check` | Aprovada, sem erro de whitespace |
| Links Markdown locais | Aprovados |
| Sintaxe JSON OpenAPI | Aprovada |
| Referências internas `$ref` | Aprovadas |
| SHA-256 do contrato normativo | Aprovado: `00441c05add60f28da55eb4563d3fb6bbda364ba8eb7b381e2e2c98613005c82` |
| Sintaxe YAML do `CITATION.cff` | Aprovada; campos DOI e versão ausentes |
| Expressão proibida de equivalência dos cenários | Ausente |
| Ambiguidade sobre seleção da API | Ausente |

**Advertências:** os comandos de validação do repositório não emitiram advertências. Durante o piloto controlado, Docker informou incompatibilidade entre a imagem `linux/amd64` e o host `linux/arm64/v8` antes de a plataforma ser explicitada; o runtime registrou ausência de binding SLF4J e depreciação do `jetty-runner`; e a primeira tentativa no contexto restrito retornou status de transporte `000`. Essas ocorrências estão preservadas no relatório e nas evidências. O ambiente não possui um validador CFF ou OpenAPI dedicado registrado nesta auditoria; foram validados YAML/JSON, campos essenciais, referências internas e checksum com as ferramentas locais disponíveis.
