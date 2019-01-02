package com.wewe.setExample;

import java.util.HashSet;

/**
 * Author: fei2
 * Date:  18-9-5 下午4:46
 * Description:  底层使用hash表来实现
 *
 * 两个对象的相等通过equals(),判断
 * 根据两个对象的hashCode值，将这两个对象保存到Hash表中的不同位置
 *
 * 如果两个对象的equals() 返回true；对象的hashCode() 返回的不同的hashCode值时，
 * 这将导致HashSet会把这两个对象保存在Hash表中的不同位置，从而是使对象添加成功。
 * 这就和Set集合的规则有出入了。
 *
 * 如果hashCode相同，equals返回值不同。HashSet会在这个位置用链式结构来保存多个对象。
 * HashSet访问集合元素时也是根据元素的HashCode值来快速定位的，这种链式结构会导致性能下降。
 *
 * 保证对象的equals()方法返回true；hashCode()返回值也相等。
 *
 * Refer To:
 * https://www.jb51.net/article/73949.htm
 * https://blog.csdn.net/qq_21163061/article/details/73606523
 */
class A {
    public boolean equals(Object obj) {
        return true;
    }
}

//类B的hashCode()方法总是返回1,但没有重写其equals()方法。不能保证当前对象是HashSet中的唯一对象
class B {
    public int hashCode() {
        return 1;
    }
}

//类C的hashCode()方法总是返回2,且有重写其equals()方法
class C {
    public int hashCode() {
        return 2;
    }

    public boolean equals(Object obj) {
        return true;
    }
}

public class HashSetTest {
    public static void main(String[] args) {
        HashSet books = new HashSet();
        //分别向books集合中添加两个A对象，两个B对象，两个C对象
        books.add(new A());
        books.add(new A());

        books.add(new B());
        books.add(new B());

        books.add(new CurrentTimeMillsProduct());
        books.add(new CurrentTimeMillsProduct());
        System.out.println(books);

    }
}