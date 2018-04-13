package lessonGenerics;

public class WildCArdExample {
    public static void main(String[] args) {
        GecericContainer<Integer> container = new GecericContainer<>(null);
        getDouble(container);
    }

//    public static double getDouble(GecericContainer<? extends Number> container){
//        return container.getItem(0.0).doubleValue();
//    }
    // upper bound wildcard - ограничиваем принимаемый тип сверху ? - неизвестный тип, наследник Number
        public static double getDouble(GecericContainer<? extends Number> container){
        Number val = container.getItem(null);
        // нельзя добавить ничего, кроме null, т.к. неизвестен конкретный тип на момент компиляции, но можно получить number
            return val == null ? 0.0 : val.doubleValue();
    }


    // ограничение снизу
    public static void printNum(GecericContainer<? super Number> container){
        // можем добавлять Number и всех его наследников, но получить можем только Object
        Object val = container.getItem(0.0);  // сюда передавать
        System.out.println(val);
    }
}
// можно применять для уточнения при описании класса, чтобы использовать нужные методы
class GenericNumContainer<T extends Number>{
    private T item;
}


