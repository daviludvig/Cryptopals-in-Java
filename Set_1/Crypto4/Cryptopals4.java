package Set_1.Crypto4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cryptopals4 {
    public static void main(String[] args) throws IOException {
        String file = "Data/4.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        int bestKey = 0;
        Double bestScore = 0.00;
        String besString = "";

        while ((line = reader.readLine()) != null) {
            int key = Utils.Produced_XOR.findKey(Utils.Hex_ByteArray.convert(line));
            byte[] keyArray = Utils.Produced_XOR.findKeyArray(key);
            byte[] result = Utils.Produced_XOR.xor(Utils.Hex_ByteArray.convert(line), keyArray);
            String asciiString = new String(result, 0, result.length, "US-ASCII");
            Double keyValue = Utils.LetterScore.scoreLetter(asciiString);
            if (keyValue > bestScore) {
                bestScore = keyValue;
                bestKey = key;
                besString = asciiString;
            }
        }
        reader.close();
        System.out.println(bestKey);
        System.out.println(besString);
    }
}
