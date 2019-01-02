package com.wewe.annotationExample;

/**
 * Author: wewe
 * Date:  18-8-18 上午11:10
 * Description:组件;作用是给注解上加上一个标示,从而知道实例化了哪个子类
 * 在实际项目中，经常会碰到下面这种场景，一个接口的实现类或者抽象类的子类很多，
 * 经常需要根据不同情况（比如根据配置文件）实例化并使用不同的子类。
 * 典型的例子是结合工厂使用职责链模式。
 * Refer To:
 */
@Component(identifier = "upper")
public class UpperCaseComponent {

    public String doWork(String input){
        if (input != null){
            return input.toUpperCase();
        } else {
           return null;
        }
    }
}
