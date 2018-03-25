package HW3;
// задача 3 массивы

public class randomArray {
    public static void main(String[] args) {
        int maxRandom = 10;  // поскольку ф-я random возвращает число меньшее 1
        int counter = 0;
        int [] randomArray = new int[15];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int)(Math.random() * maxRandom);
            if (randomArray[i] % 2 == 0) {
                counter++;
            }
        }
        for (int value: randomArray) {
            System.out.print(value + " ");
        }
        System.out.print("\nЧетных чисел в массиве: " + counter);
    }
}
