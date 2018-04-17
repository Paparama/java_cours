package dublicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DubliczteNumbersCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] intString = sc.nextLine().split(" ");
        Set<String> result = new HashSet<>(Arrays.asList(intString));
        System.out.println("Повторяющихся элементов: " + (intString.length - result.size()));
    }
}
