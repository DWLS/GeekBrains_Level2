package Lesson2.RPG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.Font.BOLD;
import static java.awt.Font.ITALIC;
import static java.awt.Font.PLAIN;

public class GameWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 539;
    private static final int WINDOW_WIDTH = 716;
    private static final int WINDOW_POS_X = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WINDOW_WIDTH / 2;
    private static final int WINDOW_POS_Y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - WINDOW_HEIGHT / 2;

    JButton btnAddTeam1 = new JButton("Добавить");
    JButton btnAddTeam2 = new JButton("Добавить");
    JButton btnStart = new JButton("НАЧАТЬ");
    JComboBox cbChooseTeam1Hero = new JComboBox();
    JComboBox cbChooseTeam2Hero = new JComboBox();
    JTextField tfRoundCount = new JTextField();
    JTextField tfHeroNameTeam1 = new JTextField();
    JTextField tfHeroNameTeam2 = new JTextField();
    JLabel lblTeam1 = new JLabel("Команда 1");
    JLabel lblTeam2 = new JLabel("Команда 2");
    JLabel lblRoundCount = new JLabel("Количество раундов:");
    JLabel lblFightLog = new JLabel("Журнал сражения:");
    JLabel lblFightResults = new JLabel("Результаты сражения:");
    JList lstTeam1 = new JList();
    JList lstTeam2 = new JList();
    JList lstFightResults = new JList();
    JList lstFightLog = new JList();
    JMenuBar mb1 = new JMenuBar();

    public GameWindow() {

        Font myFont = new Font("Tahoma", PLAIN, 9);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setTitle("Команда на Команду");
        setResizable(false);
        setLayout(null);

        btnAddTeam1.setBounds(208, 40, 75, 25);
        btnAddTeam1.setFont(myFont);
        add(btnAddTeam1);

        btnAddTeam2.setBounds(592, 40, 75, 25);
        btnAddTeam2.setFont(myFont);
        add(btnAddTeam2);

        btnStart.setBounds(304, 264, 75, 25);
        btnStart.setFont(myFont);
        btnStart.setEnabled(false);
        add(btnStart);

        cbChooseTeam1Hero.setBounds(32, 32, 145, 21);
        cbChooseTeam1Hero.setFont(myFont);
        add(cbChooseTeam1Hero);

        cbChooseTeam2Hero.setBounds(416, 32, 145, 21);
        cbChooseTeam2Hero.setFont(myFont);
        add(cbChooseTeam2Hero);

        tfRoundCount.setBounds(304, 237, 75, 21);
        tfRoundCount.setFont(new Font("Tahoma", PLAIN, 11));
        tfRoundCount.setText("3");
        add(tfRoundCount);

        tfHeroNameTeam1.setBounds(32, 59, 145, 21);
        tfHeroNameTeam1.setFont(myFont);
        tfHeroNameTeam1.setToolTipText("Имя героя");
        add(tfHeroNameTeam1);

        tfHeroNameTeam2.setBounds(416, 59, 145, 21);
        tfHeroNameTeam2.setFont(myFont);
        tfHeroNameTeam2.setToolTipText("Имя героя");
        add(tfHeroNameTeam2);

        lblTeam1.setBounds(32, 107, 57, 14);
        lblTeam1.setFont(new Font("Arial", BOLD, 11));
        add(lblTeam1);

        lblTeam2.setBounds(416, 107, 57, 14);
        lblTeam2.setFont(new Font("Arial", BOLD, 11));
        add(lblTeam2);

        lblRoundCount.setBounds(177, 237, 110, 13);
        lblRoundCount.setFont(new Font("Tahoma", PLAIN, 11));
        add(lblRoundCount);

        lblFightLog.setBounds(32, 331, 147, 23);
        lblFightLog.setFont(new Font("Comic Sans MS", BOLD|ITALIC, 16));
        add(lblFightLog);

        lblFightResults.setBounds(416, 331, 185, 23);
        lblFightResults.setFont(new Font("Comic Sans MS", BOLD|ITALIC, 16));
        add(lblFightResults);

        lstTeam1.setBounds(32, 128, 251, 97);
        lstTeam1.setFont(myFont);
        add(lstTeam1);

        lstTeam2.setBounds(416, 128, 251, 97);
        lstTeam2.setFont(myFont);
        add(lstTeam2);

        lstFightResults.setBounds(416, 360, 251, 113);
        lstFightResults.setFont(myFont);
        add(lstFightResults);

        lstFightLog.setBounds(32, 360, 347, 113);
        lstFightLog.setFont(myFont);
        add(lstFightLog);

        JMenu fileMenu = new JMenu("New");
        fileMenu.setMnemonic(KeyEvent.VK_N);
        mb1.add(fileMenu);
        JMenu exitMenu = new JMenu("Exit");
        exitMenu.setMnemonic(KeyEvent.VK_E);
        mb1.add(exitMenu);
        setJMenuBar(mb1);

        setVisible(true);
    }

    public static void main(String[] args) {
        // For Native Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new GameWindow();
            }
        });
    }
}
