package com.jun.clover.service

import com.jun.clover.entity.FrdRecmd
import com.jun.clover.repository.FrdRecmdRepository
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class FrdRecmdService (private val frdRecmdRepository: FrdRecmdRepository) {
    // 추천인 코드로 추천인 매칭
    fun matchRecmderByCode(recmdCode : String, idRecmdee: String) : String? {
        val idRecmder: String?
        try {
            idRecmder = frdRecmdRepository.findById(recmdCode).get().idRecmder
        } catch (e : NoSuchElementException) {
            e.printStackTrace()
            return null
        }

        // 매칭 성공
        val matchSucceeded = FrdRecmd(recmdCode, idRecmder)
        matchSucceeded.idRecmdee = idRecmdee
        frdRecmdRepository.save(matchSucceeded)

        return idRecmder
    }

    // 추천인 코드 생성
    fun createFrdRecmd(idRecmder : String) : String {
        // 6자리 랜덤 알파벳 대문자 생성
        val seed = ('A'..'Z').toList().toTypedArray()
        var recmdCode = (1..6).map { seed.random() }.joinToString("")
        // 생성된 코드로 찾았을 때 유효하지 않으면 생성 반복
        while (frdRecmdRepository.findById(recmdCode).isPresent) {
            recmdCode = (1..6).map { seed.random() }.joinToString("")
        }
        frdRecmdRepository.save(FrdRecmd(recmdCode, idRecmder))
        return recmdCode
    }

    // 내가 추천한 사람 목록
    fun getRecmdeeList(idRecmder: String) : List<FrdRecmd>
            = frdRecmdRepository.findFrdRecmdsByIdRecmder(idRecmder)

    // 전체 추천 목록
    fun getAllRecmdList() : List<FrdRecmd> = frdRecmdRepository.findAll()
}