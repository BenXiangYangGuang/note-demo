package com.wewe.threadArt.utils;

import java.util.concurrent.TimeUnit;

/**
 * Author: wewe
 * Date:  18-9-9 上午9:40
 * Description:
 * Refer To:
 */
public class SleepUtils {

    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
