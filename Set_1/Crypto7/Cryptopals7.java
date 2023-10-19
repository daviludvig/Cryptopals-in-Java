package Set_1.Crypto7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Cryptopals7 {
    public static void main (String[] args) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        String key = "YELLOW SUBMARINE";
        String file = "Data/7.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";

        while (reader.readLine() != null) {
            line += reader.readLine();
        };
        reader.close();

        byte[] keyBytes = key.getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
    
        byte[] cryptedBytes = Base64.getDecoder().decode(line);

        byte[] decryptedBytes = cipher.doFinal(cryptedBytes);

        String decrypted = new String(decryptedBytes, StandardCharsets.UTF_8);

        System.out.println(decrypted);
        
    }
}
