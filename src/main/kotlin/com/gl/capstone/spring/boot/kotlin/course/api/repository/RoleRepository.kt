package com.gl.capstone.spring.boot.kotlin.course.api.repository

import com.gl.capstone.spring.boot.kotlin.course.api.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long> {
}