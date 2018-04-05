package lesson7;

public class FinalLesson {
    public static void main(String[] args) {

    }
}


final class FinalChilde extends FinalExample{
    // не может иметь наследников класс final
    protected void spmeVoid(final int a) {
        // a = 9; - с аргументами с final присвоение нового значения не пройдет
        boolean isTwo = a == 2;
    }

}


class FinalExample{
    // final могут быть объявлены переменные, методы, классы и аргументы методов и локальные переменные методов
    // переменная, обязательно должна быть проинициализированна, иначе ошибка
    // final для переменной означает, что ее значение мы не можем изменить (иммутабельность)
    final int finalVar = 9;

    // методы final
    // методы final не могут быть переопределены наследником, но наслнедуются
    final protected void finalVoid(){
        System.out.println("FinalVoid");
    }

    protected void getOne(){
        System.out.println("1");
    }
}
