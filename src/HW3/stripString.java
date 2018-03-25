package HW3;

import java.util.Scanner;

public class stripString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mainString = sc.nextLine();
        mainString = mainString.replace(" ", "");
        for (int i = 0; i < mainString.length(); i++) {
            if (mainString.indexOf(mainString.charAt(i)) == i) {
                System.out.print(mainString.charAt(i));
            }
        }
    }
}
