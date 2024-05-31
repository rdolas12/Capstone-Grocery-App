package com.gl.capstone.spring.boot.kotlin.course.api.controller

import com.gl.capstone.spring.boot.kotlin.course.api.payload.CategoryDTO
import com.gl.capstone.spring.boot.kotlin.course.api.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/api/v1/category")
@RestController
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping
    fun getCategories(): ResponseEntity<List<CategoryDTO>> {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    fun getCategory(@PathVariable("id") catId: Long): ResponseEntity<CategoryDTO> {
        return ResponseEntity.ok(categoryService.findById(catId))
    }

    @PostMapping
    fun createCategory(@RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        return ResponseEntity.ok(categoryService.addCategory(categoryDTO))
    }

    @PutMapping
    fun updateCategory(@RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDTO))
    }

    @DeleteMapping("/{catId}")
    fun deleteCategory(@PathVariable("catId") id: Long): ResponseEntity<CategoryDTO> {
        categoryService.deleteById(id)
        return ResponseEntity.ok().build()
    }


}