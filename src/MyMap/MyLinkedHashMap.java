package MyMap;

import java.util.HashMap;
import java.util.Map;

public class MyLinkedHashMap<K, V> {
    private final Map<K, Node<K, V>> map;
    private Node<K, V> head;
    private Node<K, V> tail;

    public MyLinkedHashMap() {
        map = new HashMap<>();
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            removeNode(node);
            addToFront(node);
        } else {
            if (map.size() >= 10) {
                map.remove(tail.key);
                removeNode(tail);
            }
            Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            removeNode(node);
            addToFront(node);
            return node.value;
        }
        return null;
    }

    private void removeNode(Node<K, V> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addToFront(Node<K, V> node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> prev;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}