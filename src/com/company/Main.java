package com.company;


import com.company.customLists.CustomListImpl;

public class Main {

    public static void main(String[] args) {

        CustomListImpl list = new CustomListImpl();

        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");

        System.out.println("Before removal");
        System.out.println("Result" + list.toString());

        list.removeMid(list.getNodeFromData("String3"));

        System.out.println("=======");

        System.out.println("After removal");
        System.out.println("Result" + list.toString());



    }

}
