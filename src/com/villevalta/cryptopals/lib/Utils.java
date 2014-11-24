package com.villevalta.cryptopals.lib;

/**
 * Created by ville on 8/23/2014.
 */
public class Utils {

    public static byte[] ArrayCut(byte[] inputArray, int start, int stop){
        byte[] result = new byte[stop - start];
        int resultIndex = 0;
        for(int i = start; i < stop; i++){
            result[resultIndex] = inputArray[i];
            resultIndex++;
        }
        return result;
    }

    public static byte[][] ArrayBreakToBlocks(byte[] input, int blockSize){
        byte[][] result = new byte[input.length / blockSize][blockSize];
        for(int i = 0; i < result.length; i++){
            result[i] = ArrayCut(input,i*blockSize,(i*blockSize)+blockSize);
        }
        return result;
    }

    public static byte[][] ArrayTranspose(byte[][] input){
        byte[][] output = new byte[input[0].length][input.length];
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[0].length; j++) {
                output[i][j] = input[j][i];
            }
        }
        return output;
    }

    // Copies the whole source array to destination
    public static void ArrayAppend(byte[] destination, byte[] source, int index){
        for(int i = 0; i < source.length; i++){
            destination[index + i] = source[i];
        }
    }

    // Input array to be shifted
    // count = how many indexes shifted
    public static byte[] ArrayCircularShiftLeft(byte[] input, int count){
        byte[] result = new byte[input.length];
        System.arraycopy(input,count,result,0, input.length - count);
        System.arraycopy(input,0,result,input.length-count,count);
        return result;
    }

}
