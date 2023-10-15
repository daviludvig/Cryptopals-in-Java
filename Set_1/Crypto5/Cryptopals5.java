package Set_1.Crypto5;

public class Cryptopals5 {
    public static void main(String[] args) {
        String input = "Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal";
        String key = "ICE";

        byte[] inputArray = input.getBytes();
        byte[] keyArray = key.getBytes();

        keyArray = Utils.ByteArray.fixLength(keyArray, inputArray.length);

        byte[] result = Utils.Produced_XOR.xor(inputArray, keyArray);

        String hexString = Utils.ByteArray.byteHex(result);

        System.out.println(hexString);
    }
}
