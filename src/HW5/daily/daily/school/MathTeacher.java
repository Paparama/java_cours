package HW5.daily.daily.school;

public class MathTeacher extends Teacher {
    protected MathTeacher(String name){
        super(name, "Math");
    }

    protected MathTeacher(String name, String lesson) {
        super(name, "Math");
    }

    protected int plus(int a, int b){
        System.out.println("А я умею складывать, вот возьмем число " + a + " и число " + b + " в сумме дадут " + (a + b));
        return a + b;
    }
}
