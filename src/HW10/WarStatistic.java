package HW10;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WarStatistic {
    public static void main(String[] args) throws IOException {
        File file = new File("./wp.txt");
        Map<Integer, String> stat = new HashMap<>();
        List<String> words = TextCleaner.getWords(file);
        Set<String> setWord = new HashSet<>(words);
        for (String wd: setWord) {  // задача 1, получили статистику по каждому слову
            stat.put(TextCleaner.getWordStat(wd, words), wd);
        }
        //System.out.println( TextCleaner.getWordsBySymbols(3, words)); // реализован метод для собирания в группу слов по кол-ву символов
        Map<Integer, String> tm = new TreeMap<>(stat);
        int tmSize = tm.size();
        List<String> result3 = new ArrayList<>(tm.values()).subList(tmSize-10, tmSize);
        System.out.println(result3);  // ответ на 3 задачку
        List<String> result4 = new ArrayList<>(words);
        List<String> articles = new ArrayList<>(Arrays.asList("a", "the", "on", "to", "into", "under")); // cписок дополняется
        result4.removeIf(articles::contains);
        System.out.println(result4);

    }
}


