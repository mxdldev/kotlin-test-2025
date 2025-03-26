package com.example.kotlin.test.design

/**
 * Description: <Observerv1><br>
 * Author:      mxdl<br>
 * Date:        2025/3/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
import kotlin.properties.Delegates

// 定义观察者接口
interface Observer1 {
    fun update(newState: String)
}

// 定义主题类
class Subject1 {
    var state: String by Delegates.observable("Initial state") { _, oldValue, newValue ->
        if (oldValue != newValue) {
            notifyObservers(newValue)
        }
    }

    private val observers = mutableListOf<Observer1>()

    fun registerObserver(observer: Observer1) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer1) {
        observers.remove(observer)
    }

    private fun notifyObservers(newState: String) {
        observers.forEach { it.update(newState) }
    }
}

// 具体的观察者类
class ConcreteObserver1(private val name: String) : Observer1 {
    override fun update(newState: String) {
        println("$name received update: $newState")
    }
}

fun main() {
    val subject = Subject1()

    val observer1 = ConcreteObserver1("Observer 1")
    val observer2 = ConcreteObserver1("Observer 2")
    val observer3 = ConcreteObserver1("Observer 3")

    subject.registerObserver(observer1)
    subject.registerObserver(observer2)
    subject.registerObserver(observer3)

    subject.state = "New state 1"
    subject.state = "New state 2"

    subject.removeObserver(observer2)
    subject.state = "New state 3"
}