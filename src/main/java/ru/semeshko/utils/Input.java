package ru.semeshko.utils;

import java.util.Scanner;

/**
 * Утилита для дружественного ввода с проверкой.
 */
public class Input {

    private final Scanner sc;

    public Input(Scanner sc) {
        this.sc = sc;
    }

    public String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Ошибка: строка не должна быть пустой.");
        }
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v >= min && v <= max) return v;
            System.out.println("Ошибка: число должно быть в диапазоне [" + min + ";" + max + "].");
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число (можно с дробной частью).");
            }
        }
    }

    public double readDoublePositive(String prompt) {
        while (true) {
            double v = readDouble(prompt);
            if (v > 0) return v;
            System.out.println("Ошибка: число должно быть > 0.");
        }
    }

    public String readPhone(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.matches("\\d{5,20}")) return s; // простая проверка: только цифры, длина 5..20
            System.out.println("Ошибка: телефон должен состоять из цифр (длина 5..20).");
        }
    }
}
