package com.alphaomardiallo.alphaportfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val imageSrc: String,
    val imageAlt: String,
    val description: String,
    val link: String
)
