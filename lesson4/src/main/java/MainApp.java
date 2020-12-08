/*
    ПРАКТИЧЕСКОЕ ЗАДАНИЕ 4
    по курсу GeekBrains ВТБ (Java для молодых специалистов)
    ******************************************************************************

    1. Написать метод, который меняет два элемента массива местами (массив может быть любого
    ссылочного типа).

    2. Написать метод, который преобразует массив в ArrayList.

    3. Задача:
        a. Даны классы Fruit -> Apple, Orange.

        b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
        фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины.

        c. Для хранения фруктов внутри коробки можно использовать ArrayList.

        d. Написать метод getWeight(), который высчитывает вес коробки. Задать вес одного
        фрукта и их количество: вес яблока — 1.0f, апельсина — 1.5f (единицы измерения не
        важны).

        e. Внутри класса Box написать метод Compare, который позволяет сравнить текущую
        коробку с той, которую подадут в Compare в качестве параметра. True, если их массы
        равны, False — в противном случае. Можно сравнивать коробки с яблоками и
        апельсинами.

        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя высыпать яблоки в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остаётся, а в другую перекидываются
        объекты, которые были в первой.

        g. Не забываем про метод добавления фрукта в коробку.
*/

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Integer[] iArray = {1, 5, 3, 7, 8, 10};
        ArrayUtils<Integer> au = new ArrayUtils<>();
        
        System.out.println("iArray before: " + au.toArrayList(iArray));
        au.swap(iArray, 1, 2);
        System.out.println("iArray after: " + Arrays.toString(iArray));
        
        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        
        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        
        if (appleBox.compare(orangeBox))
            System.out.println("Коробки имеют одинаковый вес");
        else
            System.out.println("Коробки имеют разный вес");
        
        System.out.println(appleBox);
        
        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        
        System.out.println(appleBox2);
        
        appleBox.transfer(appleBox2);
        
        System.out.println(appleBox);
        System.out.println(appleBox2);
    }
}
