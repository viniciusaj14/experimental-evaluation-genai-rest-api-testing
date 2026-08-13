# Plano de Controle Experimental

> **Nota de adequação posterior:** os controles abaixo representam o desenho planejado. A documentação disponível não permite confirmar sua aplicação integral na execução observada; controles sem evidência são tratados como não auditáveis, e não como atendidos.

## Finalidade

Definir como reduzir vieses e preservar comparabilidade entre desenvolvimento manual, GitHub Copilot e ChatGPT no futuro experimento final Petstore. Este plano complementa o `Protocolo_Experimental.md`, o `Plano_de_Execucao.md` e o `Checklist_Pre_Execucao.md` sem alterar as métricas ou os cenários.

## Variáveis controladas

| Variável | Regra de controle | Evidência |
| --- | --- | --- |
| Estação de trabalho | Usar a mesma máquina nas três abordagens. | Identificação da máquina no log. |
| Sistema operacional | Manter mesma versão e configuração relevante. | Versão e configuração registradas. |
| Java | Usar a mesma instalação e versão. | `java -version` arquivado. |
| Maven | Usar a mesma instalação, versão e configuração. | `mvn -version` arquivado. |
| IDE | Usar a mesma versão e configuração-base; habilitar apenas o recurso inerente à condição. | Versão, plugins e configuração registrados. |
| Git | Usar o mesmo repositório, commit-base e política de commits. | Hashes e status Git. |
| Estado do projeto | Restaurar área limpa e independente a partir do mesmo baseline antes de cada abordagem. | Commit-base e checklist. |
| Dependências/cache Maven | Resolver previamente e manter a mesma política de cache. | Log de preparação e build-base. |
| Estado da IDE | Reiniciar antes de cada abordagem e aguardar indexação fora do tempo medido. | Timestamp de preparação. |
| Contrato da API | Usar a mesma especificação normativa preservada. | Path e checksum OpenAPI. |
| Cenários | Usar os mesmos cinco cenários congelados em C01–C05. | Versão/checksum da matriz. |
| Verificações | Usar a mesma matriz congelada de cinquenta verificações. | Versão/checksum da matriz. |
| Pesquisador/executor | Manter o mesmo executor nas três abordagens. | Identificação no log. |
| Ordem | Manual primeiro; GitHub Copilot e ChatGPT em ordem pré-randomizada antes do congelamento; C01–C05 em cada condição. | Método e resultado da randomização preservados. |
| Dados | Usar identificadores únicos e dados independentes por abordagem/cenário. | Registro de setup e limpeza. |
| Ambiente de execução | Usar a alternativa Petstore congelada após o piloto de viabilidade. | Base URL/configuração sem segredos. |
| Regras operacionais | Aplicar o mesmo plano de tempo, retrabalho, interrupção e evidência. | Checklists e logs. |

## Variável independente

A variável independente é a abordagem de desenvolvimento, com três níveis:

1. desenvolvimento manual, sem assistência de IA generativa;
2. desenvolvimento com GitHub Copilot conforme configuração e prompts congelados;
3. desenvolvimento com ChatGPT conforme contexto e prompts congelados.

As diferenças inerentes às ferramentas fazem parte da variável independente. Outras diferenças de ambiente ou procedimento são desvios.

## Variáveis dependentes

As seis métricas são:

1. tempo ativo de desenvolvimento;
2. retrabalho, medido por intervenções corretivas após a primeira versão executável, com origem registrada separadamente;
3. correção inicial das validações conforme numerador e denominador congelados;
4. percentual de reúso de código conforme rubrica congelada;
5. cenários aderentes ao BDD e percentual conforme rubrica congelada;
6. qualidade estrutural quantitativa conforme rubrica congelada.

O instrumento, a fórmula e o tratamento de dados ausentes de cada métrica devem estar aprovados antes da execução. Nenhuma redefinição posterior é permitida.

## Fatores de confusão e mitigação

### Efeito de aprendizagem

**Risco:** o executor pode aprender sobre domínio, cenários ou estrutura ao avançar pelas condições.

**Mitigação:** manter a condição manual primeiro; pré-randomizar a ordem entre GitHub Copilot e ChatGPT antes do congelamento e preservar método e resultado; executar cada abordagem a partir do mesmo baseline; proibir cópia ou consulta a implementações anteriores; congelar materiais; registrar experiência acumulada como ameaça. Nunca randomizar depois de observar resultado final e não afirmar que a randomização parcial eliminou o efeito.

### Fadiga do pesquisador

**Risco:** cansaço pode aumentar tempo, erros ou retrabalho nas condições posteriores.

**Mitigação:** planejar sessões e pausas antes da execução; não iniciar cenário quando o executor declarar incapacidade de manter atenção; registrar horários e pausas; aplicar a mesma política de descanso; considerar a posição sorteada das condições assistidas e não afirmar que a pré-randomização parcial eliminou a fadiga.

### Cache e estado da IDE

**Risco:** indexação, sugestões anteriores, arquivos recentes ou caches podem favorecer uma condição.

**Mitigação:** reiniciar a IDE antes de cada abordagem; aguardar indexação fora do tempo; usar configuração-base registrada; remover histórico contextual específico quando permitido sem alterar caches comuns; registrar qualquer limpeza excepcional como desvio.

### Instabilidade da API

**Risco:** indisponibilidade, reset, persistência inconsistente ou mudança de comportamento pode alterar verificações e tempos.

**Mitigação:** concluir o piloto de viabilidade; preferir instância controlada; congelar ambiente; usar dados isolados; registrar saúde antes de cada cenário; pausar apenas em indisponibilidade comprovada; classificar verificações impedidas sem aprovação presumida.

### Ambiente público compartilhado

**Risco:** terceiros podem criar, alterar ou excluir dados e contaminar filtros.

**Mitigação:** recomendar ambiente controlado para o experimento final; se o público for aprovado, usar identificadores exclusivos, janelas curtas, validação por identidade, limpeza e registro de interferência. Não validar contagem ou ordem global.

### Conectividade com a internet

**Risco:** falhas afetam API, Copilot ou ChatGPT de forma diferente.

**Mitigação:** verificar conectividade antes do cenário; registrar indisponibilidade; pausar somente quando a falha impedir atividade necessária; retomar com estado íntegro; reiniciar apenas pelos critérios deste plano. Latência normal permanece no tempo.

### Interpretação de prompts e requisitos

**Risco:** mudanças de redação, contexto ou esclarecimentos podem alterar a tarefa.

**Mitigação:** congelar texto, idioma, contexto, ordem e regras de interação; registrar checksum; proibir edição após início; usar respostas de esclarecimento previstas ou registrar desvio; preservar todo histórico permitido.

### Diferenças de runtime e dependências

**Risco:** JVM, Maven, dependências, plugins ou parâmetros distintos podem afetar build e execução.

**Mitigação:** registrar e fixar versões; usar o mesmo `pom.xml`, commit-base, comandos e configuração; resolver dependências antes da medição; impedir atualização entre condições; registrar divergência de runtime como desvio potencialmente invalidante.

## Interrupções experimentais

### Continuar a execução

Continuar a mesma execução quando:

- a interrupção for externa e recuperável;
- cronômetro, código, logs, dados e evidências permanecerem íntegros;
- a abordagem, prompt, cenário e baseline continuarem corretos;
- for possível registrar início, fim e motivo da pausa;
- a retomada não exigir redefinir requisito ou oráculo.

O cronômetro permanece ativo durante espera normal inerente à tarefa. Em interrupção externa permitida, deve ser pausado e retomado conforme o plano de execução.

### Reiniciar a execução

Reiniciar com novo identificador quando ocorrer:

- perda ou corrupção do registro de tempo;
- perda de logs/evidências essenciais da primeira execução;
- uso do cenário, prompt, abordagem ou baseline incorreto;
- contaminação por código de outra abordagem;
- assistência não permitida na condição manual;
- alteração não autorizada de ferramenta, dependência, contrato, cenário, verificação ou oráculo;
- corrupção de dados que impeça distinguir comportamento da solução e interferência externa;
- interrupção irrecuperável que impeça preservar o estado metodológico.

A execução interrompida não deve ser apagada. Deve ser marcada como interrompida/inválida, preservada para auditoria e excluída dos cálculos conforme regra prévia. Reinício não pode ser usado para descartar desempenho desfavorável.

### Suspender para decisão

Quando houver dúvida entre continuar e reiniciar, pausar, registrar o estado e abrir um desvio. A decisão deve ocorrer antes de observar ou comparar resultados agregados.

## Gestão de desvios

1. Atribuir identificador único ao desvio.
2. Registrar fase, abordagem, cenário, execução, data e responsável.
3. Descrever regra prevista e evento observado sem alterar registros originais.
4. Anexar evidências, timestamps, commits, logs e outputs relevantes.
5. Classificar origem: ambiente, ferramenta, API, dados, procedimento, interrupção ou outro.
6. Avaliar impacto sobre tempo, retrabalho, validação, rubricas, comparabilidade e reprodutibilidade.
7. Decidir antes da continuidade: prosseguir, pausar, reiniciar ou invalidar.
8. Registrar quem tomou a decisão e sua justificativa.
9. Atualizar `EXPERIMENT_LOG.md` e o checklist correspondente.
10. Preservar a execução afetada; não reescrever dados para aparentar conformidade.
11. Relatar o desvio na análise e nas ameaças à validade.

Desvio recorrente que afete mais de uma abordagem exige suspender o experimento e avaliar se o protocolo ou ambiente deve ser recongelado. Qualquer recongelamento invalida a comparabilidade com execuções anteriores, salvo decisão metodológica explícita e documentada.
