package MyList;

import java.util.Arrays;

public class MyLinkedList <T>{
    private Node head;
    private int size;

    public void add(T value){
        // first addition to the LinkedList
        if (head == null){
            this.head = new Node(value);
        }
        else {
            Node temp = head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public T get(int index){
        int currentIndex = 0;
        Node temp = head;

        while(temp!=null){
            if(currentIndex==index){
                return (T) temp.getValue();
            }
            currentIndex++;
            temp = temp.getNext();
        }
        throw new IllegalArgumentException("wrong index has been entered");
    }

    public void remove(int index){
        if (index == 0){
            this.head= head.getNext();
            size--;
            return;
        }
        int currentIndex = 0;
        Node temp = head;

        while(currentIndex!=index-1){
            temp = temp.getNext();
            currentIndex++;
        }
        temp.setNext(temp.getNext().getNext());
        size--;
    }

    @Override
    public java.lang.String toString() {
        T[] result = (T[]) new Object[size];

        int idx = 0;
        Node temp = head;

        while (temp!=null) {
            result[idx++] = (T) temp.getValue();
            temp = temp.getNext();

        }
        return Arrays.toString(result);
    }

    private static class Node<T>{
        private T value;
        private Node next;

        public Node(){};
        public Node(T value) {
            this.value = value;
        }
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

