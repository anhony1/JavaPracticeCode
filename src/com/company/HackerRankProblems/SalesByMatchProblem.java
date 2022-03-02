package com.company.HackerRankProblems;

import java.util.HashSet;
import java.util.List;

public class SalesByMatchProblem {


    public static int sockMerchant(int n, List<Integer> arr){

        HashSet<Integer> set = new HashSet<Integer>();

        int pairs = 0;

        for( int i = 0; i < n; i++){

            int cost = arr.get(i);

            if(set.contains(cost)){
                set.remove(cost);
                pairs++;
            }else{
                set.add(cost);
            }


        }

        return pairs;
    }



}
