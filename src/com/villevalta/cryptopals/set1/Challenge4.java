package com.villevalta.cryptopals.set1;

import com.villevalta.cryptopals.lib.Converter;
import com.villevalta.cryptopals.lib.Cryptography.Cryptography;
import com.villevalta.cryptopals.lib.LetterFrequency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ville on 8/27/2014.
 */
public class Challenge4 {
    public static void run() throws Exception {
        System.out.println("-------------------------------- SET 1: CHALLENGE 4: START --------------------------------");
        // avaa filu, käy kaikki läpi.. jne

        File f = new File("challenge4.txt");

        ArrayList<String> challenge4Strings = new ArrayList<String>();
        if(f.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = reader.readLine()) != null) {
                challenge4Strings.add(line);
            }
            reader.close();
        }
        HashMap<String,HashMap<Byte,String>> xorredEntries = new HashMap<String,HashMap<Byte,String>>();
        for(String entry : challenge4Strings){
            HashMap<Byte,String> tmp = new HashMap<Byte,String>();
            byte[] entryBytes = Converter.hexToBytes(entry);
            for(byte i = 0; i < Byte.MAX_VALUE; i++){
                tmp.put(i,new String(Cryptography.singleByteXor(entryBytes, i)));
            }
            xorredEntries.put(entry,tmp);
        }

        double c4hiscore = 0;
        String c4hiscoredString ="";
        byte xorbyte = 0;
        String foundInInput = "";
        for(String inputLine : xorredEntries.keySet()){
            for(Byte xorrer : xorredEntries.get(inputLine).keySet()){
                double score = LetterFrequency.getScore(xorredEntries.get(inputLine).get(xorrer));
                if(score > c4hiscore){
                    foundInInput  = inputLine;
                    xorbyte = xorrer;
                    c4hiscoredString = xorredEntries.get(inputLine).get(xorrer);
                    c4hiscore = score;
                }
            }
        }

        System.out.println("Found: \""+c4hiscoredString+"\"");
        System.out.println("From: \""+foundInInput+"\"");
        System.out.println("With byte: '"+xorbyte+"', as char: '"+(char)(xorbyte)+"'");
        System.out.println("Score: \""+c4hiscore+"\"");
        System.out.println("-------------------------------- SET 1: CHALLENGE 4: END    --------------------------------");
    }
}
