package com.company.customQueue;

public class QueueLinkedList {

    Node front, back;
    private static int counter;

    public void enqueue(Object data){

        Node newNode = new Node(data);

        if(isEmpty()){
            front = newNode;
        }else{
            back.next = newNode;
        }
        back = newNode;
        counter++;
    }

    public void dequeue(){

        if(isEmpty()){
            return;
        }else if(front.next == null){
            back = null;
        }
        front = front.next;
        counter--;
    }

    public void peek(){

        if(!isEmpty()){
            System.out.println(front.data);
        }

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
