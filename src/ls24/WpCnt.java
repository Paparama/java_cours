package ls24;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.util.function.Function;
import java.util.stream.Collectors;


public class WpCnt {

        public static void main(String[] args) throws IOException, InterruptedException {
            File file = new File("./wp.txt");
            Double avg = Files.lines(file.toPath()).parallel().map(l -> l.toLowerCase().replaceAll("\\pP", " "))
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(String::trim)
                    .filter(w -> !"".equals(w))
                    .collect(Collectors.averagingInt(l -> l.length()));
            System.out.println(avg);
        }

}
