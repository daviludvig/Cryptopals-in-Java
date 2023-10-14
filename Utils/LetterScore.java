package Utils;

import java.util.HashMap;
import java.util.Map;

public class LetterScore {
    public static Double scoreLetter(String target) {
    Map<Character, Double> letterFrequencies = new HashMap<>();

    letterFrequencies.put('a', 8.17);
    letterFrequencies.put('b', 1.49);
    letterFrequencies.put('c', 2.78);
    letterFrequencies.put('d', 4.25);
    letterFrequencies.put('e', 12.70);
    letterFrequencies.put('f', 2.23);
    letterFrequencies.put('g', 2.02);
    letterFrequencies.put('h', 6.09);
    letterFrequencies.put('i', 6.97);
    letterFrequencies.put('j', 0.15);
    letterFrequencies.put('k', 0.77);
    letterFrequencies.put('l', 4.03);
    letterFrequencies.put('m', 2.41);
    letterFrequencies.put('n', 6.75);
    letterFrequencies.put('o', 7.51);
    letterFrequencies.put('p', 1.93);
    letterFrequencies.put('q', 0.10);
    letterFrequencies.put('r', 5.99);
    letterFrequencies.put('s', 6.33);
    letterFrequencies.put('t', 9.06);
    letterFrequencies.put('u', 2.76);
    letterFrequencies.put('v', 0.98);
    letterFrequencies.put('w', 2.36);
    letterFrequencies.put('x', 0.15);
    letterFrequencies.put('y', 1.97);
    letterFrequencies.put('z', 0.07);
    letterFrequencies.put(' ', 13.00);
    letterFrequencies.put(',', 2.00);
    letterFrequencies.put('.', 2.00);
    
    Double result = 0.00;

    for (int i = 0; i < target.length(); i++) {
        result += getLetterFrequency(target.charAt(i), letterFrequencies);
    }
    return result;
    
    }

    public static Double getLetterFrequency(char c, Map<Character, Double> letterFrequencies) {
        if (letterFrequencies.containsKey(c)) {
            return letterFrequencies.get(c);
        } else {
            return 0.0;
        }
    }
}
