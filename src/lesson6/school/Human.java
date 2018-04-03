package lesson6.school;

public interface Human {
    // интерфейс позволяет определить методы, которые дальше будут реализованы в классе
    void setName(String name);
    String getName();

    // на основе интерфейса нельзя создать объект, методы - публичные, без конкретной реализации
    // хотя можно сделать реализацию метода, ключевое слово default
    default void sayHi(){
        System.out.println("Hi");
    }
}

interface Teacher extends Human{
    void teach(Pupil pupil);
}

interface Pupil extends Human{
    void study(SchoolTeacher teacher);
}

class FirstYearPupil implements Pupil, Human{
  // класс, который реализует - реализует все его методы
    // допускается множественное наследование от интерфейсов
    String name;

    @Override
    public void setName(String name) {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void study(SchoolTeacher teacher) {
        System.out.println("Меня учит :" + teacher.name);
    }

    @Override
    public void sayHi(){
        System.out.println("Privet");
    }
}

class SchoolTeacher implements Teacher{
    String name;

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void teach(Pupil pupil) {

    }

    public static void main(String[] args) {
        Pupil pupil = new FirstYearPupil(); // интерфейс может выступать как "родительский класс"
    }
}

// Абстрактные классы
// описывают базовый функционал наследников, могут иметь как реализованные, так и нет методы
// нельзя создать экземпляры класса

abstract class DomasticAnimal{
    public String getName() {
        return "DomasticAnimal";
    }

    abstract void eat(); // если без реализации

    public void say(){
        System.out.println("May");
    }
}

class Dog extends DomasticAnimal implements Human{  // можно и интерфейс отнаследовать вместе с абстрактным классом

    @Override
    void eat() {
        System.out.println("vaf amnyam");
    }

    @Override
    public void setName(String name) {

    }
}

