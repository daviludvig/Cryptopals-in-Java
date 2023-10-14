package Set_1.Crypto2;

public class Cryptopals2 {
    public static void main(String[] args) {
        String hexString1 = "1c0111001f010100061a024b53535009181c";
        String hexString2 = "686974207468652062756c6c277320657965";

        byte[] array1 = Utils.Hex_ByteArray.convert(hexString1);
        byte[] array2 = Utils.Hex_ByteArray.convert(hexString2);

        byte[] array = Utils.Produced_XOR.xor(array1, array2);

        String hexString = Utils.ByteArray.byteHex(array);
        
        System.out.println(hexString);
    }
}
