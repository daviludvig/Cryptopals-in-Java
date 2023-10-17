package Utils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class ByteArray {

    public static String byteB64String(byte[] array) {
        return java.util.Base64.getEncoder().encodeToString(array);
    }
    
    public static String byteHex(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static byte[] fixLength(byte[] target, int len) {
        byte[] array = new byte[len];
        for (int i = 0; i < len; i++) {
            array[i] = target[i % target.length];
        }
        return array;
    }

    // Deprecated method

    // public static int hammingDistance(String target1, String target2) {
    //     byte xor[] = Produced_XOR.xor(target1.getBytes(), target2.getBytes());
    //     int distance = 0;
        
    //     for (byte b : xor) distance += Integer.bitCount(b);
        
    //     return distance;
    // }

    public static int countBits(byte b) {
        int i = 0;
		if ((b & 0x01) != 0)
			i++;
		if ((b & 0x02) != 0)
			i++;
		if ((b & 0x04) != 0)
			i++;
		if ((b & 0x08) != 0)
			i++;
		if ((b & 0x10) != 0)
			i++;
		if ((b & 0x20) != 0)
			i++;
		if ((b & 0x40) != 0)
			i++;
		if ((b & 0x80) != 0)
			i++;
		return i;
    }

    public static int hammingDistance(byte[] array1, byte[] array2) {
        int distance = 0;

        for (int i = 0; i < array1.length; i++) {
            byte xor = (byte) (array1[i] ^ array2[i]);
            distance += countBits(xor);
        }

        return distance;
    }

    public static int findKeyEditDistance(String line) {
        float bestDistance = (float) 100;
        int bestKey =  0;

        ArrayList<KeyValuePair> distances = new ArrayList<KeyValuePair>();

        for (int key = 2; key < 41; key++) {
            float sum = 0;

            int limit = 4;
            for (int i = 0; i < limit; i++) {
                String block = line.substring(i*key, (i+1)*key);
                String nextblock = line.substring((i+1)*key, (i+2)*key);

                float distance = hammingDistance(nextblock.getBytes(), block.getBytes()) / (float)(key*limit);

                sum += distance;
            }

            System.out.println("Key: " + key + " Distance: " + sum);

            KeyValuePair tempPair = new KeyValuePair(key, sum);

            distances.add(tempPair);

            if (sum < bestDistance) {
                bestDistance = sum;
                bestKey = key;
            }
        }

        Collections.sort(distances, new Comparator<KeyValuePair>() {
            @Override
            public int compare(KeyValuePair pair1, KeyValuePair pair2) {
                return Float.compare(pair1.getDistance(), pair2.getDistance());
            }
        });

        System.out.println(bestKey + " " + distances.size());

        for (KeyValuePair pair : distances) {
            System.out.println(pair.getKey() + " " + pair.getDistance());
        }

        for (int i = 0; i < 5; i++) {
            ;
        }

        return 0;
    }
}   
