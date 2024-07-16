import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> mp = new HashMap<>();
        mp.putIfAbsent("abc", new ArrayList<>());
        mp.get("abc").add(23);
        mp.get("abc").add(43);
        mp.get("abc").remove(Integer.valueOf(23));
        System.out.println(mp);
    }
}
