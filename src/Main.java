 import MyList.MyStack;
 import MyMap.MyHashMap;

 import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
 import java.util.*;
 import java.util.stream.Collectors;

 public class Main {
    public static void main(String[] args) {

        String s = "abc####d##c#";

        System.out.println(s.replaceAll("#", ""));
    }
}