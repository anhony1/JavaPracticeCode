package com.company.setOfStacks;

import java.util.ArrayList;
import java.util.Stack;

//https://github.com/mirandaio/interview-questions/blob/master/stacks_and_queues/SetOfStacks.java
// ^^^^ -> This is an actual link to a repo that has implemented a stack of "plates"

public class setOfStacks {

    ArrayList<Stack> stacks = new ArrayList<>();
    Integer capacity;

    public setOfStacks(ArrayList<Stack> stacks, Integer capactiy) {
        this.stacks = stacks;
        this.capacity = capactiy;
    }

    public Stack<String> getLastStack(){

        if(stacks.isEmpty()){
            return null;
        }

        return stacks.get(stacks.size() - 1);

    }

    public void push(int v){
        Stack last = getLastStack();
        if( last != null && isFull(last)){
            last.push(v);
        }else{
            Stack stack = new Stack();
            stack.push(v);
            stacks.add(stack);

        }


    }

    public boolean isFull(Stack stack) {
         return stack.size() == capacity;
    }


}
