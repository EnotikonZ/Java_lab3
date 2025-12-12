package ru.semeshko.utils;

import ru.semeshko.geometry.Figure;

/**
 * Задание 5.3: общая площадь фигур.
 */
public class Figures {

    public static double totalArea(Figure[] figures) {
        double sum = 0;
        for (Figure f : figures) {
            sum += f.area();
        }
        return sum;
    }
}
