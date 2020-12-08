public class Wall extends Course {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean start(Movable competitor) {
        return competitor.jump(height);
    }
}
