package com.jun.clover.cloverhistory

import org.springframework.web.bind.annotation.*

@RestController
class CloverHistoryController (private val cloverHistoryService : CloverHistoryService) {
    @PostMapping(path = ["/history"])
    fun createCloverHistory() {
        cloverHistoryService.createCloverHistory()
    }

    // 전체 클로버 내역
    @GetMapping(path = ["/history/all"])
    fun getCloverHistory() : List<CloverHistory> = cloverHistoryService.getCloverHistory()

    // 오늘 회차 정보
    @GetMapping(path = ["/history/today"])
    fun getTodayClover() : CloverHistory = cloverHistoryService.getTodayClover()

    // 당첨
    @PatchMapping(path = ["/winner/{id_winner}"])
    fun weGotWinnerHere(@PathVariable(name = "id_winner") idWinner : String) {
        cloverHistoryService.weGotWinnerHere(idWinner)
    }
}