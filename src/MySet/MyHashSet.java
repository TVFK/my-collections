package MySet;

import java.util.HashMap;
import java.util.Map;

public class MyHashSet<T> {
    private static final Object PRESENT = new Object();
    private Map<T, Object> map;

    public MyHashSet() {
        map = new HashMap<>();
    }

    public boolean add(T element) {
        return map.put(element, PRESENT) == null;
    }

    public boolean remove(T element) {
        return map.remove(element) == PRESENT;
    }

    public boolean contains(T element) {
        return map.containsKey(element);
    }

    public void clear() {
        map.clear();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public static void main(String[] args) {
        MyHashSet<Integer> set = new MyHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Set contains 2: " + set.contains(2)); // Output: true

        set.remove(2);
        System.out.println("Set contains 2: " + set.contains(2)); // Output: false

        System.out.println("Set size: " + set.size()); // Output: 2
    }
}
