package com.example.kotlin.test

import kotlin.random.Random

/**
 * Description: <PartialFunction><br>
 * Author:      mxdl<br>
 * Date:        2025/3/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */

//1.申请的项目事件，包括事件金额和事件的标题
class ApplyEvent(val money: Int, val title: String)

//1.核心类事件处理器
//2.有两个非常重要的函数（检查函数，处理函数）
//3.实现了一个函数，该函数的内部做了两件事，检查事件和处理事件
//4.自定义了一个检查事件的函数，还是一个代理
class EventHandler<in Event, out Result>(val id:Int,private val checkFun: (Event) -> Boolean, private val processFun: (Event) -> Result) : (Event) -> Result {
    override fun invoke(event: Event): Result {
        //当条件成立是执行函数f
        if (checkFun(event)) {
            return processFun(event)
        } else {
            throw IllegalArgumentException("Value: ($event) isn't supported by this function")
        }
    }
    fun isCheckFun(event: Event) = checkFun(event)
}
//1.事件处理器只具备了处理的能力，不具备事件传递的能力,扩展了一个方法 当处理不了的时候进行分发传递
infix fun <Event, Result> EventHandler<Event, Result>.deliverEvent(that: EventHandler<Event, Result>): EventHandler<Event, Result> {
    return EventHandler(Random.nextInt(100,201),{ this.isCheckFun(it) || that.isCheckFun(it) }) {
        when {
            //如果条件满足则执行
            this.isCheckFun(it) -> this(it)
            else -> that(it)
        }
    }
}
//创建了一个组长，只能处理100元以下的项目
val groupLeader = {
    //创建了一个检查函数
    val checkFun: (ApplyEvent) -> Boolean = { it.money < 100 }
    //创建了一个处理函数
    val processFun: (ApplyEvent) -> Unit = { println("Group leader handled application: ${it.title}.") }

    EventHandler(1,checkFun, processFun)
}()
//创建了了一个校长，只能处理500元以下的项目
val president = {
    val checkFun: (ApplyEvent) -> Boolean = { it.money <= 500 }
    val processFun: (ApplyEvent) -> Unit = { println("President handled application: ${it.title}.") }
    EventHandler(2,checkFun, processFun)
}()
//创建了一个校委会，可以处理1000元以下的项目
val college = {
    val checkFun: (ApplyEvent) -> Boolean = { true }
    val processFun: (ApplyEvent) -> Unit = {
        when {
            it.money > 1000 -> println("College: This application is refused.")
            else -> println("College handled application: ${it.title}.")
        }
    }
    EventHandler(3,checkFun, processFun)
}()



fun main(args: Array<String>) {
    //组长，校长，校委会需要责任链串起来
    //给groupLeader指定了他的下级处理器president
    //给president指定了它的下级处理器college
    val applyChain = groupLeader deliverEvent president deliverEvent college
    println(applyChain.invoke(ApplyEvent(220,"ttt")))
    //val event1 = ApplyEvent(300, "Event 1")
    //applyChain.invoke(event1)

    println(Test().invoke(1))
    println(Test()(2))
    println(Test().t(3))
}
class Test:(Int)->Int{
    override fun invoke(p1: Int): Int {
        return 1 + p1
    }
    fun t(a:Int):Int{
        return this(a)
    }
}
