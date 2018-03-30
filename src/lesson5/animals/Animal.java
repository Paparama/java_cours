package lesson5.animals;

public class Animal {
    // модификаторы доступа,
    // public - виден везде
    // protected - виден везде, где находится класс и наследникам
    // отсутствие модификатора(default) - виден только для класса
    // private - виден только в рамках своего класса

    // static - используется у класса, но не у объекта

    private String name;
    public Animal(String name) {
        this.name = name;
    }

    private void privateVoid() {  // не доступен для кошки
        System.out.println("private");
    }

    protected void protectedVoid() {  // доступен для кошки
        System.out.println("protected");
    }

    void defaultVoid() {
        System.out.println("default");
    }

    public void say() {
        System.out.println("Animal");
    }
}
