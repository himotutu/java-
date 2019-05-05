package com.qhit.test.linkedlist;


/**
 * Created by lenovo on 2019/4/28.
 */
public class MyLinkedList {

    MyLinkedList(){
        headNode = new Node();
        nullPoint=headNode;
    }

    private Node headNode;
    private int size=0;
    private Node nullPoint;

    public int size(){
        return size;
    }

    public Node find(int index){

//        if (index>size && index<0){
//            return null;
//        }
        Node next = headNode.getNext();
        if (next==null){
            return headNode;
        }
        for (int i = 1; i <= index; i++) {
            next = next.getNext();
        }
        return next;
    }

    public void add(Object data){
        Node node = new Node(data);
//        Node preNode = find(size-1);
        nullPoint.setNext(node);
        nullPoint = node;
        size++;
    }

    public Object get(int index){
        Node node = find(index);
        if (node!=null){
            return node.getData();
        }
        return null;
    }
}
