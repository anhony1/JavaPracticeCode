package com.company.customStack;

public class StackLinkedList {

    Node top;
    private static int counter;

    public void push(Object data){

        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        counter++;

    }

    public void pop(){

        if(isEmpty()){
            return;
        }

        top = top.next;
        counter--;

    }

    public void peek(){
        if(isEmpty()){
            return;
        }
        System.out.println(top.data);
    }

    public boolean isEmpty(){
        return (counter == 0);
    }

    private static class Node{

        Node next;
        Object data;

        public Node(Object dataValue){
            next = null;
            data = dataValue;
        }

        public Node(Object dataValue, Node nextNode){
            next = nextNode;
            data = dataValue;
        }

        public Object getData(){
            return data;
        }

        public void setData(Object dataValue){
            data = dataValue;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node nextNode){
            next = nextNode;
        }

    }


}
