package Lesson2.RPG;

import javax.swing.*;

public class StartGameClass {
    public static void main(String[] args) {
        // For Native Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}

        SwingUtilities.invokeLater(GameWindow::new);
    }
}
