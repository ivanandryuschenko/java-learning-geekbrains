import java.util.*;

public class Phonebook {
    private HashMap<String, HashSet<String>> map;

    Phonebook() {
        map = new HashMap<>();
    }

    public void add(String name, String number) {
        if (!map.containsKey(name)) {
            map.put(name, new HashSet());
        }
        map.get(name).add(number);
    }

    public void get(String name) {
        System.out.print(name + ": ");
        if (map.containsKey(name)) {
            System.out.println(map.get(name));
        } else {
            System.out.println("Нет номера");
        }
    }
}
