package com.company.HackerRankProblems;

public class countingValleys {

    public static int countingValleys(int steps, String path){

        int sealevel = 0;
        int valley = 0;
        for(int i = 0; i < path.length(); i++){

            if(path.charAt(i) == 'D'){

                sealevel--;

            }else if(path.charAt(i) == 'U'){

                sealevel++;

            }
            if(sealevel == 0){
                if(path.charAt(i) == 'U'){
                    valley++;
                }
            }

        }

        return valley;

    }


}
