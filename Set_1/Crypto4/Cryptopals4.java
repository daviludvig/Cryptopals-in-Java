package Set_1.Crypto4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cryptopals4 {
    public static void main(String[] args) throws IOException {
        String file = "4.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        int count = 0;

        while ((line = reader.readLine()) != null) {
            count++;
        }
        reader.close();
        System.out.println(count);
    }
}
