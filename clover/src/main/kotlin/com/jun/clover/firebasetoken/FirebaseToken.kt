package com.jun.clover.firebasetoken

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity (name = "firebase_token")
class FirebaseToken (@Id
                    @Column(name = "token")
                     val token : String)