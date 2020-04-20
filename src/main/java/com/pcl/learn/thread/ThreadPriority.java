package com.pcl.learn.thread;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (true){
                System.out.println("t1");
            }
        }
        );
        Thread t2 = new Thread(()->{
            while (true){
                System.out.println("t2");
            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}
