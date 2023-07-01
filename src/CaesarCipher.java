import java.io.*;
import java.util.List;
import java.util.Random;

public class CaesarCipher {

    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\"-!? ";
    private static final int ALPHABET_SIZE = ALPHABET.length();
    private static int key;

    public CaesarCipher(){
        key = generateKey();
    }

    private static int generateKey() {
        Random random = new Random();
        int key = random.nextInt(26) + 1;
        System.out.println("Ключ: " + key);
        return key;
    }

    public static String encrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int index = ALPHABET.indexOf(c);
            if (index != -1) {
                char newChar = ALPHABET.charAt((index + key) % ALPHABET_SIZE);
                result.append(newChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String message) {
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

    public boolean encryptFile(String path) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(path));
        String textFromFile = "";
        List<String> lines = file.lines().toList();
        for (String line : lines) {
            textFromFile+= line + "\n";
        }
        textFromFile = encrypt(textFromFile);
        file.close();
        System.out.println("Зашифрованное сообщение: \n" + textFromFile);
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(textFromFile);
        writer.close();
        return true;
    }
    public boolean decryptFile(String path) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(path));
        String textFromFile = "";
        List<String> lines = file.lines().toList();
        for (String line : lines) {
            textFromFile+= line + "\n";
        }
        textFromFile = decrypt(textFromFile);
        file.close();
        System.out.println("Расшифрованное сообщение: \n" + textFromFile);
        return true;
    }
}
