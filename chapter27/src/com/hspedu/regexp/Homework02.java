package com.hspedu.regexp;

/**
 * @author 张立业
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        //要求验证是不是整数或者小数
        //提示： 这个题要考虑正数和负数
        //比如： 123 -345 34.89 -87.9 -0.01 0.45 等
        /**
         * 思路
         * 1. 先写出简单的正则表达式
         * 2. 在逐步的完善[根据各种情况来完善]
         */
        String content = "0.89";
        String regstr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";//[-+]? --> ?表示可能有可能没有
        if (content.matches(regstr)) {
            System.out.println("匹配成功 是整数或者小数");
        }else {
            System.out.println("匹配失败");
        }
    }
}
