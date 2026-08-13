# Dicionário de Dados dos Resultados Experimentais

## Finalidade

Este dicionário padroniza a leitura dos artefatos já preservados sem renomear arquivos, alterar resultados ou normalizar retrospectivamente o conteúdo original.

## Abordagens

| Nome canônico | Identificadores e caminhos preservados |
|---|---|
| Manual | `Manual`, `Desenvolvimento Manual`, `Implementação: Manual`, `runner.TestRunner`, `results/manual/` |
| ChatGPT | `ChatGPT`, `chatgpt`, `chatgpt.runner.ChatGPTTestRunner`, `results/chatgpt/` |
| GitHub Copilot | `GitHub Copilot`, `Copilot`, `copilot`, `copilot.runner.CopilotTestRunner`, `results/copilot/`, diretório histórico `github-copilot/` |

Os nomes canônicos devem ser usados em novas tabelas e textos. Os aliases permanecem válidos somente para localizar artefatos históricos.

## Cenários efetivamente registrados

| ID | Nome canônico para consolidação | Variações preservadas |
|---|---|---|
| C01 | Criar um pet válido | “Criar pet válido”; descrição com `POST /pet`. |
| C02 | Consultar pet pelo identificador | “Consultar um pet existente”; “Consultar um pet determinístico”; descrição com `GET /pet/{id}`. |
| C03 | Atualizar pet existente | “Atualizar um pet existente”; atualização de nome e status por `PUT /pet`. |
| C04 | Excluir pet existente | “Excluir um pet existente”; descrição com `DELETE /pet/{id}` e consulta posterior. |
| C05 | Consultar pet inexistente | “Consultar um pet inexistente”; `GET /pet/{id}`, HTTP 404 e, quando preservado, body `Pet not found`. |

Esses nomes descrevem os resultados observados. Eles não substituem a matriz do protocolo v1.1; a divergência está registrada em `Registro_de_Desvios_e_Limitacoes_da_Execucao_Final.md`.

## Estrutura dos arquivos

| Artefato | Caminho esperado |
|---|---|
| Resultado Manual | `results/manual/CNN/resultado.txt` |
| Exceção preservada Manual C02 | `results/manual/C02/resultado.tx` |
| Tempo Manual | `results/manual/CNN/tempo_execucao.txt` |
| Resultado ChatGPT | `results/chatgpt/CNN/resultado.txt` |
| Tempo ChatGPT | `results/chatgpt/CNN/tempo_execucao.txt` |
| Resultado GitHub Copilot | `results/copilot/CNN/resultado.txt` |
| Tempo GitHub Copilot | `results/copilot/CNN/tempo_execucao.txt` |

`CNN` representa C01–C05. A extensão `.tx` de C02 Manual é uma exceção histórica deliberadamente não renomeada.

## Estados e valores

| Valor | Significado |
|---|---|
| `PASS` | O resultado preservado registra aprovação do cenário efetivamente implementado. Não implica aprovação automática das dez verificações da matriz. |
| `FAIL` | Falha registrada, quando presente. Não deve ser removida ou convertida. |
| `PENDENTE` | Dado ainda não informado ou consolidado. Não equivale a zero, não aplicável ou aprovação. |

## Tempo de implementação

O tempo de implementação representa esforço de desenvolvimento até `PASS`, incluindo geração, ajustes e validação conforme o registro do pesquisador. Não usar:

- tempo interno do Maven;
- duração do runner/teste automatizado;
- tempo inferido de timestamps de arquivos;
- valor calculado retrospectivamente sem evidência.

## Campos canônicos para novas consolidações

- `Cenário`;
- `Abordagem`;
- `Tempo de implementação`;
- `Resultado esperado`;
- `Resultado obtido`;
- `Status`;
- `Limitação` ou `PENDENTE`, quando aplicável.
