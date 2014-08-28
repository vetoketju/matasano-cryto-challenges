package com.villevalta.cryptopals.lib;

import javax.rmi.CORBA.Util;

/**
 * Created by ville on 8/16/2014.
 */
public class Analysis {

    public static void runAnalysis(String message){

        boolean isHex = isHex(message,false);

        System.out.println("is HEX: "+ isHex);
        if(isHex) System.out.println("as Hex->String: \"" + Converter.hexToString(message)+"\"");
        System.out.println("Base64: "+ isBase64(message,false));
        // Base64 decode here
        lengthAnalysis(message);
    }

    private static void lengthAnalysis(String message){
        System.out.println("---- Length ----");
        System.out.println("Character count : " + message.length());
        System.out.println(getDisivibles(message.length()));
        if(message.contains(" ")){
            System.out.println("---- Spaces removed length ----");
            System.out.println("Character count : " + message.replace(" ", "").length());
            System.out.println(getDisivibles(message.replace(" ", "").length()));
        }
        if(isHex(message,true)){
            System.out.println("---- Hex -> Bytes length ----");
            System.out.println("Character count : " + message.length() / 2);
            System.out.println(getDisivibles(message.length() / 2));
        }
    }

    // fast enough is fast enough for me...
    public static int hammingDistance(byte[] first, byte[] second){
        int result = first.length * 8;
        for(int i = 0; i < first.length; i++){
            for(int m = 0x01; m != 0x100; m <<=1){ // and that is how you iterate bits in byte :)
                result -= ( ((first[i]&m)!=0) == ((second[i]&m)!=0) ) ? 1 : 0;
            }
        }
        if(second.length > first.length) result += (second.length - first.length) * 8;
        return result;
    }

    private static String getDisivibles(int len){
        String result = "Divisible by (until 64): ";
        for (int i = 1; i <= 64; i++){
            if(len % i == 0)result+= i+" ";
        }
        return result;
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




    }

    // TODO: Clean and add some checks
    public static int Find_Keysize_repeatingKeyXor(byte[] input){
        int result = 0;
        double score = 64;
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
