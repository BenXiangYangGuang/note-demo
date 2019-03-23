package com.wewe.vmware;

/**
 * Author: wewe
 * Date:  19-3-23 下午1:46
 * Description:-Xss128k; 栈溢出
 * Refer To:
 */
public class JavaVMStackSOF {
   /**
    -Xss128k;
    HotSpot虚拟机不区分虚拟机栈和本地方法栈; -Xoss参数无效设置本地方法栈无效;
    StackOverflowError 线程请求的栈深度大于虚拟机所允许的最大深度;
    OutOfMemoryError虚拟机在扩展栈时,无法申请足够的内存空间;
    栈是线程私有的,栈内存大小一定,线程栈的越大,开辟的线程越少;栈帧大小影响着栈的大小;一般1000-2000栈帧没有问题;对于普通的递归操作能过满足;
    */
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e){
            System.out.println("stack length: " + oom.stackLength);
        }

    }
}
