# Plano de Execução

> **Nota de adequação posterior:** este plano registra o procedimento previsto antes da coleta. Os registros existentes não comprovam que todas as suas etapas foram seguidas; a fase Petstore é relatada como avaliação exploratória do subconjunto efetivamente implementado. Esta nota não altera o plano histórico nem o protocolo v1.1.

## Finalidade

Este documento define o procedimento operacional planejado para a Fase 2 com Swagger Petstore OpenAPI 3. Ele transforma o protocolo científico em uma sequência executável e auditável, sem alterar objetivo, questões de pesquisa, métricas, cenários ou verificações. Na data de elaboração deste plano, a execução ainda não havia ocorrido.

Todas as quinze unidades do experimento final devem seguir o [`Protocolo_Congelado_v1.1.md`](Protocolo_Congelado_v1.1.md), que substitui a versão 1.0 como versão válida para execução. A versão 1.0 permanece preservada somente como histórico.

O plano somente poderá ser usado após o congelamento do protocolo, dos prompts, dos cenários, da matriz de validações, das rubricas e do ambiente. O [checklist](Checklist_Pre_Execucao.md) e o [plano de controle experimental](Plano_de_Controle_Experimental.md) são partes obrigatórias da execução.

## Regras gerais de execução

As três abordagens devem usar:

- a mesma estação de trabalho;
- o mesmo sistema operacional e a mesma configuração relevante;
- a mesma instalação e versão do Java;
- a mesma instalação e versão do Maven;
- a mesma IDE e configuração de plugins permitidos, exceto o recurso que caracteriza a abordagem;
- o mesmo repositório Git;
- o mesmo commit-base e o mesmo estado limpo do projeto antes de cada abordagem;
- a mesma especificação normativa Swagger Petstore e o mesmo checksum;
- os mesmos cinco cenários congelados, na ordem C01, C02, C03, C04 e C05;
- a mesma matriz de cinquenta verificações congeladas;
- as mesmas regras de tempo, retrabalho, evidência, impedimento e desvio;
- dados exclusivos por abordagem e cenário, sem compartilhamento de recursos mutáveis entre condições.

Versões e identificadores efetivamente utilizados devem ser registrados no `EXPERIMENT_LOG.md`. Nenhuma atualização de software, configuração, dependência, prompt, cenário ou verificação é permitida entre abordagens sem registrar um desvio e decidir seu tratamento antes de continuar.

## Unidades e níveis de registro

- **Unidade de execução:** um cenário implementado sob uma abordagem de desenvolvimento.
- **Total:** `5 cenários × 3 abordagens = 15 unidades de execução`.
- **Registro observacional:** evidências e medições produzidas por uma unidade de execução e vinculadas ao seu identificador.
- **Registro por unidade:** tempo de desenvolvimento, retrabalho e correção inicial das validações.
- **Consolidação por abordagem:** reúso de código, aderência ao BDD e qualidade estrutural, somente após a conclusão das cinco unidades da abordagem.

Não agregar valores entre esses níveis sem regra explícita congelada. Nenhuma rubrica de abordagem deve ser calculada ao encerrar apenas um cenário.

## Preparação do estado-base

1. Registrar o commit-base congelado.
2. Confirmar que o build e as verificações de integridade passam antes da primeira abordagem.
3. Preparar uma branch ou área de trabalho independente para cada abordagem a partir do mesmo commit-base.
4. Confirmar ausência de código ou dados residuais de outra abordagem.
5. Concluir indexação, resolução de dependências e inicialização da IDE antes do início da medição.
6. Manter o mesmo estado de cache Maven previamente preparado para as três abordagens; downloads de preparação não integram o tempo medido.
7. Reiniciar a IDE antes de cada abordagem e aguardar a conclusão da indexação antes do primeiro cenário.

## Ordem de execução

1. **Desenvolvimento manual** — executar C01 a C05.
2. **Primeira abordagem assistida pré-randomizada** — GitHub Copilot ou ChatGPT; restaurar o estado-base e executar C01 a C05.
3. **Segunda abordagem assistida** — a condição restante; restaurar o estado-base e executar C01 a C05.

A condição manual ocorre primeiro para evitar que sugestões de IA sejam vistas antes da construção da baseline. A ordem entre GitHub Copilot e ChatGPT deve ser pré-randomizada antes do congelamento do protocolo mediante procedimento reprodutível, com método, resultado, timestamp, responsável e eventual semente registrados no `EXPERIMENT_LOG.md`. O registro deve ser preservado mesmo que a sequência sorteada coincida com a ordem inicialmente proposta. É proibido sortear ou alterar a ordem após observar qualquer resultado do experimento final. Essa decisão reduz o vínculo deliberado entre ferramenta e posição, mas não elimina efeitos de aprendizagem ou fadiga, que devem ser relatados conforme o `Plano_de_Controle_Experimental.md`.

Não é permitido alternar abordagens no meio de um cenário ou reutilizar código produzido em outra abordagem.

## Ciclo de execução por cenário

Para cada abordagem e para cada cenário, seguir exatamente:

```text
Preparação
  ↓
Início do cronômetro
  ↓
Desenvolvimento
  ↓
Execução
  ↓
Validação
  ↓
Correção, se necessária
  ↓
Registro das métricas
  ↓
Commit
  ↓
Coleta de evidências
  ↓
Encerramento
```

### 1. Preparação

- confirmar abordagem, cenário e identificador da execução;
- conferir estado Git limpo e origem no commit-base aplicável;
- selecionar somente os requisitos, prompts e verificações congeladas do cenário;
- para C01, confirmar que V10 usa exatamente um corpo JSON sintaticamente malformado com `Content-Type: application/json` e resposta esperada HTTP `400`;
- preparar identificadores e dados isolados;
- confirmar disponibilidade do ambiente e iniciar logs;
- zerar o cronômetro sem iniciá-lo.

### 2. Início do cronômetro

Iniciar imediatamente antes de disponibilizar ao executor o enunciado congelado do cenário e permitir sua primeira ação de análise ou desenvolvimento.

### 3. Desenvolvimento

Inclui leitura do enunciado durante a janela medida, escrita de código, uso permitido da abordagem, build, depuração e preparação da primeira versão executável.

### 4. Execução

Executar a primeira versão capaz de iniciar o fluxo automatizado do cenário. Registrar integralmente o output. Essa execução estabelece o marco após o qual intervenções corretivas contam como ajustes.

### 5. Validação

Aplicar as dez verificações congeladas do cenário, preservando categoria, estado, evidência e eventual impedimento. Não alterar o oráculo durante a execução.

Para C01/V10, o caso negativo oficial é exclusivamente o envio de corpo JSON sintaticamente malformado com `Content-Type: application/json`, com resposta esperada HTTP `400`. A ausência de campo obrigatório, inclusive `name`, não deve ser usada como caso negativo oficial.

### 6. Correção

Quando um critério não for atendido e o protocolo permitir correção, aplicar as regras de retrabalho abaixo, executar novamente e atualizar o registro sem apagar a primeira execução.

### 7. Registro das métricas

Registrar tempo ativo, ajustes e correção inicial por unidade de execução conforme `Metricas.md`. As rubricas de reúso, aderência ao BDD e qualidade estrutural somente são consolidadas no checklist pós-abordagem, após os cinco cenários. Não calcular fórmula ainda não aprovada.

### 8. Commit

Criar um commit exclusivo do cenário após concluir código e registros obrigatórios. Associar hash, abordagem, cenário e identificador da execução no log. O commit não deve incluir segredos nem artefatos de outra abordagem.

### 9. Coleta de evidências

Consolidar logs, outputs, registros de validação, hashes e demais evidências no diretório da Fase 2, mantendo vínculo com abordagem, cenário e execução.

### 10. Encerramento

Confirmar o checklist pós-cenário, registrar limpeza, impedimentos e desvios e somente então preparar o próximo cenário. Depois do quinto cenário da abordagem, preencher também o checklist pós-abordagem e consolidar as três rubricas.

## Regras de cronometragem

### Início

O cronômetro inicia imediatamente antes da apresentação do enunciado congelado e da primeira atividade intelectual ou técnica do cenário. Preparação de ambiente, indexação, download de dependências, verificação de checksum e criação do identificador ocorrem antes e não integram o tempo.

### Períodos incluídos

- leitura e interpretação do cenário durante a janela medida;
- escrita e edição do código;
- interação permitida com a ferramenta da abordagem;
- builds, execuções e espera normal pelo runtime ou API;
- análise de falhas, depuração, validação e correções;
- repetição necessária após uma correção.

### Pausas permitidas

O cronômetro pode ser pausado somente por:

- interrupção externa não relacionada ao experimento;
- indisponibilidade comprovada de energia, rede, máquina, serviço ou ferramenta necessária;
- pausa pessoal inevitável;
- decisão formal de suspender para avaliar um possível desvio.

Não pausar por dificuldade, pesquisa permitida, reflexão, depuração, espera normal de build, resposta da IA ou chamada da API.

Toda pausa deve registrar início, fim, motivo, estado do cenário e evidência disponível. O tempo pausado não integra o tempo ativo, mas deve permanecer no log.

### Retomada

Retomar o cronômetro imediatamente antes da primeira atividade do cenário após cessar a causa da pausa. Confirmar previamente que código, logs, estado Git, dados e evidências permanecem íntegros.

### Término

Parar o cronômetro quando:

1. todas as dez verificações tiverem estado registrado;
2. correções permitidas tiverem terminado;
3. o executor declarar que não fará nova alteração;
4. o cenário alcançar o critério de conclusão ou for formalmente classificado como impedido.

Registro de métricas, commit e arquivamento posterior não integram o tempo, desde que não alterem a solução. Se uma alteração de código ocorrer após a parada, o cronômetro deve ser retomado e o motivo registrado.

## Regras de retrabalho

### O que conta como um ajuste

Um ajuste é uma intervenção corretiva logicamente identificável, aplicada após a primeira versão executável para resolver um critério não atendido, independentemente de a alteração ter sido escrita manualmente, sugerida e aceita do GitHub Copilot ou gerada pelo ChatGPT e aplicada. Deve registrar motivo, arquivos afetados, verificação relacionada, execução subsequente e origem da correção em campo separado.

### Edições repetidas

- várias edições contíguas destinadas à mesma correção, antes de nova execução, contam como um ajuste;
- se a solução for executada novamente e a mesma falha exigir nova correção, conta-se novo ajuste;
- correções de problemas distintos contam separadamente, ainda que realizadas antes da mesma reexecução;
- pressionamentos de tecla, salvamentos e mudanças de linha não são unidades de ajuste.

### O que não conta

- edição anterior à primeira versão executável;
- formatação sem mudança funcional;
- correção ortográfica em comentário ou documentação sem efeito funcional;
- refatoração exclusivamente estrutural não motivada por critério não atendido;
- sugestão do GitHub Copilot ou resposta do ChatGPT que não seja aplicada;
- mudança causada apenas pela coleta de evidência ou pelo commit.

Refatoração ou formatação que produza a correção funcional de um critério não atendido conta como ajuste e deve ser associada à verificação correspondente. Alterações sem efeito funcional não contam. Alterações não contabilizadas ainda devem aparecer no histórico Git e, quando relevantes, no log.

## Regras de prompts

- prompts, contexto permitido, ordem de uso e regras de interação devem ser congelados antes da primeira abordagem;
- cada arquivo congelado deve ter versão ou checksum registrado;
- prompts não podem ser corrigidos, ampliados, traduzidos ou substituídos depois do início do experimento;
- o mesmo conteúdo aplicável deve ser usado em todas as repetições previstas da mesma condição;
- prompts e respostas devem ser preservados no idioma exato usado;
- qualquer desvio deve ser registrado e tratado conforme o plano de controle antes da continuidade;
- a condição manual não pode receber conteúdo gerado por IA.

## Evidências obrigatórias

- identificador da fase, abordagem, cenário e execução;
- timestamps de preparação, início, pausas, retomadas, término e coleta;
- registro do cronômetro e cálculo do tempo ativo;
- screenshots, quando aplicáveis e permitidos;
- commit-base e commits produzidos;
- código criado ou alterado;
- prompts, contexto, respostas e sugestões permitidas;
- logs da IDE, build e testes quando relevantes;
- output completo das execuções;
- registros individuais das cinquenta verificações;
- contagem e descrição dos ajustes;
- evidências das rubricas congeladas;
- dados de setup e limpeza sem segredos;
- indisponibilidades, interrupções, impedimentos e desvios;
- versões observadas do sistema, Java, Maven, IDE, dependências e ferramentas;
- checksum da especificação normativa;
- atualização correspondente no `EXPERIMENT_LOG.md`.

Toda evidência deve ser rastreável ao commit e ao identificador da execução. Evidência ausente não pode ser reconstruída por suposição.
