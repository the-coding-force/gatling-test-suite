# Gatling Test Suite - Multi-módulo

Este repositório é organizado como um projeto multi-módulo no qual cada módulo representa uma suíte de testes de carga e performance usando Gatling para diferentes repositórios da nossa organização. Cada módulo é configurado individualmente, permitindo a execução de testes personalizados para cada projeto.

## Estrutura do Repositório

```
gatling-test-suite/
├── project-a/
│   ├── src/gatling/kotlin
│   ├────── simulations/
│   └── build.gradle
├── project-b/
│   ├── src/gatling/kotlin
│   ├────── simulations/
│   └── build.gradle
├── template/
│   ├── src/src/gatling/kotlin
│   ├────── simulations/
│   └── build.gradle
├── README.md
├── build.gradle
├── settings.gradle

```

- **Módulos**: Cada diretório (por exemplo, `project-a`, `project-b`) representa um módulo separado com suas próprias simulações e configurações de teste Gatling.
- **Módulo de Template**: A pasta `template/` serve como um modelo para a criação de novos módulos. Quando for criar um novo módulo, copie os itens deste diretório e personalize conforme necessário.

## Adicionando um Novo Módulo de Testes

### Criar um Novo Módulo

1. No IntelliJ IDEA, adicione um novo módulo ao projeto multi-módulo. Nomeie o módulo conforme o repositório correspondente (por exemplo, `project-c`).
2. Copie a estrutura e arquivos do diretório `template/` para o novo módulo.
3. **Adicione o novo módulo no `includes` do arquivo `settings.gradle.kts` na raiz do projeto para funcionar.**

### Configurar Simulações e Dependências

1. Adicione uma pasta `simulations/` para armazenar os scripts de simulação do Gatling.
2. Inclua um `build.gradle` com as dependências do Gatling.

## Executando Testes

Os testes são executados via terminal no módulo desejado, utilizando o seguinte comando:

```bash
./gradlew gatlingRun

```
## Acessando os Relatórios

Após a execução dos testes, você pode acessar os relatórios gerados `em app/reports/gatling`. 

Para visualizar os relatórios, abra o arquivo `index.html` no seu navegador:

![relatory-example.png](relatory-example.png)
