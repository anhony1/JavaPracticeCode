package com.company;


import com.company.customLists.CustomListImpl;

public class Main {

    public static void main(String[] args) {

        CustomListImpl list = new CustomListImpl();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(0);


        System.out.println("Before partition");
        System.out.println(list);

        list = list.partitionList(6);

        System.out.println("=======");

        System.out.println("After partition");
        System.out.println(list);



    }

}
