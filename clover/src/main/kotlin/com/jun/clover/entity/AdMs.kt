package com.jun.clover.entity

import java.io.File
import javax.persistence.*

@Entity(name = "ad_ms")
class AdMs (
        val companyMs : String,
        var linkMs : String,
        var imgMs : File,
        var profitMs : Int) {
        @Id
        @Column(name = "ad_id_ms", insertable = false, updatable = false)
        val adIdMs : Int = 0

        @Column(name = "date_ms", insertable = false, updatable = false)
        lateinit var dateMs : String
}