package com.rankii.rankiicoreservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
class RankiiCoreServiceApplication

fun main(args: Array<String>) {
	runApplication<RankiiCoreServiceApplication>(*args)
}
