package HW3;
// задача 1 массивы

public class evenArray {
    public static void main(String[] args) {
        int [] evenArr = new int[10];
        for (int i = 0; i < evenArr.length; i++) {
            evenArr[i] = (i+1)*2;
        }
        for (int value: evenArr) {
            System.out.print(value + " ");
        }
        for (int value: evenArr) {
            System.out.print("\n" + value);
        }
    }
}
