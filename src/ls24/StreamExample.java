package ls24;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        var list = List.of("one", "two", "three");

        int len = 0;
        for (String s: list){
            len += s.length();
        }
        System.out.println(len);

        var res = list.stream()  // стримы никогда не меняют источник, для них он имьютбл
                .map( s -> s.length())  // преобразует тип, преобразуя каждый элемент в его длинну
                .reduce(0, (i1, i2) -> i1 + i2 );
        System.out.println(res);

        Stream<String> stream = list.stream();

        Stream<Integer> integerStream = stream.map(s -> s.length());
        System.out.println(integerStream);
        Integer reduce = integerStream.reduce(0, (i1, i2) -> i1 + i2);

        System.out.println(reduce);

        Stream<Integer> integerStream1 = IntStream.range(0, 100).boxed();  // получаем стрим инициированный
        integerStream1.forEach(System.out::println);



    }
}
