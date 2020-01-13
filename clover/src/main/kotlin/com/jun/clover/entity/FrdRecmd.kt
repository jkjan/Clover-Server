package com.jun.clover.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "frd_recmd")
class FrdRecmd (@Id
                @Column(name = "recmd_code")
                // 추천인 코드
                val recmdCode: String,

                // 추천인 아이디
                @Column(name = "id_recmder")
                val idRecmder: String
                ) {
       // 피추천인 아이디
       var idRecmdee: String? = null

        @Column(name = "id_recmder", updatable = false, insertable = false)
       // 추천 날짜
       lateinit var dateRecmd: String
}