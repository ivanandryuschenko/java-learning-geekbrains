/*
    ПРАКТИЧЕСКОЕ ЗАДАНИЕ 8
    по курсу GeekBrains ВТБ (Java для молодых специалистов)
    ******************************************************************************

    1. Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто
    встречающееся;
    2. Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
    среднюю зарплату сотрудника;
    3. Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
    сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
    имя1, имя2, имяN;”.
 */


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainApp {

    private static class Worker {
        private String name;
        private int age;
        private double salary;
        public Worker(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

    }

    public static void  showUniqueAndCount(String[] a) {
        HashMap<String, Integer> map = new HashMap();
        for (String s : a) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> o : map.entrySet()) {
            System.out.println(o.getKey()+ ": " + o.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Наиболее часто встречающееся слово: " + Arrays.asList("сыр", "рис", "мир", "сыр", "рис", "лес", "сыр").stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max((o1, o2) -> o1.getValue().intValue() - o2.getValue().intValue())
                .get().getKey());

        Worker[] workers = new Worker[] {
                new Worker("Jon", 40, 5000.0),
                new Worker("Tom", 30, 3000.0),
                new Worker("Sam", 35, 4000.0),
                new Worker("Den", 32, 4000.0)
        };

        System.out.println("Средняя зарплата сотрудников: " + Arrays.stream(workers)
                .collect(Collectors.averagingDouble(worker -> worker.salary)));

        int n = 2;
        System.out.println(Arrays.stream(workers)
                .sorted((w1, w2) -> w2.age - w1.age)
                .map((Function<Worker, String>) w -> w.name)
                .limit(n)
                .collect(Collectors.joining(", ",n + " самых старших сотрудников зовут: ",";")));
    }
}
