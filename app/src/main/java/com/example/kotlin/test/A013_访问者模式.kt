package com.example.kotlin.test

/**
 * Description: <A013_访问者模式><br>
 * Author:      mxdl<br>
 * Date:        2025/3/5<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
// 定义图形类型
sealed class Shape {
    abstract fun accept(visitor: ShapeVisitor): Double
}

// 访问者接口
interface ShapeVisitor {
    fun visit(circle: Circle): Double
    fun visit(rectangle: Rectangle): Double
}

// 具体图形类实现 accept 方法
class Circle(val radius: Double) : Shape() {
    override fun accept(visitor: ShapeVisitor): Double = visitor.visit(this) // 分派到 visit(Circle)
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun accept(visitor: ShapeVisitor): Double = visitor.visit(this) // 分派到 visit(Rectangle)
}

// 具体访问者：面积计算
class AreaVisitor : ShapeVisitor {
    override fun visit(circle: Circle): Double = Math.PI * circle.radius * circle.radius
    override fun visit(rectangle: Rectangle): Double = rectangle.width * rectangle.height
}

// 使用访问者模式
fun main() {
    val shapes = listOf(Circle(5.0), Rectangle(10.0, 20.0))
    val areaVisitor = AreaVisitor()

    shapes.forEach { shape ->
        val area = shape.accept(areaVisitor) // 自动匹配到正确的 visit 方法
        println("Area: $area")
    }
}