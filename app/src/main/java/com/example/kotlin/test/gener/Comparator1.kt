package com.example.kotlin.test.gener

/**
 * Description: <Comparator1><br>
 * Author:      mxdl<br>
 * Date:        2025/3/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
interface Comparator1<in T> {
    fun compare(a: T, b: T): Int
}

class IntComparator : Comparator1<Int> {
    override fun compare(a: Int, b: Int): Int = a - b
}
class NumberComparator : Comparator1<Number> {
    override fun compare(a: Number, b: Number): Int {
      return 1
    }
}

fun main(args: Array<String>) {
    fun useComparator(comparator1: Comparator1<Int>){
        val num1 :Number = 1
        val num2 :Number = 2
        val result = comparator1.compare(1, 2)
        println(result)
    }

    val comparator1 = IntComparator()
    val numberComparator = NumberComparator()

    useComparator(numberComparator)
}

