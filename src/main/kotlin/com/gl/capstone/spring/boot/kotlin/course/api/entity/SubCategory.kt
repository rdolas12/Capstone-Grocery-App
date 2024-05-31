package com.gl.capstone.spring.boot.kotlin.course.api.entity

import jakarta.persistence.*

@Entity
@Table(name = "sub_category")
data class SubCategory (
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY,
    )
    var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category? = null,
    var position: Int? = null,
    var status: Boolean? = null
)