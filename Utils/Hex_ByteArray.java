package Utils;

public class Hex_ByteArray {

    public static byte[] convert(String hexString) {
        byte[] array = new byte[hexString.length() / 2];
        for (int i = 0, index = 0; i < hexString.length(); i += 2, index++) {
            array[index] = (byte) Integer.parseInt(hexString.substring(i, i + 2), 16);
        }
        return array;
    }
    
}
