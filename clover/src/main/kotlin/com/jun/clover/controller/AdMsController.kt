package com.jun.clover.controller

import com.jun.clover.entity.AdMs
import com.jun.clover.service.AdMsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AdMsController (private val adMsService: AdMsService) {
    // 모든 광고
    @GetMapping(path = ["/ad/main/all"])
    fun getAllAdMs() : List<AdMs> = adMsService.getAllAdMs()

    // 광고 랜덤하게 하나
    @GetMapping(path = ["/ad/main"])
    fun getRandomAdMs() : AdMs = adMsService.getRandomAdMs()
}