package com.example.kotlin.test

/**
 * Description: <A011_类型检查与智能转换><br>
 * Author:      mxdl<br>
 * Date:        2025/3/5<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun process(value: Any) {
    when (value) {
        is String -> println("String length: ${value.length}") // 自动转换为 String
        is Int -> println("Int value: ${value + 1}")           // 自动转换为 Int
        else -> println("Unknown type")
    }
}