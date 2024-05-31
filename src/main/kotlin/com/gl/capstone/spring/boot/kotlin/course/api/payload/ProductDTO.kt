package com.gl.capstone.spring.boot.kotlin.course.api.payload

data class ProductDTO(
    val id: Long?,
    val name: String?,
    val catDescription: String?,
    val catImage: String?,
    val position: Int?,
    val status: Boolean?,
    val catId: Long?,
    val subCatId: Long?
)
