package com.wewe.thredExample.notifyExample;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 今天在群里面看到一个很有意思的面试题：
 “编写两个线程，一个线程打印1~25，另一个线程打印字母A~Z，打印顺序为12A34B56C……5152Z，要求使用线程间的通信。”
 这是一道非常好的面试题，非常能彰显被面者关于多线程的功力，一下子就勾起了我的兴趣。这里抛砖引玉，给出7种想到的解法。
 经典的notify 和 await
 加锁,
    while (不满足)
        阻塞自己
    处理逻辑
    修改状态
    唤醒对方线程
 */
public class NotifyExample{


    public static void main(String[] args) {
        PrintService printService = new PrintService();
            Thread printNumber = new Thread(new PrintNumber(printService),"printNumber");
            Thread printCharacter = new Thread(new PrintCharacter(printService),"printCharacter");
            printNumber.start();
            printCharacter.start();
    }
}

class PrintService{

    Lock lock = new ReentrantLock();
    Condition printNumberCondition =  lock.newCondition();
    Condition printCharacterCondition = lock.newCondition();
    // true 打印数字;false 打印字母
    boolean printNumberFlag = true;

    private final Integer[] numbers = new Integer[]{1,2,3,4,5,6,7,8,9,10};
    private final String [] charaters = new String[]{"A","B","C","D","E","F","G","H","I","J"};
    private final int printSize = numbers.length;


    public void printNumber(){
        lock.lock();
        try {

            for (int i = 0; i < printSize; i++) {
                while (printNumberFlag == false){
                    printNumberCondition.await();
                }
                System.out.println(numbers[i]);
                printNumberFlag = false;
                printCharacterCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printCharacter(){
        lock.lock();
        try {
            for (int i = 0; i < printSize; i++) {
                while (printNumberFlag == true){
                    printCharacterCondition.await();
                }
                System.out.println(charaters[i]);
                printNumberFlag = true;
                printNumberCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}



class PrintNumber implements Runnable{

    private PrintService printService;

    public PrintNumber(PrintService printService) {
        this.printService = printService;
    }

    @Override
    public void run() {
        printService.printNumber();
    }
}

class PrintCharacter implements Runnable{

    private PrintService printService;

    public PrintCharacter(PrintService printService) {
        this.printService = printService;
    }
    @Override
    public void run() {
        printService.printCharacter();
    }
}