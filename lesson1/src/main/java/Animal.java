public abstract class Animal {
    public static int count;
    protected String name;
    protected int runLimit;
    protected int swimLimit;

    public Animal(String name, int runLimit, int swimLimit) {
        count++;
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(this + " пробежал " + distance + " метров");
        } else {
            System.out.println(this + " не смог пробежать " + distance + " метров");
        }
    }

    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println(this + " проплыл " + distance + " метров");
        } else {
            System.out.println(this + " не смог проплыть " + distance + " метров");
        }
    }
}
