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

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
