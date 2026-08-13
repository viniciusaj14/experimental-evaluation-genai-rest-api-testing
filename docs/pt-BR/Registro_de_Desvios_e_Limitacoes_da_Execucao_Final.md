# Registro de Desvios e Limitações da Execução Observada

## Finalidade

Este documento registra, de forma retrospectiva e sem alterar evidências, as diferenças identificadas entre o protocolo congelado v1.1 e os artefatos de execução presentes no repositório.

Ele **não altera o protocolo v1.1**, não transforma resultados existentes em conformidade retroativa e não autoriza o preenchimento de dados ausentes por inferência. Sua função é dar transparência às limitações antes da análise e da submissão do TCC.

## Identificação

| Campo | Valor |
|---|---|
| Data do registro documental | 9 de agosto de 2026 |
| Protocolo de referência | v1.1 |
| Commit-base científico do protocolo | `d626e1b95f979e33a3e41d6d4489b5b3ad54191f` |
| Branch de consolidação observada | `experiment/consolidation` |
| Natureza | Registro pós-execução exploratória de divergências e ausências documentais |

## Divergência entre cenários congelados e executados

| ID | Protocolo v1.1 | Artefatos de execução observados | Situação |
|---|---|---|---|
| C01 | Criação válida e caso negativo V10 com JSON sintaticamente malformado, esperando HTTP 400. | Os resultados consolidados registram somente criação válida com HTTP 200 e validação do nome. | V10 não possui evidência consolidada nas três abordagens. |
| C02 | Recuperar pet existente por ID. | Consulta de pet existente por ID. | Intenção principal compatível, sem auditoria das dez verificações. |
| C03 | Atualizar pet existente. | Atualização de nome e status. | Intenção principal compatível, sem auditoria das dez verificações. |
| C04 | Recuperar pets por status. | Excluir pet existente e confirmar HTTP 404 posterior. | Cenário executado diferente do congelado. |
| C05 | Excluir pet existente. | Consultar pet inexistente por ID, esperando HTTP 404. | Cenário executado diferente do congelado. |

Consequência: os quinze registros observados permitem descrição comparativa do conjunto efetivamente implementado, mas não são apresentados como execução integral das cinquenta verificações ou dos cinco cenários normativos do protocolo v1.1.

## Ordem e rastreabilidade temporal

O protocolo v1.1 prevê a ordem Manual → GitHub Copilot → ChatGPT. Os registros consolidados não preservam timestamps por unidade, início/fim, pausas, commits por cenário ou identificadores estáveis suficientes para confirmar a ordem efetivamente seguida.

Não se presume conformidade nem desvio de ordem na ausência dessas evidências. A ordem deve ser tratada como **não auditável**.

## Registros ausentes

Não foram localizados registros completos e individualizados para:

- V01–V50 e respectivos estados/evidências;
- consolidação das rubricas de reúso, aderência ao BDD e qualidade estrutural;
- timestamps e cronômetro das unidades assistidas;
- contagem completa de ajustes e intervenções por unidade;
- commits vinculados a cada unidade;
- prompts, respostas e versões/identificadores efetivamente exibidos das ferramentas assistidas;
- dados brutos e processados em `datasets/final-experiment/`.

Esses dados não devem ser reconstruídos retrospectivamente. A ausência deve constar como limitação na análise e nas ameaças à validade.

## Tempos de implementação

- Manual: há tempos nos arquivos preservados, ainda pendentes de validação/transcrição para a tabela comparativa.
- ChatGPT: cinco tempos marcados como `PENDENTE`.
- GitHub Copilot: cinco tempos marcados como `PENDENTE`.

É proibido substituir esses valores por tempo do Maven, duração dos testes ou outra métrica automática.

## Evidências de vídeo Manual

Os resultados Manual citam cinco arquivos `.mov`. Eles existem apenas no ambiente local verificado, estão excluídos pelo `.gitignore` e não integram o conteúdo versionado do repositório. Não há, neste registro, URL externa estável, checksum publicado ou política de acesso que permita recuperá-los a partir do Pull Request.

Para o pacote versionado, essas evidências devem ser tratadas como **não publicadas**. Sua eventual preservação externa exige decisão do pesquisador, observância de tamanho, privacidade e licenciamento e registro de referência estável; nenhum destino externo é presumido neste documento.

## Efeito sobre as conclusões

Os status `PASS` podem sustentar apenas a afirmação de que os cinco cenários efetivamente implementados foram registrados como aprovados em cada abordagem. Eles não sustentam, isoladamente:

- conformidade integral com o protocolo v1.1;
- execução das cinquenta verificações;
- cálculo das seis métricas planejadas;
- avaliação completa de reúso, BDD ou qualidade estrutural;
- comparação de produtividade enquanto os tempos permanecerem incompletos.

## Limitações e adaptações metodológicas

Para adequar o relato ao material empírico preservado, a fase Petstore é caracterizada como avaliação exploratória de um subconjunto observacional de cinco cenários. Essa adaptação é exclusivamente documental: não altera o protocolo histórico, o código, as features ou os resultados.

O conjunto observado é comum às três abordagens e permite relatar executabilidade e status por cenário. Não permite afirmar aderência integral à v1.1, calcular métricas sem dados ou generalizar superioridade de produtividade e qualidade.

## Tratamento exigido na submissão

1. Preservar protocolo, código e resultados existentes sem reescrita retrospectiva.
2. Citar este desvio na metodologia, nos resultados e nas ameaças à validade.
3. Limitar comparações ao conjunto efetivamente observado e às evidências disponíveis.
4. Não classificar ausências como zero, aprovação ou ausência de intervenção.
5. Manter a análise quantitativa de tempo como pendente até o preenchimento pelo pesquisador.

## Status

**Desvios formalmente documentados; limitações científicas permanecem abertas.**
