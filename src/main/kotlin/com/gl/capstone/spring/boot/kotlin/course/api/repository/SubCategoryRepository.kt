package com.gl.capstone.spring.boot.kotlin.course.api.repository

import com.gl.capstone.spring.boot.kotlin.course.api.entity.Category
import com.gl.capstone.spring.boot.kotlin.course.api.entity.SubCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubCategoryRepository: JpaRepository<SubCategory, Long> {
    fun findByCategory(category: Category): List<SubCategory>
}