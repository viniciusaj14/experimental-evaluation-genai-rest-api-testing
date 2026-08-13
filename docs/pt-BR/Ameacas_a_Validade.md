# Ameaças à Validade

## Escopo da avaliação

A fase Petstore é interpretada como avaliação exploratória do subconjunto de cinco cenários efetivamente implementado nas abordagens Manual, GitHub Copilot e ChatGPT. As ameaças abaixo limitam o alcance das conclusões e impedem tratar os artefatos como execução integral do protocolo v1.1.

## Validade de constructo

As dimensões originalmente planejadas — produtividade, retrabalho, correção inicial, reúso, aderência ao BDD e qualidade estrutural — não foram integralmente operacionalizadas nos registros disponíveis. Tempos das abordagens assistidas permanecem pendentes, contagens completas de ajustes não foram preservadas e V01–V50 e rubricas não foram consolidados.

Consequentemente, os status `PASS` representam somente o resultado registrado dos cenários implementados. Eles não constituem medidas das seis métricas planejadas e não sustentam inferência de produtividade ou qualidade global.

## Validade interna

O protocolo v1.1 previa C01/V10, C04 como consulta por status e C05 como exclusão. A execução observada não consolidou C01/V10, utilizou C04 para exclusão e C05 para consulta de pet inexistente. Essa divergência impede atribuir os resultados à aplicação integral do tratamento planejado.

Também não foram preservados timestamps, commits e registros de interação suficientes para auditar a ordem Manual → GitHub Copilot → ChatGPT, o isolamento entre condições, todas as intervenções humanas ou a influência de aprendizagem e fadiga. Diferenças observadas não podem ser atribuídas exclusivamente à abordagem de desenvolvimento.

## Validade externa

Os resultados estão vinculados a uma única API de demonstração, um ambiente local controlado, cinco cenários e uma implementação por abordagem. Ferramentas assistidas por IA podem mudar e produzir respostas diferentes. Portanto, os achados não devem ser generalizados automaticamente para outras APIs, equipes, tarefas, IDEs, versões de modelos ou contextos profissionais.

O piloto veicular utilizou outra API e permanece uma fase histórica separada. Seus dados não podem ser combinados com os registros Petstore.

## Validade de conclusão

Com os dados disponíveis, a conclusão admissível é descritiva: existem quinze registros cenário-abordagem com `PASS` para o subconjunto observado, e as suítes atuais demonstraram executabilidade em validação técnica posterior.

Não estão disponíveis bases para comparação quantitativa de produtividade, retrabalho ou qualidade, aplicação das cinquenta verificações, testes inferenciais, significância estatística ou afirmação de superioridade entre abordagens. Dados ausentes não são tratados como zero ou como evidência favorável.

## Reprodutibilidade

Os runners e comandos das abordagens assistidas permitem reexecutar tecnicamente as suítes atuais. A execução Manual original ocorreu pela IntelliJ IDEA e não preservou comando Maven específico. Reexecuções técnicas posteriores não reproduzem o esforço de implementação nem integram a coleta oficial.

A reprodutibilidade científica é reduzida pela ausência ou indisponibilidade de parte dos timestamps, versões de ferramentas, prompts e interações, commits por unidade, dados brutos/processados, rubricas e vídeos Manual no conteúdo versionado. Essas evidências não podem ser reconstruídas retrospectivamente.

## Limitações e adaptações metodológicas

- O protocolo v1.1 permanece como planejamento histórico, sem alegação de execução integral.
- O objeto analisado foi restringido documentalmente ao subconjunto de cinco cenários comum às três abordagens.
- A análise foi limitada a executabilidade, status e artefatos preservados.
- Métricas e avaliações sem evidência correspondente foram excluídas das conclusões, sem substituição por dados automáticos.
- Divergências, registros ausentes e impossibilidade de auditar a ordem devem ser declarados no texto do TCC.

Essas adaptações aumentam a transparência do relato, mas não eliminam as ameaças nem recuperam evidências ausentes.
