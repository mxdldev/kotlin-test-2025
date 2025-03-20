package com.example.kotlin.test.design

/**
 * Description: <BanShengObject><br>
 * Author:      mxdl<br>
 * Date:        2025/3/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class BanShengObject {
    companion object{
        fun foo(){
            println("ok")
        }
    }
}

fun main(args: Array<String>) {
    BanShengObject.foo()
}