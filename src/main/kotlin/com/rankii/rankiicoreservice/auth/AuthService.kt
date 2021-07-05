package com.rankii.rankiicoreservice.auth

import com.google.api.client.auth.openidconnect.IdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * @author hyungro-lee
 * created on 2021-06-25
 */
@Service
class AuthService(@Value("\${rankii.oauth.google.client-id}") val clientId: String) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun verifyGoogleAuth(idTokenString: String) : Mono<IdToken.Payload> {
        return Mono.fromCallable {
            logger.info(idTokenString)
            val googleIdTokenVerifier = GoogleIdTokenVerifier.Builder(NetHttpTransport(), GsonFactory())
                .setAudience(listOf(clientId))
                .build()
            val idToken: GoogleIdToken = googleIdTokenVerifier.verify(idTokenString)
            idToken.payload
        }
    }
}