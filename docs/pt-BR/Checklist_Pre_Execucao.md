# Checklist de Execução

## Uso

Aplicar este checklist a cada unidade de execução definida no `Plano_de_Execucao.md`. Marcar um item somente após verificação objetiva. Item não aplicável exige justificativa no `EXPERIMENT_LOG.md`; item obrigatório não atendido impede o início ou o encerramento.

## Antes da execução

- [ ] Fase confirmada como experimento final Petstore.
- [ ] Abordagem confirmada: manual, GitHub Copilot ou ChatGPT.
- [ ] Cenário correto confirmado entre C01 e C05.
- [ ] Identificador único da execução criado.
- [ ] Estação de trabalho confirmada.
- [ ] Sistema operacional e configuração registrados.
- [ ] Versão do Java confirmada e registrada.
- [ ] Versão do Maven confirmada e registrada.
- [ ] Versão e configuração da IDE confirmadas.
- [ ] Ferramenta da abordagem e seu identificador observável registrados.
- [ ] Repositório Git correto confirmado.
- [ ] Branch ou área de trabalho correta confirmada.
- [ ] Commit-base corresponde ao baseline congelado.
- [ ] `git status` limpo antes do cenário.
- [ ] Ausência de artefatos de outra abordagem confirmada.
- [ ] Build-base executado com sucesso.
- [ ] Dependências resolvidas antes da medição.
- [ ] IDE reiniciada e indexação concluída.
- [ ] Especificação OpenAPI normativa disponível.
- [ ] Checksum OpenAPI verificado.
- [ ] Ambiente Swagger Petstore selecionado e registrado.
- [ ] Endpoint necessário alcançável conforme piloto de viabilidade.
- [ ] Regra de autenticação aplicável confirmada.
- [ ] Cenário e dados parametrizados congelados disponíveis.
- [ ] Dez checks congelados do cenário disponíveis.
- [ ] Rubricas aplicáveis congeladas disponíveis.
- [ ] Prompt/contexto da condição congelado e checksum registrado.
- [ ] Para condição manual, assistência de IA desabilitada.
- [ ] Dados e identificadores isolados preparados.
- [ ] Estratégia de limpeza confirmada.
- [ ] Diretório `datasets/final-experiment/raw/` disponível.
- [ ] Diretório de evidências da execução preparado.
- [ ] Logging necessário habilitado.
- [ ] Captura de output integral configurada.
- [ ] Cronômetro zerado e ainda não iniciado.
- [ ] Ausência de interrupção conhecida confirmada.
- [ ] Checklist prévio assinado ou associado ao responsável e timestamp.

## Após a execução

- [ ] Horário de início registrado.
- [ ] Horário de término registrado.
- [ ] Pausas e retomadas registradas com justificativa.
- [ ] Tempo ativo calculado e registrado.
- [ ] Primeira versão executável identificada.
- [ ] Primeira execução preservada sem sobrescrita.
- [ ] Ajustes manuais contabilizados individualmente.
- [ ] Motivo e check de cada ajuste registrados.
- [ ] Dez checks do cenário preenchidos.
- [ ] Estados atendido, não atendido ou impedido registrados.
- [ ] Checks impedidos possuem justificativa e evidência.
- [ ] Outputs de build e execução arquivados.
- [ ] Logs relevantes arquivados.
- [ ] Código gerado ou alterado preservado.
- [ ] Prompts, respostas ou sugestões permitidas preservados no idioma original.
- [ ] Screenshots aplicáveis arquivadas sem segredos.
- [ ] Rubricas aplicáveis preenchidas com evidência.
- [ ] Limpeza dos dados do cenário executada ou impedimento registrado.
- [ ] `git diff` revisado quanto ao escopo do cenário.
- [ ] Segredos e artefatos externos ausentes do commit.
- [ ] Commit exclusivo do cenário criado.
- [ ] Hash do commit registrado.
- [ ] Evidências vinculadas ao identificador e commit.
- [ ] Dataset da fase atualizado somente com dados correspondentes.
- [ ] Desvios e interrupções documentados.
- [ ] `EXPERIMENT_LOG.md` atualizado.
- [ ] Checklist pós-execução associado ao responsável e timestamp.
- [ ] Estado necessário para o próximo cenário confirmado.
