package com.yarisalsi.exercise.reverse;

public class ReverserSlow implements Reverser{
    @Override
    public String reverse(String str) {
        char[] ret= new char[str.length()];
        for(int i=str.length(); i>0 ; i++){
            ret[i]=str.charAt(i);
        }
        return String.valueOf(ret);
    }
}
