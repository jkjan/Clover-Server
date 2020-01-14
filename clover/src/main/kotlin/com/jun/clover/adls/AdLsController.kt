package com.jun.clover.adls

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AdLsController (private val adLsService: AdLsService) {
    // 모든 광고
    @GetMapping(path = ["/ad/lockscreen/all"])
    fun getAllAdLs() : List<AdLs> = adLsService.getAllAdLs()

    // 광고 랜덤하게 하나
    @GetMapping(path = ["/ad/lockscreen"])
    fun getRandomAdLs() : AdLs = adLsService.getRandomAdLs()
}