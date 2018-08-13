package com.huang.optional;

import java.util.Optional;
import java.util.Properties;

/**
 * 如果给定属性对应的值是一个代表整数的字符串，就返回该整数值，任何其他的情况都返回0
 */
public class Test {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "7");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
        System.out.println(readDuration2(props, "a"));

    }

    /**
     * @Description: 普通的做法
     * @Param:
     * @return:
     * @Author: 黄世增
     * @Date: 2018/8/13 0013
     */
    public static int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {}
        }
        return 0;
    }

    public static int readDuration2(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                       .flatMap(OptionalUtility::stringToInt)
                       .filter(i -> i > 0)
                       .orElse(0);
    }
}
