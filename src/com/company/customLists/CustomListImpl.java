package com.company.customLists;

import java.util.HashMap;
import java.util.Map;

public class CustomListImpl{

    private static int counter;
    private Node head;

    public CustomListImpl(){

    }

    // appends the specified element to the end of this list.
    public void add(Object data) {

        Node tempNode = new Node(data);
        Node currentNode = head;

        if(head == null){
            head = tempNode;
        }else{
            if (currentNode != null) {
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(tempNode);
            }
        }
        increaseSize();
    }

    public void append(Object data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }

        // once current.getNext() == null we set the new node to the next
        current.next = new Node(data);
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
        // WARNING THIS METHOD DOES NOT WORK PROPERLY , DOES NOT RETURN LAST VALUE BEFORE NULL
        Node currentNode = head;
        if(head == null){
            System.out.println("Empty");
        }else{
            while(currentNode.next != null){
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

    public void removeDuplicates(Node head){

        // CTCI Chapter 2 Question 1 Answer - they use a doubly linked list and I used a singly linked list
        HashMap<Object, Integer> map = new HashMap<Object, Integer>();

        Node currentNode = head;

        while(currentNode != null){

            int count = map.containsKey(currentNode.data) ? map.get(currentNode.data) : 0;
            map.put(currentNode.data, count + 1);
            currentNode = currentNode.next;

        }

        currentNode = head;

        while(currentNode != null){

            for (Map.Entry mapElement : map.entrySet()) {

                if(mapElement.getKey() == currentNode.data){

                    if((int)mapElement.getValue() > 1){

                        int count = map.get(currentNode.data);
                        map.replace(mapElement.getKey(), count - 1);
                        removeAtData(currentNode.data);


                    }

                }

            }
            currentNode = currentNode.next;
        }

    }

    public Object getKthFromLast(int k){

        Node currentNode = head;

        //check to see whether the k input is greater than the size or not

        if(k == 0){
           while(currentNode != null){
               if(currentNode.next == null){
                   return currentNode.data;
               }
               currentNode = currentNode.next;
           }

        }

        if(k <= getSize()){
            int position = getSize() - k;
            for(int i = 0; i < position; i++){
                currentNode = currentNode.next;
            }

        }else{
            return null;
        }

        return currentNode.data;

    }

    public Node getNodeFromData(Object data){

        Node currentNode = head;

        while(currentNode != null){

            if(currentNode.data == data){
                return currentNode;
            }

            currentNode = currentNode.next;

        }

        return null;
    }

    /*
    this is a recursive version of the print kth element from last
    This requires you to put the head node into the method which
    is not what I usually do, and it doesn't make much sense at the minute
    but hey, fuck it
    */

    public int printKthFromLast(Node head, int k){

        if (head == null) {
            return 0;
        }

        int index = printKthFromLast(head.next, k)+1;

        if(index == k){
            System.out.println("kth last element: " + head.data);
        }

        return index;

    }

    public void removeMid(Node node){

        Node currentNode = node;

        while(currentNode != null){

            currentNode.data = currentNode.next.data;

            if(currentNode.next.next == null){
                currentNode.next = null;
            }

            currentNode = currentNode.next;

        }



    }

    public boolean deleteMidNode(Node n){

        if(n == null || n.next == null){
            return false;
        }


        n.data = n.next.data;
        n.next = n.next.next;

        //this is the way that CTCI author solves the problem
        //I noticed that you could avoid creating a new Node altogether so thats what I did.\

//        Node next = n.next;
//        n.data = next.data;
//        n.next = next.next;

        return true;

    }

    public CustomListImpl partitionList(int x){

        Node currentNode = head;

        CustomListImpl lessThan = new CustomListImpl();
        CustomListImpl greaterThan = new CustomListImpl();

        while(currentNode != null){

            if((int)currentNode.data < x){
                lessThan.add(currentNode.data);
            }else if((int)currentNode.data >= x){
                greaterThan.add(currentNode.data);
            }
            currentNode = currentNode.next;
        }

        if(lessThan.lengthOfList() == 0){
            System.out.println(greaterThan);
            return greaterThan;
        }
        lessThan.appendList(getHead(greaterThan));
        System.out.println(lessThan + " - > " + greaterThan);
        return lessThan;
    }

    private Node getHead(CustomListImpl list){
        return list.head;
    }

    public void appendList(Node listHead){

        Node currentNode = head;

        while(currentNode != null){

            if (currentNode.next == null) {

                currentNode.next = listHead;
                break;

            }
            currentNode = currentNode.next;
        }
    }

    public boolean checkIfPali(){
        return true;
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
