package com.jun.clover.frdrecmd

import com.jun.clover.frdrecmd.FrdRecmd
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FrdRecmdRepository : JpaRepository<FrdRecmd, String> {
    fun findFrdRecmdsByIdRecmder(idRecmder : String) : List<FrdRecmd>
}