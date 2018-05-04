package serialisation.simplServer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class SimpleClient {

    private SocketAddress socketAdddress;
    private Scanner scanner;

    public SimpleClient(SocketAddress socketAdddress, Scanner sc) {
        this.socketAdddress = socketAdddress;
        this.scanner = sc;
    }

    public static void main(String[] args) throws IOException {
        String addr = null;
        Scanner sc = new Scanner(System.in);


        if (args != null && args.length > 0) {
            addr = args[0];
            SimpleClient simpleClient = new SimpleClient(parseAddr(addr), sc);
            simpleClient.start();
        }

        if (addr == null) {
            System.out.println("Enter server address");
            addr = sc.nextLine();
//            System.out.println("Enter your name");
//            name = sc.nextLine();
            SimpleClient simpleClient = new SimpleClient(parseAddr(addr), sc);
            simpleClient.start();
        }



    }

    private void start() throws IOException {
        System.out.println("Enter your name");
       String name = scanner.nextLine();
       while (true) {
           String msg = scanner.nextLine();
           buildMessage(name, msg);
       }
    }

    private void sendMess(Message message) throws IOException {
        try(Socket socket = new Socket()){
            socket.connect(socketAdddress);

            try (OutputStream out = socket.getOutputStream()) {
                ObjectOutputStream ois = new ObjectOutputStream(out);

                ois.writeObject(message);
                ois.flush();
            }
        }
    }

    private void buildMessage(String name, String msg) throws IOException {
        Message message = new Message(name, msg);
        sendMess(message);
    }

    private static SocketAddress parseAddr(String addr){
        String[] str = addr.split(":");
        return new InetSocketAddress(str[0], Integer.parseInt(str[1]));
    }

}
