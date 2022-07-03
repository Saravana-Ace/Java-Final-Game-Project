/*
 * FinishedGamePanel.java
 *
 * This is the final panel of the game and
 * on this panel you will see your name and
 * the total score you received. There are two
 * buttons on this panel, previous and quit,
 * if you click on the previous button, you will
 * go to the previous panel and if you click on the
 * quit button, the game will end.
 *
 * Creator: Saravana Polisetti
 * Date: 5/22/20
 * Period: 7
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FinishedGamePanel extends JPanel implements ActionListener {
    private CardLayout listOfCards;
    private MainIntroPanel primaryPanel;
    private String playerName;
    private String playerScore;

    public FinishedGamePanel(CardLayout c, MainIntroPanel m) {
        Color gold = new Color(255, 221, 0);
        setLayout(new BorderLayout());
        setBackground(gold);
        listOfCards = c;
        primaryPanel = m;
        playerName = "";
        playerScore = "";

        JButton viewScore = new JButton("View Score");
        viewScore.addActionListener(this);
        viewScore.setOpaque(false);
        add(viewScore);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("View Score"))
        {
            Scanner inFile = null;
            String fileName = "PlayerName.txt";
            File inputFile = new File(fileName);

            try
            {
                inFile = new Scanner(inputFile);
            }
            catch (FileNotFoundException fe)
            {
                System.out.println(fe);
                System.exit(1);
            }

            while (inFile.hasNext())
            {
                playerName = inFile.nextLine();
            }

            inFile = null;
            fileName = "Scores.txt";
            inputFile = new File(fileName);
            try
            {
                inFile = new Scanner(inputFile);
            }
            catch (FileNotFoundException fe)
            {
                System.out.println(fe);
                System.exit(1);
            }

            while (inFile.hasNext())
            {
                playerScore = inFile.next();
            }

            viewFinalScore();
        }
        if(e.getActionCommand().equals("Back"))
            for(int i = 0; i < 6; i++)
            {
                listOfCards.previous(primaryPanel);
            }
        if(e.getActionCommand().equals("QUIT"))
            System.exit(1);
    }

    private void viewFinalScore()
    {
        removeAll();
        repaint();
        revalidate();

        Color gold = new Color(255, 221, 0);
        setLayout(new GridLayout(5,4));

        JLabel empty1 = new JLabel("");
        add(empty1);

        JLabel empty_1 = new JLabel("");
        add(empty_1);

        JLabel empty_2 = new JLabel("");
        add(empty_2);

        JLabel empty_3 = new JLabel("");
        add(empty_3);

        ImageIcon image = new ImageIcon("George-Washington3.jpg");
        add(new JLabel(image));

        JTextField empty2 = new JTextField("Good Job!");
        empty2.setHorizontalAlignment(JTextField.CENTER);
        empty2.setEditable(false);
        empty2.setFont(new Font("Arial", Font.BOLD, 20));
        empty2.setOpaque(true);
        empty2.setBackground(gold);
        empty2.setForeground(Color.BLUE);
        add(empty2);

        JTextField empty3 = new JTextField("You finished!");
        empty3.setHorizontalAlignment(JTextField.CENTER);
        empty3.setEditable(false);
        empty3.setFont(new Font("Arial", Font.BOLD, 20));
        empty3.setOpaque(true);
        empty3.setBackground(gold);
        empty3.setForeground(Color.BLUE);
        add(empty3);

        ImageIcon image4 = new ImageIcon("unnamed.jpg");
        add(new JLabel(image4));

        JLabel empty5 = new JLabel("");
        add(empty5);

        JTextField player = new JTextField(playerName + " you received: ");
        player.setHorizontalAlignment(JTextField.CENTER);
        player.setEditable(false);
        player.setFont(new Font("Arial", Font.BOLD, 14));
        player.setOpaque(true);
        player.setBackground(gold);
        player.setForeground(Color.BLUE);
        add(player);

        JTextField score = new JTextField(playerScore + " points");
        score.setHorizontalAlignment(JTextField.CENTER);
        score.setEditable(false);
        score.setFont(new Font("Arial", Font.BOLD, 14));
        score.setOpaque(true);
        score.setBackground(gold);
        score.setForeground(Color.BLUE);
        add(score);

        JLabel empty6 = new JLabel("");
        add(empty6);

        JLabel empty7 = new JLabel("");
        add(empty7);

        JLabel empty8 = new JLabel("");
        add(empty8);

        JLabel empty9 = new JLabel("");
        add(empty9);

        JLabel empty10 = new JLabel("");
        add(empty10);

        JButton goBack = new JButton("Back");
        goBack.setFont(new Font("Arial", Font.PLAIN, 20));
        goBack.setOpaque(false);
        goBack.addActionListener(this);
        add(goBack);

        JLabel empty11 = new JLabel("");
        add(empty11);

        JLabel empty12 = new JLabel("");
        add(empty12);

        JButton quit = new JButton("QUIT");
        quit.setFont(new Font("Arial", Font.PLAIN, 20));
        quit.setOpaque(false);
        quit.addActionListener(this);
        add(quit);
    }
}