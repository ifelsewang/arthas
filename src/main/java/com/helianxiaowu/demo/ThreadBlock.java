package com.helianxiaowu.demo;

/**
 * 公众号：赫连小伍
 * 演示线程被阻塞
 */
public class ThreadBlock {

    public void block(String str) {
        Thread t1 = new Thread(() -> {
            loop();
        });
        Thread t2 = new Thread(() -> {
            loop();
        });
        t1.start();
        t2.start();
    }

    private void loop() {
        synchronized (""){
            while(true){
                System.out.println("线程已被阻塞，10分钟后结束");
                try {
                    // 阻塞10分钟
                    Thread.sleep(10 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
