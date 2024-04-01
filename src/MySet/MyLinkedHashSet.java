package MySet;

import java.util.HashMap;
import java.util.Map;

public class MyLinkedHashSet<T> {
    private static final Object PRESENT = new Object();
    private Map<T, Object> map;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public MyLinkedHashSet() {
        map = new HashMap<>();
    }

    public boolean add(T element) {
        if (!map.containsKey(element)) {
            map.put(element, PRESENT);
            Node<T> newNode = new Node<>(element);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            return true;
        }
        return false;
    }

    public boolean remove(T element) {
        if (map.containsKey(element)) {
            map.remove(element);
            Node<T> prev = null;
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(element)) {
                    if (prev != null) {
                        prev.next = current.next;
                        if (current.next == null) {
                            tail = prev;
                        }
                    } else {
                        head = current.next;
                        if (head == null) {
                            tail = null;
                        }
                    }
                    return true;
                }
                prev = current;
                current = current.next;
            }
        }
        return false;
    }

    public boolean contains(T element) {
        return map.containsKey(element);
    }

    public void clear() {
        map.clear();
        head = null;
        tail = null;
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public static void main(String[] args) {
        MyLinkedHashSet<Integer> set = new MyLinkedHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Set contains 2: " + set.contains(2)); // Output: true

        set.remove(2);
        System.out.println("Set contains 2: " + set.contains(2)); // Output: false

        System.out.println("Set size: " + set.size()); // Output: 2
    }
}
