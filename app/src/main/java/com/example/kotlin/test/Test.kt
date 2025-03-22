package com.example.kotlin.test

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2025/2/18<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test {
}

fun main(args: Array<String>) {
   val t = html {
        body()
        t()
    }
    println("============================")
    t()
}

fun t() {
    val str:String? = null
    str.let{
        print(it?.length)
        print("ok")
    }
}

class Html {
    fun body() {
        println("ok")
    }
}

fun html(init: Html.() -> Unit): Html {
    val html = Html()
    html.init()
    return html
}