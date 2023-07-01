import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать");
        CaesarCipher caesarCipher = new CaesarCipher();
        int choose=0;
        do {
            System.out.println("Выберите необходимы режим");
            System.out.println("1 - Шифрование / расшифровка. ");
            System.out.println("2 - Криптоанализ методом brute force");
            System.out.println("3 - Выход");
            choose= in.nextInt();
            switch (choose)
            {
                case 1:{

                    System.out.println("Зашифровать файл");
                    System.out.println("Расшифровать файл");
                    System.out.println("Выход");
                    int choose2 = in.nextInt();
                    switch (choose2)
                    {
                        case 1:
                        {
                            System.out.println("Введите путь к файлу для шифрования");
                            String path = in.nextLine();
                            path = in.nextLine();
                            try {
                                if (caesarCipher.encryptFile(path)) System.out.println("Шифрование прошло успешно");
                                else System.out.println("Ошибка при шифровании");
                            } catch (IOException e) {
                                System.out.println("Ошибка файла");
                            }
                            break;
                        }
                        case 2:{

                            System.out.println("Введите путь к файлу для расшифрования");
                            String path = in.nextLine();
                            path = in.nextLine();
                            try {
                                if (caesarCipher.decryptFile(path)) System.out.println("Расшифровка прошла успешно");
                                else System.out.println("Ошибка при расшифровки");
                            } catch (IOException e) {
                                System.out.println("Ошибка файла");
                            }
                            break;
                        }
                        case 3:{ break; }
                        default:
                            System.out.println("Некорректный ввод");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Введите путь к файлу для расшифрования");
                    String path = in.nextLine();
                    path = in.nextLine();
                    BruteForce bruteForce = new BruteForce();
                    try {
                        if (bruteForce.decryptFile(path)) System.out.println("Расшифровка прошла успешно");
                        else System.out.println("Ошибка при расшифровки");
                    } catch (IOException e) {
                        System.out.println("Ошибка файла");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Выход...");
                    break;
                }
                default:
                    System.out.println("Некорректный ввод");
            }


        }while(choose!=3);
    }
}