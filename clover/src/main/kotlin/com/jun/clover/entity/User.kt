package com.jun.clover.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "user")
class User (
    @Id
    @Column(name = "id", insertable=false, updatable=false)
    // (카톡, 페북으로 전달받은) 아이디
    val id : String,

    // 예금주 (실명)
    var name : String,

    // 연결된 앱 (카톡, 페북 등)
    val connApp : String
) {
    // 포인트
    var point : Int = 0

    @Column(name = "register_date", insertable=false, updatable=false)
    // 가입일
    lateinit var registerDate : String

    // 은행명
    var bank : String? = null

    // 계좌번호
    var acc : String? = null
}