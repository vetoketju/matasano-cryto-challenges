package com.villevalta.cryptopals.set1;

import com.villevalta.cryptopals.lib.Converter;
import com.villevalta.cryptopals.lib.Cryptography.Cryptography;

/**
 * Created by ville on 8/27/2014.
 */
public class Challenge2 {

    public static void run(){
        System.out.println("-------------------------------- SET 1: CHALLENGE 2: START --------------------------------");

        String input = "1c0111001f010100061a024b53535009181c";
        String key = "686974207468652062756c6c277320657965";

        byte[] inputBytes = Converter.hexToBytes(input);
        byte[] keyBytes = Converter.hexToBytes(key);

        byte[] xorred = Cryptography.xor(inputBytes,keyBytes);

        String result = Converter.bytesToHex(xorred);

        System.out.println(result);

        //System.out.println(Converter.bytesToHex(Cryptography.xor(Converter.hexToBytes("1c0111001f010100061a024b53535009181c"), Converter.hexToBytes("686974207468652062756c6c277320657965"))));
        System.out.println("-------------------------------- SET 1: CHALLENGE 2: END    --------------------------------");
    }

}
