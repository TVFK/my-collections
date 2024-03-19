package MyList;

import java.util.Stack;

public class MyStack <T>{
    private T[] array;

    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(){
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyStack(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("capacity must be more then 0");
        }
        array = (T[]) new Object[capacity];
    }

    public int size(){
        return this.size;
    }

    public void push(T pushObject){
        array[size++] = pushObject;
    }
    public T peek(){
        return array[size-1];
    }

    public T pop(){
        return array[--size];
    }

    public boolean isEmpty(){
        return size==0;
    }

}
