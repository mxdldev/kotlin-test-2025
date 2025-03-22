package com.example.kotlin.test.design

/**
 * Description: <companion_factory_pattern><br>
 * Author:      mxdl<br>
 * Date:        2025/3/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
// 定义产品接口
interface Product1 {
    fun use()
}

// 具体产品类 A
class ConcreteProductA1 : Product {
    override fun use() {
        println("Using ConcreteProductA")
    }
}

// 具体产品类 B
class ConcreteProductB1 : Product {
    override fun use() {
        println("Using ConcreteProductB")
    }
}

// 产品类，使用伴生对象作为工厂
class CompanionFactory {
    companion object {
        fun createProduct(type: String): Product {
            return when (type) {
                "A" -> ConcreteProductA1()
                "B" -> ConcreteProductB1()
                else -> throw IllegalArgumentException("Invalid product type")
            }
        }
    }
}

// 使用伴生对象工厂创建产品
fun main() {
    val productA = CompanionFactory.createProduct("A")
    productA.use()
    val productB = CompanionFactory.createProduct("B")
    productB.use()
}