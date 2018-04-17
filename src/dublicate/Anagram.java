package dublicate;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder(sc.nextLine().replace(" ",""));
        List<StringBuilder> result = new ArrayList<>();
        for (int i= 0; i <= input.length(); i++) {
            for (int j=i+2; j<=input.length(); j++){
                StringBuilder check = new StringBuilder(input.substring(i, j));
                if (check.toString().equals(check.reverse().toString())) {
                    result.add(check);
                }
            }
        }
        System.out.println(result);

    }
}
