package com.jun.clover.firebasetoken

import org.springframework.stereotype.Service

@Service
class FirebaseTokenService (private val firebaseTokenRepository: FirebaseTokenRepository) {
    fun addToken(token : String) = firebaseTokenRepository.save(FirebaseToken(token))

    fun getToken() : List<FirebaseToken> {
        return firebaseTokenRepository.findAll()
    }
}