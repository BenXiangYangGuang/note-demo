package com.wewe.gengeral;

import java.net.URL;

/**
 * @Author: fei2
 * @Date:2018/6/20 09:36
 * @Description: 获取资源目录
 * @Refer To:https://zm8.sm-tc.cn/?src=l4uLj4zF0NCdk5CY0ZyMm5HRkZqL0J2Wi5yejZKekZOamtCejYuWnJOa0Juai56Wk4zQyM7PysjNzck%3D&uid=182293090ef7288fa31e39561de4f85f&hid=e6ce933cf4dab10536cf9f17e224d4c4&pos=1&cid=9&time=1529454763824&from=click&restype=1&pagetype=0020004000000402&bu=news_natural&query=java%E8%8E%B7%E5%8F%96%E8%B5%84%E6%BA%90%E6%96%87%E4%BB%B6%E7%9B%AE%E5%BD%95&mode=&v=1&force=true&wap=false&uc_param_str=dnntnwvepffrgibijbprsvdsdichei
 * 参考：https://blog.csdn.net/dudefu011/article/details/49911287
 * 参考：http://uule.iteye.com/blog/2262642
 */
public class ResourceLoaderDemo {
    
    public static void main(String[] args) {
        /*getClassLoaderDemo();
        getResourceDemo();
        getSystemPath();
        getPath();*/
//        getSourceFilePath();
        getSystemPath();
    }
    
    public static void getClassLoaderDemo(){
        String path = ResourceLoaderDemo.class.getClassLoader().getResource("").getPath();
        //得到资源路径：/D:/IdeaProjects/springdemo/security/target/classes/
        System.out.println("得到资源路径：" +path);
        
        String fileStr = path + "conf/krb5.conf";
    
    }
    
    /**
     * 需要注意的就是，如果使用Class.getResource方法，入参为空的时候，是 当前.class文件的路径；而当入参为”/”的时候，是从根目录开始查找！
     */
    public static void getResourceDemo(){
        String path = ResourceLoaderDemo.class.getResource("").getPath();
        System.out.println("得到资源路径：" +path);
        
        String path2  = ResourceLoaderDemo.class.getResource("/").getPath();
        System.out.println("得到资源路径：" +path2);
    
    }
    
    public static void getSystemPath(){
        //得到资源路径：D:\IdeaProjects\springdemo
        String path = System.getProperty("user.dir"); // 获得项目根目录的绝对路径
        System.out.println("得到资源路径：" +path);
        //得到资源路径：E:\Java\jdk1.8.0_91\jre\lib\charsets.jar;E:\Java\jdk1.8.0_91\jre\lib\deploy.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\access-bridge-64.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\cldrdata.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\dnsns.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\jaccess.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\jfxrt.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\localedata.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\nashorn.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\sunec.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\sunjce_provider.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\sunmscapi.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\sunpkcs11.jar;E:\Java\jdk1.8.0_91\jre\lib\ext\zipfs.jar;E:\Java\jdk1.8.0_91\jre\lib\javaws.jar;E:\Java\jdk1.8.0_91\jre\lib\jce.jar;E:\Java\jdk1.8.0_91\jre\lib\jfr.jar;E:\Java\jdk1.8.0_91\jre\lib\jfxswt.jar;E:\Java\jdk1.8.0_91\jre\lib\jsse.jar;E:\Java\jdk1.8.0_91\jre\lib\management-agent.jar;E:\Java\jdk1.8.0_91\jre\lib\plugin.jar;E:\Java\jdk1.8.0_91\jre\lib\resources.jar;E:\Java\jdk1.8.0_91\jre\lib\rt.jar;D:\IdeaProjects\springdemo\security\target\classes;D:\maven\repository\org\springframework\boot\spring-boot-starter\1.5.13.RELEASE\spring-boot-starter-1.5.13.RELEASE.jar;D:\maven\repository\org\springframework\boot\spring-boot\1.5.13.RELEASE\spring-boot-1.5.13.RELEASE.jar;D:\maven\repository\org\springframework\spring-context\4.3.17.RELEASE\spring-context-4.3.17.RELEASE.jar;D:\maven\repository\org\springframework\boot\spring-boot-autoconfigure\1.5.13.RELEASE\spring-boot-autoconfigure-1.5.13.RELEASE.jar;D:\maven\repository\org\springframework\boot\spring-boot-starter-logging\1.5.13.RELEASE\spring-boot-starter-logging-1.5.13.RELEASE.jar;D:\maven\repository\ch\qos\logback\logback-classic\1.1.11\logback-classic-1.1.11.jar;D:\maven\repository\ch\qos\logback\logback-core\1.1.11\logback-core-1.1.11.jar;D:\maven\repository\org\slf4j\jcl-over-slf4j\1.7.25\jcl-over-slf4j-1.7.25.jar;D:\maven\repository\org\slf4j\jul-to-slf4j\1.7.25\jul-to-slf4j-1.7.25.jar;D:\maven\repository\org\slf4j\log4j-over-slf4j\1.7.25\log4j-over-slf4j-1.7.25.jar;D:\maven\repository\org\springframework\spring-core\4.3.17.RELEASE\spring-core-4.3.17.RELEASE.jar;D:\maven\repository\org\yaml\snakeyaml\1.17\snakeyaml-1.17.jar;D:\maven\repository\org\springframework\boot\spring-boot-starter-web\1.5.13.RELEASE\spring-boot-starter-web-1.5.13.RELEASE.jar;D:\maven\repository\org\springframework\boot\spring-boot-starter-tomcat\1.5.13.RELEASE\spring-boot-starter-tomcat-1.5.13.RELEASE.jar;D:\maven\repository\org\apache\tomcat\embed\tomcat-embed-core\8.5.31\tomcat-embed-core-8.5.31.jar;D:\maven\repository\org\apache\tomcat\tomcat-annotations-api\8.5.31\tomcat-annotations-api-8.5.31.jar;D:\maven\repository\org\apache\tomcat\embed\tomcat-embed-el\8.5.31\tomcat-embed-el-8.5.31.jar;D:\maven\repository\org\apache\tomcat\embed\tomcat-embed-websocket\8.5.31\tomcat-embed-websocket-8.5.31.jar;D:\maven\repository\org\hibernate\hibernate-validator\5.3.6.Final\hibernate-validator-5.3.6.Final.jar;D:\maven\repository\javax\validation\validation-api\1.1.0.Final\validation-api-1.1.0.Final.jar;D:\maven\repository\org\jboss\logging\jboss-logging\3.3.2.Final\jboss-logging-3.3.2.Final.jar;D:\maven\repository\com\fasterxml\classmate\1.3.4\classmate-1.3.4.jar;D:\maven\repository\com\fasterxml\jackson\core\jackson-databind\2.8.11.1\jackson-databind-2.8.11.1.jar;D:\maven\repository\com\fasterxml\jackson\core\jackson-annotations\2.8.0\jackson-annotations-2.8.0.jar;D:\maven\repository\com\fasterxml\jackson\core\jackson-core\2.8.11\jackson-core-2.8.11.jar;D:\maven\repository\org\springframework\spring-web\4.3.17.RELEASE\spring-web-4.3.17.RELEASE.jar;D:\maven\repository\org\springframework\spring-aop\4.3.17.RELEASE\spring-aop-4.3.17.RELEASE.jar;D:\maven\repository\org\springframework\spring-beans\4.3.17.RELEASE\spring-beans-4.3.17.RELEASE.jar;D:\maven\repository\org\springframework\spring-webmvc\4.3.17.RELEASE\spring-webmvc-4.3.17.RELEASE.jar;D:\maven\repository\org\springframework\spring-expression\4.3.17.RELEASE\spring-expression-4.3.17.RELEASE.jar;D:\maven\repository\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;D:\IntelliJ IDEA 2017.1.4\lib\idea_rt.jar
        String path2 =  System.getProperty("java.class.path"); //得到类路径和包路径
        System.out.println("得到资源路径：" +path2);
    }
    
    public static void getPath(){
        //file:/D:/IdeaProjects/springdemo/security/target/classes/
        URL path = Thread.currentThread().getContextClassLoader().getResource(""); //获得资源文件(.class文件)所在路径
        System.out.println(path.toString());
        //file:/D:/IdeaProjects/springdemo/security/target/classes/
        URL path2 = ClassLoader.getSystemResource("");
        System.out.println(path2.toString());
    }
    
    /**
     * getContextClassLoader() 和 getClassLoader()中的getResource() 中不包含根目录
     * 参考：http://codepub.cn/2015/04/22/How-to-load-resource-file-in-a-Jar-package-correctly/
     *
     */
    public static void getSourceFilePath(){
        
        //空指针异常
        //getContextClassLoader 不能有根目录
        URL url3 =  Thread.currentThread().getContextClassLoader().getResource("/");
        //空指针异常没有此文件
        URL url4 =  Thread.currentThread().getContextClassLoader().getResource("/rule-engine.properties");
        //D:/IdeaProjects/springdemo/security/target/classes/
        URL url =  Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println(url.getPath());
        ///D:/IdeaProjects/springdemo/security/target/classes/rule-engine.properties
        URL url2 =  Thread.currentThread().getContextClassLoader().getResource("rule-engine.properties");
        System.out.println(url2.getPath());
        // /D:/IdeaProjects/springdemo/security/target/classes/
        URL url5 = ResourceLoaderDemo.class.getResource("/");
        System.out.println(url5.getPath());
        // /D:/IdeaProjects/springdemo/security/target/classes/
        URL url6 = ResourceLoaderDemo.class.getClassLoader().getResource("");
        System.out.println(url6.getPath());
        //空指针异常
       /* URL url7 = ResourceLoaderDemo.class.getClassLoader().getResource("/");
        System.out.println(url7.getPath());*/
    
    }

}
