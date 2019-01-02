package com.wewe.annotationExample;

/**
 * Author: wewe
 * Date:  18-8-18 上午11:12
 * Description:组件的使用
 * Refer To:
 */
public class Client {
    public static void main(String[] args) {
        try {
            Class componentClass = Class.forName("com.wewe.annotationExample.UpperCaseComponent");
            if (componentClass.isAnnotationPresent(Component.class)){
                Component component = (Component) componentClass.getAnnotation(Component.class);
                String identifier = component.identifier();
                System.out.println(String.format("Identifier for com.wewe.annotationExample.UpperCaseComponent '%s'",identifier));
            } else {
                System.out.println("com.jasongj.UpperCaseComponent is not annotated by"
                        + " com.jasongj.annotation.Component");

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
