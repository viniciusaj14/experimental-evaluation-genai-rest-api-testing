# Seleção da API

> **Escopo temporal:** a Swagger Petstore foi selecionada exclusivamente para o futuro experimento final. O estudo piloto concluído utilizou outra API pública do domínio veicular, cuja identidade não foi preservada. Nenhum dado ou resultado histórico pode ser atribuído à Petstore.

## API selecionada

O objeto de estudo selecionado é a **Swagger Petstore - OpenAPI 3.0**, disponibilizada pelo projeto oficial Swagger Petstore. O contrato preservado declara OpenAPI `3.0.4` e versão de documento da API `1.0.27`. A cópia JSON utilizada para as decisões metodológicas está em [`docs/api-specification/swagger-petstore-openapi.json`](../api-specification/swagger-petstore-openapi.json), com origem e checksum registrados no [`README` da especificação](../api-specification/README.md).

A Swagger Petstore foi selecionada como objeto do estudo. Ela não foi desenvolvida como parte desta pesquisa.

## Justificativa

A API oferece um contrato OpenAPI legível por ferramentas e um conjunto de operações REST que permite planejar testes de criação, consulta, atualização, filtragem e exclusão. O domínio de demonstração é suficientemente simples para que as três abordagens — desenvolvimento manual, GitHub Copilot e ChatGPT — recebam requisitos equivalentes sem depender de conhecimento especializado de negócio.

O contrato contempla múltiplos métodos HTTP, parâmetros de path, query e header, payloads JSON, códigos de status HTTP e schemas de resposta. Essas características sustentam cenários positivos e negativos e permitem que REST Assured seja usado para requisições e validações, Cucumber para a especificação executável e Behavior-Driven Development (BDD) para expressar contexto, ação e comportamento esperado.

## Benefícios para a reprodutibilidade

- contrato oficial preservado localmente com checksum;
- identificação explícita das versões declaradas pelo documento;
- rastreabilidade entre operações, cenários e validações planejadas;
- possibilidade de revisar o contrato sem depender da disponibilidade imediata do serviço público;
- separação entre o contrato congelado para o estudo e mudanças posteriores do ambiente online.

## Limitações e riscos do ambiente público

O serviço público é uma demonstração compartilhada. Outros usuários podem criar, alterar ou remover dados simultaneamente. O ambiente pode sofrer resets, indisponibilidade, mudança de comportamento ou atualização independente da cópia preservada. Portanto, a existência e o conteúdo de recursos públicos não devem ser presumidos como estáveis.

Os principais riscos são:

- interferência externa nos dados usados por um cenário;
- colisão de identificadores ou nomes;
- remoção ou alteração de recursos entre preparação e validação;
- resultados de filtros contaminados por dados de terceiros;
- falha de limpeza por indisponibilidade ou alteração concorrente;
- divergência entre a implementação pública e o contrato preservado.

## Mitigações planejadas

- gerar identificadores e valores textuais exclusivos por execução;
- criar dados isolados para cada cenário que dependa de estado;
- validar o recurso pela identidade exclusiva, sem assumir exclusividade global do ambiente;
- executar limpeza explícita quando a operação e o estado do serviço permitirem;
- registrar verificações impedidas separadamente, sem removê-las nem contá-las como aprovadas;
- preservar o contrato OpenAPI local e registrar divergências observadas no ambiente público.

## Alternativas de ambiente de execução

### Instância pública

`https://petstore3.swagger.io` permite acesso direto à demonstração oficial, porém compartilha estado com terceiros e pode sofrer resets, indisponibilidade ou mudança independente do contrato preservado.

### Instância local ou conteinerizada controlada

Uma instância controlada do projeto oficial permite preparar estado conhecido, isolar dados, repetir cenários e executar limpeza com menor interferência externa. Por essas razões, ela é a alternativa recomendada para o experimento final. Este repositório ainda não configura nem inicia essa instância.

A escolha definitiva entre o ambiente Petstore público e o controlado deve ser baseada no [piloto de viabilidade](Piloto_de_Viabilidade.md). O ambiente histórico da API veicular não é critério de seleção para a Fase 2 e não deve ser reconstruído ou comparado por inferência.

## Decisões ainda pendentes

A API está formalmente selecionada para o experimento final, que ainda não foi executado. O subconjunto final de operações e os detalhes dos cinco cenários permanecem em revisão metodológica nas matrizes de [endpoints](Inventario_de_Endpoints.md), [cenários](Matriz_de_Cenarios.md) e [validações](Matriz_de_Validacoes.md). A adoção desses candidatos não deve ser confundida com o piloto veicular, execução Petstore concluída ou publicação de resultados.
