package Set_1.Crypto1;

import Utils.ByteArray;
import Utils.Hex_ByteArray;

public class Cryptopals1 {
    public static void main(String[] args) {
        String hexString = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
        byte[] array = Hex_ByteArray.convert(hexString);
        String b64String = ByteArray.byteB64String(array);
        System.out.println(b64String);
    }
}
