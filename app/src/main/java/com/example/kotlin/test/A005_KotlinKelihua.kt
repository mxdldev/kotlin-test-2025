package com.example.kotlin.test

/**
 * Description: <A005_KolinKelihua><br>
 * Author:      mxdl<br>
 * Date:        2025/2/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun add(a: Int, b: Int, c: Int):Int {
    return  a + c + b
}

fun add1(a: Int): (Int) -> (Int) -> Int = { b ->
    { c -> a + b + c }
}

fun add2(x: Int) = { y: Int -> { z: Int -> x + y + z } }

fun main(args: Array<String>) {
    println(add(1, 2, 3))
    println(add1(1)(2)(3))
    println(add2(1)(2)(3))
}