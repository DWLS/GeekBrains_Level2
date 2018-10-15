package Lesson2.RPG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static java.awt.Font.BOLD;
import static java.awt.Font.ITALIC;
import static java.awt.Font.PLAIN;

public class GameWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 539;
    private static final int WINDOW_WIDTH = 716;
    private static final int WINDOW_POS_X = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WINDOW_WIDTH / 2;
    private static final int WINDOW_POS_Y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - WINDOW_HEIGHT / 2;
    private static final int TEAM_MEMBERS_COUNT = 3;

    private String[] heroList = new String[] {
            "Воин",
            "Убийца",
            "Лекарь"
    };

    private ArrayList<Hero> team1 = new ArrayList<>();
    private ArrayList<Hero> team2 = new ArrayList<>();

    private int roundCount = 10;
    private Random randomStep = new Random();
    private Random randomHealing = new Random();
    private Random randomHit = new Random();

    private DefaultListModel<String> dlmTeam1 = new DefaultListModel<>();
    private DefaultListModel<String> dlmTeam2 = new DefaultListModel<>();
    private DefaultListModel<String> dlmFightResults = new DefaultListModel<>();
    private DefaultListModel<String> dlmFightLog = new DefaultListModel<>();

    private JButton btnAddTeam1 = new JButton("Добавить");
    private JButton btnAddTeam2 = new JButton("Добавить");
    private JButton btnStart = new JButton("НАЧАТЬ");
    private JComboBox<String> cbChooseTeam1Hero = new JComboBox<>(heroList);
    private JComboBox<String> cbChooseTeam2Hero = new JComboBox<>(heroList);
    private JTextField tfRoundCount = new JTextField();
    private JTextField tfHeroNameTeam1 = new JTextField();
    private JTextField tfHeroNameTeam2 = new JTextField();
    private JLabel lblTeam1 = new JLabel("Команда 1");
    private JLabel lblTeam2 = new JLabel("Команда 2");
    private JLabel lblRoundCount = new JLabel("Количество раундов:");
    private JLabel lblFightLog = new JLabel("Журнал сражения:");
    private JLabel lblFightResults = new JLabel("Результаты сражения:");
    private JList<String> lstTeam1 = new JList<>(dlmTeam1);
    private JList<String> lstTeam2 = new JList<>(dlmTeam2);
    private JList<String> lstFightResults = new JList<>(dlmFightResults);
    private JList<String> lstFightLog = new JList<>(dlmFightLog);
    private JMenuBar mb1 = new JMenuBar();

    public GameWindow() {

        Font myFont = new Font("Tahoma", PLAIN, 11);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setTitle("Кто кого?");
        setResizable(false);
        setLayout(null);

        btnAddTeam1.setBounds(195, 40, 88, 25);
        btnAddTeam1.setFont(myFont);
        btnAddTeam1.addActionListener(e -> {
            if (dlmTeam1.getSize() < TEAM_MEMBERS_COUNT && !tfHeroNameTeam1.getText().equalsIgnoreCase("")) {
                dlmTeam1.add(dlmTeam1.getSize(), cbChooseTeam1Hero.getSelectedItem() + " " + tfHeroNameTeam1.getText());
                switch ((String) Objects.requireNonNull(cbChooseTeam1Hero.getSelectedItem())) {
                    case "Воин": {
                        team1.add(new Warrior(250, tfHeroNameTeam1.getText(), 50, 0));
                        break;
                    }
                    case "Убийца": {
                        team1.add(new Assassin(150, tfHeroNameTeam1.getText(), 70, 0));
                        break;
                    }
                    case "Лекарь": {
                        team1.add(new Doctor(120, tfHeroNameTeam1.getText(), 0, 70));
                    }
                }
                tfHeroNameTeam1.setText("");
                if (dlmTeam1.getSize() == TEAM_MEMBERS_COUNT && dlmTeam2.getSize() == TEAM_MEMBERS_COUNT) {
                    btnStart.setEnabled(true);
                }
            }
            validate();
        });
        add(btnAddTeam1);

        btnAddTeam2.setBounds(579, 40, 88, 25);
        btnAddTeam2.setFont(myFont);
        btnAddTeam2.addActionListener(e -> {
            if (dlmTeam2.getSize() < TEAM_MEMBERS_COUNT && !tfHeroNameTeam2.getText().equalsIgnoreCase("")) {
                dlmTeam2.add(dlmTeam2.getSize(), cbChooseTeam2Hero.getSelectedItem() + " " + tfHeroNameTeam2.getText());
                switch ((String) Objects.requireNonNull(cbChooseTeam2Hero.getSelectedItem())) {
                    case "Воин": {
                        team2.add(new Warrior(240, tfHeroNameTeam2.getText(), 60, 0));
                        break;
                    }
                    case "Убийца": {
                        team2.add(new Assassin(160, tfHeroNameTeam2.getText(), 60, 0));
                        break;
                    }
                    case "Лекарь": {
                        team2.add(new Doctor(110, tfHeroNameTeam2.getText(), 0, 80));
                    }
                }
                tfHeroNameTeam2.setText("");
                if (dlmTeam1.getSize() == TEAM_MEMBERS_COUNT && dlmTeam2.getSize() == TEAM_MEMBERS_COUNT) {
                    btnStart.setEnabled(true);
                }
            }
            validate();
        });
        add(btnAddTeam2);

        btnStart.setBounds(304, 264, 75, 25);
        btnStart.setFont(myFont);
        btnStart.setEnabled(false);
        btnStart.addActionListener(e -> {
            try {
                roundCount = Integer.parseInt(tfRoundCount.getText());
            } catch (NumberFormatException nfe) {
                // добавить обработку исключения по значению текстового поля, если там оказывается не число
            }
            for (int j = 0; j < roundCount; j++) {
                for (int i = 0; i < TEAM_MEMBERS_COUNT; i++) {
                    if(randomStep.nextInt(2) == 0) {
                        System.out.print("Ход игрока первой команды: ");
                        if(team1.get(i) instanceof Doctor) {
                            dlmFightLog.add(dlmFightLog.size(), "Ход игрока первой команды: " + team1.get(i).healing(team1.get(randomHealing.nextInt(3))));
                            // доктор может лечить в том числе и себя
                        } else {
                            dlmFightLog.add(dlmFightLog.size(), "Ход игрока первой команды: " + team1.get(i).hit(team2.get(randomHit.nextInt(3))));
                        }
                    } else {
                        System.out.print("Ход игрока второй команды: ");
                        if(team2.get(i) instanceof Doctor) {
                            dlmFightLog.add(dlmFightLog.size(), "Ход игрока второй команды: " + team2.get(i).healing(team2.get(randomHealing.nextInt(3))));
                            // доктор может лечить в том числе и себя
                        } else {
                            dlmFightLog.add(dlmFightLog.size(), "Ход игрока второй команды: " + team2.get(i).hit(team1.get(randomHit.nextInt(3))));
                        }
                    }
                }
            }

            // шапка для информации в консоли
            System.out.println("__________________");
            System.out.println("| ИТОГИ СРАЖЕНИЯ |");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

            for (Hero t1: team1) {
                dlmFightResults.add(dlmFightResults.getSize(), t1.info());
            }

            for (Hero t2: team2) {
                dlmFightResults.add(dlmFightResults.getSize(), t2.info());
            }

            dlmTeam1.clear();
            dlmTeam2.clear();
            btnStart.setEnabled(false);
            team1.clear();
            team2.clear();

        });
        add(btnStart);

        cbChooseTeam1Hero.setBounds(32, 32, 145, 21);
        cbChooseTeam1Hero.setFont(myFont);
        add(cbChooseTeam1Hero);

        cbChooseTeam2Hero.setBounds(416, 32, 145, 21);
        cbChooseTeam2Hero.setFont(myFont);
        add(cbChooseTeam2Hero);

        tfRoundCount.setBounds(304, 237, 75, 21);
        tfRoundCount.setFont(new Font("Tahoma", PLAIN, 11));
        tfRoundCount.setText(String.valueOf(roundCount));
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
        JScrollPane spTeam1 = new JScrollPane(lstTeam1);
        spTeam1.setBounds(32, 128, 251, 97);
        add(spTeam1);

        lstTeam2.setBounds(416, 128, 251, 97);
        lstTeam2.setFont(myFont);
        JScrollPane spTeam2 = new JScrollPane(lstTeam2);
        spTeam2.setBounds(416, 128, 251, 97);
        add(spTeam2);

        lstFightResults.setBounds(416, 360, 251, 113);
        lstFightResults.setFont(myFont);
        JScrollPane spFightResults = new JScrollPane(lstFightResults);
        spFightResults.setBounds(416, 360, 251, 113);
        add(spFightResults);

        lstFightLog.setBounds(32, 360, 347, 113);
        lstFightLog.setFont(myFont);
        JScrollPane spFightLog = new JScrollPane(lstFightLog);
        spFightLog.setBounds(32, 360, 347, 113);
        add(spFightLog);

        JMenu fileMenu = new JMenu("Новая игра");
        fileMenu.setMnemonic(KeyEvent.VK_N);
        mb1.add(fileMenu);
        JMenu exitMenu = new JMenu("Выход");
        exitMenu.setMnemonic(KeyEvent.VK_E);
        mb1.add(exitMenu);
        setJMenuBar(mb1);

        setVisible(true);
    }

}
