package com.wewe.java8.nashorn;

import javax.script.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fei2 on 2018/4/8.
 */
public class JSEngineDemo {
    public static void main(String[] args) {
        //参考文档http://www.cnblogs.com/MMLoveMeMM/articles/3219998.html
      /*  EngineTpye();
        sayHeloWorld();
        passParameter();
        dynamicInvoke();
        javaInterfaceDynamicInvoke();
        ComplishJs();
        //参考文档http://uuhorse.iteye.com/blog/1705684
        useCustomBinding();
        scriptContextBindings();
        useScriptContextValues();
        attributeInBindings();*/
        coparmeString("女");
//        coparmeString("3");
//        coparmeString("30");
    }
    public static void EngineTpye(){
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        for (ScriptEngineFactory f : factories) {
            System.out.println(
                "egine name:"+f.getEngineName()+
                    ",engine version:"+f.getEngineVersion()+
                    ",language name:"+f.getLanguageName()+
                    ",language version:"+f.getLanguageVersion()+
                    ",names:"+f.getNames()+
                    ",mime:"+f.getMimeTypes()+
                    ",extension:"+f.getExtensions());
        }
    }
    public static void sayHeloWorld(){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String script = "print ('hello world')";
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    
    }
    public static void passParameter(){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put("a",4);
        engine.put("b",6);
        try {
            Object maxNum = engine.eval("function max_num(a,b){return (a>b) ? a:b} max_num(a,b);");
            System.out.println("max_num:"+maxNum);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
    public static void dynamicInvoke(){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            engine.eval("function max_num(a,b){return (a>b) ? a:b}");
            Invocable invoke = (Invocable) engine;
            Object maxNum = invoke.invokeFunction("max_num",4,6);
            System.out.println(maxNum);
            maxNum = invoke.invokeFunction("max_num",7,6);
            System.out.println(maxNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    public static void javaInterfaceDynamicInvoke(){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            engine.eval("function max_num(a,b){return (a>b)?a:b;}");
            Invocable invoke = (Invocable)engine;
            JSLib jsLib = invoke.getInterface(JSLib.class);
            int max_Num = jsLib.max_num(4, 5);
            System.out.println(max_Num);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
    
    public static void ComplishJs() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Compilable compEngine = (Compilable) engine;
        try {
            CompiledScript script = compEngine.compile("function max_num(a,b){return (a>b)?a:b}");
            script.eval();
            Invocable invoke = (Invocable) engine;
            Object maxNum = invoke.invokeFunction("max_num",4,6);
            System.out.println(maxNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void useCustomBinding() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        Bindings bindings = new SimpleBindings();
        bindings.put("hobby", "playing games");
        try {
            engine.eval("print('I like ' + hobby);", bindings);
        } catch (ScriptException e) {
        
        
        }
    }
    public static void invokeMethod() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        String scriptText = "var obj = { getGreeting : function(name) { return 'Hello, ' + name; } }; ";
        try {
            engine.eval(scriptText);
            Invocable invocable = (Invocable) engine;
            Object scope = engine.get("obj");
            Object result = invocable.invokeMethod(scope, "getGreeting", "Alex");   //第一个参数为方法所属对象
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void scriptContextBindings(){
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        ScriptContext context = engine.getContext();
        Bindings bindings1 = engine.createBindings();
        bindings1.put("name", "Alex");
        context.setBindings(bindings1, ScriptContext.GLOBAL_SCOPE);
        Bindings bindings2 = engine.createBindings();
        bindings2.put("name", "Bob");
        context.setBindings(bindings2, ScriptContext.ENGINE_SCOPE);
        String script = "print(name);";
        try {
            engine.eval(script);//Bob
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static void useScriptContextValues() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        ScriptContext context = engine.getContext();
        Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
        bindings.put("name", "Alex");
        try {
            engine.eval("print(name);");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
    public static void attributeInBindings() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        ScriptContext context = engine.getContext();
        context.setAttribute("name", "Alex", ScriptContext.GLOBAL_SCOPE);
        try {
            engine.eval("print(name);");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
    public static void coparmeString(String dataValue){
    
        CompiledScript engineC = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        Bindings bindings = new SimpleBindings();
        Map<String,String> map = new HashMap<>();
        map.put("dataV",dataValue);
        String script2 = "dataV > 10";
        bindings.putAll(map);
    
        Compilable compEngine = (Compilable) engine;
    
        try {
            engineC = compEngine.compile(script2);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    
    
        Object result4 = null;
        try {
            result4 = engineC.eval(bindings);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(result4);
        
       
    }
}
