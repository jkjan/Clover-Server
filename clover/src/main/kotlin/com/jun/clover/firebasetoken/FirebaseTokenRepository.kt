package com.jun.clover.firebasetoken

import org.springframework.data.jpa.repository.JpaRepository

interface FirebaseTokenRepository : JpaRepository<FirebaseToken, String> {
}