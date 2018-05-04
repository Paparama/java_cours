package streams;


// символьные потоки
// наследуются от java.io.Reader kava.io.Writer

import java.io.*;
import java.nio.charset.Charset;

// Класы для файдлвлшл ввлжа и вывлжа jaca.io.FileReader java.io.FileWriter
public class CharStream {
    private void writeToFile(String str, File file) throws IOException {
         try(Writer writer = new FileWriter(file)) {
             writer.write(str);
         }
    }

    private String readToStr(File file) throws  IOException{
        try(Reader reader = new FileReader(file)){
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[512];
            int len;
            while ((len = reader.read(buf)) > 0) {
                sb.append(buf, 0, len);
            }
            return sb.toString();
        }
    }

    // любой поток байт можно превратить в поток символов, обернув его в java.io.inputStreamReader ( мост между классом
    // InputStream и Reader) или в OutputStreamWriter ( мост между догадайся сам чем)

    // try (Reader reader = new InputStreamReader(new ByteArrayInputStream(массив байтов. Charset.forName("UTF-8")))

    private void readWithBuffer(File file) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")))) {

            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {

    }


}
