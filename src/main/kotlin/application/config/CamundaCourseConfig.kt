package application.config

import application.common.JacksonExtension
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class CamundaCourseConfig {

    @Bean
    open fun objectMapper(): ObjectMapper {
        return JacksonExtension.jacksonObjectMapper
    }

}