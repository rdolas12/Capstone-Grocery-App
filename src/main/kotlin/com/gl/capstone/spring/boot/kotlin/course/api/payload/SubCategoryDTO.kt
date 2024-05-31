package com.gl.capstone.spring.boot.kotlin.course.api.payload

data class SubCategoryDTO(
    val id: Long?,
    val name: String?,
    val catDescription: String?,
    val position: Int?,
    val status: Boolean?,
    val catId: Long?
)
