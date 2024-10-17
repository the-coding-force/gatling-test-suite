plugins {
    // Aplica o plugin foojay-resolver para permitir download automático de JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "gatling-test-suite"

// Inclua todos os módulos de forma explícita
include("exploring-kotlin-coroutines")
include("template")
