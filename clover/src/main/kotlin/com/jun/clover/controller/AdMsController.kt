package com.jun.clover.controller

import com.jun.clover.entity.AdMs
import com.jun.clover.service.AdMsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AdMsController (private val adMsService: AdMsService) {
    @GetMapping(path = ["/ad/main"])
    fun getAllAdMs() : List<AdMs> = adMsService.getAllAdMs()
}