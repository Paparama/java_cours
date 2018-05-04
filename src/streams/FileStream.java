package streams;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.Charset;

public class FileStream {


    // FileOutputStream - запись в файл
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

    // fileInputStream - для чтения файла
    private String readWithoutTryRes(File file) throws IOException{
        InputStream in = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) > 0) {
                bout.write(bytes, 0, len);
            }
            return new String(bout.toByteArray(), Charset.forName("UTF-8"));
        }
        finally {
            bout.close();
            if(in != null) {
                in.close();
            }
        }
    }


    // try with resourses вызывает close обязательно при завершении кострукции
    // объекты должны реализовывать интерфейс AutoClosable, которые передаются в try
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

    private String readWithBuffer(File file) throws IOException{
        try(InputStream in = new BufferedInputStream(new FileInputStream(file));
            ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) > 0) {
                bout.write(bytes, 0, len);
            }
            return new String(bout.toByteArray(), Charset.forName("UTF-8"));

        }
    }

    public static void main(String[] args) throws IIOException {
        FileStream bs = new FileStream();
        File file = new File("test.txt");
        bs.writeToFile("STRE\nSTR2\nstr3", file, true);
    }


}
