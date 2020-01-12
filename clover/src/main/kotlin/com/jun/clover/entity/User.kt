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

    // 은행명
    var bank : String,

    // 예금주 (실명)
    var name : String,

    // 포인트
    var point : Int,

    // 연결된 앱 (카톡, 페북 등)
    val connApp : String,

    // 가입일
    val registerDate : String
)