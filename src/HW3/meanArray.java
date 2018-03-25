package HW3;
// задача 4 массивы

public class meanArray {
    public static void main(String[] args) {
        int maxRandom = 6;
        int sumArr1 = 0;
        int sumArr2 = 0;
        int [] randomArray1 = new int[5];
        int [] randomArray2 = new int[5];
        for (int i = 0; i < randomArray1.length; i++) {
            randomArray1[i] = (int) (Math.random() * maxRandom);
            randomArray2[i] = (int) (Math.random() * maxRandom);
            sumArr1 += randomArray1[i];
            sumArr2 += randomArray2[i];
        }
        if ((float) sumArr1/randomArray1.length > (float) sumArr2/randomArray2.length) {
            System.out.println("Среднее арифметическое 1-го массива больше, чем у второго");
        } else if ((float) sumArr1/randomArray1.length < (float) sumArr2/randomArray2.length) {
            System.out.println("Среднее арифметическое 2-го массива больше, чем у первого");
        } else {
            System.out.println("Среднее арифметическое у обоих массивов равны");
        }
        System.out.print((float) sumArr1/randomArray1.length + "  " + (float) sumArr2/randomArray2.length);

    }
}
