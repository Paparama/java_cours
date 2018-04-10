package lesson10;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class HashMaps {
    public static void main(String[] args) throws IOException {
//        CollectionExample col1 = new CollectionExample("ColEx", 4);
//        CollectionExample col2 = new CollectionExample("ColEx", 4);
//        CollectionExample col3 = new CollectionExample("ColExx", 3);
//        System.out.println(col1.hashCode());
//        System.out.println(col2.hashCode());
//        System.out.println(col3.hashCode());
//        System.out.println(col1.equals(col2));

        // для работы с коллекциями в джаве есть collection framework
        // встроены следующие интерфейсы
        // 1 Interface Set - коллекция без дубликатов
        // а) HashSet - реализация на основе хэш-таблицы. Это наиболее эффективная реализация, но она не гарантирует порядка
        // элементов при обходе
        Set<String> hs = new HashSet();
        System.out.println( hs.add("asd"));
        System.out.println( hs.add("12"));
        System.out.println( hs.add("d+64"));
        System.out.println( hs.add("asd"));
        System.out.println( hs.size());
        System.out.println( hs.remove("12"));

        for (String s: hs) {
            System.out.println(s);
        }

        Iterator<String> iter = hs.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


        // б) LinkedHashSet - реализация на осное хеш-таблицы, но дополнительно пролинокованная связанным списном.
        // Эта реализация избавляет от хаотичного порядка элементов


        // в) TreeSet - упорядываечет эл-ты в соот-ии с их зн-ем

        // 2 List  - упорядоченная коллекция, может содержать дубликаты
        // доступ к дополнительным методам - доступ, уделаение, добавление элементов по индексу
        // поиск элементов
        // операции с частью списка
        // замена элемента
        // ListIterator - расширенный итератор, который имеет методы hasPrevius
        //ListIterator<String> a;
        //a.hasPrevious();
        List<String> arrLst = new ArrayList<>();
        List<String> linkLst = new LinkedList<>(); // если часто вставки/удаления делаем
        // arrLst.subList(1, 3).clear(); - метода позволяет работать с частью списка



        // 3 Queue - однонаправленная очередь
        //element(); возвращает, но не удаляет элемент из начала очереди - при пустой коллекции генерит исключение
        // poll(); возвращает и удаляет элемент из начала очереди
        // peek() возвращает без удаления и не вызывает исключения, если очередь пуста
        //        Queue<String> queue;
        //        queue.peek()
        // remove() - удаляет элемент, возвращает, при пустом - кидает исключение

        // Deque - двунаправленная очередь (дополнительно getFirst, getLast etc.)
        Queue<String> queue = new PriorityQueue<>();
        queue.add("adf");

        // методы коллекций
        // size() - возвращает кол-во эле-ов
        // isEmpty() - пустая ли коллекция
        // contains(Object o) - возвращает содержится ли объект в коллекции
        // add(elem) - добавляет в конец коллекии элемент
        // remove(Object o) - удаляет первый объект и возвращает bool - если не удалил, то фолс
        // containsAll(Collection<> c) - вернет true, если в коллекции содержатся одинаковые элементы
        // addAll(collection<> c) - добавит коллекцию в нашу коллекцию
        // removeAll(Colection<> c) - из исходной удалит все элементы из переданной коллекции
        // clear() - очищает коллекцию

        File file = new File("./config.txt");
        List<String> lines = Files.readAllLines(file.toPath());
        List<String> result = new ArrayList<>();
        for (String str: lines) {
            str.toLowerCase();
            str.trim();
            for (String s: str.split(" ")){
                result.add(s);
            }
        }
        System.out.println(result.toString());


    }
}

class CollectionExample{
    private String name;
    private int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionExample that = (CollectionExample) o;
        return count == that.count &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, count);
    }

    public CollectionExample(String name, int count){
        this.name = name;
        this.count = count;
    }
        }