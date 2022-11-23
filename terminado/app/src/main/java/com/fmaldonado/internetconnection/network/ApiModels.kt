package com.fmaldonado.internetconnection.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiModel(
    val id:String,
    @SerialName("img_src")
    val imgSrc:String
)