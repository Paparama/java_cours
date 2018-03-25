package HW3;
// строки 1 задача

import java.util.Scanner;

public class replaceString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mainString = sc.nextLine();
        String find = sc.nextLine();
        String replace = sc.nextLine();
        String result = mainString.replace(find, replace);
        System.out.println(result);
    }
}
