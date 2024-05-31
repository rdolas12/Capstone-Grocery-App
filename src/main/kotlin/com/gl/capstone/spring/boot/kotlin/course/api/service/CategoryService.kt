package com.gl.capstone.spring.boot.kotlin.course.api.service

import com.gl.capstone.spring.boot.kotlin.course.api.entity.Category
import com.gl.capstone.spring.boot.kotlin.course.api.payload.CategoryDTO
import com.gl.capstone.spring.boot.kotlin.course.api.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    fun addCategory(categoryDTO: CategoryDTO): CategoryDTO {
        val categoryEntity = categoryRepository.save(Category(null, categoryDTO.name, categoryDTO.catDescription, categoryDTO.catImage, categoryDTO.position, categoryDTO.status))
        return CategoryDTO(categoryEntity.id, categoryEntity.name, categoryEntity.catDescription, categoryEntity.catImage, categoryEntity.position, categoryEntity.status)
    }

    fun updateCategory(categoryDTO: CategoryDTO): CategoryDTO {
        val categoryEntity = categoryRepository.findById(categoryDTO.id!!)
        return if (categoryEntity.isPresent) {
            categoryEntity.get()
                .let {
                    it.name = categoryDTO.name
                    it.catDescription = categoryDTO.catDescription
                    it.catImage = categoryDTO.catImage
                    it.position = categoryDTO.position
                    it.status = categoryDTO.status
                    categoryRepository.save(it)
                    CategoryDTO(it.id, it.name, it.catDescription, it.catImage, it.position, it.status)
                }
        } else {
            throw RuntimeException("no course found")
        }
    }

    fun findAll(): List<CategoryDTO> {
        val categories = categoryRepository.findAll()
        return categories.map {
            CategoryDTO(it.id, it.name, it.catDescription, it.catImage, it.position, it.status)
        }
    }

    fun findById(id: Long): CategoryDTO {
        val category = categoryRepository.findById(id)
        return if (category.isPresent) {
            category.get().let { CategoryDTO(it.id, it.name, it.catDescription, it.catImage, it.position, it.status) }
        } else {
            throw RuntimeException("no category found")
        }
    }

    fun deleteById(id: Long) {
        val category = categoryRepository.findById(id)
        if (category.isPresent) {
            category.get().let { categoryRepository.delete(it) }
        } else {
            throw RuntimeException("no category found")
        }
    }
}