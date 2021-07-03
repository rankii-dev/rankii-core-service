package com.rankii.rankiicoreservice.auth.domain

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author hyungro-lee
 * created on 2021-06-24
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class GoogleAuthResponse (
    @param:JsonProperty("idHash") @get:JsonProperty("idHash") val idHash: String
)
