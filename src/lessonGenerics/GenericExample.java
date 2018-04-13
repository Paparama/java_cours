package lessonGenerics;

public class GenericExample {
    /**
     * Подход к описанию данных и алгоритмов, который позволяет их использовать
     * с различными типами данных без изменения их описания
     */
    public static void main(String[] args) {
        Container container = new Container("Some value");
        Container container1 = new Container(null);
        String str = (String) container.getItemOrDefault("dflt");
        Integer integer = (Integer) container1.getItemOrDefault(0);
        System.out.println(str);
        System.out.println(integer);

        GecericContainer<String> gsc = new GecericContainer<>("Yoyo");  // до 1.7 включительно в скобках больше меньше тип был обязателен
        GecericContainer<Integer> gic = new GecericContainer<>(null);
        GecericContainer someObj = new GecericContainer(null); // можно вообще ничего не указывать, но при работе метода - приведение типа обязательно
        System.out.println( gsc.getItem("koko"));
        System.out.println( gic.getItem(0));
        // gic.getItem("asd")  - будет подсказка о неверном типе данных, при этом ошибка на моменте компиляции
        Pair<String, Integer> pair = new Pair<>("ololo", 300);

        // Generic соблюдает правило полиморфизма
        GecericContainer<Number> numbCont = new GecericContainer<>(null);
        Number number = numbCont.getItem(0);

    }
}

class Container{
    private Object item;
    public Container(Object item) {
        this.item = item;
    }

    public Object getItemOrDefault(Object dflt){
        return item == null ? dflt : item;
    }
}

class GecericContainer<T>{ // в угловых скобках указываем, что это неизвестный тип
    private T item;
    public GecericContainer(T item) {
        this.item = item;
    }

    public T getItem(T dflt) {
        return item == null ? dflt : item;
    }

}

// Допускается использовать несколько generic типов

class Pair<K, V> {
    // like a map
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue(){
        return this.value;
    }
}

