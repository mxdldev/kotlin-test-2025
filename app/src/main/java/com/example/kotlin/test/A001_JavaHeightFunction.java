package com.example.kotlin.test;


import java.util.function.Function;

/**
 * Description: <Java高阶函数的运用><br>
 * Author:      mxdl<br>
 * Date:        2025/2/18<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class A001_JavaHeightFunction {
    public static void main(String[] args) {
        //定义了一个函数式接口Function输入参数求平方的实现
        Function<Integer, Integer> square = x -> x * x;
        //定义了一个函数式接口Function输入参数加1的实现
        Function<Integer, Integer> addOne = x -> x + 1;

        //调用Function接口的andThen函数，先执行square函数，，然后再执行addOne函数
        Function<Integer, Integer> andThen = square.andThen(addOne);
        //执行结果
        Integer result = andThen.apply(4);
        System.out.println(result);

        //调用Function接口的compose函数，先执行addOne函数，再执行square函数
        Function<Integer, Integer> compose = square.compose(addOne);
        Integer result1 = compose.apply(4);
        System.out.println(result1);
    }
}
