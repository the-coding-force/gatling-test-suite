# Gatling Test Suite - Multi-módulo

Este repositório é organizado como um projeto multi-módulo no qual cada módulo representa uma suíte de testes de carga e performance usando Gatling para diferentes repositórios da nossa organização. Cada módulo é configurado individualmente, permitindo a execução de testes personalizados para cada projeto.

## Estrutura do Repositório

```
gatling-test-suite/
├── project-a/
│   ├── src/
│   ├── simulations/
│   ├── resources/
│   └── build.gradle
├── project-b/
│   ├── src/
│   ├── simulations/
│   ├── resources/
│   └── build.gradle
├── global-resources/
│   └── gatling.conf
├── setup.sh
├── run_tests.sh
├── README.md
└── .github/
    └── workflows/
        └── gatling-tests.yml


```


- **Módulos**: Cada diretório (por exemplo, `project-a`, `project-b`) representa um módulo separado com suas próprias simulações e configurações de teste Gatling.
- **Configurações Globais**: A pasta `global-resources/` contém configurações do Gatling compartilhadas entre todos os módulos.
- **Scripts de Automação**: `setup.sh` prepara o ambiente para os testes, enquanto `run_tests.sh` permite a execução de testes de forma modular.

## Adicionando um Novo Módulo de Testes

1. **Criar um Novo Módulo**:
   - No IntelliJ IDEA, adicione um novo módulo ao projeto multi-módulo. Nomeie o módulo conforme o repositório correspondente (por exemplo, `project-c`).

2. **Configurar Simulações e Dependências**:
   - Adicione uma pasta `simulations/` para armazenar os scripts de simulação do Gatling.
   - Inclua um `build.gradle` com as dependências do Gatling.
   - Se necessário, crie um `gatling.conf` específico no módulo, ou utilize as configurações de `global-resources/`.

## Executando Testes

Para executar todos os módulos:

```bash
./run_tests.sh all
