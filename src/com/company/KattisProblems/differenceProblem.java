package com.company.KattisProblems;

import java.util.Scanner;

public class differenceProblem {

    public static void main(){

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLong()){
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(Math.abs(a-b));
        }


    }

}
