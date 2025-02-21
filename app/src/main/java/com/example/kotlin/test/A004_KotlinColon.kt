package com.example.kotlin.test

/**
 * Description: <A004_KotlinColon><br>
 * Author:      mxdl<br>
 * Date:        2025/2/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //将集合中Book对象的name属性过滤
    val bookNames = listOf(Book("pingfan"), Book("yuguanyin")).map(Book::name)
    //将集合中Book对象的name属性过滤
    val bookNames1 = listOf(Book("pingfan"), Book("yuguanyin")).map { it.name }
    //Book::name的本质是个函数
    println(bookNames)
    println(bookNames1)

    val book = Book("bainiangudu")
    println(book::name.invoke())
    val getName = Book::name
    println(getName(book))

    val t = Book::test
    t(book,3)

    val book1 = Book("xiyouji")
    println(book1.name)
    book1.name = "hongloumeng"
    println(book1.name)


}
data class Book(var name:String){
    fun test(a:Int){
        println(a)
    }
}