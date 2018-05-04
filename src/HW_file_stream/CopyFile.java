package HW_file_stream;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    private void writeToFile(String str, File file, boolean append) throws IIOException {

        try(OutputStream out = new FileOutputStream(file, append)) {
            byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readWithTryREs(File file) throws  IOException {
        try(InputStream in = new FileInputStream(file);
            ByteArrayOutputStream bout = new ByteArrayOutputStream()) {


            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) > 0) {
                bout.write(bytes, 0, len);
            }
            return new String(bout.toByteArray(), Charset.forName("UTF-8"));
        }
    }

    private List<String> readPartOfFile(File file, int step) throws  IOException {
        try(InputStream in = new FileInputStream(file);
            ByteArrayOutputStream bout = new ByteArrayOutputStream()) {

            List<String> result = new ArrayList<>();
            byte[] bytes = new byte[step];
            int len;
            while ((len = in.read(bytes)) > 0) {
                bout.write(bytes, 0, len);
                result.add(new String(bout.toByteArray(), Charset.forName("UTF-8")));
                bout.reset();
            }
            return result;
        }
    }

    private void writePartlyFile(String str, int step, File file, boolean append) throws IIOException {

        try(OutputStream out = new FileOutputStream(file, append)) {
            byte[] bytes = str.getBytes(Charset.forName("UTF-8"));

            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        CopyFile cf = new CopyFile();
        File fl = new File("hwfile.txt");
        cf.writeToFile("ololo", fl, true);
        File second = new File("hwfile_2.txt");
        cf.writeToFile(cf.readWithTryREs(fl), second, true);
        System.out.println(cf.readWithTryREs(second));
        System.out.println(cf.readPartOfFile(fl, 2));  // задача 2, разбили посимвольно

    }
}
