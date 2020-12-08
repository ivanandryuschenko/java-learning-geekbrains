public class Tiger extends Animal {
    public static int count;

    public Tiger(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        count++;
    }

    @Override
    public String toString() {
        return "Тигр " + name;
    }
}