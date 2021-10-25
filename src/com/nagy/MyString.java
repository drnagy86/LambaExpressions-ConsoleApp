package com.nagy;

public class MyString {

    public static StringOperation contains(){
        return ((targetStr, searchStr) -> targetStr.contains(searchStr));
    }

    public static StringOperation startsWith() {
        return (targetStr, searchStr) -> targetStr.startsWith(searchStr);
    }
    // use length method in the string class for HW

    public static StringOperation equals(){
        return (targetStr, searchStr) -> targetStr.equals(searchStr);
    }

    public static StringOperation endsWith(){
        return (targetStr, searchStr) -> targetStr.endsWith(searchStr);
    }

    public static StringOperation containsSearchAndLessThanFive(){
        return (targetStr, searchStr) -> targetStr.contains(searchStr) && targetStr.length() <= 5;
    }


    public static StringOperation containsSearchAndMoreThanFive(){
        return (targetStr, searchStr) -> targetStr.contains(searchStr) && targetStr.length() > 5;
    }


}
