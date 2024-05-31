package com.gl.capstone.spring.boot.kotlin.course.api.controller

import com.gl.capstone.spring.boot.kotlin.course.api.payload.SubCategoryDTO
import com.gl.capstone.spring.boot.kotlin.course.api.service.SubCategoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/subcategory")
class SubCategoryController(
    private val subCategoryService: SubCategoryService
) {

    @GetMapping
    fun getSubCategoryList(): List<SubCategoryDTO> {
        return subCategoryService.getAllSubCategories()
    }

    @GetMapping("/{id}")
    fun getSubCategory(@PathVariable("id") subCategoryId: Long): SubCategoryDTO {
        return subCategoryService.getSubCategory(subCategoryId)
    }

    @GetMapping("/{catId}")
    fun getSubCategoryByCatId(@PathVariable("catId") categoryId: Long): List<SubCategoryDTO> {
        return subCategoryService.getSubCategoriesByCatId(categoryId)
    }

    @PostMapping
    fun addSubCategory(@RequestBody subCategoryDTO: SubCategoryDTO): SubCategoryDTO {
        return subCategoryService.addSubCategory(subCategoryDTO)
    }

    @PutMapping("/{subCategoryId}")
    fun updateSubCategory(@PathVariable("subCategoryId") subCategoryId: Long, @RequestBody subCategoryDTO: SubCategoryDTO) {
        return subCategoryService.updateSubCategory(subCategoryId, subCategoryDTO)
    }

}