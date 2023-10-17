package Set_1.Crypto6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

import javax.sound.midi.SysexMessage;
import javax.swing.text.Utilities;

public class Cryptopals6 {
    public static void main (String [] args) throws IOException {
        String file = "Data/6.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";

        while (reader.readLine() != null) {
            line += reader.readLine();
        };
        reader.close();

        byte[] b64bytes = Base64.getDecoder().decode(line);

        Utils.ByteArray.findKeyEditDistance(line);


    }
}