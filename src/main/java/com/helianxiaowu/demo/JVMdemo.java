package com.helianxiaowu.demo;

public class JVMdemo {

    public static void main(String[] args) {
        JVMdemo jvMdemo = new JVMdemo();
        jvMdemo.add();
    }


    public int add() {
        int i = 10;
        int j = 5;
        int add = i + j;
        return add;
    }

    public int sum() {
        int i = 10;
        i++;
        return 0;
    }
}
