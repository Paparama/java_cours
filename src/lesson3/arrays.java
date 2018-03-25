package lesson3;

import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {
        // в массивехранятся последовательности из однотипных переменных, объединенных общим имене
        // массив неизменяемый, длинна массива как задана, так и не меняется, можно поменять элемент массива только

        // Создаем массивы
        int[] arr1 = new int[3]; // кол-во элементов в массиве в []
        String arr2 [] = new String[2]; // в момент задания кол-ва элементов массива - выделяется память

        System.out.println(Arrays.toString(arr1) + "   " + Arrays.toString(arr2));

        int[] arr3 = {1, 2, 3, 4, 5}; // инициализация со значениями

        // доступ к элементу массива
        int arr3Elem = arr3[3];

        // заполнение значений в цикле

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = "elem #" + i;
        }
        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < arr3.length; i++) {
            System.out.println("index : " + i + ", elem : " + arr3[i]);
        }

        for (int value : arr3) {
            System.out.println(value);
        }

        int[] newArr3 = arr3.clone(); // копия массива
        //System.arraycopy(
                // массив - источник
                // позиция - начало нового массива
                // массив - назначение
                // начальная позиция целевого
                // кол-во элементов копируемых )
        int [] newArr4 = new int[3];
        System.arraycopy(arr3, 1, newArr4, 1, 2);
        System.out.println(Arrays.toString(newArr4));

        // Arrays.copyOf(исходный_массив, длинна_нового_массива);
        int[] newArr5 = Arrays.copyOf(arr3, 2);
        // Arrays.copyOfRange(исходный массив, начало, конец);
        int[] newArr6 = Arrays.copyOfRange(arr3, 1, 4);
        System.out.println(Arrays.toString(newArr6));

        // сравение массивов
        Arrays.equals(newArr5, arr3);

        // позволяет заполнить массив значениями (одинаковыми, в примере заполнит 2-ми)
        Arrays.fill(arr1, 2);

        // поиск по массиву (массив, индекс)  или искать в массиве в диапазоне значений, метод для упорядоченных массивов
        Arrays.binarySearch(arr1, 1); // возвращает индекс ключа, первый встретившийся
        Arrays.binarySearch(arr3, 1, 3, 3);


        // сортировка массива
        Arrays.sort(arr3);
        Arrays.parallelSort(arr3); // быстрее

        // Многомерные массивы
        //int [][] arr2D;
        //int [][][] arr3D;

        int[][] arr2d = new int[10][];
        for (int i = 0; i < arr2d.length; i++) {
            arr2d [i] = new int[i];

        }
        System.out.println(Arrays.deepToString(arr2d));
        System.out.println(Arrays.binarySearch(arr3, 1, 4, 1));

    }
}
