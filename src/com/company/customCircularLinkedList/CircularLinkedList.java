package com.company.customCircularLinkedList;

import com.company.customLists.CustomListImpl;

public class CircularLinkedList {

    //BROKEN

    private static int counter;
    private Node head;
    private Node tail;

    public CircularLinkedList(){

    }

    // appends the specified element to the end of this list.
    public void add(Object data) {

        Node tempNode = new Node(data);
        Node currentNode = head;

        increaseSize();
    }

    public void append(Object data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        // once current.getNext() == null we set the new node to the next
        currentNode.next = new Node(data);
        currentNode.next.next = head;

    }

    public void prepend(Object data){

        Node newHead = new Node(data);
        newHead.setNext(head);
        head = newHead;

    }

    private static void increaseSize(){
        counter++;
    }

    private static void decreaseSize(){
        counter--;
    }

    private static int getSize(){
        return counter;
    }

    public void removeAtIndex(int index){

        if(index < 0 || index >= getSize()){
            System.out.println("removeAtGivenIndex Size Error");
            return;
        }
        if(index == 0){
            head = head.getNext();
        }else{
            Node currentNode = head;
            for(int i = 0; i < index - 1; i++){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        decreaseSize();
    }


    public void removeAtData(Object data){

        if(head == null){
            return;
        }

        if(head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void printList(){
        Node currentNode = head;
        if(head == null){
            System.out.println("Empty");
        }else{
            while(currentNode.next != head){
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }

    }

    public String toString(){
        String result = "";
        Node currentNode = head;
        while(currentNode.getNext() != null){
            result += currentNode.getData();
            if(currentNode.getNext() != null){
                result += ", ";
            }
            currentNode = currentNode.getNext();
        }
        result += currentNode.getData();
        return "Contents of the List: " + result;
    }

    public int lengthOfList(){

        Node currentNode = head;
        int count = 0;
        while(currentNode != null){
            currentNode = currentNode.next;
            count++;
        }
        return count;
    }


    private class Node{
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
