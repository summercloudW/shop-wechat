package com.shop.util;

public class StringUtil {

    public static Boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
