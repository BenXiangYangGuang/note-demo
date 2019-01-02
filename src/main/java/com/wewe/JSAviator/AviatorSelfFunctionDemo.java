package com.wewe.JSAviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fei2 on 2018/5/21.
 * 描述：自定义表达式
 * 参考 ：http://www.aichengxu.com/java/24672282.htm
 */
public class AviatorSelfFunctionDemo {
    
    public static void main(String[] args) {
        AviatorEvaluator.addFunction(new MySumFunction());
        
        String expression = "my_sum(a,b,c)";
    
        Map<String,Object> params = new HashMap<>();
        params.put("a",1);
        params.put("b",3);
        params.put("c",4);
        
        Long result = (Long) AviatorEvaluator.execute(expression,params);
        
        System.out.println("result :" + result);
        
    }
    
    static class MySumFunction extends AbstractFunction{
    
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
            
            Number numA = FunctionUtils.getNumberValue(arg1,env);
            Number numB = FunctionUtils.getNumberValue(arg2,env);
            Number numC = FunctionUtils.getNumberValue(arg3,env);
            
            Long result = numA.longValue() + numB.longValue() + numC.longValue();
            
            return new AviatorLong(result);
            
        }
    
        @Override
        public String getName() {
            return "my_sum";
        }
    }
}
