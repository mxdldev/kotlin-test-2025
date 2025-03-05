package com.example.kotlin.test

/**
 * Description: <A008_KotlinDataClass><br>
 * Author:      mxdl<br>
 * Date:        2025/3/3<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
data class Bird(val weight: String, val age: String, val color: String)

fun main() {
    val bird = Bird("10kg", "3years", "blue")
    val (weight, age, color) = bird
    println("Weight: $weight")
    println("Age: $age")
    println("Color: $color")

    val pair = Pair(1,"nihao")
    println(pair.first)
    println(pair.second)

    val triple = Triple(1,"asdf",1.54)
    println(triple.first)
    println(triple.second)
    println(triple.third)

    val p = 1 to 2
    println(p.first)
    println(p.second)
    val listOf = listOf(1, 2, 3)
    val map = mapOf(1 to 2, 2 to 3,p)
}
