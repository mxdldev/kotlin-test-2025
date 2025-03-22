package com.example.kotlin

import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.util.TypedValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin.ui.theme.Kotlintest2025Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlintest2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        val input = "这是"
        val widthInDp = 20
        val splitStrings = splitStringByDisplayWidth(this, input, widthInDp)

        for (str in splitStrings) {
            println(str)
        }
    }

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
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlintest2025Theme {
        Greeting("Android")
    }
}
