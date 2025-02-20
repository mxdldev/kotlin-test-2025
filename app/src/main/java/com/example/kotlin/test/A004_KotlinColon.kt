package com.example.kotlin.test

/**
 * Description: <A004_KotlinColon><br>
 * Author:      mxdl<br>
 * Date:        2025/2/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    val bookNames = listOf(Book("平凡的世界"), Book("玉观音")).map(Book::name)
    val bookNames1 = listOf(Book("平凡的世界"), Book("玉观音")).map { it.name }
    println(bookNames)
    println(bookNames1)

    val book = Book("百年孤独")
    println(book::name.invoke())
    val getName = Book::name
    println(getName(book))
}
data class Book(val name:String)