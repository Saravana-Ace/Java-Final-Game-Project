/*
 * EnterNamePanel.java
 *
 * In this panel you will see two empty JTextFields, or two empty
 * spaces for your first name and last name. You need to make sure that
 * you have entered your name before pressing next or else the program
 * will not be able to save your name and, thus, your name will not be shown
 * once you have finished the game.
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
import java.util.Scanner;
import java.io.PrintWriter;

public class EnterNamePanel extends JPanel implements ActionListener
{
    private CardLayout listOfCards;
    private MainIntroPanel primaryPanel;
    private JTextField enterFirst;
    private JTextField enterLast;
    private int counter;
    private int count;
    private String firstNameIs;
    private String lastNameIs;
    private String names;
    private JButton Home;

    public EnterNamePanel(CardLayout c, MainIntroPanel m)
    {
        listOfCards = c;
        primaryPanel = m;
        counter = 0;
        count = 0;
        Color gold = new Color(255, 221,0);
        setBackground(gold);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new GridLayout(3,1,10,10));

        JPanel firstName = new JPanel();
        firstName.setBackground(Color.BLUE);
        firstName.setLayout(new FlowLayout(FlowLayout.CENTER,0,60));
        add(firstName);

        JLabel first = new JLabel("First Name: ");
        first.setFont(new Font("Arial", Font.BOLD, 20));
        first.setForeground(Color.WHITE);
        firstName.add(first);

        enterFirst = new JTextField(20);
        enterFirst.setFont(new Font("Arial", Font.BOLD, 20));
        enterFirst.setForeground(Color.BLACK);
        firstName.add(enterFirst);

        JPanel lastName = new JPanel();
        lastName.setBackground(Color.BLUE);
        lastName.setLayout(new FlowLayout(FlowLayout.CENTER,0,70));
        add(lastName);

        JLabel last = new JLabel("Last Name: ");
        last.setFont(new Font("Arial", Font.BOLD, 20));
        last.setForeground(Color.WHITE);
        lastName.add(last);

        enterLast = new JTextField(20);
        enterLast.setFont(new Font("Arial", Font.BOLD, 20));
        enterLast.setForeground(Color.BLACK);
        lastName.add(enterLast);

        JPanel backAndNext = new JPanel();
        backAndNext.setBackground(Color.BLUE);
        backAndNext.setLayout(new FlowLayout(FlowLayout.CENTER,0,80));
        add(backAndNext);

        Home = new JButton("Home");
        Home.setFont(new Font("Arial", Font.PLAIN, 20));
        Home.setOpaque(false);
        Home.addActionListener(this);
        backAndNext.add(Home);

        JButton goNext = new JButton("Next");
        goNext.setFont(new Font("Arial", Font.PLAIN, 20));
        goNext.setOpaque(false);
        goNext.addActionListener(this);
        backAndNext.add(goNext);
    }

    public String getName() // this method gets the name that the user inputted
    {
        firstNameIs = enterFirst.getText();
        lastNameIs = enterLast.getText();
        return firstNameIs + " " + lastNameIs;
    }

    public void actionPerformed(ActionEvent e) // this method receives information from the user to go to the home panel or the next panel
    {
        if(e.getActionCommand().equals("Home"))
        {
            for(int i = 0; i < 2; i++)
            {
                listOfCards.previous(primaryPanel);
            }
        }

        if(e.getActionCommand().equals("Next"))
        {
            if(count == 0)
            {
                names = "";

                Scanner inFile = null;
                String fileName = "PlayerName.txt";
                File inputFile = new File(fileName);

                try
                {
                    inFile = new Scanner(inputFile);
                } catch (FileNotFoundException fe) {
                    System.out.println(fe);
                    System.exit(1);
                }

                while (inFile.hasNext())
                {
                    names = names + inFile.nextLine() + "\n";
                    counter++;
                }

                PrintWriter outFile = null;
                fileName = "PlayerName.txt";
                File toFile = new File(fileName);
                try
                {
                    outFile = new PrintWriter(toFile);
                }
                catch (IOException ef)
                {
                    System.out.println(ef);
                    System.exit(2);
                }

                names = names + getName();
                outFile.println(names);

                inFile.close();
                outFile.close();
            }
            count++;
        }

        listOfCards.next(primaryPanel);
    }
}