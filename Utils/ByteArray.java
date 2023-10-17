package Utils;

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

    public static int hammingDistance(String target1, String target2) {
        int distance = 0;

        byte[] array1 = target1.getBytes();
        byte[] array2 = target2.getBytes();

        for (int i = 0; i < array1.length; i++) {
            byte xor = (byte) (array1[i] ^ array2[i]);
            distance += Integer.bitCount(xor);
        }

        // for (int i = 0; i < array1.length; i++) {
        //     if (array1[i] != array2[i]) {
        //         distance++;
        //     }
        // }
        
        return distance;
    }

    public static int findKeyEditDistance(String line) {
        float bestDistance = (float) 100;
        int bestKey =  0;
        for (int key = 2; key < 41; key++) {
            float sum = 0;

            for (int i = 0; i < 4; i++) {
                String block = line.substring(i*key, (i+1)*key);
                String nextblock = line.substring((i+1)*key, (i+2)*key);


                float distance = hammingDistance(block, nextblock) / (float)(key*4);
                //float distance = (float) 4;
                sum += distance;
            }

            System.out.println("Key: " + key + " Distance: " + sum);

            if (sum < bestDistance) {
                bestDistance = sum;
                bestKey = key;
            }
        }
        System.out.println(bestKey);
        return 0;
    }
}   
