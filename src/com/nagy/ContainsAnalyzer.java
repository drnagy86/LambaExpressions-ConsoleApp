package com.nagy;

public class ContainsAnalyzer implements StringOperation{
    @Override
    public boolean analyze(String targetStr, String searchStr) {
        return targetStr.contains(searchStr);
    }
}
