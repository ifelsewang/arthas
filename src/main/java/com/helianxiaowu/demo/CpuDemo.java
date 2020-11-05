package com.helianxiaowu.demo;

/**
 * 公众号：赫连小伍
 * 命令演示
 */
public class CpuDemo {

    public void high() {
        new Thread(()->{
            long i = 0;
            while (true) {
                i++;
            }
        }).start();
    }
}
