package HW3;
// массивы задание 8

public class teacherHelper {
    public static void main(String[] args) {
        int a;
        int b;
        String example;
        String [][] array2D = new String[8][];  // создаем таблицу умножения без зеркальных повторений (2*3 есть, 3*2 нет)
        for (int i = 0; i < array2D.length; i++) {
            array2D[i] = new String[8 - i];
            for (int j = 7; j >= i; j--) {
                array2D[i][j - i] = (i+2) +"*" + (j+2);
                }
        }
        for (int i = 0; i < 15; i++) {
            do {
            a = (int) (Math.random() * array2D.length);
            b = (int) (Math.random() * array2D[a].length);
            example = array2D[a][b];
            } while (example.equals("Used"));
            System.out.println(array2D[a][b]);
            array2D[a][b] = "Used";
        }
    }
}
