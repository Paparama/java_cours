package HW5.daily.daily.school;

public class HighShoolPupil extends Pupil {


    protected HighShoolPupil(String name) {
        super(name);
        this.setLesson("Math");
        this.setLesson("Math");
        this.setLesson("Math");
        this.setLesson("Math");
        this.setLesson("Math");
        this.setLesson("Languge");
    }

    protected void goToSomeCourse(String course) {
        System.out.println("Иду на подготовительные курсы по " + course);
    }
}
