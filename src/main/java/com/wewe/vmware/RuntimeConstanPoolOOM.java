package com.wewe.vmware;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: wewe
 * Date:  19-3-23 下午2:49
 * Description:元数据方法区溢出
 * Refer To:
 */
public class RuntimeConstanPoolOOM {
    /**
    String.Intern()是一个Native方法;
    如果字符串常量池存在一个等于string的字符串,则返回代表池中字符串的String对象;否则新建一个String对象放入常量池中,并返回String对象的引用;
    JDK 1.7 已经把运行时常量池移除方法区
    PermGen方法区
    -XX:PermSize=10M -XX:MaxPermSize=10M 设置方法区大小;
    Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
    Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
    -XX:MetaspaceSize=3M -XX:MaxMetaspaceSize=3M
    Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
    方法区主要存放Class相关信息;类名,访问修饰符,常量池,字段描述,方法描述;测试主要通过动态添加大量的类,进行测试;CGLib;
    jdk1.8中，其实已经没有永久代这一说了，取而代之的是一个叫元空间(Meta space)。而常量池放到了堆中，所以也就不会出现PermGen space了
    类的元数据, 字符串池, 类的静态变量将会从永久代移除, 放入Java heap或者native memory. 其中建议JVM的实现中将类的元数据放入native memory, 将字符串池和类的静态变量放入java堆中. 这样可以加载多少类的元数据就不在由MaxPermSize控制, 而由系统的实际可用空间来控制。
*/

    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o,args);
                }
            });
            enhancer.create();
        }

    }
    static class OOMObject{}
}
