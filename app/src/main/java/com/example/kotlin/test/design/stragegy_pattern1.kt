package com.example.kotlin.test.design

/**
 * Description: <stragegy_pattern1><br>
 * Author:      mxdl<br>
 * Date:        2025/3/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun test(a: Int, b: Int, t: (Int, Int) -> Int): Int {
    return t(a, b)
}

fun main(args: Array<String>) {
    test(1, 2, { a, b ->
        a + b
    })

    test(1, 2, { a, b ->
        a - b
    })
}