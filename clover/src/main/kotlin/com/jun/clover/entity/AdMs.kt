package com.jun.clover.entity

import java.io.File
import javax.persistence.*

@Entity
class AdMs (
        @Id
        @Column(name = "ad_id_ms", insertable=false, updatable=false)
        val adIdMs : Int,
        val companyMs : String,
        var linkMs : String,
        var dateMs : String,
        var imgMs : File,
        var profitMs : Int
        )