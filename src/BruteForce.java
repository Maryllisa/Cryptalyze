import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BruteForce {
        public static String decrypt(String message, String ALPHABET, int ALPHABET_SIZE) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            String decryptedMessage = decrypt(message, i, ALPHABET, ALPHABET_SIZE);
            if (checkKey(decryptedMessage) > 0) {
                System.out.println("Шаг " + i + ": " + decryptedMessage);
                return decryptedMessage;
            }
        }
        return null;
    }
    private static int checkKey(String text) {
        int score = 0;
        int countSpaces = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                countSpaces++;
                if (countSpaces > 2) {
                    score++;
                    break;
                }
            }
        }
        return score;
    }
    public static String decrypt(String message, int key, String ALPHABET, int ALPHABET_SIZE) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int index = ALPHABET.indexOf(c);
            if (index != -1) {
                char newChar = ALPHABET.charAt((index - key + ALPHABET_SIZE) % ALPHABET_SIZE);
                result.append(newChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public boolean decryptFile(String path) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(path));
        String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\"-!? ";
        int ALPHABET_SIZE = ALPHABET.length();
        String textFromFile = "";
        List<String> lines = file.lines().toList();
        for (String line : lines) {
            textFromFile+= line;
        }
        textFromFile = decrypt(textFromFile, ALPHABET, ALPHABET_SIZE);
        file.close();
        System.out.println("Расшифрованное сообщение: \n" + textFromFile);
        return true;
    }

}
