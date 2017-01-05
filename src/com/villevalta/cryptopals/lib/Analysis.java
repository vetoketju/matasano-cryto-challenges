package com.villevalta.cryptopals.lib;


import java.util.ArrayList;

/**
 * Created by ville on 8/16/2014.
 */
public class Analysis {

    // fast enough is fast enough for me...
    public static int hammingDistance(byte[] first, byte[] second){
        int result = first.length * 8;
        for(int i = 0; i < first.length; i++){
            for(byte m = 1; m != 0; m <<= 1){
                result -= (((first[i] & m) != 0) == ((second[i] & m) != 0) ) ? 1 : 0;
            }
        }
        if(second.length > first.length) result += (second.length - first.length) * 8;
        return result;
    }

    public static String getDivisors(int len){
        String result = "Divisors of "+len+": ";
        for (int i = 1; i <= len; i++){
            if(len % i == 0)result+= i+" ";
        }
        return result;
    }

    public static ArrayList<Integer> getDivisorsArray(int number){
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++){
            if(number % i == 0) divisors.add(i);
        }
        return divisors;
    }

    public static boolean isBase64(String message, boolean removeSpaces){
        String m = message;
        if(removeSpaces) m = m.replace(" ","");
        return m.matches("[a-zA-Z0-9+/=]");
    }

    public static boolean isHex(String message, boolean removeSpaces){
        String m = message;
        if(removeSpaces) m = m.replace(" ","");
        return m.matches("\\A\\b[0-9a-fA-F]+\\b\\Z") && m.length() % 2 == 0;
    }

    public static void KasiskiAnalyzis(String message){
        // Todo
    }

    // TODO: Clean and add some checks
    public static int FindRepeatingKeyXorKeysize(byte[] input){
        int result = 0;
        double score = 64; // find keysizes that are 2 to 64 size

        // keysizes:


        for(int i = 2; i < (input.length < 64 ? input.length : 64);i++){

            // Takes average from 10
            double hammingDistanceNormalized = 0;
            for(int a = 0; a < 10; a++){
                hammingDistanceNormalized += (double)(hammingDistance(Utils.ArrayCut(input,a*i,a*i+i),Utils.ArrayCut(input,i*a+i,i*a+(2*i))) / i);
            }

             hammingDistanceNormalized /= 10;

            if(hammingDistanceNormalized < score){
                result = i;
                score = hammingDistanceNormalized;
            }
            //System.out.println(i + " - " + hammingDistanceNormalized);
        }


        return result;
    }

}
