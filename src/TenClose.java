import java.util.Scanner;
public class TenClose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float m = sc.nextFloat();
        float n = sc.nextFloat();
        if (Math.abs(m - 10) > Math.abs(n - 10)) {
            System.out.println(n);
        } else {
            System.out.println(m);
        }
    }
}
