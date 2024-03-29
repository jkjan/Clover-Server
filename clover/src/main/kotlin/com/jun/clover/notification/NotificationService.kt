package com.jun.clover.notification

import com.jun.clover.firebasetoken.FirebaseTokenService
import org.springframework.http.HttpEntity
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.RestTemplate
import java.util.concurrent.CompletableFuture
import javax.swing.text.html.parser.Entity

@Service
class NotificationService(private val firebaseTokenService: FirebaseTokenService) {
    private val firebaseServerKey = "AAAAZPCIeWA:APA91bHmwquIEwxDYebiiYUv_F1rOBvrgSZDJfCjJHQY_WlgQZvbi8dt44rl0N7_eQnXL4rsUza7DCeALVOckshy0DE15JkYhlksoijZHejXa4p3iHIqn7HI3lVz1KPvmEh9r2ahZVXw"
    private val firebaseApiUrl = "https://fcm.googleapis.com/fcm/send"

    @Async
    @Transactional(rollbackFor = [Exception::class])
    fun send(entity : HttpEntity<String>) : CompletableFuture<String> {
        val restTemplate = RestTemplate()
        val interceptors = arrayListOf<ClientHttpRequestInterceptor>()
        interceptors.add(HeaderRequestInterceptor("Authorization", "key=$firebaseServerKey"))
        interceptors.add(HeaderRequestInterceptor("Content-Type", "application/json; UTF-8 "))
        restTemplate.interceptors = interceptors

        val firebaseResponse = restTemplate.postForObject(firebaseApiUrl, entity, String::class.java)

        return CompletableFuture.completedFuture(firebaseResponse)
    }

    @Async
    @Transactional(rollbackFor = [Exception::class])
    fun update() {
        val notifications = PushPeriodicNotifications().periodicNotificationJson(firebaseTokenService.getToken())
        val request = HttpEntity<String>(notifications)
        send(request)
    }
}