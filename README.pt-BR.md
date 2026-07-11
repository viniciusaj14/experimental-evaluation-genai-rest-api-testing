# Avaliação Experimental de Inteligência Artificial Generativa para Automação de Testes de API REST Utilizando Behavior-Driven Development (BDD)

[English](README.md) | [Português (Brasil)](README.pt-BR.md)

Repositório científico do Trabalho de Conclusão de Curso do MBA USP/ESALQ.

> **Status da pesquisa:** o protocolo e os instrumentos estão em preparação. Não há resultados experimentais nem DOI emitido. Resultados não devem ser inventados.

## Objetivo

Avaliar experimentalmente a produtividade e a qualidade da automação de testes de API REST com Behavior-Driven Development (BDD) em três abordagens:

- desenvolvimento manual;
- desenvolvimento assistido pelo GitHub Copilot;
- desenvolvimento assistido pelo ChatGPT.

## Escopo confirmado

- cinco cenários de teste equivalentes para cada abordagem;
- cinquenta verificações de validação para cada abordagem;
- Java 21, Maven, REST Assured, Cucumber, JUnit 5 e IntelliJ IDEA;
- métricas de tempo de desenvolvimento, retrabalho, cobertura de validação, reúso de código, aderência ao BDD e qualidade estrutural.

O nome da API e seus endpoints permanecem pendentes enquanto não forem formalmente definidos. Nenhuma API, endpoint, versão de modelo ou resultado deve ser inferido.

## Questões de pesquisa

A questão principal compara produtividade e qualidade entre as três abordagens. Duas questões auxiliares tratam de:

1. tempo de desenvolvimento e retrabalho;
2. cobertura de validação, reúso de código, aderência ao BDD e qualidade estrutural.

Consulte [`docs/pt-BR/Questoes_de_Pesquisa.md`](docs/pt-BR/Questoes_de_Pesquisa.md).

## Delineamento

Cada abordagem deve implementar os mesmos cinco cenários e ser submetida às mesmas cinquenta verificações. Requisitos, materiais, ambiente e critérios de conclusão devem permanecer equivalentes, exceto pela forma de desenvolvimento que define cada abordagem. Dados brutos, transformações, intervenções e desvios devem ser registrados com rastreabilidade.

Documentos metodológicos oficiais:

- [`Protocolo_Experimental.md`](docs/pt-BR/Protocolo_Experimental.md);
- [`Metodologia.md`](docs/pt-BR/Metodologia.md);
- [`Metricas.md`](docs/pt-BR/Metricas.md);
- [`Questoes_de_Pesquisa.md`](docs/pt-BR/Questoes_de_Pesquisa.md);
- [`Ameacas_a_Validade.md`](docs/pt-BR/Ameacas_a_Validade.md).

As traduções integrais para inglês serão produzidas somente após o congelamento do protocolo, conforme [`docs/en/README.md`](docs/en/README.md).

## Estrutura do repositório

```text
.
├── docs/
│   ├── pt-BR/                 # Documentação científica oficial
│   └── en/                    # Status das futuras traduções
├── prompts/                   # Regras e registros das três abordagens
├── manual/                    # Artefatos do desenvolvimento manual
├── github-copilot/            # Artefatos da abordagem GitHub Copilot
├── chatgpt/                   # Artefatos da abordagem ChatGPT
├── datasets/
│   ├── raw/                   # Registros originais imutáveis
│   └── processed/             # Transformações documentadas
├── results/                   # Tabelas, gráficos, relatórios e análises
├── EXPERIMENT_LOG.md          # Registro cronológico do experimento
├── REPRODUCIBILITY.md         # Instruções institucionais de reprodução
└── pom.xml                    # Configuração Maven com Java 21
```

## Prompts e idioma

Prompts, instruções, contexto, respostas e históricos devem permanecer no idioma exato utilizado durante o experimento. Esses registros não devem ser traduzidos ou reconstruídos posteriormente.

## Reprodutibilidade e dados

O procedimento de reprodução está em [`REPRODUCIBILITY.md`](REPRODUCIBILITY.md). Os dados brutos não devem ser sobrescritos, e toda transformação deve manter vínculo com sua origem. Nenhum conjunto de dados experimental foi publicado até o momento.

## Citação e DOI

Os metadados de citação estão em [`CITATION.cff`](CITATION.cff). **Nenhum DOI foi emitido para este repositório.** Um DOI somente poderá ser informado após sua emissão efetiva.

## Licença

O código-fonte e a documentação são disponibilizados sob a [`MIT License`](LICENSE). Materiais de terceiros e conjuntos de dados futuros poderão ter termos próprios, que deverão ser documentados.
