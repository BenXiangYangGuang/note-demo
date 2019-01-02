package com.wewe.generic.genericinterface;

import java.util.Random;

/**
 * Created by fei2 on 2018/5/9.
 */
public class AnimalGenerator implements Generator<String > {
    private String[] animals = new String[]{"dog","pig","cat"};
    public String next() {
        Random rand = new Random();
        return animals[rand.nextInt(3)];
    }
}
