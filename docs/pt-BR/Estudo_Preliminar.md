# Estudo Preliminar

## Classificação

O estudo já realizado é classificado como **estudo piloto preliminar**. Seus resultados não pertencem ao protocolo final da Swagger Petstore e não podem ser combinados numericamente com dados do futuro experimento final.

Esta classificação decorre da revisão do documento original de resultados preliminares. Nenhum valor numérico é reproduzido aqui.

## Informações históricas confirmadas

- foram comparadas três abordagens: desenvolvimento manual, GitHub Copilot e ChatGPT;
- foi utilizada uma API REST pública de dados abertos do domínio veicular;
- a identidade oficial, o provedor, a URL, o contrato e os paths exatos dessa API não foram preservados;
- o ambiente local incluiu Java 21, REST Assured, Cucumber, Gherkin e IntelliJ IDEA;
- foram planejadas dez validações por cenário, totalizando cinquenta validações por abordagem.

Não há confirmação documental suficiente para acrescentar OpenAPI, código-fonte, prompts, versões de ferramentas, identificadores de modelos ou outros artefatos ausentes.

## Cinco cenários registrados

1. consulta de marcas de veículos;
2. consulta de modelos de veículos por marca;
3. consulta de ano/modelo;
4. consulta de detalhes de veículo;
5. consulta com parâmetro inválido.

O documento preliminar menciona campos como `traceId`, `results` e `zeroKm`. Essas referências são preservadas apenas como informação histórica confirmada. Não permitem inferir schema, endpoint, fornecedor, semântica completa ou resposta concreta.

## Métricas registradas no piloto

O documento preliminar registra:

- tempo ativo de desenvolvimento;
- total de ajustes manuais após a primeira execução;
- média de ajustes por cenário;
- taxa de retrabalho;
- proporção de validações corretas na primeira execução;
- percentual de código reutilizado;
- quantidade de cenários aderentes ao BDD entre os cinco;
- percentual de aderência ao BDD;
- discussão qualitativa de qualidade estrutural.

As definições confirmadas e os limites de interpretação estão em [`Metricas.md`](Metricas.md). Não foi confirmada uma pontuação numérica objetiva e consolidada de qualidade estrutural no piloto.

## Limitações históricas

- ausência da identificação oficial da API e de sua URL;
- ausência de contrato preservado;
- ausência dos paths exatos usados;
- ausência de artefatos-fonte necessários para reprodução integral;
- impossibilidade de verificar retrospectivamente o comportamento do serviço;
- risco de reconstruir procedimentos, schemas, respostas ou métricas por suposição;
- impossibilidade de mapear legitimamente os resultados veiculares para a Swagger Petstore.

## Consequência metodológica

O piloto contribui como evidência de viabilidade e aprendizado metodológico, mas não constitui a execução do protocolo final Petstore. A Swagger Petstore, seus cinco cenários candidatos e seus cinquenta checks definem um novo protocolo que deverá ser congelado e executado novamente.
