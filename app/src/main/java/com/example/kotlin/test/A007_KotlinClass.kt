package com.example.kotlin.test

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2025/2/18<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
//通过指定参数的默认值避免不必要的构造方法重载


import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.util.TypedValue

fun splitStringByDisplayWidth(context: Context, input: String, widthInDp: Int): List<String> {
    // 创建一个 Paint 对象用于测量文本宽度
    val paint = Paint()
    // 获取字体大小，这里假设使用默认字体大小
    val textSize = paint.textSize
    paint.textSize = textSize

    // 将 dp 转换为 px
    val widthInPx = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        widthInDp.toFloat(),
        context.resources.displayMetrics
    )

    val result = mutableListOf<String>()
    var startIndex = 0
    var currentIndex = 0

    while (currentIndex < input.length) {
        // 截取从 startIndex 到 currentIndex 的子字符串
        val substring = input.substring(startIndex, currentIndex + 1)
        // 测量子字符串的宽度
        val measuredWidth = paint.measureText(substring)

        if (measuredWidth > widthInPx) {
            // 如果宽度超过指定宽度，将上一个截取的子字符串添加到结果列表
            if (startIndex < currentIndex) {
                result.add(input.substring(startIndex, currentIndex))
            }
            // 更新 startIndex
            startIndex = currentIndex
        } else if (currentIndex == input.length - 1) {
            // 处理最后一个子字符串
            result.add(input.substring(startIndex))
        }
        // 移动到下一个字符
        currentIndex++
    }

    return result
}


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val input = "这是一个测试字符串，用于演示如何按显示宽度分割字符串。"
        val widthInDp = 200
        val splitStrings = splitStringByDisplayWidth(this, input, widthInDp)

        for (str in splitStrings) {
            println(str)
        }
    }
}