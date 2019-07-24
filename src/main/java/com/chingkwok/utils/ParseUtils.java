package com.chingkwok.utils;

/**
 * Created by guojingye on 2019/7/24
 */
public class ParseUtils {
    public static int parseInt(Object o, int defaultValue) {
        if (o != null) {
            return parseInt(o);
        } else {
            return defaultValue;
        }
    }

    public static Integer parseInt(Object o) {
        try {
            if (o != null) {
                return Integer.parseInt(o.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
