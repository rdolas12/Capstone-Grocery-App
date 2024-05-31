package com.gl.capstone.spring.boot.kotlin.course.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CapstoneRestApi

fun main(args: Array<String>) {
	runApplication<CapstoneRestApi>(*args)
}
