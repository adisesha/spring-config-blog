package me.spring.starter

import org.springframework.boot.actuate.availability.LivenessStateHealthIndicator
import org.springframework.boot.actuate.availability.ReadinessStateHealthIndicator
import org.springframework.boot.availability.ApplicationAvailabilityBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HealthConfig {
    @Bean
    fun applicationAvailabilityBean() = ApplicationAvailabilityBean()

    @Bean
    fun livenessStateHealthIndicator(applicationAvailabilityBean: ApplicationAvailabilityBean) =
        LivenessStateHealthIndicator(applicationAvailabilityBean)

    @Bean
    fun readinessStateHealthIndicator(applicationAvailabilityBean: ApplicationAvailabilityBean) =
        ReadinessStateHealthIndicator(applicationAvailabilityBean)

}
