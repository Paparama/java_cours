package HW5.daily.daily.school;

public class HistoryTeacher extends Teacher {
    protected HistoryTeacher(String name){
        super(name, "History");
    }

    protected HistoryTeacher(String name, String lesson) {
        super(name, "History");
    }

    protected void tellStory() {
        System.out.println("А вот в моем детстве, еще до всего до вот этого, еще в эпоху развитого социализма...");
    }
}
