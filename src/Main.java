 import MyList.MyStack;
 import MyMap.MyHashMap;

 import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
 import java.util.*;

 public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyHashMap<Integer, Integer> map = new MyHashMap<>();

        map.put(1, 2);
        map.put(1, 4);
        map.put(3, 8);


        System.out.println(map.get(1));
    }
}