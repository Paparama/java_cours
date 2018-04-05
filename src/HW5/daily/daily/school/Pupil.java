package HW5.daily.daily.school;

import java.util.ArrayList;

public class Pupil extends Human {
    private ArrayList<String> lessons = new ArrayList<>();

    protected Pupil(String name) {
        super(name);
    }

    protected void getLessons() {
        for (String lesson: lessons) {
            System.out.println("Ученик посещяет: " + lesson);
        }
    }

    protected void setLesson(String lesson) {
        lessons.add(lesson);
    }
}
