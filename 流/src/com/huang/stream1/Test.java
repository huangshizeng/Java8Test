package com.huang.stream1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800),
                new Dish("beef", false, 700),
                new Dish("chicken", false, 400),
                new Dish("french fries", true, 530),
                new Dish("rice", true, 350),
                new Dish("season fruit", true, 120),
                new Dish("pizza", true, 550),
                new Dish("prawns", false, 300),
                new Dish("salmon", false, 450)
        );

        List<String> threeHighCaloricDishNames = menu.stream() //从菜单中获取流
                                                    .filter(d -> d.getCalories() > 300) //首先选出高热量的菜肴
                                                    .map(Dish::getName) //获取菜名
                                                    .limit(3) //选择前3个
                                                    .collect(Collectors.toList()); //将结果保存在另一个List中
        System.out.println(threeHighCaloricDishNames);
    }
}
