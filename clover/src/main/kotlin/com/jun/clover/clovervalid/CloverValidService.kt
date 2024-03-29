package com.jun.clover.clovervalid

import com.jun.clover.cloverhistory.CloverHistoryRepository
import com.jun.clover.notification.NotificationService
import com.jun.clover.user.UserRepository
import com.jun.clover.variable.Price
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CloverValidService (private val cloverValidRepository: CloverValidRepository,
                          private val userRepository: UserRepository,
                          private val cloverHistoryRepository: CloverHistoryRepository,
                          private val notificationService: NotificationService) {
    // 사용자가 클로버를 구매
    @Transactional(rollbackFor = [Exception::class])
    fun purchaseClover(id : String) {
        userRepository.modifyPoint(id, -Price.CLOVER.get())  // 포인트 깎기
        cloverValidRepository.save(CloverValid(id))   // 클로버 추가
        cloverHistoryRepository.updatePrize()  // 당첨금 증가
        notificationService.update()
    }

    // 현재 구매된 클로버 리스트
    fun getPurchasedCloverList() : List<CloverValid> = cloverValidRepository.findAll()

    // 클로버 전체 삭제 (추첨 완료 시)
    fun deleteTodayClover() = cloverValidRepository.deleteAll()

    fun getPurchasedCloverListById(id : String) = cloverValidRepository.findCloverValidByPrcsrId(id)
}