package com.qhit.test.linkedlist;

/**
 * Created by Administrator on 2019-4-27 0027.
 */
// 单链表
public class Node {

    private Object data;
    private Node next;

    public Node(Object data) {
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node() {

    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
