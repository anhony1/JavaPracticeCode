package com.company.CodeChefProblems;

public class atmProblem {

    //HS08TEST - codechef.com

    public static double atmMachine(int amountToWithdrawl, int userBalance){
        if(userBalance % 5 == 0 && userBalance >= amountToWithdrawl+0.5){
            return (userBalance - amountToWithdrawl - 0.5);
        }else{
            return userBalance;
        }
    }


}
