package com.example.kotlin.test.design

/**
 * Description: <Observer><br>
 * Author:      mxdl<br>
 * Date:        2025/3/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
// 定义观察者接口
interface Observer {
    fun update(data: String)
}

// 定义主题接口
interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

// 具体的主题类
class ConcreteSubject : Subject {
    private val observers = mutableListOf<Observer>()
    private var state: String = ""

    fun setState(newState: String) {
        state = newState
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(state) }
    }
}

// 具体的观察者类
class ConcreteObserver : Observer {
    override fun update(data: String) {
        println("Received update: $data")
    }
}

fun main() {
    val subject = ConcreteSubject()
    val observer1 = ConcreteObserver()
    val observer2 = ConcreteObserver()

    subject.registerObserver(observer1)
    subject.registerObserver(observer2)

    subject.setState("New state")
}