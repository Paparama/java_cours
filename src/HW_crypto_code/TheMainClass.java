package HW_crypto_code;

import java.io.UnsupportedEncodingException;

public class TheMainClass{
    public static void main(String[] args) throws UnsupportedEncodingException {
        String testText = "May-Mya gav-gav";

        DataSourceDecorator encripter = new EncryptionDecorator(new FileDataSource("testEncode"), "ishkere");
        encripter.writeData(testText);
        DataSource fileData = new FileDataSource("testEncode");
        System.out.println(fileData.readData());  // читаем закодироанный
        System.out.println(encripter.readData()); // читаем раскодированный
    }
}
