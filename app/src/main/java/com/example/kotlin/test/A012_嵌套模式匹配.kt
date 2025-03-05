package com.example.kotlin.test

/**
 * Description: <A012_嵌套模式匹配><br>
 * Author:      mxdl<br>
 * Date:        2025/3/5<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
sealed class Expr {
    data class Num(val value: Int) : Expr()
    data class Add(val left: Expr, val right: Expr) : Expr()
}

fun eval(expr: Expr): Int = when (expr) {
    is Expr.Num -> expr.value
    is Expr.Add -> eval(expr.left) + eval(expr.right) // 递归匹配嵌套结构
}