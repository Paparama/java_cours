import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();
        float disc = (float) (Math.pow(b, 2) - 4*a*c);
        if (disc < 0) {
            System.out.println("Вещественных корней нет");
        } else if (disc == 0) {
            System.out.println("Корень: " + -b/(2*a));
        } else {
            System.out.println("Первый корень: " + (-b+Math.sqrt(disc))/(2*a) + "  Второй кореь: " + (-b-Math.sqrt(disc))/(2*a));
        }
    }
}
