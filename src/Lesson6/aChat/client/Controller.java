package Lesson6.aChat.client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    ListView userList;
    @FXML
    HBox hbox1;
    @FXML
    Button btnSend;

    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    private Socket socket;

    private DataInputStream in;
    private DataOutputStream out;

    private final String IP_ADDRESS = "localhost";
    private final int PORT = 8189;

    public void sendMsg() {
        if (!textField.getText().equals("")) {
            try {
                out.writeUTF(textField.getText());
                textField.clear();
                textField.requestFocus();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeApp() {
        System.exit(0);
    }

    public void showAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("О программе");
        alert.setHeaderText("aChat v 0.1");
        alert.setContentText("Заготовка клиентского окна чата на JavaFX");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/serverClosed")) {
                            break;
                        }
                        textArea.appendText(String.format("%s%s", str, System.lineSeparator()));
                    }
                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
