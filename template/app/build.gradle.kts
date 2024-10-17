plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.allopen") version "2.0.21"

    // The following line allows to load io.gatling.gradle plugin and directly apply it
    id("io.gatling.gradle") version "3.12.0.3"
}

dependencies {
    testImplementation("io.gatling.highcharts:gatling-charts-highcharts:3.9.5")
}

repositories {
    mavenCentral()
}
