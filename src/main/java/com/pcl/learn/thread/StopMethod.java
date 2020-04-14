package com.pcl.learn.thread;

/**
 * stop方法
 *
 * @author pengchenglin
 * @create 2020-04-13 17:43
 */
public class StopMethod {

    public static User user = new User();

    public static class User{
        private int id;
        private String name;

        public User(){
            id = 0;
            name = "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }




    }

    public static class  ChangeObjectThread extends Thread{
        @Override
        public void run(){
            while (true){

                synchronized (user){
                    int v = (int) (System.currentTimeMillis()/1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                //它让掉当前线程 CPU 的时间片，使正在运行中的线程重新变成就绪状态，
                // 并重新竞争 CPU 的调度权。它可能会获取到，也有可能被其他线程获取到
                Thread.yield();
            }


        }

    }

    public static class ReadObjectThread extends Thread{

        @Override
        public void run(){
            while (true){
                synchronized(user){
                    try{
                        if( user.getId()!=Integer.parseInt(user.getName())){
                            System.out.println(user.toString());
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true){
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            t.stop();
        }

    }
}


