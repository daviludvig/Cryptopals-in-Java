package Set_1.Crypto6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cryptopals6 {
    public static void main (String [] args) throws IOException {
        String file = "Data/6.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        reader.close();

        
    }
}