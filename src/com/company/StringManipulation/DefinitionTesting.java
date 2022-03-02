package com.company.StringManipulation;

import java.util.LinkedList;
import java.util.List;

public class DefinitionTesting {

    static List<String> test = new LinkedList<String>();

    String test1[] = {"abound", "amorphous", "austere", "belie", "capricious",
            "cerebral", "congenial", "conspicuous", "cursory", "daunting", "deify",
            "didactic", "disseminate", "feasible", "flout", "homogeneous", "humdrum",
            "insipid", "loquacious", "misanthropic", "misnomer", "negligent", "obsequious",
            "placate", "proclivity", "puerile", "quixotic", "spendthrift", "taciturn", "wary"};

    public static void stringManiuplation(String[] wordList){

        for(int i = 0; i < wordList.length; i++){
            test.add(wordList[i]);
        }

        System.out.println(test.contains("abound"));

    }



}
