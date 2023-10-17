package Set_1.Crypto6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cryptopals6 {
    public static void main (String [] args) throws IOException {
        String file = "Data/6.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        line += reader.readLine();
        line += reader.readLine();
        reader.close();

        Double bestDistance = 100.00;
        for (int key = 2; key < 41; key++) {
            String chunk1 = line.substring(0, key);
            String chunk2 = line.substring(key, key * 2);
            String chunk3 = line.substring(key * 2, key * 3);
            String chunk4 = line.substring(key * 3, key * 4);

            Double distance1 = Utils.ByteArray.hammingDistance(chunk1, chunk2);
            Double distance3 = Utils.ByteArray.hammingDistance(chunk3, chunk4);

            Double distance = (distance1 + distance3) / 2;

            Double normalizedDistance = distance / key;

            if (normalizedDistance < bestDistance) {
                bestDistance = normalizedDistance;
                // System.out.println(key);
            }
        }
    }
}