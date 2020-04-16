package com.pcl.learn.thread;

public class DeamonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DeamonThread");
        //当设为守护线程后，main线程结束后，进程里没有了非守护线程，进程退出。
        //thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);
        System.out.println("Main Thread finish it's lifecycle.");
    }
}
