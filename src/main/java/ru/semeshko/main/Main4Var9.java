package ru.semeshko.main;

import ru.semeshko.geometry.*;
import ru.semeshko.phonebook.PhoneBook;
import ru.semeshko.students.Student;
import ru.semeshko.utils.Figures;
import ru.semeshko.utils.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;


public class Main4Var9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Input in = new Input(sc);

        System.out.println("=== Лабораторная работа lab4var9 (semeshko) ===");

        // ---------------------------
        // Задание 1.9: Студент
        // ---------------------------
        System.out.println("\n--- Задание 1.9: Диапазон оценок ---");
        String studentName = in.readNonEmptyString("Введите имя студента: ");
        Student st = new Student(studentName);

        System.out.println("Вводите оценки (2..5). Введите 0 чтобы закончить.");
        while (true) {
            int g = in.readInt("Оценка: ");
            if (g == 0) break;

            boolean ok = st.addGrade(g);
            if (!ok) {
                System.out.println("Ошибка: оценка должна быть в диапазоне 2..5. Не добавлено.");
            } else {
                System.out.println("Добавлено. Текущий студент: " + st);
            }
        }

        // Демонстрация, что “сломать” оценки нельзя:
        int[] copy = st.getGrades();
        if (copy.length > 0) copy[0] = 100; // меняем копию
        System.out.println("Проверка защиты оценок (после попытки изменить массив снаружи): " + st);
        System.out.println("Средний балл: " + String.format("%.2f", st.getAverage()) + ", отличник: " + st.isExcellent());

        // ---------------------------
        // Задание 2.3: PhoneBook
        // ---------------------------
        System.out.println("\n--- Задание 2.3: Телефонный справочник ---");
        PhoneBook book = new PhoneBook();

        int nContacts = in.readIntInRange("Сколько контактов добавить (1..10)? ", 1, 10);
        for (int i = 1; i <= nContacts; i++) {
            System.out.println("Контакт #" + i);
            String name = in.readNonEmptyString("Имя: ");
            String phone = in.readPhone("Телефон (только цифры): ");
            String old = book.add(phone, name);
            if (old != null) {
                System.out.println("Имя уже было. Старый телефон заменён. Старый = " + old);
            }
        }

        System.out.println("\nТекущий справочник:\n" + book);

        String findName = in.readNonEmptyString("Введите имя для поиска телефона: ");
        String phoneFound = book.getPhone(findName);
        System.out.println(phoneFound == null ? "Контакт не найден." : "Телефон: " + phoneFound);

        String prefix = in.readNonEmptyString("Введите префикс имени для поиска: ");
        String[] namesByPrefix = book.findNamesByPrefix(prefix);
        System.out.println("Найденные имена: " + java.util.Arrays.toString(namesByPrefix));

        // ---------------------------
        // Задание 3.5: Point3D
        // ---------------------------
        System.out.println("\n--- Задание 3.5: Трёхмерная точка ---");
        double x3 = in.readDouble("X: ");
        double y3 = in.readDouble("Y: ");
        double z3 = in.readDouble("Z: ");
        Point3D p3 = new Point3D(x3, y3, z3);
        System.out.println("Создана точка: " + p3);

        // ---------------------------
        // Задания 4.4, 5.3, 5.6: Фигуры + общая площадь + замкнутый квадрат
        // ---------------------------
        System.out.println("\n--- Задания 4.4 / 5.3 / 5.6: Фигуры ---");
        List<Figure> figs = new ArrayList<>();

        int circles = in.readIntInRange("Сколько кругов создать (0..5)? ", 0, 5);
        for (int i = 1; i <= circles; i++) {
            System.out.println("Круг #" + i);
            double cx = in.readDouble("Центр X: ");
            double cy = in.readDouble("Центр Y: ");
            double r = in.readDoublePositive("Радиус (>0): ");
            Circle c = new Circle(new Point(cx, cy), r);
            figs.add(c);
            System.out.println("Создан: " + c + ", площадь=" + String.format("%.2f", c.area()));
        }

        int squares = in.readIntInRange("Сколько квадратов создать (1..5)? ", 1, 5);
        for (int i = 1; i <= squares; i++) {
            System.out.println("Квадрат #" + i);
            double sx = in.readDouble("Левый верх X: ");
            double sy = in.readDouble("Левый верх Y: ");
            double a = in.readDoublePositive("Сторона (>0): ");
            Square sq = new Square(new Point(sx, sy), a);
            figs.add(sq);
            System.out.println("Создан: " + sq + ", площадь=" + String.format("%.2f", sq.area()));
            System.out.println("Замкнутая ломаная квадрата: " + sq.getPolyline());
        }

        // Прямоугольник
        System.out.println("\nПрямоугольник (для демонстрации площади):");
        double rx = in.readDouble("Левый верх X: ");
        double ry = in.readDouble("Левый верх Y: ");
        double w = in.readDoublePositive("Ширина (>0): ");
        double h = in.readDoublePositive("Высота (>0): ");
        Rectangle rect = new Rectangle(new Point(rx, ry), w, h);
        System.out.println("Создан: " + rect + ", площадь=" + String.format("%.2f", rect.area()));

        // Треугольник
        System.out.println("\nТреугольник (для демонстрации площади):");
        Point ta = new Point(in.readDouble("A.x: "), in.readDouble("A.y: "));
        Point tb = new Point(in.readDouble("B.x: "), in.readDouble("B.y: "));
        Point tc = new Point(in.readDouble("C.x: "), in.readDouble("C.y: "));
        Triangle tr = new Triangle(ta, tb, tc);
        System.out.println("Создан: " + tr + ", площадь=" + String.format("%.2f", tr.area()));

        // Общая площадь (5.3) — по кругам и квадратам (и вообще всем, что в списке)
        Figure[] arr = figs.toArray(new Figure[0]);
        System.out.println("\nОбщая площадь (сумма без учёта пересечений): " + String.format("%.2f", Figures.totalArea(arr)));

        // ---------------------------
        // Задания 6.2 и 8.4: equals и clone для Point
        // ---------------------------
        System.out.println("\n--- Задания 6.2 / 8.4: Сравнение и клонирование точки ---");
        System.out.println("Введите координаты первой точки:");
        Point p1 = new Point(in.readDouble("X1: "), in.readDouble("Y1: "));
        System.out.println("Введите координаты второй точки:");
        Point p2 = new Point(in.readDouble("X2: "), in.readDouble("Y2: "));

        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);
        System.out.println("equals(p1, p2) = " + p1.equals(p2));

        Point p1Clone = p1.clone();
        System.out.println("Клон точки 1: " + p1Clone);
        System.out.println("equals(p1, clone) = " + p1.equals(p1Clone));
        System.out.println("p1 == clone (ссылка одна и та же?) = " + (p1 == p1Clone));

        // ---------------------------
        // Задание 7.3: Возведение в степень
        // ---------------------------
        System.out.println("\n--- Задание 7.3: Возведение в степень ---");
        System.out.println("Можно ввести X и Y с клавиатуры, либо передать через аргументы командной строки.");
        String xs, ys;

        if (args != null && args.length >= 2) {
            xs = args[0];
            ys = args[1];
            System.out.println("Аргументы командной строки: X=" + xs + ", Y=" + ys);
        } else {
            xs = in.readNonEmptyString("Введите X (целое): ");
            ys = in.readNonEmptyString("Введите Y (целое): ");
        }

        // Используем короткие имена статических методов: parseInt и pow
        try {
            int X = parseInt(xs);
            int Y = parseInt(ys);
            System.out.println("Результат X^Y = " + pow(X, Y));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: X и Y должны быть целыми числами.");
        }

        System.out.println("\n=== Конец демонстрации. ===");
    }
}
