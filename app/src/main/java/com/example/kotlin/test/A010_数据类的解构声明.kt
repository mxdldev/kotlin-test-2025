package com.example.kotlin.test

/**
 * Description: <A010_数据类的解构声明><br>
 * Author:      mxdl<br>
 * Date:        2025/3/5<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
data class User(val name: String, val age: Int)

fun processUser(user: User) {
    val (name, age) = user // 解构声明
    println("Name: $name, Age: $age")
}

fun matchUser(user: User) = when (user) {
    is User -> {
        val (name, age) = user
        if (age > 18) "Adult: $name" else "Child: $name"
    }

    else -> {}
}