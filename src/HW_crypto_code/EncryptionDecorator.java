package HW_crypto_code;

import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {
    String keyWord;

    public EncryptionDecorator(DataSource source, String keyWord) {
        super(source);
        this.keyWord = keyWord;
    }

    @Override
    public void writeData(String data) {
        super.writeData(data);
    }



    @Override
    public String readData() {
        return decode(super.readData());
    }

    public byte[] encrypt(String text, String keyWord)
    {
        byte[] arr = text.getBytes();
        byte[] keyarr = keyWord.getBytes();
        byte[] result = new byte[arr.length];
        for(int i = 0; i< arr.length; i++) {
            result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]); }
        return result; }

    public String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
