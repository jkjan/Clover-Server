package com.jun.clover.user

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
    @Column(name = "name")
    var name : String,

    // 연결된 앱 (카톡, 페북 등)
    val connApp : String,

    @Column(name = "email")
    val email : String
) {
    // 포인트
    @Column(name = "point")
    var point : Int = 0

    // 은행명
    @Column(name = "bank")
    var bank : String? = null

    // 계좌번호
    @Column(name = "acc")
    var acc : String? = null
}