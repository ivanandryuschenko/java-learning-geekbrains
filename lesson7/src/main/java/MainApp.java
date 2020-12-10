/*
    ПРАКТИЧЕСКОЕ ЗАДАНИЕ 7
    по курсу GeekBrains ВТБ (Java для молодых специалистов)
    ******************************************************************************

    Перенести приведенный ниже код в новый проект, где мы организуем гонки.
    - Все участники должны стартовать одновременно, несмотря на разное время подготовки.
    - В тоннель не может одновременно заехать больше половины участников (условность).
    - Попробуйте все это синхронизировать.
    - Когда все завершат гонку, нужно выдать объявление об окончании.
    - Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из
    пакета util.concurrent.
    - Обязательно необходимо объявить победителя гонки, он должен быть только один, и это участник
    первым закончивший последний этап.
*/

import java.util.*;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.CountDownLatch;

public class MainApp {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!" );
        Race race = new Race( new Road( 60 ), new Tunnel(CARS_COUNT / 2), new Road( 40 ));
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        CountDownLatch cdlBegin = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdlEnd = new CountDownLatch(CARS_COUNT);

        Car[] cars = new Car[CARS_COUNT];
        for ( int i = 0 ; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + ( int ) (Math.random() * 10 ), cb, cdlBegin, cdlEnd);
        }
        for ( int i = 0 ; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cdlBegin.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!" );
        try {
            cdlEnd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!" );
    }
}
