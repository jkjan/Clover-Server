package com.jun.clover.service

import com.jun.clover.entity.AdMs
import com.jun.clover.repository.AdMsRepository
import org.springframework.stereotype.Service

@Service
class AdMsService (private val adMsRepository: AdMsRepository) {
    fun getAllAdMs() : List<AdMs> = adMsRepository.findAll()
}