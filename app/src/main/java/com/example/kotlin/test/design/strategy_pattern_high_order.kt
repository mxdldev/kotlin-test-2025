package com.example.kotlin.test.design

/**
 * Description: <strategy_pattern_high_order><br>
 * Author:      mxdl<br>
 * Date:        2025/3/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
// 定义支付策略的高阶函数类型
typealias PaymentStrategy = (Double) -> Unit

// 具体的支付策略函数
fun creditCardPayment(amount: Double) {
    println("使用信用卡支付了 $amount 元")
}

fun alipayPayment(amount: Double) {
    println("使用支付宝支付了 $amount 元")
}

fun wechatPayment(amount: Double) {
    println("使用微信支付了 $amount 元")
}

// 上下文类，持有支付策略函数并使用它进行操作
class ShoppingCart {
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

    // 设置使用信用卡支付
    cart.setPaymentStrategy(::creditCardPayment)
    cart.checkout(100.0)

    // 设置使用支付宝支付
    cart.setPaymentStrategy(::alipayPayment)
    cart.checkout(200.0)

    // 设置使用微信支付
    cart.setPaymentStrategy(::wechatPayment)
    cart.checkout(300.0)
}