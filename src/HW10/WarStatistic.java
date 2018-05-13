package HW10;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WarStatistic {
    public static void main(String[] args) throws IOException {
        int counter = 0;
        int proc = Runtime.getRuntime().availableProcessors();
        File file = new File("./wp.txt");
        List<String> words = TextCleaner.getWords(file);
        Map<String, Integer> wordsStat = TextCleaner.getAllWordsStat(words);
        Map<String, Integer>  sortedWordStat = new LinkedHashMap<>();
        wordsStat.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(k -> sortedWordStat.put(k.getKey(), k.getValue()));
        for (Map.Entry set: sortedWordStat.entrySet()) {
            System.out.println(set.getKey() + " " + set.getValue());
            counter++;
            if (counter == 9) {
                break;
            }
        }
        List<String> result4 = new ArrayList<>(words);
        List<String> articles = new ArrayList<>(Arrays.asList("a", "the", "on", "to", "into", "under", "of", "for", "as", "by", "or")); // cписок дополняется
        result4.removeIf(articles::contains);
        System.out.println(result4);
        System.out.println(TextCleaner.getWordsBySymbols(4, words));
        System.out.println(TextCleaner.getAllCharsStat(TextCleaner.worsdToChar(words)));

    }
}


