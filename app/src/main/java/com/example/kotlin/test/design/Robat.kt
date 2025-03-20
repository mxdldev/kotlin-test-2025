package com.example.kotlin.test.design

/**
 * Description: <Robat><br>
 * Author:      mxdl<br>
 * Date:        2025/3/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Robot(
    val code: String,
    val battery: String? = null,
    val height: Int? = null,
    val weight: Int? = null
) {
    init {
        require(weight == null || battery != null) {
            "Battery should be determined when setting weight."
        }
    }
}

fun main(args: Array<String>) {
    Robot(code = "111", weight = 100)

}