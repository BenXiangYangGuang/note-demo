package com.wewe.algorithmExam;


/**
 * Author: fei2
 * Date:  19-6-12 下午10:56
 * Description:
 * Refer To:
 */
public class LinkedListRevert {

    public static void main(String[] args) {
        NodeExample n1 = new NodeExample(1,null);
        NodeExample n2 = new NodeExample(2,null);
        NodeExample n3 = new NodeExample(3,null);
        NodeExample n4 = new NodeExample(4,null);
        NodeExample n5 = new NodeExample(5,null);
        NodeExample n6 = new NodeExample(6,null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        NodeExample head = n1;
/*        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }*/
        NodeExample tail = revert(head);

        while (tail != null){
            System.out.println(tail.value);
            tail = tail.next;
        }
    }

    /**
     * 链表逆序
     *
     * @param head
     * @return
     */

    private static NodeExample revert(NodeExample head){
        if (head == null){
            return null;
        }

        NodeExample cur = head;
        NodeExample pre = null;
        NodeExample post = null;

        while (cur!=null){
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;

    }


    private static final class NodeExample{
        private int value;
        private NodeExample next;

        public NodeExample(int value, NodeExample next) {
            this.value = value;
            this.next = next;
        }
    }
}


