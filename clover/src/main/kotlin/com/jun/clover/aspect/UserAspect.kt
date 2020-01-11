package com.jun.clover.aspect

import com.jun.clover.entity.User
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class UserAspect {
    @Around(value = "execution(* com.jun.clover.service.UserService.userRegister(..)) and args(user)")
    fun aroundAdvice(pjp : ProceedingJoinPoint, user : User) {
        println("Start creating a user of ${user.id} with a name of ${user.name}")
        val tik = System.currentTimeMillis()
        try {
            pjp.proceed()
        } catch (e : Exception) {
            e.printStackTrace()
        }
        val tok = System.currentTimeMillis()
        println(String.format("creating a hello done in %.4f seconds", ((tok - tik).toDouble()/1000)))
    }
}