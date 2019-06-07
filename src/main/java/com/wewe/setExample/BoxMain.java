package com.wewe.setExample;

/**
 * Author: fei2
 * Date:  19-6-7 下午10:26
 * Description:  数组 和 链表 的 测试
 * Refer To:
 */
public class BoxMain {

    public static void main(String[] args) {


        Box box = new ArrayBox();
        box.add(1);
        box.add(2);
        box.remove(0);
        box.get(0);

        LinkedBox linkedBox = new LinkedBox();
        linkedBox.add(2);
        linkedBox.add(3);
        linkedBox.add(4);
        linkedBox.add(5);
        linkedBox.remove(1);
        linkedBox.remove(2);

        linkedBox.get(1);

    }


}
