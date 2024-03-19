package MyList;

import java.util.Arrays;

public class MyArrayList <T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MyArrayList(){
        list = (T[]) new Object[DEFAULT_CAPACITY];    }
    public MyArrayList(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException("длинна должна быть больше 0");
        }
        list = (T[]) new Object[capacity];
    }

    public void add(T item){
        list[size++] = item;
    }

    public void add(int index, T item){
        if (index >= size){
            throw new IllegalArgumentException("вы вышли за пределы массива");
        }
        for (int i = 0; i < size; i++){
            if (index == i){
                list[i]=item;
            }
        }
    }

    public void remove(int index){
        if (index >= size){
            throw new IllegalArgumentException("вы вышли за пределы массива");
        }
        for (int i = index; i < size; i++){
            list[i] = list[i+1];
        }
        size--;
    }

    public T get(int index){
        if (index >= size){
            throw new IllegalArgumentException("вы вышли за пределы массива");
        }
        return list[index];
    }

    @Override
    public String toString() {
        T[] result = (T[]) new Object[size];
        for (int i = 0; i < size; i++){
            result[i] = list[i];
        }
        return Arrays.toString(result);

    }
}
