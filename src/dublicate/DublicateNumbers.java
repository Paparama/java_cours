package dublicate;

import java.util.*;

public class DublicateNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] intString = sc.nextLine().split(" ");
        Map<String, Integer> result = new HashMap<>();
        Arrays.asList(intString).forEach(s -> {
            if (result.containsKey(s)) {
                result.put(s, result.get(s) + 1);
            } else {
                result.put(s, 1);
            }
        });

        System.out.println(result.keySet());
    }
}
