package HW3;
// задача 2 массивы

public class oddArray {
    public static void main(String[] args) {
        int[] oddArr = new int[50];
        for (int i = 0; i < oddArr.length; i++) {
            oddArr[i] = (i*2 + 1);
        }
        for (int value: oddArr) {
            System.out.print(value + " ");
        }
        System.out.print("\n");
        for (int i = oddArr.length - 1; i >= 0; i--) {
            System.out.print(oddArr[i] + " ");
        }
    }
}
