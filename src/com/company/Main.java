package com.company;
import java.util.Iterator;
import java.util.LinkedList;
import static java.lang.Math.pow;

//experimenting with polymorphism
class Bird{
    public void sing(){
        System.out.println("Tweet");
    }
}

class Robin extends Bird{
    public void sing(){
        System.out.println("Twoot");
    }
}

public class Main {

    public static void main(String[] args) {


    }

    public boolean paliCheckList(LinkedList list){

        return true;


    }

    //CTCI 2.5 -> ssume that the integers are stored backwards
    public static int sumListFromBack(LinkedList listA, LinkedList listB){

        //takes in two lists and sums up the values

         int valueToChange = 1;
         int total = 0;

        Iterator<Integer> iteratorA = listA.iterator();

        while (iteratorA.hasNext()) {

            total = total + (iteratorA.next() * valueToChange);
            valueToChange *= 10;

        }

        valueToChange = 1;

        Iterator<Integer> iteratorB = listB.iterator();

        while (iteratorB.hasNext()){

            total = total + (iteratorB.next() * valueToChange);
            valueToChange *= 10;

        }

        return total;

    }

    //CTCI 2.5 -> assume that the integers are stored foward
    public static int sumListFromFront(LinkedList listA, LinkedList listB){

        //takes in 2 lists and sums up the values

        double total = 0;

        double valueToChangeA = pow(10, listA.size() - 1);
        double valueToChangeB = pow(10, listA.size() - 1);

        Iterator<Integer> iteratorA = listA.iterator();

        while(iteratorA.hasNext()){

            total = total + (iteratorA.next() * valueToChangeA);
            valueToChangeA /= 10;

        }

        Iterator<Integer> iteratorB = listB.iterator();

        while (iteratorB.hasNext()) {

            total = total + (iteratorB.next() * valueToChangeB);
            valueToChangeB /= 10;

        }
        return (int)total;
    }

}
