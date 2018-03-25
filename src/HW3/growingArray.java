package HW3;

// задача 5 массивы
public class growingArray {
    public static void main(String[] args) {
        int maxRandom = 90;
        int startRandom = 10;
        boolean flag = false;
        int [] randomArray = new int[4];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = startRandom + (int) (Math.random() * maxRandom);
            System.out.print(randomArray[i] + " ");
            if (i > 0 && randomArray[i-1] >= randomArray[i]) {
                flag = true;
            }
        }
        if (flag) {
            System.out.print("\nМассив не является строго возрастающей последовательностью");
        } else {
            System.out.print("\nУра, строго возрастающая последовательность");
        }

    }
}
