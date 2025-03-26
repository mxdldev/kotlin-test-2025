package com.example.kotlin.test

/**
 * Description: <PartialFunction><br>
 * Author:      mxdl<br>
 * Date:        2025/3/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */

//创建了一个事件类ApplyEvent，参数1：money，参数2：title，金额的不同处理的流程不一样
class ApplyEvent(val money: Int, val title: String)

//创建PartialFunction类
//1.该类有两个泛型参数P1,R
//2.该类的构造参数有两个definedAt，f而且都是函数类型的
//3.definedAt是检查条件是否成立，f是如果条件成立要执行的逻辑
//4.该类实现了一个函数类型为(P1) -> R （第一次见）
class PartialFunction<in P1, out R>(private val definedAt: (P1) -> Boolean,
                                    private val f: (P1) -> R) : (P1) -> R {
    override fun invoke(p1: P1): R {
        //当条件成立是执行函数f
        if (definedAt(p1)) {
            return f(p1)
        } else {
            throw IllegalArgumentException("Value: ($p1) isn't supported by this function")
        }
    }
    fun isDefinedAt(p1: P1) = definedAt(p1)
}
//1.给PartialFunction类定义一个中缀扩展函数orElse
//2.该函数有一个参数为PartialFunction，该函数的返回值为PartialFunction
infix fun <P1, R> PartialFunction<P1, R>.orElse(that: PartialFunction<P1, R>): PartialFunction<P1, R> {

    return PartialFunction({ this.isDefinedAt(it) || that.isDefinedAt(it) }) {
        when {
            //如果条件满足则执行
            this.isDefinedAt(it) -> this(it)
            else -> that(it)
        }
    }
}

val president = {
    val definedAt: (ApplyEvent) -> Boolean = { it.money <= 500 }
    val handler: (ApplyEvent) -> Unit = { println("President handled application: ${it.title}.") }
    PartialFunction(definedAt, handler)
}()

val college = {
    val definedAt: (ApplyEvent) -> Boolean = { true }
    val handler: (ApplyEvent) -> Unit = {
        when {
            it.money > 1000 -> println("College: This application is refused.")
            else -> println("College handled application: ${it.title}.")
        }
    }
    PartialFunction(definedAt, handler)
}()

val groupLeader = {
    val definedAt: (ApplyEvent) -> Boolean = { it.money < 100 }
    val handler: (ApplyEvent) -> Unit = { println("Group leader handled application: ${it.title}.") }
    PartialFunction(definedAt, handler)
}()

fun main(args: Array<String>) {
    val applyChain = groupLeader orElse president orElse college

    val event1 = ApplyEvent(50, "Event 1")
    val event2 = ApplyEvent(300, "Event 2")
    val event3 = ApplyEvent(1200, "Event 3")

    applyChain.invoke(event1)
    applyChain.invoke(event2)
    applyChain.invoke(event3)
}