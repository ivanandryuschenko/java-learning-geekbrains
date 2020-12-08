import java.util.*;

public class Box <T extends Fruit> {
    private ArrayList<T> fruits;
    
    public Box() {
        fruits = new ArrayList<>();
    }
    
    public void add(T f) {
        fruits.add(f);
    }
    
    public float getWeight() {
        float weight = 0;
        for (T f : fruits)
            weight += f.getWeight();
        return weight;
    }
    
    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }
    
    public void transfer(Box<T> box) {
        for (T f : fruits)
            box.add(f);
        fruits.clear();
    }
    
    public String toString() {
        return "В коробке " + fruits.size() + " фруктов";        
    }
}
