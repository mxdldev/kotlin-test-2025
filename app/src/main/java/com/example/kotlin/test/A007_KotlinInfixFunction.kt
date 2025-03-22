package com.example.kotlin.test

/**
 * Description: <A007_KotlinInfixFunction><br>
 * Author:      mxdl<br>
 * Date:        2025/2/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */

fun main() {
    // 使用中缀表达式调用 addTo 函数
    val result = 3 addTo 5
    println("3 + 5 的结果是: $result")

    val num1 = CompareNumber(10)
    val num2 = CompareNumber(5)
    // 使用中缀表达式调用 isGreaterThan 函数
    val result1 = num1 isGreaterThan num2
    println("num1 是否大于 num2: $result1")

    val list = listOf(1, 2, 3)
    // 使用中缀表达式调用 append 函数
    val newList1 = list append 4
    println("新列表: $newList1")

}
// 定义一个扩展函数并使用 infix 修饰
infix fun Int.addTo(other: Int): Int {
    return this + other
}

// 定义一个成员函数并使用 infix 修饰
class CompareNumber(val num: Int) {
    infix fun isGreaterThan(other: CompareNumber): Boolean {
        return this.num > other.num
    }
}
// 定义一个扩展函数并使用 infix 修饰
infix fun <T> List<T>.append(element: T): List<T> {
    return this + element
}
