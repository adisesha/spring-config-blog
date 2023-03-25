package me.spring.starter

import org.springframework.boot.actuate.availability.LivenessStateHealthIndicator
import org.springframework.boot.actuate.availability.ReadinessStateHealthIndicator
import org.springframework.boot.actuate.health.Health
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthController(
    private val livenessStateHealthIndicator: LivenessStateHealthIndicator,
    private val readinessStateHealthIndicator: ReadinessStateHealthIndicator
) {
    @GetMapping
    fun health() = mapOf(
        "liveness" to livenessStateHealthIndicator.health().status.code,
        "readiness" to readinessStateHealthIndicator.health().status.code
    )

    @GetMapping("/liveness")
    fun liveness():Health = livenessStateHealthIndicator.health()

    @GetMapping("/readiness")
    fun readiness(): Health = readinessStateHealthIndicator.health()
}
