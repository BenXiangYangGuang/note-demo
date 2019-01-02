package com.wewe.gengeral;

/**
 * @Author: fei2
 * @Date:2018/6/7 13:32
 * @Description: 测试一个类里面的变量，两个线程是不会相互影响的
 * @Refer To:
 */
public class ThreadVar {
    public static void main(String[] args) throws InterruptedException {
        
        MyThread myThread1 = new MyThread(1,true);
        MyThread myThread2 = new MyThread(2,true);
        
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        myThread1.setFlag(false);
        
    }
    static class MyThread implements Runnable{
        
        private int id;
        private boolean flag;
    
        public boolean isFlag() {
            return flag;
        }
    
        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    
        public MyThread(int id, boolean flag) {
            this.id = id;
            this.flag = flag;
        }
    
        @Override
        public void run() {
            while (true) {
                if(flag){
                    System.out.println("线程id:" + id + "flag 为" + flag);
                }
            }
        }
    }
}
