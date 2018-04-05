package HW5.daily.daily.school;

public class Teacher extends Human{
    String lesson;
    protected Teacher(String name, String lesson) {
        super(name);
        this.lesson = lesson;
    }

    protected void learn(){
        System.out.println("Обучаю предмету :" + lesson);
    }
}
