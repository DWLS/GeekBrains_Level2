package Lesson6.aChat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Vector;

public class MainServer {

    private Vector<ClientHandler> clients;

    Vector<ClientHandler> getClients() {
        return clients;
    }

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

    void broadCastMsg(String msg) {
        for (ClientHandler o :
                clients) {
            o.sendMsg(msg);
        }
    }

    void privateMsg(ClientHandler from, String nickTo, String msg) {
        for (ClientHandler o :
                clients) {
            if (o.getNick().equals(nickTo)) {
                o.sendMsg("от " + from.getNick() + ": " + msg);
                from.sendMsg("юзеру " + nickTo + ": " + msg);
                return;
            }
        }
        from.sendMsg("Юзера " + nickTo + " нет в чате");
    }

    void subscribe(ClientHandler client) {
        clients.add(client);
    }

    void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

}