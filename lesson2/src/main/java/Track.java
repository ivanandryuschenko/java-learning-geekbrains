public class Track extends Course {
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean start(Movable competitor) {
        return competitor.run(distance);
    }
}
