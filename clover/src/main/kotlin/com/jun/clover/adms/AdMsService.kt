package com.jun.clover.adms

import com.jun.clover.adls.AdLs
import com.jun.clover.adls.AdLsRepository
import org.springframework.stereotype.Service

@Service
class AdMsService (private val adLsRepository: AdLsRepository) {
    fun getAllAdMs() : List<AdLs> = adLsRepository.findAll()

    fun getRandomAdMs() : AdLs = adLsRepository.findRandomAdLs()
}