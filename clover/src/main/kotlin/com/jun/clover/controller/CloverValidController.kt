package com.jun.clover.controller

import com.jun.clover.entity.CloverValid
import com.jun.clover.service.CloverValidService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CloverValidController (private val cloverValidService: CloverValidService) {
    // 클로버 추가
    @PostMapping(path = ["/clover/{id}"])
    fun purchaseClover(@PathVariable(name = "id") id : String) = cloverValidService.purchaseClover(id)

    // 오늘 구매된 클로버들
    @GetMapping(path = ["/clover/today"])
    fun getPurchasedCloverList() : List<CloverValid> = cloverValidService.getPurchasedCloverList()

    // 클로버 전체 삭제
    @DeleteMapping(path = ["/clover/today"])
    fun deleteTodayClover() = cloverValidService.deleteTodayClover()
}