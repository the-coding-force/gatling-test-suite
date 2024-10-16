# Gatling Test Suite

Este repositório contém a suíte de testes de carga e performance usando Gatling para os projetos da nossa organização. Cada projeto é configurado individualmente dentro deste repositório, e este arquivo fornece diretrizes para adicionar, organizar e executar testes para cada um deles.

## Estrutura do Repositório

A estrutura do repositório é organizada da seguinte forma:

```
├── project-a/
│   ├── simulations/
│   ├── resources/
│   ├── gatling.conf
│   └── build.gradle
├── project-b/
│   ├── simulations/
│   ├── resources/
│   ├── gatling.conf
│   └── build.gradle
├── global-resources/
│   └── gatling.conf
├── setup.sh
├── run_tests.sh
├── README.md
└── .github/workflows/gatling-tests.yml

```

- Cada projeto possui seu próprio diretório (`project-a`, `project-b`, etc.) contendo as simulações e configurações específicas.
- O diretório `global-resources/` contém configurações globais do Gatling que podem ser compartilhadas entre todos os projetos.
- O script `setup.sh` prepara o ambiente, e `run_tests.sh` executa os testes para um ou mais projetos.

## Adicionando um Novo Projeto

1. **Criar um Diretório do Projeto**:
   - Crie um novo diretório com o nome do projeto, por exemplo, `project-c/`.
   
2. **Adicionar Simulações e Configurações**:
   - Dentro do novo diretório, crie uma pasta `simulations/` para armazenar os testes Gatling.
   - Inclua um arquivo `build.gradle` ou `pom.xml` com as dependências necessárias.
   - Adicione um arquivo `gatling.conf` específico do projeto, se necessário, ou utilize o que está em `global-resources/`.

3. **Configurar o Script de Execução**:
   - Certifique-se de que o `run_tests.sh` funcione para o novo projeto. Você pode fazer isso testando localmente:
     ```bash
     ./run_tests.sh project-c
     ```

## Executando Testes

Para executar todos os testes:

```bash
./run_tests.sh all
