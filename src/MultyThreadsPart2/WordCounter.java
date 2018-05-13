package MultyThreadsPart2;


import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WordCounter {
    private static Map<String, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream in = WordCounter.class.getClassLoader().getResourceAsStream("wp.txt");

        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));

        List<String> lines = rdr.lines().collect(toList());

        int cpus = Runtime.getRuntime().availableProcessors();

        List<WordCountThread> workers = new ArrayList<>();

        Map<String, Integer>  sortedWordStat = new LinkedHashMap<>();

        int start = 0;
        int step = lines.size()/cpus;
        for (int i = 0; i < cpus; i++) {
            // TODO implemen



            WordCountThread wct = new WordCountThread(lines.subList(start, start + step)); // разделить lines на равные части числом cpus
            start += step;
            workers.add(wct);
            wct.start();
        }

        for (WordCountThread worker : workers)
            worker.join();
        result.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(k -> sortedWordStat.put(k.getKey(), k.getValue()));

        // Выбрать топ 100 из result
        int counter = 0;
        for (Map.Entry set: sortedWordStat.entrySet()) {
            System.out.println(set.getKey() + " " + set.getValue());
            counter++;
            if (counter == 99) {
                break;
            }
        }
    }

    private static class WordCountThread extends Thread {
        private List<String> words;
        private Map<String, Integer> wordCnt = new HashMap<>();

        public WordCountThread(List<String> words) {
            this.words = words;
        }

        @Override
        public void run() {
            // Считаем в wordCnt
            List<String> split_words = new ArrayList<>();
            for (String line: words) {
                split_words.addAll(Arrays.asList(line.replaceAll("[-*\".,\'/()!?@#$%^&+=;:0-9\n\t]", "").split(" ")));
            }
            split_words.removeIf(s -> s.length() == 0);
            split_words = split_words.stream().map(String::toLowerCase).collect(Collectors.toList());

            for (String str: split_words) {
                if (wordCnt.containsKey(str)) {
                    wordCnt.computeIfPresent(str, (k, v) -> v+1);
                }
                else {
                    wordCnt.put(str, 1);
                }
            }

            // Сливаем в общую Map
            synchronized (result) {
                for (Map.Entry<String, Integer> entry: wordCnt.entrySet()) {
                    if (result.containsKey(entry.getKey())) {
                        result.computeIfPresent(entry.getKey(), (k, v) -> v + entry.getValue());
                    } else {
                        result.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }
}

