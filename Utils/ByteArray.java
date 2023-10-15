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
}   
