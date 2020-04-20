package com.pcl.learn.thread;

import java.util.concurrent.TimeUnit;

/**
 * sleep方法的使用
 */
public class SleepMethod {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.DAYS.sleep(1);
                TimeUnit.HOURS.sleep(10);
                TimeUnit.MINUTES.sleep(10);
                TimeUnit.SECONDS.sleep(12);
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
