package com.gl.capstone.spring.boot.kotlin.course.api.repository

import com.gl.capstone.spring.boot.kotlin.course.api.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<User, Long>{

    fun findByEmail(email: String): Optional<User>
    fun findByUsername(username: String): Optional<User>
    fun findByUsernameOrEmail(username: String, email: String): Optional<User>
}