package org.example.finalWorkJava.view;


import org.example.finalWorkJava.controller.Controller;
import org.example.finalWorkJava.data.Toy;

import java.io.*;
import java.util.*;

public class View {
        Controller controller = new Controller();
    public void run() {
        System.out.println("===============================");
        System.out.println("\t\t ЛИСТ ИГРУШЕК");
        System.out.println("===============================");
        while (true) {
            System.out.println("1 - Добавить новый товар.");
            System.out.println("2 - Посмотреть все товары.");
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
                Toy toy = controller.inputToy();
                controller.send(toy);
                System.out.println("Введённые данные: " + controller.show());
                System.out.println("_______________________________");
                System.out.println("1 - Добавить запись");
                System.out.println("2 - Отменить ввод данных");
                System.out.println("_______________________________");
                int choiceAdd = 0;
                boolean validAdd = false;
                while (!validAdd) {
                    try {
                        choiceAdd = scanner.nextInt();
                        validAdd = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка ввода. Введите целое число");
                        System.out.println("_______________________________");
                        scanner.nextLine(); // очистка буфера ввода
                    }
                }
                if (choiceAdd == 1) {
                    controller.recBase();
                    System.out.println("_______________________________");
                    System.out.println("Запись добавлена!");
                    System.out.println("_______________________________");
                    continue;
                }
                System.out.println("Необходимо повторить ввод данных");
                break;
            } else if (choice == 2) {
                controller.readerBase();
            } else if (choice == 3) {
//                System.out.println("Список готов к розыгрышу!");
                System.out.println("_______________________________");
                break;
            } else {
                System.out.println("Некорректный ввод данных. Повторите ввод.");
                System.out.println("_______________________________");
            }
        }
    }

    public void game() throws FileNotFoundException {
        String path = "C:\\Users\\vvlee\\Моя учёба_GeekBrans\\Exceptions\\Seminars\\src\\main\\java\\org\\example\\finalHW\\data\\";
        Scanner scanner = new Scanner(new File(path + "listToy.txt"));
        List<Integer> id = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<Integer> probability = new ArrayList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] tokens = line.trim().split(",");
            id.add(Integer.valueOf(tokens[0]));
            name.add(tokens[1]);
            probability.add(Integer.valueOf((tokens[2])));
        }
        Random random = new Random();
        int count = 0;
        for (Integer i : probability) {
            count += i;
        }
        List<String> list = new LinkedList<>();
        for (int i = 0; i < id.size(); i++) {
            for (int j = 0; j < probability.get(i); j++) {
                list.add((name.get(i)));
            }
        }
        // Вывод вероятностей:
        for (int i = 0; i < probability.size(); i++) {
            System.out.println("Вероятность числа \"" + name.get(i) + ":  \t" + Math.round(probability.get(i) * 100d / count) + " %");
        }
        System.out.println("=========================================");
        StringBuilder result = new StringBuilder();
        // Генерация случайного числа
        for (int i = 1; i <= count; i++) {
            int index = random.nextInt(list.size()); // Выбираем случайный индекс из воображаемого массива
            System.out.println(i + " -> " + list.get(index));
            result.append("# ").append(i).append(" -> ").append(list.get(index)).append("\t\n");
            list.remove(list.get(index));
        }
        try (FileWriter writer = new FileWriter( path + "result.txt", true)) {
            writer.write(result.toString());
            writer.append("=========================================\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}