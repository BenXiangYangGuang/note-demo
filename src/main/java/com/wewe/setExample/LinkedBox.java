package com.wewe.setExample;

/**
 * Author: fei2
 * Date:  19-6-7 下午6:49
 * Description:
 * Refer To:
 */
public class LinkedBox implements Box{

    private Node head;
    private Node tail;

    private int size;

    private void linkLast(int element){
        Node t = tail;

        Node newNode = new Node(element,t,null);

        tail = newNode;

        if (t == null){
            head = newNode;
        } else {
            t.next = newNode;
        }
        size++;

    }
    private Node node(int index){
        Node targetNode;

        if(index < (size>>1)){
            targetNode = head;
            //    2
            //1 2 3 4 5
            for (int i = 0; i <index; i++){ //从头部开始查找
                targetNode = targetNode.next;
            }
        } else {
            targetNode = tail;
            for (int i = size - 1; i > index; i--){ //从尾部开始查找
                targetNode = targetNode.prev;
            }
        }
        return targetNode;
    }
    private int unLink(Node targetNode){

        Node prev = targetNode.prev;
        Node next = targetNode.next;

        if (prev == null){ //我就是头结点
            head = next;
        } else{
            prev.next = next;
            targetNode.prev = null;
        }

        if (next == null){ //我就是尾节点
            tail = prev;
        }else {
            //把prev节点赋值给next节点的prev
            next.prev = prev;
            targetNode.next = null;
        }
        size--;
        return targetNode.element;
    }
    @Override
    public boolean add(int element) {
        this.linkLast(element);
        return true;
    }

    @Override
    public int remove(int index) {
        this.rangeCheck(index);
        Node targetNode = node(index);
        int oldValue = unLink(targetNode);
        return oldValue ;
    }

    @Override
    public int get(int index) {
        this.rangeCheck(index);
        Node targetNode = this.node(index);
        return targetNode.element;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node{
        int element;
        Node prev;
        Node next;
        public Node(int element,Node prev,Node next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
    private void rangeCheck(int index){
        if (index < 0 || index >= size){
            throw new ArrayOutOfBoundsException("index:" + index + ",size:" + size);
        }
    }

}
