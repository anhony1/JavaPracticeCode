package com.company.arrayStack;

import java.util.EmptyStackException;

public class arrayStack{

    // #3.1 CTCI
    // in this exercise I need to figure out how to create 3 stacks while using only one array

    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public arrayStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) throws FullStackException {

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0; //clear
        sizes[stackNum]--; //shrink array
        return value;
    }

    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    private static class FullStackException extends Exception {
        private String fullStackException(){
            return("stack full");
        }
    }
}
