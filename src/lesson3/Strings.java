package lesson3;

public class Strings {
    public static void main(String[] args) {
        // строка - объект, хранящий в себе набор символов
        String str = "Yo_yo--- yo";  // неизменяемый объект
        String str2 = new String("Yo yo mthfk");

        // форматирование вывода чисел


        String st = String.format("шаблон со спец символами %d%n it's cool yo yo yo", 222); // но оч медленно, пзда ваще
        System.out.println(st);
        StringBuilder sb = new StringBuilder(); // изменяемые строки
        StringBuffer sbf = new StringBuffer(); // требует больше ресурсов, но безопасен для потоков

        sb.append("some new").append("sm stpd txt"); // изменяем объект
        sb.insert(3, "no way");
        System.out.println(sb);

        StringBuilder sbLoop = new StringBuilder();

        long start = System.nanoTime();
        String stFromLoop = "";
        for (int i = 0; i < 100; i++) {
            sbLoop.append("kokoko" + i); // предпочтительнее, меньше ресурсов для длинных строк
            //stFromLoop += " number " + i;
        }
        long end = System.nanoTime();

        System.out.println("Time: " + (start - end)/1000000.00);

        start = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            stFromLoop += "kokoko" + i;
        }

        end = System.nanoTime();

        System.out.println("Time: " + (start - end)/1000000.00);
        System.out.println(sbLoop);

        // javap -c file_name для просмотра скомпилированного файла

        // сравнение
        // str.equals(str2);
        // str.equalsIgnoreCase(str2)
        // str.compareTo(str2) str.CompareToIgnoreCase(str2) - ингорим регистр
        // 0 - если аргумент лексически равен строке
        // > 0 если аргумент больше строки
        // < 0 если аргумент меньше строки

        str.startsWith("q");
        str.endsWith("e");

        str.length(); // длинна

    }
}
