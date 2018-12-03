package Lesson6.ConsoleChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    private static Scanner reader;
    private static PrintWriter writer;
    private static String message;
    private static Scanner consoleReader;

    private final static int SERVER_PORT = 8189;
    private final static String SERVER_ADDRESS = "localhost";

    public static void main(String[] args) {
        Socket sock = null;
        try {
            sock = new Socket(SERVER_ADDRESS, SERVER_PORT);
            reader = new Scanner(sock.getInputStream());
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Cоединение установлено...");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        new Thread(() -> {
            try {
                while (reader.hasNextLine()) {
                    message = reader.nextLine();
                    System.out.println("Получено от сервера: " + message);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();

        Socket finalSock = sock;
        Thread tRead = new Thread(() -> {
            try {
                while (true) {
                    consoleReader = new Scanner(System.in);
                    String msg = consoleReader.nextLine();
                    if (msg.equals("BYE")) {
                        writer.println(msg);
                        writer.flush();
                        Objects.requireNonNull(finalSock).close();
                        if (!finalSock.isClosed()) {
                            finalSock.close();    // если ввели управляющее слово, то закрываем клиента
                        }
                    } else {
                        writer.println(msg);
                        writer.flush();
                    }
                }
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
        });
        tRead.setDaemon(true);
        tRead.start();
    }

}