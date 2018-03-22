import java.util.Scanner;

public class SimpleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        if (m == 1 || m == 2) {
            System.out.println("Простое");
        } else {
            for (int i = 2; i <= m/2; i++) {
                if (m % i == 0) {
                    System.out.println("Не простое");
                    break;
                }
                if (i == m/2) {
                    System.out.println("Простое");
                }
            }

        }
    }
}
