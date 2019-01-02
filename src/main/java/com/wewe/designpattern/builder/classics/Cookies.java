package com.wewe.designpattern.builder.classics;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：
 * 参考：https://www.jianshu.com/p/1ddb69f1f67e
 */
public class Cookies {
    private String shape;
    
    public String getShape(){
        return shape;
    }
    
    public void setShape(String shape){
        this.shape = shape;
    }
    
    @Override
    public String toString() {
        return "Cookies{" +
            "shape='" + shape + '\'' +
            '}';
    }
}
