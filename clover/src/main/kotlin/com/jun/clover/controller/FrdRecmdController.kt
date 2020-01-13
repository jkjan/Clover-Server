package com.jun.clover.controller

import com.jun.clover.service.FrdRecmdService
import com.sun.istack.NotNull
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class FrdRecmdController (private val frdRecmdService : FrdRecmdService) {
    // 친구 추천
    @PostMapping(path = ["/recommend"])
    fun createFrdRecmd(idRecmder : String) {
        frdRecmdService.createFrdRecmd(idRecmder)
    }

    // 추천인 코드 적용
    @PatchMapping(path = ["/recommend"])
    fun matchRecmderByCode(@Valid @NotNull @RequestBody recmdCode : String, idRecmdee: String) {
        frdRecmdService.matchRecmderByCode(recmdCode, idRecmdee)
    }

    // 내가 추천한 친구들
    @GetMapping(path = ["/recommend/{id_recmder}"])
    fun getRecmdeeList(@PathVariable(name = "id_recmder") idRecmder: String)
            = frdRecmdService.getRecmdeeList(idRecmder)

    // 전체 추천인 코드 목록
    @GetMapping(path = ["/recommend"])
    fun getAllRecmdList() = frdRecmdService.getAllRecmdList()
}