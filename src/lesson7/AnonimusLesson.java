package lesson7;
// анонимный класс


public class AnonimusLesson {
    public static void main(String[] args) {
        new Runnable() {
            @Override
            public void run() {
                System.out.println("run Forest, run");
            }
        }.run();

        SomeInterface someInterface = new SomeInterface() {
            @Override
            public int plus(int a, int b) {
                return a + b;
            }

        };

        // можно и на основе абстрактного класса
        SomeAbstract someAbstract = new SomeAbstract() {
            @Override
            void first() {

            }
        };
        someAbstract.plus(1,3); // можем вызвать не переопределенный метод
    }
}

abstract class SomeAbstract{
    abstract void first();
    public int plus(int a, int b) {
        return a+b;
    }

}

interface SomeInterface{

    public int plus(int a, int b);

}

class AnonimusExample{
    public void createClass(){

        // аноничный класс, где создается, там и описывается

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        runnable.run();

        // можем создать и через просто new Runnable()
        new Runnable() {
            @Override
            public void run() {

            }
        };


    }
}
