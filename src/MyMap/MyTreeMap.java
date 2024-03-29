package MyMap;

import java.util.Comparator;

public class MyTreeMap<K, V> {
    private Node<K, V> root;
    private Comparator<? super K> comparator;

    public MyTreeMap() {
        this.root = null;
        this.comparator = null;
    }

    public MyTreeMap(Comparator<? super K> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        int cmp = compare(key, node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    public V get(K key) {
        Node<K, V> node = get(root, key);
        return (node == null) ? null : node.value;
    }

    private Node<K, V> get(Node<K, V> node, K key) {
        while (node != null) {
            int cmp = compare(key, node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    private int compare(K key1, K key2) {
        if (comparator != null) {
            return comparator.compare(key1, key2);
        } else {
            return ((Comparable<? super K>) key1).compareTo(key2);
        }
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}