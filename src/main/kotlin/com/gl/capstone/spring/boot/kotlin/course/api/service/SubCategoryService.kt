package com.gl.capstone.spring.boot.kotlin.course.api.service

import com.gl.capstone.spring.boot.kotlin.course.api.entity.Category
import com.gl.capstone.spring.boot.kotlin.course.api.entity.SubCategory
import com.gl.capstone.spring.boot.kotlin.course.api.payload.SubCategoryDTO
import com.gl.capstone.spring.boot.kotlin.course.api.repository.SubCategoryRepository
import org.springframework.stereotype.Service

@Service
class SubCategoryService(
    private val subCategoryRepository: SubCategoryRepository
) {

    fun getAllSubCategories(): List<SubCategoryDTO> {
        val subCategories = subCategoryRepository.findAll()
        return subCategories.map {
            SubCategoryDTO(it.id, it.name, it.description, it.position, it.status, it.category?.id)
        }
    }

    fun getSubCategory(subCategoryId: Long): SubCategoryDTO {
        val subCategory = subCategoryRepository.findById(subCategoryId)
        return if (subCategory.isPresent) {
            subCategory.get().let { SubCategoryDTO(it.id, it.name, it.description, it.position, it.status, it.category?.id)}
        } else {
            throw RuntimeException("Sub Category Not Found")
        }
    }

    fun getSubCategoriesByCatId(categoryId: Long): List<SubCategoryDTO> {
        val categoryList = subCategoryRepository.findByCategory(Category(categoryId))
        return categoryList.map {
            SubCategoryDTO(it.id, it.name, it.description, it.position, it.status, it.category?.id)
        }
    }

    fun addSubCategory(subCategoryDTO: SubCategoryDTO): SubCategoryDTO {
        val subCategory = subCategoryRepository.save(SubCategory(null, subCategoryDTO.name, subCategoryDTO.catDescription, Category(subCategoryDTO.catId), subCategoryDTO.position, subCategoryDTO.status))
        return subCategory.let {  SubCategoryDTO(it.id, it.name, it.description, it.position, it.status, it.category?.id)}
    }

    fun updateSubCategory(subCategoryId: Long, subCategoryDTO: SubCategoryDTO) {
        var subCategory = subCategoryRepository.findById(subCategoryId)
        return if (subCategory.isPresent) {
            subCategory.get().let {
                it.name = subCategoryDTO.name
                it.category = Category(subCategoryDTO.catId)
                it.description = subCategoryDTO.catDescription
                it.position = subCategoryDTO.position
            }
        } else {
            throw RuntimeException("Sub Category Not Found")
        }
    }

    fun deleteSubCategory(subCategoryId: Long) {
        var subCategory = subCategoryRepository.findById(subCategoryId)
        if (subCategory.isPresent) {
            subCategory.get().let {subCategoryRepository.deleteById(subCategoryId)}
        } else {
            throw RuntimeException("Sub Category Not Found")
        }
    }


}