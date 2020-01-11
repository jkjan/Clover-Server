package com.jun.clover.service

import com.jun.clover.entity.CloverValid
import com.jun.clover.repository.CloverValidRepository
import org.springframework.stereotype.Service
import java.sql.Time

@Service
class CloverValidService (private val cloverValidRepository: CloverValidRepository) {
    // 사용자가 클로버를 구매
    fun purchaseClover(id : String) {
        cloverValidRepository.save(CloverValid(id))
    }

    // 현재 구매된 클로버 리스트
    fun getPurchasedCloverList() : List<CloverValid> = cloverValidRepository.findAll()

    // 클로버 전체 삭제 (추첨 완료 시)
    fun deleteTodayClover() = cloverValidRepository.deleteAll()
}