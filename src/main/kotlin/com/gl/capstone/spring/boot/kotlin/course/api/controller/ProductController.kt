package com.gl.capstone.spring.boot.kotlin.course.api.controller

import com.gl.capstone.spring.boot.kotlin.course.api.payload.ProductDTO
import com.gl.capstone.spring.boot.kotlin.course.api.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/products"])
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getProducts(): List<ProductDTO> {
        return productService.getAllProducts()
    }

    @GetMapping(value = ["/{productId}"])
    fun getProductById(@PathVariable("productId") productId: Long): ProductDTO {
        return productService.getProdctById(productId)
    }

    @GetMapping(value = ["/{subCategoryId}"])
    fun getProductsBySubCategoryId(@PathVariable("subCategoryId") subCategoryId: Long): List<ProductDTO> {
        return productService.getProductsBySubCategory(subCategoryId)
    }

    @GetMapping(value = ["/{categoryId}"])
    fun getProductsByCategoryId(@PathVariable("categoryId") categoryId: Long): List<ProductDTO> {
        return productService.getProductsByCategory(categoryId)
    }
}