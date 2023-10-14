package Set_1.Crypto4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cryptopals4 {
    String file = "4.txt";

    public Cryptopals4() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        int count = 0;

        while ((line = reader.readLine()) != null) {
            count++;
        }

        System.out.println(count);
    }
}
