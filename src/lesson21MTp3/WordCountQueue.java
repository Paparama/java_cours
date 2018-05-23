package lesson21MTp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WordCountQueue {
    private static Map<String, Integer> result = new HashMap<>();
    private static final String STOP = new String();
    final static private Object monitorResult = new Object();

    // TODO
    // Задача №2
    // Результаты сложить в другую очередь для main,
    // а main сольет их вместе.

    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream in = WordCountQueue.class.getClassLoader().getResourceAsStream("wp.txt");

        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));

        List<String> lines = rdr.lines().collect(toList());
        Map<String, Integer>  sortedWordStat = new LinkedHashMap<>();
        lines.add(STOP);

        int cpus = Runtime.getRuntime().availableProcessors();

        List<WordCountThread> workers = new ArrayList<>();
        BlockingQueue<String> linesQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < cpus; i++) {
            // TODO implement
            WordCountThread wct = new WordCountThread(linesQueue);

            workers.add(wct);
            wct.start();
        }

        // В добавить lines в linesQueue.
        linesQueue.addAll(lines);

        for (WordCountThread worker : workers)
            worker.join();

        // Выбрать топ 10 из result
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
        private final BlockingQueue<String> linesQueue;
        private Map<String, Integer> wordCnt = new HashMap<>();

        private WordCountThread(BlockingQueue<String> linesQueue) {
            this.linesQueue = linesQueue;
        }

        @Override
        public void run() {
            // Считаем в wordCnt
            while (!isInterrupted()) {
                try {
                    String line = linesQueue.take();

                    if (line == STOP) {
                        linesQueue.add(STOP);
                        this.interrupt();
                        break;
                    }
                    // Код обработки строки,

                    List<String> split_words = new ArrayList<>(Arrays.asList(line.replaceAll("[-*\".,\'/()!?@#$%^&+=;:0-9\n\t]", "").split(" ")));


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

                    // добавляем результат в wordCnt
                    synchronized (monitorResult) {
                        for (Map.Entry<String, Integer> entry: wordCnt.entrySet()) {
                            if (result.containsKey(entry.getKey())) {
                                result.computeIfPresent(entry.getKey(), (k, v) -> v + entry.getValue());
                            } else {
                                result.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    wordCnt.clear();
                } catch (InterruptedException e) {
                    return;
                }
            }

            // Сливаем в общую Map
        }
    }
}
