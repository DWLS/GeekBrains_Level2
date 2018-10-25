package Lesson6.SimpleTestChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class VerySimpleChatServer {
    private ArrayList<PrintWriter> clientOutputStream;

    public class ClientHandler implements Runnable {
        Scanner reader;
        Socket sock;

        ClientHandler(Socket clientSocket) {
            try {
                sock = clientSocket;
                reader = new Scanner(sock.getInputStream());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while (true) {
                    if (reader.hasNext()) {
                        message = reader.nextLine();
                        System.out.println("прочитано: " + message);
                        tellEveryone(message);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    void go() {
        clientOutputStream = new ArrayList<>();
        try {
            ServerSocket serverSock = new ServerSocket(8189);
            System.out.println("Сервер запущен...");

            while (true) {
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStream.add(writer);

                new Thread(new ClientHandler(clientSocket)).start();
                System.out.println("произошло подключение...");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void tellEveryone(String message) {
        for (PrintWriter aClientOutputStream : clientOutputStream) {
            try {
                aClientOutputStream.println(message);
                aClientOutputStream.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
