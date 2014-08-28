package com.villevalta.cryptopals.set1;

import com.villevalta.cryptopals.lib.*;
import com.villevalta.cryptopals.lib.Cryptography.Cryptography;

import java.io.File;
import java.io.FileReader;

/**
 * Created by ville on 8/19/2014.
 */
public class Challenge6 {

    public static void run() throws Exception{
        System.out.println("-------------------------------- SET 1: CHALLENGE 6: START --------------------------------");
        System.out.println("Hamming distance: "+ Analysis.hammingDistance("this is a test".getBytes(), "wokka wokka!!!".getBytes()));
        File f = new File("challenge6.txt");
        FileReader reader = new FileReader(f);
        char[] fileChars = new char[(int)f.length()];
        reader.read(fileChars);
        byte[] input = Converter.base64ToBytes(new String(fileChars));

        int KEYSIZE = Analysis.Find_Keysize_repeatingKeyXor(input);

        System.out.println("Key size is probably: " +KEYSIZE);

        byte[][] blocks = Utils.ArrayBreakToBlocks(input,KEYSIZE);

        byte[][] transposed = Utils.ArrayTranspose(blocks);

        byte[] KEY = new byte[KEYSIZE];
        // singlebyte XORraa ja eti parhaat -> key
        for(int i = 0; i < KEYSIZE; i++){
            double highestScore = 0;
            String highestScoredWord = "";
            byte bestByte = 0x00;
            for(byte j = 0; j < Byte.MAX_VALUE; j++){
                String guess = new String(Cryptography.singleByteXor(transposed[i], j));
                double tmp = LetterFrequency.getScore(guess.toLowerCase());
                //System.out.print(tmp+"|");

                if(tmp > highestScore){
                    highestScore = tmp;
                    highestScoredWord = guess;
                    bestByte = j;
                }
            }
            KEY[i] = bestByte;
            /*
            System.out.println();
            System.out.println("----------- SCORE FOR "+ i +" points("+highestScore+") --------------");
            System.out.println(highestScoredWord);
            System.out.println("----------- "+i+" END ----------------");
            //System.out.println("Highest scored output was \""+highestScoredWord+"\" with score: "+highestScore);
            */
        }
        System.out.println("KEY="+new String(KEY));

        System.out.println("----------- RESULT START --------------");
        System.out.println(new String(Cryptography.repeatingKeyXor(input,KEY)));
        System.out.println("----------- RESULT END ----------------");
        System.out.println("-------------------------------- SET 1: CHALLENGE 6: END    --------------------------------");
    }
}
