package com.pcl.learn.thread;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * 打断阻塞的方法interrupt
 * @author pengchenglin
 */
public class InterruptMethod {
    /**
     * 测试线程的中断方法
     * @throws InterruptedException
     */
    public static void testInterrupt() throws InterruptedException {
        Thread thread = new Thread(()->{
            while(true){

            }
        },"空线程");
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.printf("Thread:"+thread.getName()+" is interrupted ? %s\n",thread.isInterrupted());
        thread.interrupt();
        System.out.printf("Thread:"+thread.getName()+" is interrupted ? %s\n",thread.isInterrupted());
    }

    /**
     * 测试中断线程的sleep阻塞状态，以及sleep被中断后，擦除interrupt标志
     * @throws InterruptedException
     */
    public static void testSleepInterrupt() throws InterruptedException {
        Thread thread = new Thread(()->{
            while(true){
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    System.out.printf("I'm be interrupted? %s\n",Thread.currentThread().isInterrupted());
                }
            }
        },"sleep线程");
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread:"+thread.getName()+" is interrupted ? %s\n",thread.isInterrupted());
        thread.interrupt();
        /**
         * 不加sleep,线程来不及擦除interrupt标志
         */
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread:"+thread.getName()+" is interrupted,after interrupt ? %s\n",thread.isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        testInterrupt();
        testSleepInterrupt();


    }
}
