package com.company;
import com.company.arrayStack.arrayStack;
import com.company.customCircularLinkedList.CircularLinkedList;

import java.util.HashSet;
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

    public static int binarySearchMethod(int[] array){

        return 0;
    }

    public static Object testMethod(Object node){
     return node;
    }

    // CTCI 2.7 -> checking if two lists have a node in which they intersect at
    public static boolean intersectCheck(LinkedList<String> list1, LinkedList<String> list2){

        Iterator<String> it1 = list1.iterator();
        Iterator<String> it2 = list2.iterator();

        HashSet<String> set = new HashSet<>();

        while(it1.hasNext()){
            set.add(it1.next());
        }

        while(it2.hasNext()){

            if(set.contains(it2.next())){
                return true;
            }

        }

        return false;

    }

    // CTCI 2.6 -> palindrome checker
    public static boolean paliCheckList(LinkedList<String> list){

        LinkedList<String> revList = new LinkedList<>();

        Iterator<String> listIt = list.descendingIterator();

        while(listIt.hasNext()){
            revList.add(listIt.next());
        }

        //compare list and revList

        return compareLists(list, revList);

    }

    public static boolean compareLists(LinkedList<String> list1, LinkedList<String>  list2){

        Iterator<String> list1It = list1.iterator();
        Iterator<String> list2It = list2.iterator();

        while(list1It.hasNext() && list2It.hasNext()){
            if(!list1It.next().equals(list2It.next())){
                return false;
            }
        }
        return true;
    }

    //CTCI 2.5 -> assume that the integers are stored backwards
    public static int sumListFromBack(LinkedList<Integer> listA, LinkedList<Integer> listB){

        //takes in two lists and sums up the values

         int valueToChange = 1;
         int total = 0;

        for (Integer value : listA) {

            total = total + (value * valueToChange);
            valueToChange *= 10;

        }

        valueToChange = 1;

        for (Integer integer : listB) {

            total = total + (integer * valueToChange);
            valueToChange *= 10;

        }

        return total;

    }

    //CTCI 2.5 -> assume that the integers are stored foward
    public static int sumListFromFront(LinkedList<Integer> listA, LinkedList<Integer> listB){

        //takes in 2 lists and sums up the values

        double total = 0;

        double valueToChangeA = pow(10, listA.size() - 1);
        double valueToChangeB = pow(10, listA.size() - 1);

        for (Integer integer : listA) {

            total = total + (integer * valueToChangeA);
            valueToChangeA /= 10;

        }

        for (Integer integer : listB) {

            total = total + (integer * valueToChangeB);
            valueToChangeB /= 10;

        }
        return (int)total;
    }

}
