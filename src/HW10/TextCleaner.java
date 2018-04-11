package HW10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class TextCleaner {
    static List<String> result = new ArrayList<>();

    protected static List<String> getWords(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        List<String> result = new ArrayList<>();
        for (String line: lines) {
            result.addAll(Arrays.asList(line.replaceAll("[-*\".,\'/()!?@#$%^&+=;:0-9\n\t]", "").split(" ")));
        }
        result.removeIf(s -> s.length() == 0);
        return result;
    }

    protected static Set<String> getWordsBySymbols(int i, List<String> text) {
        text.removeIf(s -> (s.length()!= i));
        return new HashSet<String>(text);
    }

    protected static int getWordStat(String word, List<String> text) {
        if (word == null) { return 0;}
        List<String> result = new ArrayList<>(text);
        result.removeIf(s -> !s.equals(word));
        return result.size();
    }

    protected static Map<String, Integer> getAllWordsStat(List<String> text){
        Map<String, Integer> result = new HashMap<>();
        for (String str: text) {
            if (result.containsKey(str)) {
                result.computeIfPresent(str, (k, v) -> v+1);
            }
            else {
                result.put(str, 1);
            }
        }
        return result;
    }

}
