package com.wewe.java8.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by fei2 on 2018/5/23.
 * 描述：
 */
public class Java8Tester {
    
    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        
        String name = "Tom";
        
        Integer result = null;
    
        try {
            nashorn.eval("print('"+ name +"')");
            
            result = (Integer) nashorn.eval("10 + 2");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
        System.out.println(result.toString());
    
    
    }
}
