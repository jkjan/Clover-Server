package com.jun.clover.repository

import com.jun.clover.entity.FrdRecmd
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FrdRecmdRepository : JpaRepository<FrdRecmd, String> {
    fun findFrdRecmdsByIdRecmder(idRecmder : String) : List<FrdRecmd>
}