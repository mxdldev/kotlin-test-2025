package com.example.kotlin.test

/**
 * Description: <A006_KotlinInvoke><br>
 * Author:      mxdl<br>
 * Date:        2025/2/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class A006_KotlinInvoke {

}
fun foo(i:Int){
    println(i)
}
fun foo1(i:Int) = {
    println(i)
}
fun main(args: Array<String>) {
    listOf(1,2,3,4).forEach({ foo(it) })
    listOf(1,2,3,4).forEach{ foo1(it)() }
    foo(1)
    foo1(1).invoke()
}
val lambda1 = { x: Int -> x * 2 }
// 等价于：
val lambda2: Function1<Int, Int> = object : Function1<Int, Int> {
    override fun invoke(x: Int): Int = x * 2
}
