package com.example.kotlin.test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/**
 * Description: <TestJava><br>
 * Author:      mxdl<br>
 * Date:        2025/2/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class TestJava {
    public static void main(String[] args) {
        //System.out.println(slen.apply("hello"));
        Integer hello = slen.apply("hello");
        System.out.println(1==2?1:2);

    }
    static Function<String,Integer> slen = new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return s.length();
        }
    };
    Consumer consumer = new Consumer<String>() {
        @Override
        public void accept(String o) {

        }
    };
    BiConsumer biConsumer = new BiConsumer<String, Integer>() {
        @Override
        public void accept(String s, Integer integer) {

        }
    };
    ObjIntConsumer objIntConsumer = new ObjIntConsumer<String>() {

        @Override
        public void accept(String s, int i) {

        }
    };
}
interface Function<Arg,Void>{
    Void apply(Arg arg);
}

