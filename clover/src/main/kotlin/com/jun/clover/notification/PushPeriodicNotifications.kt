package com.jun.clover.notification

import org.springframework.boot.configurationprocessor.json.JSONArray
import org.springframework.boot.configurationprocessor.json.JSONObject
import java.time.LocalDate

class PushPeriodicNotifications {
    fun periodicNotificationJson() : String {
        val localDate = LocalDate.now()
        val sampleData = listOf("eZIYqRhhKvM:APA91bEACg6DcEKbbMdsHdYDDZs2q65gfmy0Gb45AkHj0BkaBwOYPjXubXHQO1I_GuxldGrvbcDVTs0s_dHRORw5skND_4brFNq73bxINm1SyH6zBaNySWBQ2re9kY3_L-31ozQDth0P",
                                "device token value 2", "device token value 3")
        val body = JSONObject()
        val tokenList = ArrayList<String>()
        for (i in sampleData.indices) {
            tokenList.add(sampleData[i])
        }
        val array = JSONArray()
        for (i in tokenList.indices) {
            array.put(tokenList[i])
        }

        body.put("registration_ids", array)

        val notification = JSONObject()
        notification.put("title", "Hello!")
        notification.put("body", "Today is ${localDate.dayOfWeek.name}!")
        body.put("notification", notification)

        println(body.toString())
        return body.toString()
    }
}