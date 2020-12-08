public class Cat implements Movable {
    private String name;
    private int maxDistance;
    private int maxHeight;

    public Cat(String name, int distance, int height) {
        this.name = name;
        maxDistance = distance;
        maxHeight = height;
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
        if (height <= maxHeight) {
            System.out.println(this + " успешно перепрыгнул стену высотой " + height + " сантиметров");
            return true;
        } else {
            System.out.println(this + " не смог перепрыгнуть стену высотой " + height + " сантиметров");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Кот " + name;
    }
}
