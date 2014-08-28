package com.villevalta.cryptopals.lib.Cryptography;

/**
 * Created by ville on 8/16/2014.
 */
public class Cryptography {

    // If there is one flaw to using XOR to obfuscate your file, it’s that any byte you XOR with 0 stays the same.
    // Therefore, if you are going to XOR an entire file with the same byte, anytime you encounter a zero, that byte will then become the XOR key.
    public static byte[] xor(byte[] one, byte[] two){
        byte[] result = new byte[one.length];
        for(int i = 0; i < one.length; i++){
            result[i] = (byte)(one[i] ^ two[i]);
        }
        return result;
    }

    public static byte[] singleByteXor(byte[] input, byte key){
        byte[] result = new byte[input.length];
        for(int i = 0; i < input.length; i++){
            result[i] = (byte)(input[i] ^ key);
        }
        return result;
    }

    public static byte[] repeatingKeyXor(byte[] message, byte[] key){
        byte[] result = new byte[message.length];
        int keyindex = 0;
        for(int i = 0; i < message.length; i++){
            result[i] =(byte)(message[i] ^ key[keyindex]);
            keyindex++;
            if(keyindex >= key.length) keyindex = 0;
        }
        return result;
    }

}
