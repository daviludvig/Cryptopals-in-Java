package Utils;

import java.io.UnsupportedEncodingException;

public class Produced_XOR {
    public static byte[] xor(byte[] array1, byte[] array2) {
        byte[] array = new byte[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array[i] = (byte) (array1[i] ^ array2[i]);
        }
        return array;
    }

    public static int findKey(byte[] array) throws UnsupportedEncodingException {
        Double bestScore = 0.00;
        int bestKey = 0;
        for (int key = 0; key < 256; key++) {

            byte[] keyArray = new byte[array.length];
            for (int i = 0; i < array.length; i++) {
                keyArray[i] = (byte) key;
            }

            byte[] result = xor(array, keyArray);

            String asciiString = new String(result, 0, result.length, "US-ASCII");

            Double keyValue = Utils.LetterScore.scoreLetter(asciiString);

            if (keyValue > bestScore) {
                bestScore = keyValue;
                bestKey = key;
            }

            System.out.println("Key: " + key + " Result: " + asciiString + " Score: " + keyValue);    
    }
    return bestKey;
}

}
