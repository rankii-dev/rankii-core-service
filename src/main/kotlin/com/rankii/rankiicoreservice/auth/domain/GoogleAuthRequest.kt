package com.rankii.rankiicoreservice.auth.domain

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author hyungro-lee
 * created on 2021-06-25
 */
@JsonInclude
data class GoogleAuthRequest(
    @param:JsonProperty("idToken") @get:JsonProperty("idToken") val idToken: String
)