package me.spring.starter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Lazy
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
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