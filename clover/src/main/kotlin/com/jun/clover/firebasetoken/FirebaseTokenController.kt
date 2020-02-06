package com.jun.clover.firebasetoken

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FirebaseTokenController (private val firebaseTokenService: FirebaseTokenService){
    @PostMapping(path = ["/clover/firebase/token"])
    fun addToken(@RequestBody token : String) = firebaseTokenService.addToken(token)
}