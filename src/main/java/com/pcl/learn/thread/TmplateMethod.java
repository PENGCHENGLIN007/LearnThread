package com.pcl.learn.thread;

/**
 * 模板方法设计模式
 */
public class TmplateMethod {
    public void start(){
        System.out.println("线程启动。。。");
        run();
        System.out.println("线程已经启动了。。。");
    }
    public void run(){

    }

    public static void main(String[] args) {
        TmplateMethod tmplateMethod = new TmplateMethod(){
            @Override
            public void run(){
                System.out.println("执行run方法。。。");

            }
        };

        tmplateMethod.start();
        Sun sun = new Sun();
        sun.start();

    }
}

class Sun extends Thread{
    @Override
    public void start(){
        System.out.println("重写了Start");
    }

}

abstract class Threadd implements Runnable{

}


