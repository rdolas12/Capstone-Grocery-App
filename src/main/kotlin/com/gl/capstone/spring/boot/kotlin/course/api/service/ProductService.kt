package com.gl.capstone.spring.boot.kotlin.course.api.service

import com.gl.capstone.spring.boot.kotlin.course.api.entity.Category
import com.gl.capstone.spring.boot.kotlin.course.api.entity.Product
import com.gl.capstone.spring.boot.kotlin.course.api.entity.SubCategory
import com.gl.capstone.spring.boot.kotlin.course.api.payload.ProductDTO
import com.gl.capstone.spring.boot.kotlin.course.api.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun getProdctById(productId: Long): ProductDTO {
        var productEntity = productRepository.findById(productId)
        return if (productEntity.isPresent) {
            productEntity.get().let {
                ProductDTO(it.id, it.name, it.description, it.imageUrl, it.position, it.status, it.category?.id, it.subCategory?.id)
            }
        } else {
            throw RuntimeException("Product not found")
        }
    }

    fun getAllProducts(): List<ProductDTO> {
        var products = productRepository.findAll()
       return products.map {  ProductDTO(it.id, it.name, it.description, it.imageUrl, it.position, it.status, it.category?.id, it.subCategory?.id) }
    }

    fun getProductsBySubCategory(subCategoryId: Long): List<ProductDTO> {
        var products = productRepository.findBySubCategory(SubCategory(subCategoryId))
        return products.map {  ProductDTO(it.id, it.name, it.description, it.imageUrl, it.position, it.status, it.category?.id, it.subCategory?.id) }
    }

    fun getProductsByCategory(categoryId: Long): List<ProductDTO> {
        var products = productRepository.findByCategory(Category(categoryId))
        return products.map {  ProductDTO(it.id, it.name, it.description, it.imageUrl, it.position, it.status, it.category?.id, it.subCategory?.id) }
    }


}