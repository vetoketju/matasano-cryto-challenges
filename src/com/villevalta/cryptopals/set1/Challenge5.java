package com.villevalta.cryptopals.set1;

import com.villevalta.cryptopals.lib.Converter;
import com.villevalta.cryptopals.lib.Cryptography.Cryptography;

/**
 * Created by ville on 8/27/2014.
 */
public class Challenge5 {
    public static void run(){
        System.out.println("-------------------------------- SET 1: CHALLENGE 5: START --------------------------------");
        System.out.println(Converter.bytesToHex(Cryptography.repeatingKeyXor("Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal".getBytes(), "ICE".getBytes())).toLowerCase());
        System.out.println("-------------------------------- SET 1: CHALLENGE 5: END    --------------------------------");
    }
}
