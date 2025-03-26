package com.example.kotlin.test.design

/**
 * Description: <strategy_pattern><br>
 * Author:      mxdl<br>
 * Date:        2025/3/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
// 定义策略接口
interface PaymentStrategy1 {
    fun pay(amount: Double)
}

// 具体策略类：信用卡支付
class CreditCardPayment1 : PaymentStrategy1 {
    override fun pay(amount: Double) {
        println("使用信用卡支付了 $amount 元")
    }
}

// 具体策略类：支付宝支付
class AlipayPayment1 : PaymentStrategy1 {
    override fun pay(amount: Double) {
        println("使用支付宝支付了 $amount 元")
    }
}

// 具体策略类：微信支付
class WechatPayment1 : PaymentStrategy1 {
    override fun pay(amount: Double) {
        println("使用微信支付了 $amount 元")
    }
}

// 上下文类，持有策略对象并使用它进行操作
class ShoppingCart2 {
    private var paymentStrategy: PaymentStrategy1? = null

    fun setPaymentStrategy(strategy: PaymentStrategy1) {
        this.paymentStrategy = strategy
    }

    fun checkout(amount: Double) {
        paymentStrategy?.pay(amount) ?: println("请选择支付方式")
    }
}

fun main() {
    val cart = ShoppingCart2()

    // 设置使用信用卡支付
    cart.setPaymentStrategy(CreditCardPayment1())
    cart.checkout(100.0)

    // 设置使用支付宝支付
    cart.setPaymentStrategy(AlipayPayment1())
    cart.checkout(200.0)

    // 设置使用微信支付
    cart.setPaymentStrategy(WechatPayment1())
    cart.checkout(300.0)
}