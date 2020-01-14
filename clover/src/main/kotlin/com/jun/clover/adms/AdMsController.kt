package com.jun.clover.adms

import com.jun.clover.adls.AdLs
import com.jun.clover.adls.AdLsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AdMsController (private val adLsService: AdLsService) {
    // 모든 광고
    @GetMapping(path = ["/ad/main/all"])
    fun getAllAdMs() : List<AdLs> = adLsService.getAllAdLs()

    // 광고 랜덤하게 하나
    @GetMapping(path = ["/ad/main"])
    fun getRandomAdMs() : AdLs = adLsService.getRandomAdLs()
}