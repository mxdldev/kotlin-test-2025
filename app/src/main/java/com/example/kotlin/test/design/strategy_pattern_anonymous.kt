package com.example.kotlin.test.design

/**
 * Description: <strategy_pattern_anonymous><br>
 * Author:      mxdl<br>
 * Date:        2025/3/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
// 定义支付策略的高阶函数类型

// 上下文类，持有支付策略函数并使用它进行操作
class ShoppingCart1 {
    private var paymentStrategy: PaymentStrategy? = null

    fun setPaymentStrategy(strategy: PaymentStrategy) {
        this.paymentStrategy = strategy
    }

    fun checkout(amount: Double) {
        paymentStrategy?.invoke(amount) ?: println("请选择支付方式")
    }
}

fun main() {
    val cart = ShoppingCart()

    // 设置使用信用卡支付，使用匿名函数实现支付策略
    cart.setPaymentStrategy(fun(amount: Double) {
        println("使用信用卡支付了 $amount 元")
    })
    cart.checkout(100.0)

    // 设置使用支付宝支付，使用匿名函数实现支付策略
    cart.setPaymentStrategy(fun(amount: Double) {
        println("使用支付宝支付了 $amount 元")
    })
    cart.checkout(200.0)

    // 设置使用微信支付，使用匿名函数实现支付策略
    cart.setPaymentStrategy(fun(amount: Double) {
        println("使用微信支付了 $amount 元")
    })
    cart.checkout(300.0)
}