package com.example.kotlin.test.design

/**
 * Description: <偏函数><br>
 * Author:      mxdl<br>
 * Date:        2025/3/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun add(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    // 固定add函数的第一个参数a为5，得到一个新的函数plusFive
    val plusFive: (Int) -> Int = { b -> add(5, b) }
    val result = plusFive(3)
    println(result)
}