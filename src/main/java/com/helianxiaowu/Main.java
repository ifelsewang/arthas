package com.helianxiaowu;

import com.helianxiaowu.demo.CpuDemo;
import com.helianxiaowu.demo.MethodDemo;
import com.helianxiaowu.demo.SheelDemo;
import com.helianxiaowu.demo.ThreadBlock;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 公众号：赫连小伍
 */
public class Main {

    private static boolean runing = false;
    private static Thread thread = null;

    public static void main(String[] args) {
        // 输出提示语
        printMsg();

        // 始终读取控制台输入参数
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            if(runing && !"end".equals(s)){
                System.out.println("请先使用 end 命令结束当前演示");
                continue;
            }
            // 启用线程，调用方法时方便终止
            if (thread == null) {
                thread = new Thread(()->{
                    execute(s);
                });
            }
            // end命令终止演示
            if(s.equals("end")){
                runing = false;
                thread.interrupt();
                thread = null;
                System.out.println("当前演示结束");
                continue;
            }
            // 线程开始运行
            thread.start();
        }
    }

    /**
     * 输出提示语
     */
    public static void printMsg() {
        System.out.println("输入 block 进行线程阻塞演示");
        System.out.println("输入 watch 进行watch命令演示");
        System.out.println("输入 cpu 进行cpu飙升演示");
        System.out.println("输入 method 进行方法响应慢演示");
        System.out.println("输入 end 结束当前演示");
        System.out.println("---------------------------");
    }

    /**
     * 根据输入命令执行具体方法
     * @param str
     */
    public static void execute(String str){
        runing = true;

        switch (str) {
            case "block":
                System.out.println("开始演示线程阻塞");
                ThreadBlock block = new ThreadBlock();
                block.block("演示");
                break;
            case "watch":
                int i = 2;
                int j = 3;
                System.out.println("开始演示watch命令，入参" + i + "和" + j + "");
                SheelDemo sheelDemo = new SheelDemo();
                int num = sheelDemo.add(2, 3);
                System.out.println("结束演示watch命令，返回值=" + num);
                break;
            case "cpu":
                System.out.println("开始进行cpu飙升演示");
                CpuDemo cpuDemo = new CpuDemo();
                cpuDemo.high();
                break;
            case "method":
                System.out.println("开始演示方法响应慢");
                MethodDemo methodDemo = new MethodDemo();
                methodDemo.slow();
                break;
            default:
                System.out.println("不支持 " + str + " 命令，请重新输入");
                runing = false;
                thread = null;
                break;
        }
    }
}
