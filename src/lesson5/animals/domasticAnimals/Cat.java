package lesson5.animals.domasticAnimals;

import lesson5.animals.Animal;

public class Cat extends DomasticAnimal{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void say(){
        System.out.println("May");
    }

    public void raw(){
        System.out.println("raw-raw");
    }

    // перегруз метода
    public void say(String text){
        System.out.println(text);
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Murz");
        cat.say();
        cat.say("Kitty puff");
        cat.protectedVoid();  // доступен протектед метод родительского класса

        Dog dog = new Dog("Varya");
        dog.say();

        // полиморфизм наследования используем только методы класса анимал, но переопределенные кэтом
        Animal animal1 = new Cat("animal - cat");
        animal1.say();
        // animal1.raw(); не сработает
        Animal animal12= new Dog("animal - cat");
        animal12.say();
    }
}
