package com.wy.shop.utils;

public class StringUtil {

    public static Boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
