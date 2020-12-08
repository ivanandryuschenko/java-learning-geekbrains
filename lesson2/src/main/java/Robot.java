public class Robot implements Movable {
    private String name;
    private int maxDistance;

    public Robot(String name, int distance) {
        this.name = name;
        maxDistance = distance;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxDistance) {
            System.out.println(this + " успешно пробежал " + distance + " метров");
            return true;
        } else {
            System.out.println(this + " не смог пробежать " + distance + " метров");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        System.out.println(this + " не умеет прыгать");
        return false;

    }

    @Override
    public String toString() {
        return "Робот " + name;
    }
}
