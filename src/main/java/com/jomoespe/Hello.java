package com.jomoespe;

public class Hello {
    public static void main(String...args) {
        System.out.printf("Hello %s!\n", args.length>0 ? args[0] : "world");
    }
}