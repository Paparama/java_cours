package HW3;

import java.util.Arrays;
import java.util.Scanner;

// задача 6 массивы

public class arrayScaner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int maxRandom = 11;
        int startRandom = -5;
        int leftAbs = 0;
        int rightAbs = 0;
        while (a % 2 == 1) {
            a = sc.nextInt();
        }
        int [] randomArray = new int[a];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = startRandom + (int) (Math.random() * maxRandom);
            System.out.print(randomArray[i] + " ");
            if (i < a/2) {
                leftAbs += Math.abs(randomArray[i]);
            } else {
                rightAbs += Math.abs(randomArray[i]);
            }
        }
        if (leftAbs > rightAbs) {
            System.out.print("Сумма модулей левой части больше, чем правой");
        } else if (leftAbs == rightAbs) {
            System.out.print("Сумма модулей левой части равна правой");
        } else {
            System.out.print("Сумма модулей правой части больше, чем левой");
        }
        System.out.println("\n" + Arrays.toString(randomArray));
    }
}
