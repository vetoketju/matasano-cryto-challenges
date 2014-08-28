package com.villevalta.cryptopals.lib;

import java.util.HashMap;

/**
 * Created by ville on 8/14/2014.
 */
public class LetterFrequency {

    private static final String ETAOIN = "etaoinshrdlcumwfgypbvkjxqz";
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static HashMap<Character,Double> engLetterFreq(){
        HashMap<Character,Double> result = new HashMap<Character,Double>();
        result.put('a',8.167);
        result.put('b',1.492);
        result.put('c',2.782);
        result.put('d',4.253);
        result.put('e',13.0001);
        result.put('f',2.228);
        result.put('g',2.015);
        result.put('h',6.094);
        result.put('i',6.966);
        result.put('j',0.153);
        result.put('k',0.772);
        result.put('l',4.025);
        result.put('m',2.406);
        result.put('n',6.749);
        result.put('o',7.507);
        result.put('p',1.929);
        result.put('q',0.095);
        result.put('r',5.987);
        result.put('s',6.327);
        result.put('t',9.056);
        result.put('u',2.758);
        result.put('v',0.978);
        result.put('w',2.360);
        result.put('x',0.150);
        result.put('y',1.974);
        result.put('z',0.074);
        return result;
    }

    private static HashMap<Character,Integer> getLetterCount(String message){
        HashMap<Character,Integer> result = new HashMap<Character,Integer>();
        for(char c : LETTERS.toCharArray()){
            result.put(c,0);
        }
        for(char c : message.toLowerCase().toCharArray()){
            if(result.containsKey(c)){
                int tmp = result.get(c) + 1;
                result.remove(c);
                result.put(c,tmp);
            }
        }

        return result;
    }

    private final static double[] frequencyScoreTable = new double[]{
            8.167,      // a
            1.492,      // b
            2.782,      // c
            4.253,      // d
            13.0001,    // e
            2.228,      // f
            2.015,      // g
            6.094,      // h
            6.966,      // i
            0.153,      // j
            0.772,      // k
            4.025,      // l
            2.406,      // m
            6.749,      // n
            7.507,      // o
            1.929,      // p
            0.095,      // q
            5.987,      // r
            6.327,      // s
            9.056,      // t
            2.758,      // u
            0.978,      // v
            2.360,      // w
            0.150,      // x
            1.974,      // y
            0.074       // z
    };

    private static double getScore(char letter){
        int index = letter;
        if(index > 96 && index < 123){
            return frequencyScoreTable[index - 97];
        }
        else return 0;
    }

    public static double getScore(String input){
        double score = 0;
        int missedCount = 0;
        //if(!input.matches("\\d\\b\\w\\s\\W")) return 0;
        for(char c: input.toCharArray()){
            double letterScore = getScore(c);
            if(letterScore == 0 && c != ' ') missedCount++;
            score+=letterScore;
        }
        return score / (1 + missedCount);
    }



}
