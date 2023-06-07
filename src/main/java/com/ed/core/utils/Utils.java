package com.ed.core.utils;

public class Utils {
    public static boolean isNullOrEmpty(Object o){
        return o == null || (o instanceof String && ((String) o).isEmpty());
    }
}
