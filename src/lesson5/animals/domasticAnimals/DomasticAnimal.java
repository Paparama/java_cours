package lesson5.animals.domasticAnimals; // отметка принадлежности пакету


// для создания пакета можем прописать lesson5.animals.DomasticAnimal.DomasticAnimal

import lesson5.animals.Animal;
//import lesson5.animals.*;

public class DomasticAnimal extends Animal{  // имеет досуп ко всем не приватным методам и св-м родителя
    public DomasticAnimal(String name){
        super(name);  // вызываем конструктор родителя
    }

    public void liveWithPeople() {
        System.out.println("I'am live with people");
    }

//    public static void main(String[] args) {
//        DomasticAnimal da = new DomasticAnimal("Domastic");
//        da.say();
//        da.liveWithPeople();
//    }
}
