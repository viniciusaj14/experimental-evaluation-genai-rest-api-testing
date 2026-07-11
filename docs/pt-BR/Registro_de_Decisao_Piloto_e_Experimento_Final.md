# Registro de Decisão — Piloto e Experimento Final

## Decisão

Separar formalmente:

1. o **estudo piloto preliminar concluído**, realizado com uma API pública de dados abertos do domínio veicular não identificada nos registros preservados;
2. o **piloto de viabilidade Petstore proposto**, destinado apenas a validar ambiente e contrato;
3. o **experimento final Petstore futuro**, ainda não executado.

## Por que os resultados preliminares são classificados como piloto

O documento histórico confirma abordagens, cenários e métricas, mas não preserva o nome oficial, URL, contrato ou endpoints exatos da API veicular. Também faltam artefatos-fonte necessários para reprodução integral. Essas lacunas impedem tratar os resultados como execução do novo protocolo Petstore.

## Por que a Swagger Petstore foi selecionada

A Swagger Petstore oferece contrato OpenAPI oficial que pode ser preservado por checksum, operações REST variadas e suporte ao planejamento explícito de cenários e oráculos. A seleção busca melhorar rastreabilidade e reprodutibilidade no experimento final. Ela não altera a identidade histórica da API usada no piloto.

## Por que o experimento final deve ser reexecutado

Swagger Petstore, endpoints, payloads e checks diferem do domínio veicular registrado no piloto. A comparação final somente será metodologicamente válida se as três abordagens executarem novamente o mesmo protocolo Petstore após congelamento de ambiente, cenários, validações e métricas.

## Proibições

- não mapear retroativamente marcas, modelos, ano/modelo, detalhes ou parâmetro inválido para operações Petstore;
- não atribuir à API histórica nome, provedor, URL, contrato ou endpoint não preservado;
- não reutilizar valores do piloto como resultados do experimento final;
- não combinar numericamente métricas do piloto e do experimento final;
- não descrever o futuro protocolo Petstore como já executado.

## Separação de dados

Artefatos devem permanecer em árvores independentes:

```text
datasets/
├── pilot/
│   ├── raw/
│   └── processed/
└── final-experiment/
    ├── raw/
    └── processed/
```

O piloto de viabilidade Petstore também deve ser identificado como piloto e não pode alimentar os valores do experimento final. Caso seus registros venham a ser publicados, sua localização específica deverá ser definida antes da publicação sem misturá-los aos dados finais.

## Decisões ainda pendentes para o experimento final

- ambiente Petstore público ou controlado, com recomendação atual pela instância controlada;
- congelamento dos cinco cenários e cinquenta checks;
- oráculos negativos e autenticação efetiva;
- definição final das rubricas;
- aprovação formal das fórmulas que serão mantidas ou alteradas em relação ao piloto.
