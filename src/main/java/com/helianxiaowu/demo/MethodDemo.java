package com.helianxiaowu.demo;

/**
 * 公众号：赫连小伍
 * 方法演示
 */
public class MethodDemo {

    /**
     * 模拟方法响应慢
     */
    public void slow() {
        long starti = System.currentTimeMillis();
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endi = System.currentTimeMillis();
        System.out.println("slow方法执行完毕，共耗时" + (endi-starti) + "毫秒");
    }
}
