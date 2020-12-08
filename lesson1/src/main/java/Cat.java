public class Cat extends Animal {
    public static int count;

    public Cat(String name, int runLimit) {
        super(name, runLimit, 0);
        count++;
    }

    @Override
    public void swim(int len) {
        System.out.println(this + " не умеет плавать");
    }

    @Override
    public String toString() {
        return "Кот " + name;
    }
}

