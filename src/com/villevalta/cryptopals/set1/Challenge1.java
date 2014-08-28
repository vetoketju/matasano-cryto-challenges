package com.villevalta.cryptopals.set1;

import com.villevalta.cryptopals.lib.Converter;

/**
 * Created by ville on 8/27/2014.
 */
public class Challenge1 {

    public static void run(){
        System.out.println("-------------------------------- SET 1: CHALLENGE 1: START --------------------------------");

        String input = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
        byte[] inputBytes = Converter.hexToBytes(input);
        String base64_result = Converter.bytesToBase64(inputBytes, true);

        System.out.println(base64_result);

        System.out.println("-------------------------------- SET 1: CHALLENGE 1: END   --------------------------------");
    }

}
