package lesson10;

import java.util.*;

public class MapExample {
    // Map хранит 2 объекта - ключ и значение, типы всегда ссылочные должны быть, ключи должны быть уникальны
    // можно искать по ключу, значению

    // SortedMap - элементы размещаются по возрастанию ключей
    // NavigableMap - расширяет SortedMap
    // Map.Entry - позволяет работать с элементами

    // LinkedMap - запоминает порядок элементов добавления
    // TreeMap - отсортирует ключи
    // WeakHashMap - значения могут удаляться сборщиком мусора, елси не используются
    // IdentityHashMap - ключи сравниваются с помощью ==, вместо equals
    // для перебора можно использовать цикал for (Map.Entry entry: MapName.entrySrt())
//    TreeMap();
//    TreeMap(Comparator comp) - можем передать объект с сортировкой ключей так, как нужно
    // TreeMap(Map m) - на основе другой коллекции
    // TreeMap(SortedMap sortm) - тогда сортировка на основании переданной отсортированной

    final static Map<String, String > fmap = new LinkedHashMap<>();

    public static void main(String[] args) {
        fmap.put("qew", "asd"); // все равно можем добавлять значения
        Map<String, String>  newMap = Collections.unmodifiableMap(fmap); // а так - нельзя будет
        // newMap.put("fds", "gd");
        //System.out.println(newMap);
    }



}
