/*
    ПРАКТИЧЕСКОЕ ЗАДАНИЕ 3
    по курсу GeekBrains ВТБ (Java для молодых специалистов)
    ******************************************************************************

    1. Создайте исключения: MyArraySizeException (неправильный размер массива), и
    MyArrayDataException (в ячейке массива лежит что-то не то);

    2. Напишите метод, на вход которого подаётся двумерный строковый массив (String[][]) размером
    4×4. При подаче массива другого размера необходимо бросить исключение
    MyArraySizeException.

    3. Далее метод должен пройтись по всем элементам массива, преобразовать в int и
    просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
    ячейке лежит символ или текст вместо числа), должно быть брошено исключение
    MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные. Расчет
    данных для этой матрицы прекращается.

    4. В методе main() нужно вызвать полученный метод, обработать возможные исключения
    MySizeArrayException и MyArrayDataException и вывести результат расчёта.
 */

public class MainApp {
    public static int sumArray(String[][] a) {
        int summ = 0;

        if (a.length != 4)
            throw new MyArraySizeException();

        for (int i = 0; i < 4; i++) {
            if (a[i].length != 4)
                throw new MyArraySizeException();

            for (int j = 0; j < 4; j++) {
                try {
                    summ += Integer.valueOf(a[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] неверные данные");
                }
            }
        }

        return summ;
    }

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            int sum = sumArray(array);
            System.out.println("Сумма всех элементов массива = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Задан неправильный размер массива");
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
