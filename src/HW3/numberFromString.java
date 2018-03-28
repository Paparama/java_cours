package HW3;


import java.util.Arrays;
import java.util.Scanner;

public class numberFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mainString = sc.nextLine();
        mainString = mainString.replaceAll("[^0-9]+", " ");
        String [] numbString = mainString.split(" ");
        int [] resul = new int [numbString.length-1];
        for (int i = 0; i < resul.length; i++) {
            resul[i] = Integer.parseInt(numbString[i+1]);
        }
        System.out.println(Arrays.toString(resul));
    }
}
