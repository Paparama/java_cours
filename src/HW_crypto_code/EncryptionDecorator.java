package HW_crypto_code;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {
    String keyWord;

    public EncryptionDecorator(DataSource source, String keyWord) {
        super(source);
        this.keyWord = keyWord;
    }

    @Override
    public void writeData(String data) throws UnsupportedEncodingException {
        super.writeData(new String(encrypt(data, keyWord), "UTF-8"));
    }



    @Override
    public String readData() throws UnsupportedEncodingException {
        return decode(super.readData().getBytes("UTF-8"), keyWord);
    }

    public byte[] encrypt(String text, String keyWord)
    {
        byte[] arr = text.getBytes();
        byte[] keyarr = keyWord.getBytes();
        byte[] result = new byte[arr.length];
        for(int i = 0; i< arr.length; i++) {
            result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]); }
        return result; }

    public String decode(byte[] text, String keyWord) {
        byte[] result = new byte[text.length];
        byte[] keyarr = keyWord.getBytes();
        for(int i = 0; i < text.length;i++) {
            result[i] = (byte) (text[i] ^ keyarr[i% keyarr.length]);
        }
        return new String(result); }
}



