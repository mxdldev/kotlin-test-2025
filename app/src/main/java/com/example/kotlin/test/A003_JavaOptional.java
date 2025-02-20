package com.example.kotlin.test;


import android.text.TextUtils;

import java.util.Optional;

/**
 * Description: <A003_JavaOptional><br>
 * Author:      mxdl<br>
 * Date:        2025/2/18<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class A003_JavaOptional {
    public static void main(String[] args) {
        String name = "Jack";
        //对于name字符串构建了一个Optional对象实体
        Optional<String> optional = Optional.of(name);
        //判断是不是存在，传递了一个lambda，一行代码搞定
        optional.ifPresent(value -> System.out.println(value));
        //传统方法，相当于TextUtils.isEmpty()函数
        if(optional.isPresent()){
            System.out.println(optional.get());
        }

    }

}
