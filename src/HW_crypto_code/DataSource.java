package HW_crypto_code;

import java.io.UnsupportedEncodingException;

public interface DataSource {
    void writeData(String data) throws UnsupportedEncodingException;

    String readData() throws UnsupportedEncodingException;
}
