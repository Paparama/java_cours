package lesson22MTHp3;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WordCountPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InputStream in = WordCountPool.class.getClassLoader().getResourceAsStream("wp.txt");

        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));

        List<String> lines = rdr.lines().collect(toList());

        Map<String, Integer> conclusion = new HashMap<>();
        Map<String, Integer> wordCnt = new HashMap<>();
        Map<String, Integer> sortedWordStat = new LinkedHashMap<>();

        int cpus = Runtime.getRuntime().availableProcessors();

        ExecutorService pool = Executors.newFixedThreadPool(cpus);

        List<Future<Map<String, Integer>>> futs = new ArrayList<>();

        int start = 0;
        int step = lines.size()/cpus;
        for (int i = 0; i < cpus; i++) {
            // TODO submit WordCountTask into pool, futures add to futs
            Future<Map<String, Integer>> fut = pool.submit(new WordCountTask(lines.subList(start, start + step)));
            futs.add(fut);
            start += step;
        }

        for (Future<Map<String, Integer>> fut : futs) {
            // TODO collect results
            wordCnt = fut.get();
            for (Map.Entry<String, Integer> entry: wordCnt.entrySet()) {
                if (conclusion.containsKey(entry.getKey())) {
                    conclusion.computeIfPresent(entry.getKey(), (k, v) -> v + entry.getValue());
                } else {
                    conclusion.put(entry.getKey(), entry.getValue());
                }
            }
        }

        pool.shutdown();
        conclusion.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(k -> sortedWordStat.put(k.getKey(), k.getValue()));

        int counter = 0;
        for (Map.Entry set: sortedWordStat.entrySet()) {
            System.out.println(set.getKey() + " " + set.getValue());
            counter++;
            if (counter == 99) {
                break;
            }
        }
    }

    private static class WordCountTask implements Callable<Map<String, Integer>> {
        private final List<String> lines;

        public WordCountTask(List<String> lines) {
            this.lines = lines;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> res = new HashMap<>();

            // TODO count words
            List<String> split_words = new ArrayList<>();
            for (String line: lines) {
                split_words.addAll(Arrays.asList(line.replaceAll("[-*\".,\'/()!?@#$%^&+=;:0-9\n\t]", "").split(" ")));
            }
            split_words.removeIf(s -> s.length() == 0);
            split_words = split_words.stream().map(String::toLowerCase).collect(Collectors.toList());

            for (String str: split_words) {
                if (res.containsKey(str)) {
                    res.computeIfPresent(str, (k, v) -> v+1);
                }
                else {
                    res.put(str, 1);
                }
            }


            return res;
            }

        }
}
