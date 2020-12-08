/*
    ПРАКТИЧЕСКОЕ ЗАДАНИЕ 2
    по курсу GeekBrains ВТБ (Java для молодых специалистов)
    ******************************************************************************

    1. Продолжаем работать с участниками и выполнением действий. Создайте три класса Человек,
    Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
    прыгать, все также с выводом информации о действии в консоль.

    2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
    должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
    печатаем в консоль (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина
    (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.

    3. Создайте два массив: с участниками и препятствиями, и заставьте всех участников пройти
    этот набор препятствий. Если участник не смог пройти одно из препятствий, то дальше по
    списку он препятствий не идет.
 */

public class MainApp {

    public static void main(String[] args) {
        Course[] courses = new Course[] {
                new Track(100),
                new Track(200),
                new Wall(80),
                new Track(300),
                new Wall(120)
        };

        Movable[] competitors = new Movable[] {
                new Man("Petr", 200, 100),
                new Man("Vlad", 250, 120),
                new Cat("Murzik", 400, 150),
                new Robot("Bender", 600),
                new Cat("Boris", 500, 140)
        };

        for (Movable comp : competitors) {
            boolean finish = true;
            for (Course c : courses) {
                finish = c.start(comp);
                if (finish == false)
                    break;
            }
            if (finish)
                System.out.println(comp + " успешно прошел все препятствия");
            else
                System.out.println(comp + " сошел с дистанции");
        }
    }
}
