package com.jun.clover.user

import com.jun.clover.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface UserRepository : JpaRepository<User, String> {
    @Transactional
    @Modifying
    @Query("update user as u set u.point = u.point + ?2 where u.id = ?1")
    // 포인트 추가/감소
    fun modifyPoint(id : String, add : Int) : Int
}