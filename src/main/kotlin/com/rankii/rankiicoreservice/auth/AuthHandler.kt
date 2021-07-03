package com.rankii.rankiicoreservice.auth

import com.rankii.rankiicoreservice.auth.domain.GoogleAuthRequest
import com.rankii.rankiicoreservice.auth.domain.GoogleAuthResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

/**
 * @author hyungro-lee
 * created on 2021-06-22
 */
@Component
class AuthHandler(val authService: AuthService) {
    fun performGoogleAuth(request: ServerRequest) : Mono<ServerResponse> {
        return request
            .bodyToMono(GoogleAuthRequest::class.java)
            .map(GoogleAuthRequest::idToken)
            .flatMap(authService::verifyGoogleAuth)
            .flatMap { token -> ServerResponse.ok().bodyValue(GoogleAuthResponse(token.accessTokenHash)) }
    }
}
