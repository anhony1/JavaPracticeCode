package com.company.AnimalShelter;

import java.util.LinkedList;

public class AnimalShelter {

    public AnimalShelter() {

    }

    LinkedList<Integer> list = new LinkedList<Integer>();

    public void enqueue(Integer value){
        list.add(value);
    }

    public int dequeueAny(){
        Integer temp = list.getFirst();
        list.remove(temp);
        return temp;
    }

    public int dequeueDog(){
        for(Integer value : list){
            if(value.equals(1)){
                var temp = value;
                list.remove(temp);
                return temp;
            }
        }
        return -1;
    }

    public int dequeueCat(){
        for(Integer value : list){
            if(value.equals(0)){
                var temp = value;
                list.remove(temp);
                return temp;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "AnimalShelter{" +
                "list=" + list +
                '}';
    }
}
