package application.common

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

object JacksonExtension {

    val jacksonObjectMapper: ObjectMapper by lazy {
        ObjectMapper().registerModule(KotlinModule())
            .also { it.registerModule(SimpleModule()) }
            .also { it.registerModule(JavaTimeModule()) }
            .also { it.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false) }
            .also { it.configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, true) }
            .also { it.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) }
            .also { it.setSerializationInclusion(JsonInclude.Include.NON_NULL) }
            .also { it.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE) }
            .also { it.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true) }
    }

}