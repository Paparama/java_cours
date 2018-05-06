package HW_crypto_code;

import java.io.UnsupportedEncodingException;

public class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) throws UnsupportedEncodingException {
        wrappee.writeData(data);
    }

    @Override
    public String readData() throws UnsupportedEncodingException {
        return wrappee.readData();
    }
}
