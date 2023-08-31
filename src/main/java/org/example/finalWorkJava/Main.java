package org.example.finalWorkJava;



import org.example.finalWorkJava.view.View;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        View view = new View();
        System.out.println("===============================");
        System.out.println("\t\t РОЗЫГРЫШ ИГРУШЕК");
        System.out.println("===============================");
        while (true) {
            System.out.println("1 - Проверить лист игрушек");
            System.out.println("2 - Запуск розыгрыша");
            System.out.println("3 - Выход.");
            System.out.println("_______________________________");
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    choice = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Введите целое число");
                    System.out.println("_______________________________");
                    scanner.nextLine(); // очистка буфера ввода
                }
            }
            if (choice == 1) {
                view.run();
            }else if (choice == 2) {
                view.game();
                break;
            } else if (choice == 3) {
                System.out.println("_______________________________");
                break;
            } else {
                System.out.println("Некорректный ввод данных. Повторите ввод.");
                System.out.println("_______________________________");
            }
        }
    }
}