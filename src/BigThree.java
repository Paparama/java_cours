import java.util.Scanner;

public class BigThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int max = a/100>a%10 ? a/100:a%10;
        max = max>a/10%10 ? max:a/10%10;
        System.out.println(max);
    }
}
