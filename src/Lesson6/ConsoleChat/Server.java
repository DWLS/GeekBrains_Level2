package Lesson6.ConsoleChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Socket incoming;

        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен. Ожидаем подключение...");
            incoming = serverSocket.accept();
            System.out.println("Клиент подключился...");
            InputStream is = incoming.getInputStream();
            OutputStream os = incoming.getOutputStream();

            Scanner in = new Scanner(is, "UTF-8");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8), true);

            new Thread(() -> {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println("Получено от клиента: " + line);
                    if (line.trim().equals("BYE")) {
                        System.exit(0);
                    }
                }
            }).start();
            new Thread(() -> {
                while (true) {
                    try {
                        Scanner readerThread = new Scanner(System.in);
                        String msg = readerThread.nextLine();
                        out.println(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
