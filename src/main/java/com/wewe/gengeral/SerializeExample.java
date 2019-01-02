package com.wewe.gengeral;

import java.io.*;
import java.util.Date;

/**
 * Author: fei2
 * Date:  18-8-1 上午11:27
 * Description: 对象实例的序列化和反序列化
 * Refer To: http://swiftlet.net/archives/1268
 * https://blog.csdn.net/gengkunpeng/article/details/5980435
 * https://blog.csdn.net/yangxiangyuibm/article/details/43227457
 */
public class SerializeExample {
    /**
     * java 内存资源是有限的;
     * 对象实例序列化到磁盘;
     * 对象实例经过网络传输
     * transient  短暂的  修饰的字段不会被序列化
     * 静态变量不会被序列化；静态变量属于全局变量；不属于对象；所以不会被序列化；
     * 输出后：如果有值，只是因为去全局变量区里面查找了。
     *
     * @param args
     */
    public static void main(String[] args) {

        serialize("/home/wewe/userinfo.txt");
        System.out.println("序列化完毕");

        deserialize("/home/wewe/userinfo.txt");
        System.out.println("反序列化完毕");
    }

    //序列化对象到文件
    public static void serialize(String fileName) {
        try {
            //创建一个对象输出流，讲对象输出到文件
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));


            UserInfo user = new UserInfo("renyanwei", "888888", 20);
            out.writeObject(user);  //序列化一个会员对象

            out.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }

    }

    //从文件反序列化到对象
    public static void deserialize(String fileName) {
        try {
            //创建一个对象输入流，从文件读取对象
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

            //注意读对象时必须按照序列化对象顺序读，否则会出错
            //读取字符串
           /* String today = (String) (in.readObject());
            System.out.println(today);

            //读取日期对象
            Date date = (Date) (in.readObject());
            System.out.println(date.toString());*/

            //读取UserInfo对象并调用它的toString()方法
            UserInfo user = (UserInfo) (in.readObject());
            System.out.println(user.toString());

            in.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }


    }
}
class UserInfo implements Serializable {
    /**
     * 一是默认的1L，比如：private static final long serialVersionUID = 1L;
     * 二是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段，比如：
     * private static final  long   serialVersionUID = xxxxL;
     */
    /**
     * 当实现java.io.Serializable接口的类没有显式地定义一个serialVersionUID变量时候，
     * Java序列化机制会根据编译的Class自动生成一个serialVersionUID作序列化版本比较用，
     * 这种情况下，如果Class文件(类名，方法明等)没有发生变化(增加空格，换行，增加注释等等)，
     * 就算再编译多次，serialVersionUID也不会变化的。

     * 如果我们不希望通过编译来强制划分软件版本，
     * 即实现序列化接口的实体能够兼容先前版本，
     * 就需要显式地定义一个名为serialVersionUID，类型为long的变量，
     * 不修改这个变量值的序列化实体都可以相互进行串行化和反串行化。
     */
    //不一致;否则就会出现序列化版本不一致的异常，即是InvalidCastException。
    //进行反序列化的验证标志
    private static final  long   serialVersionUID = 1L;

    public static String userName;
    public String userPass;
    //注意，userAge变量前面的transient
    public transient int userAge;

    public UserInfo() {
    }

    public UserInfo(String username, String userpass, int userage) {
        this.userName = username;
        this.userPass = userpass;
        this.userAge = userage;
    }

    public String toString() {
        return "用户名: " + this.userName + ";密码：" + this.userPass +
                ";年龄：" + this.userAge;
    }

}
