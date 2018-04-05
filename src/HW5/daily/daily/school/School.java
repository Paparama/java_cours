package HW5.daily.daily.school;

public class School {
    public static void main(String[] args) {
        HistoryTeacher ht = new HistoryTeacher("Anatoly");
        MathTeacher mt = new MathTeacher("Volodya");
        HighShoolPupil hp = new HighShoolPupil("Masha");
        FirstClassPupil firstClassPupil = new FirstClassPupil("Bob");
        ht.tellStory();
        mt.plus(1,2);
        firstClassPupil.getLessons();
        hp.goToSomeCourse("Economy");

    }
}
