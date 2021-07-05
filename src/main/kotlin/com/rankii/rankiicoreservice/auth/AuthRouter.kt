package com.rankii.rankiicoreservice.auth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

/**
 * @author hyungro-lee
 * created on 2021-06-22
 */
@Configuration
class AuthRouter {
    @Bean
    fun route(authHandler: AuthHandler) = router {
        accept(MediaType.APPLICATION_JSON).nest {
            "auth".nest {
                POST("/google", authHandler::performGoogleAuth)
            }
        }
    }
}