# Auditoria Final Pré-Submissão

## Identificação da auditoria

| Campo | Valor |
|---|---|
| Data | 9 de agosto de 2026 |
| Branch analisada | `experiment/consolidation` |
| Commit `HEAD` | `751587dccec1279bff237652d87bc65497108103` |
| Escopo | `EXPERIMENT_LOG.md`, `Relatorio_Validacao_Final_Experimento.md`, `README.md`, `REPRODUCIBILITY.md` e `results/{manual,chatgpt,copilot}` |
| Natureza | Auditoria documental e de existência/rastreamento de artefatos; após as correções, as três suítes foram executadas somente como validação técnica não experimental |

## Parecer executivo

**Situação: NÃO PRONTO para abertura do Pull Request de submissão.**

As três abordagens estão documentadas e os quinze arquivos de resultado registram `PASS`. Entretanto, permanecem divergências entre protocolo e execução, documentos de entrada desatualizados, tempos pendentes, ausência de registros metodológicos obrigatórios e evidências Manual que existem apenas localmente e não serão incluídas no Pull Request.

## Reavaliação após correções documentais

Após a emissão inicial desta auditoria, foram realizadas correções exclusivamente documentais, sem alteração de protocolo congelado, código, features ou resultados:

- `README.md` e `README.pt-BR.md` passaram a indicar protocolo v1.1, resultados presentes e limitações abertas;
- `REPRODUCIBILITY.md` passou a documentar Docker Compose, runners específicos e limitações atuais;
- o estado `0 de 15` foi contextualizado como fotografia pré-experimental, preservando o histórico;
- a divergência protocolo–execução foi formalizada em `Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md`;
- aliases e nomes canônicos foram formalizados em `Dicionario_de_Dados_Resultados_Experimentais.md`;
- evidências não publicadas, dados finais ausentes e registros metodológicos faltantes foram explicitamente declarados;
- as três suítes foram reexecutadas como validação técnica pós-consolidação, cada uma com 5 testes, 0 falhas, 0 erros, 0 ignorados e `BUILD SUCCESS`.

Classificação após as correções:

| Achado original | Estado atual |
|---|---|
| B1 — divergência protocolo–execução | Documentada, mas cientificamente não resolvida. |
| B2 — estado temporal contraditório | Corrigido documentalmente por contextualização histórica. |
| B3 — registros metodológicos ausentes | Limitação registrada; evidências continuam ausentes. |
| B4 — tempos incompletos | Continua pendente; nenhum tempo foi inventado. |
| B5 — vídeos fora do Git | Política/indisponibilidade registrada; evidências continuam fora do PR. |
| A1/A2 — README e reprodutibilidade desatualizados | Corrigidos. |
| Nomenclaturas | Padronizadas para novas consolidações por dicionário, sem renomear históricos. |

**Parecer reavaliado:** a documentação está adequada para um Pull Request corretivo/intermediário, mas o pacote continua **NÃO PRONTO para o Pull Request de submissão final do TCC**, porque B1, B3, B4 e B5 dependem de decisão do pesquisador ou de evidência que não pode ser reconstruída.

## Resumo das verificações

| Verificação | Resultado | Síntese |
|---|---|---|
| Três abordagens documentadas | Conforme | Manual, ChatGPT e GitHub Copilot possuem seções separadas no `EXPERIMENT_LOG.md`. |
| Cenários C01–C05 presentes | Conforme com ressalva | Há cinco resultados por abordagem, mas a atribuição C04/C05 diverge da matriz congelada v1.1. |
| Comandos de execução | Parcialmente conforme | Os comandos ChatGPT/Copilot correspondem aos runners existentes; a execução Manual foi pela IDE sem comando Maven preservado. |
| Coerência dos status `PASS` | Conforme documentalmente | Cada abordagem possui cinco arquivos de resultado com `PASS`; ChatGPT/Copilot também têm agregados de 5 testes, 0 falhas e 0 erros. |
| Nomenclatura | Não conforme | Há variações de nomes de cenário, abordagem, diretório e extensão de arquivo. |
| Referências a arquivos | Parcialmente conforme | Referências textuais do log existem; vídeos citados nos resultados Manual não são rastreados pelo Git. |
| Reprodutibilidade | Não conforme | Guias estão desatualizados e faltam registros observacionais e consolidações metodológicas. |
| Tempos comparativos | Não conforme | ChatGPT e Copilot permanecem `PENDENTE`; a tabela comparativa ainda não foi preenchida. |

## Achados conformes

1. O `EXPERIMENT_LOG.md` separa explicitamente Manual, ChatGPT e GitHub Copilot.
2. Existem cinco arquivos `resultado` e cinco arquivos `tempo_execucao` rastreados pelo Git em cada abordagem.
3. Todos os quinze arquivos de resultado contêm `PASS`.
4. O comando `mvn -Dtest=chatgpt.runner.ChatGPTTestRunner test` é consistente com o runner existente `src/test/java/chatgpt/runner/ChatGPTTestRunner.java`.
5. O comando `mvn -Dtest=copilot.runner.CopilotTestRunner test` é consistente com o runner existente `src/test/java/copilot/runner/CopilotTestRunner.java`.
6. O runner Manual `src/test/java/runner/TestRunner.java` existe e é coerente com o registro de execução pela IntelliJ IDEA.
7. Os caminhos de resultados e tempos referenciados no `EXPERIMENT_LOG.md` existem e estão rastreados, inclusive o nome preservado `results/manual/C02/resultado.tx`.
8. Os alvos locais dos links verificados em `README.md` existem.
9. O `Relatorio_Validacao_Final_Experimento.md` apresenta corretamente a auditoria como documental e explicita as principais limitações já conhecidas.

## Achados bloqueadores

### B1 — Protocolo congelado e cenários executados não coincidem

A matriz v1.1 define C04 como consulta por status e C05 como exclusão. Também fixa o caso negativo de C01/V10 como JSON sintaticamente malformado com resposta HTTP 400. Os resultados Manual, ChatGPT e Copilot registram C04 como exclusão e C05 como consulta de pet inexistente por GET, sem evidência consolidada do C01/V10 congelado.

Essa divergência impede afirmar, sem decisão metodológica formal, que as quinze execuções observadas correspondem às unidades previstas no protocolo v1.1.

### B2 — Estado temporal contraditório

O início do `EXPERIMENT_LOG.md`, o `README.md`, o `REPRODUCIBILITY.md` e o protocolo congelado ainda declaram que o experimento final não foi executado ou está pendente. Em contraste, o mesmo log e as pastas `results/` documentam quinze unidades com `PASS`.

O `README.md` ainda apresenta protocolo v1.0 como versão aplicável, enquanto o log e o relatório final adotam v1.1.

### B3 — Registros metodológicos obrigatórios ausentes

As seções de execução não preenchem, por unidade, diversos campos previstos no próprio modelo do log:

- identificador estável da execução;
- data, horário, fuso, início, pausas, retomadas e término;
- commit associado a cada unidade;
- contagem e descrição completa dos ajustes;
- registro das cinquenta verificações V01–V50;
- consolidação das rubricas de reúso, BDD e qualidade estrutural;
- prompts/interações e versões efetivamente observadas das ferramentas assistidas;
- evidências de ordem de execução e desvios.

Sem esses registros, não há rastreabilidade suficiente para reproduzir as métricas planejadas ou auditar a conformidade integral com o protocolo.

### B4 — Tempos de implementação incompletos

Os cinco tempos ChatGPT e os cinco tempos GitHub Copilot permanecem `PENDENTE`. Os tempos Manual estão nos registros, mas ainda não foram validados/transcritos para a tabela comparativa, que mantém todas as células como `PENDENTE`.

Sem esses valores, a comparação de produtividade não pode ser concluída.

### B5 — Evidências de vídeo ausentes do conteúdo versionado

Os arquivos Manual citam vídeos `C01_execucao_manual.mov` a `C05_execucao_manual.mov`. Eles existem apenas no ambiente local, estão ignorados pelo Git e não serão incluídos no Pull Request. Seus tamanhos observados variam aproximadamente de 48 MB a 382 MB.

Deve existir uma decisão explícita de preservação/publicação externa, com referência estável e política de acesso, ou uma declaração formal de indisponibilidade. A simples existência local não constitui evidência reprodutível no repositório.

## Achados de alta prioridade

### A1 — `README.md` desatualizado

O README declara, entre outros pontos:

- protocolo v1.0 como versão congelada aplicável;
- experimento final ainda não executado;
- artefatos experimentais ainda não publicados;
- execução final pendente.

Essas afirmações contradizem o log, os resultados rastreados e o relatório de validação v1.1.

### A2 — `REPRODUCIBILITY.md` desatualizado

O guia afirma que detalhes dos cenários e comando experimental permanecem pendentes, que não existe instância local/container configurada e que o experimento final ainda não ocorreu. O repositório já contém configuração Docker, comandos específicos e resultados das três abordagens.

O único comando apresentado pelo guia é `mvn test`; não está demonstrado documentalmente que esse comando genérico execute e diferencie as três suítes. Os comandos efetivamente registrados para ChatGPT e Copilot são específicos por runner.

### A3 — Área de dados finais vazia

`datasets/final-experiment/raw/` e `datasets/final-experiment/processed/` contêm apenas `.gitkeep`. Isso diverge do procedimento de reprodutibilidade que determina armazenamento das observações finais brutas e transformadas nessas áreas.

### A4 — Ordem experimental não auditável

O log não fornece timestamps ou identificadores por unidade que permitam confirmar a ordem de execução prevista, distinguir reexecuções ou reconstruir a sequência Manual/GitHub Copilot/ChatGPT.

### A5 — Resultado Manual sem saída agregada equivalente

Os cinco resultados Manual registram `PASS`, mas não há relatório agregado equivalente a `Tests run`, `Failures`, `Errors`, `Skipped` e `BUILD SUCCESS`. A equivalência das contagens é documental por arquivos, não por uma saída consolidada do runner.

## Divergências de nomenclatura e formato

1. `results/manual/C02/resultado.tx` usa extensão diferente dos demais `resultado.txt`.
2. A abordagem Manual aparece como `Manual`, `Desenvolvimento Manual` e `Implementação: Manual`.
3. C02 aparece como “Consultar um pet existente”, “Consultar pet pelo identificador” e “Consultar um pet determinístico”.
4. C03/C04 variam entre formas com e sem artigo: “Atualizar pet existente”/“Atualizar um pet existente” e “Excluir pet existente”/“Excluir um pet existente”.
5. A abordagem é denominada “GitHub Copilot”, mas código e resultados usam o segmento `copilot`, enquanto a estrutura apresentada no README usa `github-copilot/`.
6. Os arquivos Manual não seguem um único esquema de campos; ChatGPT e Copilot usam formato mais uniforme.
7. C05 ChatGPT registra HTTP 404 e pet não encontrado, mas seu arquivo de resultado não preserva literalmente o body `Pet not found`; o log apresenta essa literalidade.

Essas variações não invalidam sozinhas os status, mas dificultam processamento automático e rastreabilidade sem um dicionário de dados.

## Verificação de referências

### Referências existentes e rastreadas

- Todos os arquivos `resultado` e `tempo_execucao` referenciados pelo `EXPERIMENT_LOG.md` existem e estão rastreados.
- Os runners Manual, ChatGPT e Copilot existem nos caminhos compatíveis com os registros.
- Os documentos e artefatos locais vinculados pelo `README.md` e verificados nesta auditoria existem.

### Referências indisponíveis no Pull Request

- Os cinco vídeos Manual citados nos próprios arquivos de resultado existem localmente, porém são ignorados e não rastreados.
- Arquivos `.DS_Store` também existem localmente em `results/manual`, mas estão ignorados e não devem compor evidência científica.

## Pendências identificadas na auditoria original

1. Resolver formalmente a divergência entre protocolo v1.1 e cenários efetivamente executados, sem reescrever retrospectivamente evidências.
2. Conciliar o status temporal do protocolo/log com as quinze unidades registradas.
3. Atualizar `README.md` e `REPRODUCIBILITY.md` para o estado real, a versão aplicável e os comandos específicos.
4. Preencher e auditar os tempos ChatGPT/Copilot e consolidar os tempos Manual.
5. Completar ou declarar formalmente a ausência dos registros V01–V50, rubricas, ajustes, timestamps, commits, prompts e desvios.
6. Definir a política de armazenamento e referência das evidências de vídeo Manual.
7. Publicar ou justificar a ausência de dados brutos em `datasets/final-experiment/`.
8. Padronizar ou documentar em um dicionário as nomenclaturas e formatos preservados.
9. Adicionar ao versionamento os relatórios novos após revisão, pois `Relatorio_Validacao_Final_Experimento.md` e este relatório ainda não pertencem ao `HEAD` auditado.
10. Executar uma nova auditoria documental após as decisões acima, sem converter ausência de evidência em aprovação presumida.

## Adequação científica posterior

Após esta auditoria, a documentação foi ajustada para caracterizar a fase Petstore como avaliação exploratória do subconjunto de cinco cenários efetivamente implementado. Essa decisão não declara conformidade retroativa com a v1.1 e não cria dados ausentes.

Com essa adequação:

- a divergência protocolo–execução permanece registrada como limitação, e não como conformidade;
- os quinze `PASS` são limitados aos cenários observados;
- produtividade, retrabalho, V01–V50 e qualidade não são apresentados como resultados concluídos;
- tempos, rubricas, rastreabilidade, datasets e vídeos ausentes continuam indisponíveis ou pendentes;
- documentos normativos anteriores são preservados como registros históricos de planejamento.

## Parecer atualizado sobre o Pull Request

**O repositório está documentalmente adequado somente para um relato exploratório com as limitações declaradas. Não está adequado para uma submissão que afirme execução integral do protocolo v1.1 ou comparação quantitativa completa de produtividade e qualidade.**

Os resultados textuais das três abordagens são coerentes quanto aos quinze status `PASS` do subconjunto observado. As lacunas B3–B5 continuam reduzindo a rastreabilidade e a reprodutibilidade e devem permanecer explícitas no TCC; elas não podem ser supridas por inferência.
