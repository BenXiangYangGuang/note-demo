package com.wewe.setExample;

/**
 1) boolean hasPrevious(): 返回该迭代器关联的集合是否还有上一个元素
 2) Object previous(): 返回该迭代器的上一个元素(向前迭代)
 3) void add(): 在指定位置插入一个元素
 */

import java.util.*;

public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {
                "疯狂Java讲义",
                "轻量级Java EE企业应用实战"
        };
        List bookList = new ArrayList();
        for (int i = 0; i < books.length; i++) {
            bookList.add(books[i]);
        }
        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
            lit.add("-------分隔符-------");
        }
        System.out.println("=======下面开始反向迭代=======");
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
        }
    }
}
