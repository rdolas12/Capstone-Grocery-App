package com.gl.capstone.spring.boot.kotlin.course.api.repository

import com.gl.capstone.spring.boot.kotlin.course.api.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category, Long> {
}