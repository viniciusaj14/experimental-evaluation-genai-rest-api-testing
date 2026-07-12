# Checklist de Execução

## Uso

Aplicar as seções prévia e pós-cenário a cada unidade de execução definida no `Plano_de_Execucao.md`. Aplicar a seção pós-abordagem somente depois das cinco unidades da respectiva abordagem. Marcar um item somente após verificação objetiva. Item não aplicável exige justificativa no `EXPERIMENT_LOG.md`; item obrigatório não atendido impede o início ou o encerramento.

## Antes da execução

- [ ] Fase confirmada como experimento final Petstore.
- [ ] Abordagem confirmada: manual, GitHub Copilot ou ChatGPT.
- [ ] Se a condição for assistida, sua posição corresponde ao registro de pré-randomização congelado.
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
- [ ] Dez verificações congeladas do cenário disponíveis.
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

## Após cada cenário

- [ ] Horário de início registrado.
- [ ] Horário de término registrado.
- [ ] Pausas e retomadas registradas com justificativa.
- [ ] Tempo ativo calculado e registrado.
- [ ] Primeira versão executável identificada.
- [ ] Primeira execução preservada sem sobrescrita.
- [ ] Ajustes contabilizados individualmente, independentemente da origem da correção.
- [ ] Motivo, verificação e origem de cada ajuste registrados: manual / sugestão aceita do GitHub Copilot / conteúdo do ChatGPT aplicado.
- [ ] Sugestões não aplicadas excluídas da contagem de ajustes.
- [ ] Múltiplas edições contíguas da mesma correção antes da próxima execução contabilizadas como um ajuste.
- [ ] Dez verificações do cenário preenchidas.
- [ ] Estados atendido, não atendido ou impedido registrados.
- [ ] Verificações impedidas possuem justificativa e evidência.
- [ ] Outputs de build e execução arquivados.
- [ ] Logs relevantes arquivados.
- [ ] Código gerado ou alterado preservado.
- [ ] Prompts, respostas ou sugestões permitidas preservados no idioma original.
- [ ] Screenshots aplicáveis arquivadas sem segredos.
- [ ] Limpeza dos dados do cenário executada ou impedimento registrado.
- [ ] `git diff` revisado quanto ao escopo do cenário.
- [ ] Segredos e artefatos externos ausentes do commit.
- [ ] Commit exclusivo do cenário criado.
- [ ] Hash do commit registrado.
- [ ] Evidências vinculadas ao identificador e commit.
- [ ] Dataset da fase atualizado somente com dados correspondentes.
- [ ] Desvios e interrupções documentados.
- [ ] `EXPERIMENT_LOG.md` atualizado.
- [ ] Checklist pós-cenário associado ao responsável e timestamp.
- [ ] Estado necessário para o próximo cenário confirmado.

As rubricas de reúso de código, aderência ao BDD e qualidade estrutural não devem ser pontuadas neste checklist de cenário isolado.

## Após cada abordagem

- [ ] As cinco unidades de execução C01–C05 da abordagem estão concluídas ou possuem impedimentos formalmente registrados.
- [ ] Os cinco checklists pós-cenário estão completos e vinculados aos respectivos registros observacionais.
- [ ] Os cinquenta registros de verificação estão presentes e rastreáveis.
- [ ] A completude de tempos, primeiras execuções, ajustes, logs, evidências, commits, setup e limpeza foi auditada.
- [ ] A rubrica de reúso de código foi aplicada à implementação completa da abordagem.
- [ ] A rubrica de aderência ao BDD foi aplicada aos cinco cenários em conjunto.
- [ ] A rubrica de qualidade estrutural foi aplicada à implementação completa da abordagem.
- [ ] Evidências e justificativas de itens não aplicáveis das rubricas foram preservadas.
- [ ] Referência ou commit final da abordagem completa foi criado e registrado.
- [ ] Nenhum artefato de outra abordagem contaminou a consolidação.
- [ ] Dataset da abordagem contém os cinco registros observacionais sem sobrescrita.
- [ ] Auditoria de completude da abordagem foi associada ao responsável e timestamp.
