package com.gl.capstone.spring.boot.kotlin.course.api.entity

import jakarta.persistence.*

@Entity
@Table(name = "category")
data class Category(
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY,
    )
    var id: Long? = null,
    var name: String? =null,
    var catDescription: String? = null,
    var catImage: String? = null,
    var position: Int? = null,
    var status: Boolean? = null
)
