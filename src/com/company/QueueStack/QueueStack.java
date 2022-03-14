package com.company.QueueStack;

import java.util.Stack;

public class QueueStack {

    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public QueueStack() {

    }

    public boolean enqueue(int value){

        while(!st1.isEmpty()){
            st2.add(st1.pop());
        }

        st2.add(value);

        while(!st2.isEmpty()){
            st1.add(st2.pop());
        }

        return true;
    }


    public boolean dequeue(){

        while(!st1.isEmpty()){
            st2.add(st1.pop());
        }

        st2.pop();

        while (!st2.isEmpty()){
            st1.add(st2.pop());
        }

        return true;
    }

    @Override
    public String toString() {
        return "QueueStack{" + "st1=" + st1 + '}';
    }
}
