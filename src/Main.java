 import MyList.MyStack;

 import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
 import java.util.*;

 public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        map.put(null, 12);
        map.put(null, 32);
        map.put(1, 32);
        map.put(1, 3);

        System.out.println(map);
    }
}