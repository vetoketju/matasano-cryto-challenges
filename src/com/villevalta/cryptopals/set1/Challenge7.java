package com.villevalta.cryptopals.set1;

import com.villevalta.cryptopals.lib.Cryptography.AES;

/**
 * Created by ville on 9/20/2014.
 */
public class Challenge7 {
    public static void run(){
        System.out.println("-------------------------------- SET 1: CHALLENGE 7: START --------------------------------");

        String input = "YELLOWKSUBMARINE";
        String key = "YELLOW SUBMARINE";

        String crypted = AES.Encrypt(input.getBytes(),key.getBytes());
        System.out.println(crypted);


        System.out.println("-------------------------------- SET 1: CHALLENGE 7: END   --------------------------------");
    }
}
