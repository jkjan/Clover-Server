package com.jun.clover.adls

import org.springframework.stereotype.Service

@Service
class AdLsService (private val adLsRepository: AdLsRepository) {
    fun getAllAdLs() : List<AdLs> = adLsRepository.findAll()

    fun getRandomAdLs() : AdLs = adLsRepository.findRandomAdLs()
}