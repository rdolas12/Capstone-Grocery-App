package com.gl.capstone.spring.boot.kotlin.course.api.repository

import com.gl.capstone.spring.boot.kotlin.course.api.entity.Category
import com.gl.capstone.spring.boot.kotlin.course.api.entity.Product
import com.gl.capstone.spring.boot.kotlin.course.api.entity.SubCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {
    fun findBySubCategory(subCategory: SubCategory): List<Product>
    fun findByCategory(category: Category): List<Product>
}