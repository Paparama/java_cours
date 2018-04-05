package lesson7;
// вложенные классы
// static
// member innter
// local classes

public class InnerLesson {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerStatic innerStatic = new OuterClass.InnerStatic(); // создали объект внутреннего класса через обращение к внешнему
        innerStatic.someVoid();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass(); // создаем не статик класс
    }
}

class OuterClass {
    private int nonstaticInt = 1;
    private static int staticInt = 1;

    public OuterClass() {
        InnerStatic innerStatic = new InnerStatic();
        System.out.println(innerStatic.nonStaticInt); // доступ к его нестатическим полям есть
        InnerClass innerClass = new InnerClass();
        innerClass.innerVoid();
    }
    // вложенный статический класс
    static class InnerStatic {
        private int nonStaticInt = 1;

        public void someVoid() {
            staticInt++; // есть доступ к статическим св-в и методам, к нестатическим доступа нет
            // nonstaticInt++; будет ошибка
        }

    }

    // внутренние нестатические классы
    class InnerClass {
        public void innerVoid() {
            System.out.println(staticInt + " " + nonstaticInt); // видит и статическую и нестатическую переменную внешнего класса
        }
        // не может содержать статические методы и св-ва
        // public static void - ошибка
    }
    // внутри метода тоже можем сделать класс, называют - локальными методами
    protected void localVoid() {
        class MethodClass{
            int a = 5;
            public int getA() {
                return this.a;
            }

            public void printSmth(){
                System.out.println(staticInt);  // видит и статические и нестатические св-ва основного класса
                System.out.println(nonstaticInt);
            }

        }
        MethodClass m = new MethodClass();
        System.out.println(m.a);
        m.getA();
    }


}

class ChildOuter extends OuterClass{  // можно отнаследоваться от внутреннего класса, если позволяет доступ
    public void someVoid(){

    }
}