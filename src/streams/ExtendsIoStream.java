package streams;

import java.io.*;

public class ExtendsIoStream {

    // Можно расширять функциональность потоком путем оборачивания в другие потоки
    // например для упрощенной работы с приметивами и строками можно стандартные потоки обернуть в java.io.DataInputStream
    // и java.io.DataOutputsStream


    private void dataInputStream(InputStream in) throws IOException{
        DataInputStream data = new DataInputStream(in);
        int someInt = data.readInt();
        boolean someBiilean = data.readBoolean();
        String someStr = data.readUTF();
        System.out.printf("%s %s %s", someInt, someBiilean, someStr);
    }

    private void dataOutputStream(OutputStream out) throws IOException{
        DataOutputStream dataOut = new DataOutputStream(out);
        dataOut.writeInt(342);
        dataOut.writeBoolean(true);
        dataOut.writeUTF("OLOLO");
    }

    public static void main(String[] args) throws IOException {
        try(OutputStream outputStream = new FileOutputStream(new File("tst.txt"));){

            ExtendsIoStream ext = new ExtendsIoStream();
            ext.dataOutputStream(outputStream);
        }

    }

}
