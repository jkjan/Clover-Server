package com.jun.clover.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "frd_recmd")
class FrdRecmd (
       @Id
       @Column(name = "recmd_code", insertable=false, updatable=false)
       // 추천인 코드
       val recmdCode : String,

       // 추천인 아이디
       val idRecmder : String,

       // 피추천인 아이디
       val idRecmdee : String?,

       // 추천 날짜
       val dateRecmd : String
)