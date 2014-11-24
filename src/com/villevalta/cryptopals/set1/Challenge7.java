package com.villevalta.cryptopals.set1;

import com.villevalta.cryptopals.lib.Converter;
import com.villevalta.cryptopals.lib.Cryptography.AES;

/**
 * Created by ville on 9/20/2014.
 */
public class Challenge7 {
    public static void run() throws Exception {
        System.out.println("-------------------------------- SET 1: CHALLENGE 7: START --------------------------------");

        String input = "HSOVJKSISDASDASD";
        String key =   "YELLOWKSUBMARINE";

        byte[] crypted = AES.Encrypt(input.getBytes(),key.getBytes());
        System.out.println(Converter.bytesToHex(crypted,true));


        /*
        System.out.println("FROM JAVA:");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE,new SecretKeySpec(key.getBytes(),"AES"));
        System.out.println(Converter.bytesToHex(cipher.doFinal(input.getBytes()),true));
        */


        System.out.println("-------------------------------- SET 1: CHALLENGE 7: END   --------------------------------");
    }
}
