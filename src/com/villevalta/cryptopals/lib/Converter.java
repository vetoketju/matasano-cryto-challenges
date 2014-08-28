package com.villevalta.cryptopals.lib;

/**
 * Created by ville on 8/14/2014.
 */
public class Converter {

    final private static char[] hexIndex = "0123456789ABCDEF".toCharArray();
    public final static char[] base64index = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static String hexToString(String hex){
        return new String(hexToBytes(hex));
    }

    public static byte[] hexToBytes(String hex){
        byte[] result = new byte[hex.length()/2];
        for(int i = 0; i < hex.length(); i+=2){
            result[i/2] = (byte) Integer.parseInt(hex.substring(i,i+2),16);
        }
        return result;
    }

    public static String bytesToHex(byte[] bytes){
        char[] result = new char[bytes.length * 2];
        for(int i = 0; i < bytes.length; i++){
            int a = bytes[i] & 0xFF;
            result[i * 2] = hexIndex[a >>> 4];
            result[i * 2 + 1] = hexIndex[a & 0x0F];
        }
        return new String(result);
    }


    private static byte indexFromBase64(char needle){
        for(int i = 0; i < base64index.length; i++){
            if(needle == base64index[i]) return (byte)i;
        }
        return 0;
    }


    public static byte[] base64ToBytes(String base64){
        int pad = 0;
        base64 = base64.replace("\n","").replace("\r",""); // remove new line characters
        char[] input = base64.replace("=","").toCharArray();
        if(base64.endsWith("==")) pad = 2;
        else if(base64.endsWith("=")) pad = 1;
        byte[] result = new byte[((base64.length() / 4) * 3) - pad];
        int resultIndex = 0;

        for(int i = 0; i < input.length; i+=4){
            byte[] in = new byte[4];

            for(int j = 0; j < 4; j++){
                if(i+j < input.length)
                    in[j] = indexFromBase64(input[i+j]);
            }

            int k = 0;
            if( i + 4 > input.length){
                k = input.length - i;
            }
            result[resultIndex++] = (byte) (in[0] << 2 | in[1] >> 4);

            if(k == 2) {
                break;
            }
            result[resultIndex++] = (byte) ((((in[1] & 0xf) << 4)) | ((in[2] >> 2) & 0xf));

            if(k == 3) {
                break;
            }
            result[resultIndex++] = (byte) (in[2] << 6 | in[3]);

        }
        return result;
    }


    public static String bytesToBase64(byte[] bytes, boolean pad){
        String result = "";
        for(int i = 0; i < bytes.length; i+=3){

            byte[] in = new byte[3];
            for(int j = 0; j < 3; j++){
                if(i+j < bytes.length)
                    in[j] = bytes[i+j];
            }

            int k = 0;
            if( i + 3 > bytes.length){
                k = bytes.length - i;
            }

            result += base64index[in[0] >> 2];
            result += base64index[((in[0] & 0x3) << 4) | in[1] >> 4];

            if(k == 1){
                if (pad) result += "==";
                break;
            }

            result += base64index[(in[1] & 0x0f) << 2 | ((in[2]) >> 6)];

            if(k == 2){
                if (pad) result += "=";
                break;
            }

            result += base64index[in[2] & 0x3f];
        }
        return result;
        // 00 00 11 11 = 0x0f;
        // 00 00 00 11 = 0x3;
        // 11 11 11 00 = 0xfc;
        // 11 00 00 00 = 0xc0;
        // 00 11 11 11 = 0x3f;
    }

}
