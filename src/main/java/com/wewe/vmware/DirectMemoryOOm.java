package com.wewe.vmware;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Author: wewe
 * Date:  19-3-23 下午3:22
 * Description:直接内存溢出
 * Refer To:
 *
 * -Xmx20M -XX:MaxDirectMemorySize=10M
    默认值和堆的大小一样
 */
public class DirectMemoryOOm {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
