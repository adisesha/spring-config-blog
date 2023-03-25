package me.spring.starter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Lazy
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class StarterApplication

fun main(args: Array<String>) {
	runApplication<StarterApplication>(*args)
}


@Lazy
@RestController
@RequestMapping("/hello")
class HelloController {
	init {
		// Pretend to do some work
	   Thread.sleep(3000)
	}
	@GetMapping
	fun hello() = "Hello, world!"
}