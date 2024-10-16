package com.exploringkotlincoroutines

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExploringKotlinCoroutinesApplication

fun main(args: Array<String>) {
	runApplication<ExploringKotlinCoroutinesApplication>(*args)
}
