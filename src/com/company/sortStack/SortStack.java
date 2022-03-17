package com.company.sortStack;

import java.util.Stack;

public class SortStack {

    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();

    public SortStack() {

    }

    @Override
    public String toString() {
        return "SortStack{" +
                "st1=" + st1 +
                ", st2=" + st2 +
                '}';
    }

    public void add(Integer input){

        //if th
        if(st1.isEmpty()){
            st1.add(input);
            return;
        }

        if(st1.peek() > input){

            while(!st1.isEmpty()){

                if(st1.peek() > input){
                    st2.add(st1.pop());
                }else{
                    st1.add(input);
                    while(!st2.isEmpty()){
                        st1.add(st2.pop());
                    }
                    break;
                }

            }

        }else{
            st1.add(input);
        }

        if(st1.isEmpty()){
            st1.add(input);
            while(!st2.isEmpty()){
                st1.add(st2.pop());
            }
        }


    }

    public void remove(){


    }

}
