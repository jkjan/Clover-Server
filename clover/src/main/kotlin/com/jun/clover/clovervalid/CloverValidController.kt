package com.jun.clover.clovervalid

import org.springframework.web.bind.annotation.*

@RestController
class CloverValidController (private val cloverValidService: CloverValidService) {
    // 사용자가 클로버를 구매
    @PostMapping(path = ["/clover/{id}"])
    fun purchaseClover(@PathVariable(name = "id") id : String) = cloverValidService.purchaseClover(id)

    // 오늘 구매된 클로버들
    @GetMapping(path = ["/clover/today"])
    fun getPurchasedCloverList() : List<CloverValid> = cloverValidService.getPurchasedCloverList()

    // 클로버 전체 삭제
    @DeleteMapping(path = ["/clover/today"])
    fun deleteTodayClover() = cloverValidService.deleteTodayClover()
}