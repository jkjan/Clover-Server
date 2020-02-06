package com.jun.clover.notification

import com.google.firebase.internal.FirebaseService
import com.jun.clover.firebasetoken.FirebaseTokenService
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

@RestController
class NotificationController (private val notificationService: NotificationService,
                              private val firebaseTokenService: FirebaseTokenService) {
    @GetMapping(value = ["/send"], produces = ["application/json"])
    @ResponseBody
    fun send() : ResponseEntity<String> {
        val notifications = PushPeriodicNotifications().periodicNotificationJson(firebaseTokenService.getToken())
        val request = HttpEntity<String>(notifications)
        val pushNotification = notificationService.send(request)
        CompletableFuture.allOf(pushNotification).join()

        try {
            val firebaseResponse = pushNotification.get()
            return ResponseEntity<String>(firebaseResponse, HttpStatus.OK)
        } catch (e : InterruptedException) {
            println("interrupted!")
            throw InterruptedException()
        } catch (e : ExecutionException) {
            println("execution error!")
        }

        return ResponseEntity("Push Notification ERROR!", HttpStatus.BAD_REQUEST)
    }
}