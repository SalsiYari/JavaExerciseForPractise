package com.yarisalsi.exercise.reverse;

public class TestApp {
    public static void main(String[] args){
        Reverser r=new Reverser() {
            @Override
            public String reverse(String str) {
                return new StringBuilder(str).reverse().toString();
            }
        };
        System.out.println(r.reverse("hello world"));

        Reverser rv= new Reverser() {
            @Override
            public String reverse(String str) {
                return new StringBuilder(str).reverse().toString();
            }
        };
        System.out.println(rv.reverse("grazie al cazzo che funziona"));


        //Reverser r1=new ReverserFast();
        //System.out.println(r1.reverse("ciaooooola") );
    }
}
