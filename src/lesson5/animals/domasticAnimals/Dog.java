package lesson5.animals.domasticAnimals;

public class Dog extends DomasticAnimal{
    public Dog(String name) {
        super(name);
    }

    @Override // сообщаем компилятору о переопределении метода
    public void say() {
        //super.say();  // если в рамках метода хотим использовать родительский метод для переорпеделения поведения
        System.out.println("Gav"); // переопределяем метод родителя
    }

//    public static void main(String[] args) {
//        Dog dog = new Dog("Varyk");
//        dog.liveWithPeople();
//        dog.say();
//    }
}
