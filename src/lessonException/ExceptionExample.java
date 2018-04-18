package lessonException;

public class ExceptionExample {
    public static void main(String[] args) {
        // исключения - наследуются от Throwable, Error и Exception - 2 его прямых наследника
        // Error - ошибки JVM , обрабатывать теоретически можем, но по сути - нет
        // Exception(На этапе компиляции),  RuntimeException - случаются на этапе выполнения кода, их можно обрабатывать
        // tryException();  // вызываем NPE
        // throwException();  // вызов исключения

        // для обработки используем try catch блок
        try {
            throwException();
            tryException();
//            String[] st = new String[0];
//            st[0] = "ad";
        } catch (NumberFormatException e) {
            System.out.println("poymal oi oi oi " + e.fillInStackTrace());
        } catch (NullPointerException e) {  // можем добавлять несколько блоков
            System.out.println("NPE NPE");
        }
        finally {
            // блок, который будет обязательно
            System.out.println("koko");
        }
        // Начиная с 7 джавы исключения можно группировать через оператор | catch (NPE | NFE e)
        // можно отлавливать через родителя его детей

    }
    public static void tryException(){
        String a = null;
        a.equals("Str");
    }

    public static void throwException(){
        throw new NumberFormatException(" oi oi oi");  // можем добавить описание в консоле к ошибке
    }

    public static void tryExp2() throws Exception {
        throw new Exception("exex");  // метод выбрасывает эксепшн, которые не RunTime
        // для обработки либо обрабатываем в try catch, либо объявляем, что метод можем вызывать исключение
    }

}
