package com.jun.clover.adls

import java.io.File
import javax.persistence.*

@Entity(name = "ad_ls")
class AdLs (
        val companyLs : String,
        var linkLs : String,
        var imgLs : File,
        var profitLs : Int) {
        @Id
        @Column(name = "ad_id_ls", insertable = false, updatable = false)
        val adIdLs : Int = 0

        @Column(name = "date_ls", insertable = false, updatable = false)
        lateinit var dateLs : String
}