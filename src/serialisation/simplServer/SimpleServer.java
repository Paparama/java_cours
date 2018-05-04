package serialisation.simplServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private int port;
    public SimpleServer(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port);){
            System.out.println("Server on :" + serverSocket);

            while (true) {
                Socket socket = serverSocket.accept(); // ждем клиента
                try {
                    getMess(socket);
                }
                catch (ClassNotFoundException e) {
                    System.out.println("Wrong mess");
                    e.printStackTrace();
                }

                finally {
                    socket.close();
                }
            }
        }
    }

    private void getMess(Socket socket) throws IOException, ClassNotFoundException {
        String host = socket.getInetAddress().getHostAddress();
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream()); OutputStream out = socket.getOutputStream()){
            Object obj = ois.readObject();
            printMess((Message) obj , host);
        }
    }

    private void printMess(Message msg, String sendedAddr) {
        System.out.println(msg.getMessageText() + " sender: " + msg.getSender() + " date:" + msg.getDate());
    }

    public static void main(String[] args) throws IOException {
        if(args == null || args.length == 0 ) {
            throw new IllegalArgumentException("port, we need port");
        }

        int port = Integer.parseInt(args[0]);
        SimpleServer simpleServer = new SimpleServer(port);
        simpleServer.start();
    }
}
