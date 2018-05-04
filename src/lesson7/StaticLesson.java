package lesson7;


public class StaticLesson {
    public static void main(String[] args) {
        // доступ к статич переменной через класс, через экземпляр класса - не выйдет
        System.out.println(StaticExample.staticTnt); // обращение к статической переменной
        StaticExample example = new StaticExample();
        System.out.println(StaticExample.staticTnt);
        StaticExample example1 = new StaticExample();
        StaticExample example2 = new StaticExample();
        System.out.println(example.nonStaticInt + " " + example1.nonStaticInt + " " + example2.nonStaticInt);
        System.out.println(StaticExample.staticTnt);
        StaticExample.StaticVoid(); // обращение к статическому методу

    }
}

class StaticExample implements StaticInterface{
    // могут быть переменные, методы, вложенные классы

    // статическая переменная
    static int staticTnt = 0;
    int nonStaticInt = 0;
    // статиеские переменные относятся к классу, а не объекту, обращение через класс

    public  StaticExample() {
        staticTnt++;
        nonStaticInt++;
    }
    // статические методы
    // не наследуются
    static protected void StaticVoid(){
        // могут вызывать только другие статические методы
        // могут работать со статическими переменными (только)
        // в них нельзя обращаться к this и super
        System.out.println(staticTnt);
    }

//    @Override  переопределить статический метод не можем
//    static void sttaticVoid() { // статические методы нельзя переопределять
//        System.out.println("staticVoid Interface");
//    }

}

interface StaticInterface{  // начиная с джава 8 есть возможность описывать в интерфейсах статические методы
    static void sttaticVoid() { // статические методы нельзя переопределять
        System.out.println("staticVoid Interface");
    }
    // доступны внутри интерфейса. Могут использоваться через интерфейс: имя_интерфейса.имя метода
}