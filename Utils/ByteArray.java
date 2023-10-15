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

    public static Double hammingDistance(String target1, String target2) {
        String bits1 = "";
        String bits2 = "";

        for (int i = 0; i < target1.length(); i++) {
            int charValue = (int) target1.charAt(i);
            String binaryString = Integer.toBinaryString(charValue);
            bits1 += binaryString;

            charValue = (int) target2.charAt(i);
            binaryString = Integer.toBinaryString(charValue);
            bits2 += binaryString;
        }

        Double distance = 0.00;

        for (int i = 0; i < bits1.length(); i++) {
            if (bits1.charAt(i) != bits2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}   
