package com.example.kotlin.test;


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
        Optional<String> optional = Optional.of(name);
        optional.ifPresent(value -> System.out.println(value));
        if(optional.isPresent()){
            System.out.println(optional.get());
        }

    }

}
