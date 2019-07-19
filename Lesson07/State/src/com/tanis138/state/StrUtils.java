package com.tanis138.state;

/**
 * String handling utilities
 */
public class StrUtils {
    /**
     * Capitalizes the first letter of the string
     *
     * @param str string to capitalize
     * @return capitalized string or "" (if str == null)
     */
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
