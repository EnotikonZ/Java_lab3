package ru.semeshko.students;

import java.util.Arrays;

/**
 * Задание 1.9: Студент. Разрешены оценки только 2..5.
 */
public class Student {

    private final String name;
    private int[] grades;

    public Student(String name) {
        this.name = name;
        this.grades = new int[0];
    }

    /**
     * Добавляет оценку, если она в диапазоне [2;5].
     */
    public boolean addGrade(int grade) {
        if (grade < 2 || grade > 5) return false;
        grades = Arrays.copyOf(grades, grades.length + 1);
        grades[grades.length - 1] = grade;
        return true;
    }

    /**
     * Возвращает копию массива — изменить оценки “снаружи” нельзя.
     */
    public int[] getGrades() {
        return Arrays.copyOf(grades, grades.length);
    }

    public double getAverage() {
        if (grades.length == 0) return 0.0;
        double sum = 0;
        for (int g : grades) sum += g;
        return sum / grades.length;
    }

    public boolean isExcellent() {
        if (grades.length == 0) return false;
        for (int g : grades) if (g != 5) return false;
        return true;
    }

    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}
