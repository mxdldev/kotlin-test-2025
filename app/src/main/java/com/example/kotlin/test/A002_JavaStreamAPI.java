package com.example.kotlin.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Description: <A002_JavaStreamAPI><br>
 * Author:      mxdl<br>
 * Date:        2025/2/18<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class A002_JavaStreamAPI {
    public static void main(String[] args) {
        //1.过滤 把小于3的元素过滤掉
        List<Integer> list = List.of(1,2,3,4,5);
        List<Integer> collect = list.stream().filter(n -> n > 2).collect(Collectors.toList());
        System.out.println(collect);

        //2.映射
        List<String>  list1 = List.of("LiLei","HanMeimei","JeckMa");
        List<Integer> collect1 = list1.stream().map(String::length).collect(Collectors.toList());
        System.out.println(collect1);

        //3.归约，所有元素求和
        List<Integer> list2 = List.of(2,4,6,8);
        Integer sum = list2.stream().reduce(0,Integer::sum);
        System.out.println(sum);

        //4.排序
        List<Integer> list3 = List.of(3,1,4,2);
        List<Integer> collect2 = list3.stream().sorted().collect(Collectors.toList());
        System.out.println(collect2);

        //5.去重
        List<Integer> list4 = List.of(2,3,1,1,2,4);
        List<Integer> collect3 = list4.stream().distinct().collect(Collectors.toList());
        System.out.println(collect3);

    }
}
