package org.example.finalWorkJava.servises;

import org.example.finalWorkJava.data.Toy;
import org.example.finalWorkJava.probability.Probability;

import java.io.*;
import java.util.*;

public class ToysData implements ICreateService, IReaderService, IRecordService{
    private final List<Toy> toyBaseList = new ArrayList<>();
    String path = "C:\\Users\\vvlee\\Моя учёба_GeekBrans\\Exceptions\\Seminars\\src\\main\\java\\org\\example\\finalHW\\data\\";

    @Override
    public void create(Toy toy) {
        toyBaseList.add(toy);
    }

    @Override
    public List<Toy> read() {
        return toyBaseList;
    }

    @Override
    public Toy input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID товара: ");
        int toyID = 0;
        boolean validInputID = false;
        while (!validInputID) {
            try {
                toyID = scanner.nextInt();
                validInputID = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Введите целое число");
                System.out.println("_______________________________");
                scanner.nextLine(); // очистка буфера ввода
            }
        }
        System.out.println("Введите наименование: ");
        scanner.nextLine();
        String toyName = scanner.nextLine();
        System.out.println("Введите количество игрушек: ");
        Probability department = new Probability(scanner.nextInt());
        return new Toy(toyID, toyName, department);
    }

    @Override
    public void readerBaseFile() {
        try (FileReader reader = new FileReader(path + "listToy.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
                System.out.println("\n=========================================");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void recBaseFile() {
        String path = this.path;
        StringBuilder result = new StringBuilder();
        for (Toy s : this.toyBaseList) {
            result.append(s).append("\t");
        }
        try (FileWriter writer = new FileWriter( path + "listToy.txt", true)) {
            writer.write(result.toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}