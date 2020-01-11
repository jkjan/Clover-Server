package com.jun.clover.controller

import com.jun.clover.service.CloverValidService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CloverValidController (private val cloverValidService: CloverValidService) {
    // 클로버 추가
    @PostMapping(path = ["/clover/{id}"])
    fun purchaseClover(@PathVariable(name = "id") id : String) {
        cloverValidService.purchaseClover(id)
    }
}