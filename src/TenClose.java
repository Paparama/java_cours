import java.util.Scanner;
public class TenClose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (m - 10 > n - 10) {
            System.out.println(n);
        } else {
            System.out.println(m);
        }
    }
}
