package Lesson6.aChat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Vector;

public class MainServer {

    private Vector<ClientHandler> clients;

    public MainServer() {

        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен! Ожидаем подключение...");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");
                clients.add(new ClientHandler(this, socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(socket).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Objects.requireNonNull(server).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadCastMsg(String msg) {
        for (ClientHandler o: clients) {
            o.sendMsg(msg);
        }
    }

}
