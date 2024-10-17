plugins {
    kotlin("jvm") version "2.0.21"
    id("io.gatling.gradle") version "3.12.0.3"
}

repositories {
    mavenCentral()
}

dependencies {
    // Dependências do Gatling
    testImplementation("io.gatling.highcharts:gatling-charts-highcharts:3.9.5")

    // Dependências adicionais (se necessário)
}
