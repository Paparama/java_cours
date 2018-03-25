package HW3;

import java.util.Arrays;

// Задача 7 на массива

public class multyDimantionArray {
    public static void main(String[] args) {
        int [][] array2D = new int [5][8];
        int startRandom = -99;
        int maxRandom = 199;
        int maxValue = -100;
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                array2D[i][j] = startRandom + (int) (Math.random() * maxRandom);
                if (array2D[i][j] > maxValue){
                    maxValue = array2D[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(array2D));
        System.out.println(maxValue);

    }
}
