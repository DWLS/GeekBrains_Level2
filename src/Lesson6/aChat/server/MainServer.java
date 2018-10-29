package Lesson6.aChat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Vector;

class MainServer {

    private Vector<ClientHandler> clients;

    Vector<ClientHandler> getClients() {
        return clients;
    }

    MainServer() throws SQLException {

        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            AuthService.connect();

            server = new ServerSocket(8189);
            System.out.println("Сервер localhost:8189 запущен! Ожидаем подключения...");

            while (true) {
                socket = server.accept();
                new ClientHandler(this, socket);
                System.out.println("Клиент инициировал подключение!");
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
            AuthService.disconnect();
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