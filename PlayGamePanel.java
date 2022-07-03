/*
 * PlayGamePanel.java
 *
 * This panel, I would say, is where the game really starts.
 * In this panel you will see a 5 by 5 grid of question boxes
 * that have different prices on them. When a player answers
 * a question right, they will get the amount of points the
 * question was worth. But if the user gets a question wrong,
 * no points will be added and no points will be deducted.
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PlayGamePanel extends JPanel implements ActionListener
{
    private static JButton[] button;
    private JPanel top;
    private JPanel bottom;
    private CardLayout listOfCards;
    private MainIntroPanel primaryPanel;
    private String[] indicator;
    private boolean[] disabled;
    private JButton next;
    private static int iValue;
    private int score;
    private String playerScores;
    private int counter;

    public PlayGamePanel(CardLayout c, MainIntroPanel m)
    {
        listOfCards = c;
        primaryPanel = m;
        button = new JButton[25];
        indicator = new String[5];
        disabled = new boolean[25];
        iValue = 0;
        score = 0;
        counter = 0;

        setLayout(new BorderLayout());

        top = new JPanel();
        top.setLayout(new GridLayout(1, 5));
        Color gold = new Color(255, 221,0);
        add(top, BorderLayout.NORTH);

        JTextField firstCat = new JTextField("Coming to America");
        firstCat.setHorizontalAlignment(JTextField.CENTER);
        firstCat.setEditable(false);
        firstCat.setFont(new Font("Arial", Font.BOLD, 17));
        firstCat.setOpaque(true);
        firstCat.setBackground(gold);
        firstCat.setForeground(Color.BLUE);
        top.add(firstCat, BorderLayout.NORTH);

        JTextField secondCat = new JTextField("Prelude to the Civil War");
        secondCat.setHorizontalAlignment(JTextField.CENTER);
        secondCat.setEditable(false);
        secondCat.setFont(new Font("Arial", Font.BOLD, 17));
        secondCat.setOpaque(true);
        secondCat.setBackground(gold);
        secondCat.setForeground(Color.BLUE);
        top.add(secondCat, BorderLayout.NORTH);

        JTextField thirdCat = new JTextField("American Imperialism");
        thirdCat.setHorizontalAlignment(JTextField.CENTER);
        thirdCat.setEditable(false);
        thirdCat.setFont(new Font("Arial", Font.BOLD, 17));
        thirdCat.setOpaque(true);
        thirdCat.setBackground(gold);
        thirdCat.setForeground(Color.BLUE);
        top.add(thirdCat, BorderLayout.NORTH);

        JTextField fourthCat = new JTextField("Women's Suffrage");
        fourthCat.setHorizontalAlignment(JTextField.CENTER);
        fourthCat.setEditable(false);
        fourthCat.setFont(new Font("Arial", Font.BOLD, 17));
        fourthCat.setOpaque(true);
        fourthCat.setBackground(gold);
        fourthCat.setForeground(Color.BLUE);
        top.add(fourthCat, BorderLayout.NORTH);

        JTextField fifthCat = new JTextField("The Harlem Renaissance");
        fifthCat.setHorizontalAlignment(JTextField.CENTER);
        fifthCat.setEditable(false);
        fifthCat.setFont(new Font("Arial", Font.BOLD, 17));
        fifthCat.setOpaque(true);
        fifthCat.setBackground(gold);
        fifthCat.setForeground(Color.BLUE);
        top.add(fifthCat, BorderLayout.NORTH);

        indicator[0] = "Category 1:";
        indicator[1] = "Category 2:";
        indicator[2] = "Category 3:";
        indicator[3] = "Category 4:";
        indicator[4] = "Category 5:";

        bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 5));
        bottom.setBackground(gold);
        add(bottom, BorderLayout.CENTER);

        for (int i = 0; i < 5; i++)
        {
            button[i] = new JButton(indicator[i] + " $100");
            button[i].setForeground(Color.BLUE);
            button[i].addActionListener(this);
            bottom.add(button[i]);
        }

        for (int i = 5; i < 10; i++)
        {
            button[i] = new JButton(indicator[i - 5] + " $200");
            button[i].setForeground(Color.BLUE);
            button[i].addActionListener(this);
            bottom.add(button[i]);
        }

        for (int i = 10; i < 15; i++)
        {
            button[i] = new JButton(indicator[i - 10] + " $300");
            button[i].setForeground(Color.BLUE);
            button[i].addActionListener(this);
            bottom.add(button[i]);
        }

        for (int i = 15; i < 20; i++)
        {
            button[i] = new JButton(indicator[i - 15] + " $400");
            button[i].setForeground(Color.BLUE);
            button[i].addActionListener(this);
            bottom.add(button[i]);
        }

        for (int i = 20; i < 25; i++)
        {
            button[i] = new JButton(indicator[i - 20] + " $500");
            button[i].setForeground(Color.BLUE);
            button[i].addActionListener(this);
            bottom.add(button[i]);
        }

        JPanel quitHome = new JPanel();
        quitHome.setLayout(new FlowLayout(FlowLayout.RIGHT));
        quitHome.setBackground(Color.BLUE);
        add(quitHome, BorderLayout.SOUTH);

        JButton quitGame = new JButton("Back");
        quitGame.setBackground(gold);
        quitGame.setForeground(Color.BLUE);
        quitGame.setOpaque(true);
        quitGame.setBorderPainted(false);
        quitGame.addActionListener(this);
        quitHome.add(quitGame);

        next = new JButton("Next");
        next.setEnabled(false);
        next.setBackground(gold);
        next.setForeground(Color.BLUE);
        next.setOpaque(true);
        next.setBorderPainted(false);
        next.addActionListener(this);
        quitHome.add(next);
    }

    public static JButton[] getButtons() // this method returns the button array
    {
        return button;
    }

    public void actionPerformed(ActionEvent e) // this method will get the iValue when the user clicks a button/question box
    {
        if (e.getActionCommand().equals("Category 1: $100") ||
                e.getActionCommand().equals("Category 1: $200") ||
                e.getActionCommand().equals("Category 1: $300") ||
                e.getActionCommand().equals("Category 1: $400") ||
                e.getActionCommand().equals("Category 1: $500"))
        {
            for (int i = 0; i < 25; i++)
            {
                if(button[i] == e.getSource())
                {
                    iValue = i;
                    button[i].setEnabled(false);
                }
            }
            listOfCards.next(primaryPanel);
        }

        if (e.getActionCommand().equals("Category 2: $100") ||
                e.getActionCommand().equals("Category 2: $200") ||
                e.getActionCommand().equals("Category 2: $300") ||
                e.getActionCommand().equals("Category 2: $400") ||
                e.getActionCommand().equals("Category 2: $500"))
        {
            for (int i = 0; i < 25; i++)
            {
                if(button[i] == e.getSource())
                {
                    iValue = i;
                    button[i].setEnabled(false);
                }
            }

            for(int i = 0; i < 2; i++)
            {
                listOfCards.next(primaryPanel);
            }
        }

        if (e.getActionCommand().equals("Category 3: $100") ||
                e.getActionCommand().equals("Category 3: $200") ||
                e.getActionCommand().equals("Category 3: $300") ||
                e.getActionCommand().equals("Category 3: $400") ||
                e.getActionCommand().equals("Category 3: $500"))
        {
            for (int i = 0; i < 25; i++)
            {
                if(button[i] == e.getSource())
                {
                    iValue = i;
                    button[i].setEnabled(false);
                }
            }

            for(int i = 0; i < 3; i++)
            {
                listOfCards.next(primaryPanel);
            }
        }

        if (e.getActionCommand().equals("Category 4: $100") ||
                e.getActionCommand().equals("Category 4: $200") ||
                e.getActionCommand().equals("Category 4: $300") ||
                e.getActionCommand().equals("Category 4: $400") ||
                e.getActionCommand().equals("Category 4: $500"))
        {
            for (int i = 0; i < 25; i++)
            {
                if(button[i] == e.getSource())
                {
                    iValue = i;
                    button[i].setEnabled(false);
                }
            }

            for(int i = 0; i < 4; i++)
            {
                listOfCards.next(primaryPanel);
            }
        }

        if (e.getActionCommand().equals("Category 5: $100") ||
                e.getActionCommand().equals("Category 5: $200") ||
                e.getActionCommand().equals("Category 5: $300") ||
                e.getActionCommand().equals("Category 5: $400") ||
                e.getActionCommand().equals("Category 5: $500"))
        {
            for (int i = 0; i < 25; i++)
            {
                if(button[i] == e.getSource())
                {
                    iValue = i;
                    button[i].setEnabled(false);
                }
            }

            for(int i = 0; i < 5; i++)
            {
                listOfCards.next(primaryPanel);
            }
        }

        if(e.getActionCommand().equals("Back"))
            listOfCards.previous(primaryPanel);

        for(int i = 0; i < button.length; i++)
        {
            if(button[i] == e.getSource())
            {
                button[i].setEnabled(false);
                disabled[i] = true;
            }
        }

        for(int i = 0; i < button.length; i++)
        {
            if(disabled[i] == false)
            {
                return;
            }
        }

        next.setEnabled(true);

        if(e.getActionCommand().equals("Next"))
        {
            score = HarlemRenaissanceQuestionPanel.getHarlemScore()
                    + SuffrageQuestionPanel.getSuffrageScore()
                    + ImperialismQuestionPanel.getImperialScore()
                    + PreludeQuestionPanel.getPreludeScore()
                    + ComingToAmericaQuestionPanel.getComingScore();

            Scanner inFile = null;
            String fileName = "Scores.txt";
            File inputFile = new File(fileName);

            try
            {
                inFile = new Scanner(inputFile);
            }
            catch(FileNotFoundException fe)
            {
                System.out.println(fe);
                System.exit(1);
            }

            while(inFile.hasNext())
            {
                playerScores = playerScores + inFile.nextLine() + "\n";
                counter++;
            }

            PrintWriter outFile = null;
            fileName = "Scores.txt";
            File toFile = new File(fileName);
            try
            {
                outFile = new PrintWriter(toFile);
            }

            catch(IOException ef)
            {
                System.out.println(ef);
                System.exit(2);
            }

            playerScores = playerScores + score;
            outFile.println(playerScores);

            inFile.close();
            outFile.close();

            for(int i = 0; i < 6; i++)
            {
                listOfCards.next(primaryPanel);
            }
        }
    }

    public static int getiValue()
    {
        return iValue;
    }
}