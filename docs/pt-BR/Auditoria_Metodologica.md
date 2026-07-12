# Auditoria Metodológica

## Identificação

- **Data da auditoria:** 2026-07-12
- **Escopo:** consistência documental entre o piloto preliminar veicular e o futuro experimento final Swagger Petstore
- **Natureza:** auditoria científica de documentação; nenhuma execução experimental foi realizada

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
- `docs/pt-BR/Piloto_de_Viabilidade.md`
- `docs/pt-BR/Protocolo_Experimental.md`
- `docs/pt-BR/Questoes_de_Pesquisa.md`
- `docs/pt-BR/Registro_de_Decisao_Piloto_e_Experimento_Final.md`
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

## Correções realizadas

- criadas seções `Study phases` e `Fases do estudo` imediatamente após o status da pesquisa;
- substituído o status por três afirmações explícitas: piloto concluído, protocolo final Petstore não executado e datasets/análises não publicados;
- adicionados status do repositório em inglês e português;
- uniformizada a expressão “cinco cenários funcionalmente distintos, aplicados de forma idêntica às três abordagens”;
- afirmada a adoção da Swagger Petstore OpenAPI 3 no experimento final, com ligação para `Selecao_da_API.md`;
- corrigido o resumo de retrabalho para correções manuais individuais após a primeira versão executável;
- diferenciada qualidade estrutural qualitativa do piloto e avaliação quantitativa planejada para a Fase 2;
- adicionada ao guia de reprodutibilidade a justificativa explícita da separação entre fases;
- atualizados `CHANGELOG.md`, `docs/en/README.md`, questões de pesquisa e templates de prompts;
- mantidas separadas as árvores de dados do piloto e do experimento final;
- preservada a regra de não combinação numérica entre fases.

## Decisões ainda pendentes

- escolha final entre ambiente Petstore público e instância controlada;
- congelamento do subconjunto de endpoints e dos cinco cenários;
- congelamento dos cinquenta checks e do tratamento de impedidos;
- aprovação da fórmula de retrabalho para a Fase 2;
- definição do numerador e denominador da correção inicial/validação final;
- congelamento das rubricas de reúso, aderência ao BDD e qualidade estrutural;
- congelamento dos textos das tarefas, prompts e regras de interação;
- registro das versões e identificadores efetivamente observados durante a futura execução.

## Confirmação de integridade científica

Esta auditoria não acrescentou resultado experimental, valor observado, DOI, identidade da API veicular histórica, endpoint histórico, contrato histórico, prompt histórico, código-fonte histórico ou versão de ferramenta não preservada. A Swagger Petstore e seu contrato permanecem associados exclusivamente ao futuro experimento final.

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

**Advertências:** nenhuma advertência foi emitida pelos comandos de validação. O ambiente não possui um validador CFF ou OpenAPI dedicado registrado nesta auditoria; foram validados YAML/JSON, campos essenciais, referências internas e checksum com as ferramentas locais disponíveis.
