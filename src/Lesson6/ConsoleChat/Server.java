package Lesson6.ConsoleChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {

    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) {

        ServerSocket serverSocket;
        Socket incoming;
        InputStream is;
        OutputStream os;
        Scanner in;
        PrintWriter out;

        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Сервер запущен. Ожидаем подключение...");
            incoming = serverSocket.accept();
            System.out.println("Клиент подключился...");
            is = incoming.getInputStream();
            System.out.println("Получили входящий поток от клиента...");
            os = incoming.getOutputStream();
            System.out.println("Получили исходящий поток к клиенту...");
            in = new Scanner(is, "UTF-8");
            out = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8), true);

            new Thread(() -> {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println("Получено от клиента: " + line);
                    if (line.equals("BYE")) {
                        System.out.println("Получена команда отключения...");
                        try {
                            if (!incoming.isClosed()) {
                                System.out.println("Закрываем сокет клиента...");
                                incoming.close();     //если получили управляющее слово, то закрываем сервер
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            Thread tRead = new Thread(() -> {
                try {
                    while (true) {
                        Scanner readerThread = new Scanner(System.in);
                        String msg = readerThread.nextLine();
                        out.println(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            tRead.setDaemon(true);
            tRead.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}