package Lesson6.SimpleTestChat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatClient {
    private JTextArea incoming;
    private JTextField outgoing;
    private Scanner reader;
    private PrintWriter writer;

    void go() {
        JFrame frame = new JFrame("Простецкий клиент-чат");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(e -> {
            if (!outgoing.getText().equals("")) {
                try {
                    writer.println(outgoing.getText());
                    writer.flush();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                outgoing.setText("");
                outgoing.requestFocus();
            }
        });
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        setUpNetworking();

        new Thread(() -> {
            String message;
            try {
                while ((message = reader.nextLine()) != null) {
                    System.out.println("прочитано: " + message);
                    incoming.append(message + System.lineSeparator());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(600, 340);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        try {
            Socket sock = new Socket("localhost", 8189);
            reader = new Scanner(sock.getInputStream());
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("соединение установлено...");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

