package Set_1.Crypto3;

import java.io.UnsupportedEncodingException;

public class Cryptopals3 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String target = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        
        byte[] targetArray = Utils.Hex_ByteArray.convert(target);

        System.out.println(Utils.Produced_XOR.findKey(targetArray));
    }
}
