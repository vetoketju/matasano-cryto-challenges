package com.villevalta.cryptopals.set1;

import com.villevalta.cryptopals.lib.Converter;
import com.villevalta.cryptopals.lib.Cryptography.Cryptography;
import com.villevalta.cryptopals.lib.LetterFrequency;

/**
 * Created by ville on 8/27/2014.
 */
public class Challenge3 {
    public static void run(){
        System.out.println("-------------------------------- SET 1: CHALLENGE 3: START --------------------------------");

        double highestScore = 0;
        String highestScoredWord = "";

        for(byte i = 0; i < Byte.MAX_VALUE; i++){
            String guess = new String(Cryptography.singleByteXor(Converter.hexToBytes("1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"),i)); //,"US-ASCII"
            double tmp = LetterFrequency.getScore(guess.toLowerCase());
            if(tmp > highestScore){
                highestScore = tmp;
                highestScoredWord = guess;
            }
        }

        System.out.println("Highest scored output was \""+highestScoredWord+"\" with score: "+highestScore);

        System.out.println("-------------------------------- SET 1: CHALLENGE 3: END    --------------------------------");
    }
}
