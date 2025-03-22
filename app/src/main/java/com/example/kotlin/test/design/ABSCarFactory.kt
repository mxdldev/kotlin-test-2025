package com.example.kotlin.test.design

/**
 * Description: <ABSCarFactory><br>
 * Author:      mxdl<br>
 * Date:        2025/3/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
// 交通工具接口
interface Vehicle {
    fun move()
}

// 燃料接口
interface Fuel {
    fun burn()
}

// 抽象工厂接口
interface TransportFactory {
    fun createVehicle(): Vehicle
    fun createFuel(): Fuel
}

// 具体交通工具 - 汽车
class Car : Vehicle {
    override fun move() {
        println("Car is moving")
    }
}

// 具体燃料 - 汽油
class Gasoline : Fuel {
    override fun burn() {
        println("Gasoline is burning")
    }
}

// 具体工厂 - 汽车工厂
class CarFactory : TransportFactory {
    override fun createVehicle(): Vehicle = Car()
    override fun createFuel(): Fuel = Gasoline()
}
//============================================================
// 内联函数简化工厂创建
inline fun <reified T : Vehicle, reified F : Fuel> createTransportFactory(): TransportFactory {
    return object : TransportFactory {
        override fun createVehicle(): Vehicle = T::class.java.getDeclaredConstructor().newInstance()
        override fun createFuel(): Fuel = F::class.java.getDeclaredConstructor().newInstance()
    }
}

// 使用简化后的工厂创建
fun main() {
    val factory = createTransportFactory<Car, Gasoline>()
    val vehicle = factory.createVehicle()
    val fuel = factory.createFuel()
    vehicle.move()
    fuel.burn()
}