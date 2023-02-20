package com.coop.api.utility;

public class StringUtility {

    public static String extractKey(String string){
        if(!string.startsWith("${")) {
            return string;
        }
        else {
            return string.substring(2, string.length() - 1);
        }
    }

    public static void main(String args[]){
        System.out.println("key:"+extractKey("${test }"));
    }
}
