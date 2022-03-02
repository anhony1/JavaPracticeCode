package com.company.customDoublyLinkedList;

import com.company.customLists.CustomListImpl;

public class DoublyLinkedList {

    private Node head;
    private static int counter;

    public DoublyLinkedList(){

    }

    public void add(Object data)
    {
        Node tempNode = new Node(data);
        Node currentNode = head;

        if(head == null){
            head = tempNode;
            tempNode.next = null;
        }else{
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = tempNode;
            tempNode.prev = currentNode;
            increaseSize();
        }

    }

    public void prepend(Object data)
    {
        Node newNode = new Node(data);

        newNode.next = head;

        if(head != null){
            head.prev = newNode;
        }

        head = newNode;
        increaseSize();

    }

    public void removeAtData(Object data)
    {
        Node currentNode = head;

        if(head == null){
            return;
        }

        if(head.data == data){
            head = head.next;
            head.prev = null;
            return;
        }

        while(currentNode != null){
            if(currentNode.data == data){
                if(currentNode.next == null){
                    currentNode.prev.next = null;
                }else{
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                decreaseSize();
                return;
            }
            currentNode = currentNode.next;
        }

    }

    public void removeAtIndex(int index)
    {

        if(head == null && index == 1){
            return;
        }

        if(index == 1){
            removeAtData(head.data);
        }

        int currentPosition = 1;
        Node currentNode = head;

        while(currentNode != null){
            currentPosition++;
            currentNode = currentNode.next;

            if(currentPosition == index){
                removeAtData(currentNode.data);
            }

        }


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

    private static class Node{

        Node next;
        Node prev;
        Object data;

        public Node(Object dataValue)
        {
            next = null;
            prev = null;
            data = dataValue;

        }

        public Node(Object dataValue, Node nextNode)
        {
            next = nextNode;
            prev = null;
            data = dataValue;

        }

        public Node(Object dataValue, Node nextNode, Node prevNode)
        {
            next = nextNode;
            prev = prevNode;
            data = dataValue;

        }

        public Object getData()
        {
            return data;
        }

        public void setData(Object dataValue)
        {
            data = dataValue;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext(Node nextNode)
        {
            next = nextNode;
        }

        public Node getPrev()
        {
            return prev;
        }

        public void setPrev(Node prevNode)
        {
            prev = prevNode;
        }

    }


}
