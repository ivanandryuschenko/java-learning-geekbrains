public class Dog extends Animal {
    public static int count;

    public Dog(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        count++;
    }

    @Override
    public String toString() {
        return "Пёс " + name;
    }
}
