package com.example.kotlin.test

/**
 * Description: <A006_KotlinFunction><br>
 * Author:      mxdl<br>
 * Date:        2025/2/25<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
//定义一个函数完整版
val foo: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

//lambda在实现这个函数的时候xy可以不声明类型，可自动进行类型推导
val foo1: (Int, Int) -> Int = { x, y -> x + y }

//如果函数实现的时候指定了类型，那么foo2变量的类型可以省略，可以类型推导
val foo2 = { x: Int, y: Int -> x + y }

//利用fun关键字来声明一个lambda表达式
fun foo4(x: Int, y: Int) = { a: Int, b: Int -> x + y }
fun foo44(x: Int, y: Int): (Int, Int) -> Int = { a: Int, b: Int -> x + y + a + b }
fun foo5(x: Int, y: Int) = { x + y }
fun foo6(x: Int, y: Int) = x + y
fun main(args: Array<String>) {
    println(foo2(1, 2))
    println(foo2.invoke(1, 2))
    println(foo4(1, 2).invoke(2, 3))
    println(foo44(1, 2).invoke(2, 3))
    println(foo44(1, 2)(2, 3))
}