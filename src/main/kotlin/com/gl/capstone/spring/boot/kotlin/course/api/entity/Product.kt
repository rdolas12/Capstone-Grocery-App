package com.gl.capstone.spring.boot.kotlin.course.api.entity

import jakarta.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY,
    )
    var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category? = null,
    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    var subCategory: SubCategory? = null,
    var position: Int? = null,
    var status: Boolean? = null
)