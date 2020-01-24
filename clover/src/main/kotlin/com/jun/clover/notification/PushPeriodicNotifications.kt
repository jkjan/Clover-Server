package com.jun.clover.notification

import org.json.JSONArray
import org.json.JSONObject
import java.time.LocalDate

class PushPeriodicNotifications {
    fun periodicNotificationJson() : String {
        val localDate = LocalDate.now()
        val sampleData = listOf("eZIYqRhhKvM:APA91bEACg6DcEKbbMdsHdYDDZs2q65gfmy0Gb45AkHj0BkaBwOYPjXubXHQO1I_GuxldGrvbcDVTs0s_dHRORw5skND_4brFNq73bxINm1SyH6zBaNySWBQ2re9kY3_L-31ozQDth0P",
                                "c2R_YkbuXpc:APA91bG-GrEAFsXBYHe_QBY22ReI49JPktVFud9AWdhlu9XbYwij0jxK2Z6Sv0DgJg68I_xn9rsdcTTRlMk5HqdYUdfNwfuEbr-k_J93qaz97JApNGWc1SgvobyIIwk0OF6vcnTkBqXg",
                "dsJRtGzasZU:APA91bHS244OIzNK8tAKR1VXRbaXC3NtTQQrTlHygAANMLJLjbJ7-G3fm9vhIe9Mdr-9_eA9nFzCG91ZqTnzlG5g52UXdZdhC3KCImnuf2fPuYRBKjR3iMCdtKewjDbk8lcK5DBsxfd6",
                "exddgJstbpI:APA91bG_uMMtwgHFzhY4A26vZwDgIa62TQYN9b_KF6Uzkan5mtUxIWhMs-aCzb2tMmnmBwSZRvqeidLBaF5gkt9BkxA_F9IjuafQJS3AxdcPk3aIHsaPNpiJk2CdST1gvn9EM8rp3dif")
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