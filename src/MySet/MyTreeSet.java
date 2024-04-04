package MySet;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MyTreeSet<T> {
    private static final Object PRESENT = new Object();
    private transient NavigableMap<T, Object> map;

    public MyTreeSet() {
        map = new TreeMap<>();
    }

    public MyTreeSet(Comparator<? super T> comparator) {
        map = new TreeMap<>(comparator);
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
        MyTreeSet<Integer> set = new MyTreeSet<>();
        set.add(3);
        set.add(1);
        set.add(2);

        System.out.println("Set contains 2: " + set.contains(2));

        set.remove(2);
        System.out.println("Set contains 2: " + set.contains(2));

        System.out.println("Set size: " + set.size());
    }
}
