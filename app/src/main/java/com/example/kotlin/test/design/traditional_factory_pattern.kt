package com.example.kotlin.test.design

/**
 * Description: <traditional_factory_pattern><br>
 * Author:      mxdl<br>
 * Date:        2025/3/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
// 定义产品接口
interface Product {
    fun use()
}

// 具体产品类 A
class ConcreteProductA : Product {
    override fun use() {
        println("Using ConcreteProductA")
    }
}

// 具体产品类 B
class ConcreteProductB : Product {
    override fun use() {
        println("Using ConcreteProductB")
    }
}

// 传统工厂类
class TraditionalFactory {
    fun createProduct(type: String): Product {
        return when (type) {
            "A" -> ConcreteProductA()
            "B" -> ConcreteProductB()
            else -> throw IllegalArgumentException("Invalid product type")
        }
    }
}

// 使用传统工厂创建产品
fun main() {
    val factory = TraditionalFactory()
    val productA = factory.createProduct("A")
    productA.use()
    val productB = factory.createProduct("B")
    productB.use()
}