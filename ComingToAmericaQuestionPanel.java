/*
 * ComingToAmericaQuestionPanel.java
 *
 * In this panel you will see the question from
 * the coming to america unit in US history and you will
 * also see 5 answer choices and a go back home button.
 * If you answer the question right, you will be awarded
 * points. If you don't get a question right, you won't lose
 * any points.
 *
 * Creator: Saravana Polisetti
 * Date: 5/22/20
 * Period: 7
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComingToAmericaQuestionPanel extends JPanel implements ActionListener
{
    private CardLayout listOfCards;
    private MainIntroPanel primaryPanel;
    private JTextField question;
    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JButton choice4;
    private JButton choice5;
    private JButton back;
    private String[] questions;
    private String[] answers;
    private boolean[] repeatOrNot;
    private int randomNum;
    private static int comingScore;

    public ComingToAmericaQuestionPanel(CardLayout c, MainIntroPanel m)
    {
        Color gold = new Color(255, 221,0);
        setLayout(new GridLayout(7, 1));
        setBackground(gold);

        listOfCards = c;
        primaryPanel = m;
        comingScore = 0;

        questions = new String[] {"How did the early humans travel to these new places?",
                                  "Approximately how many humans migrated?",
                                  "When did the humans migrate?",
                                  "When was the Treaty of Tordesillas signed?",
                                  "When did the “Vikings” migrate to the West",
                                  "When was the earliest form of slavery introduced?",
                                  "What happened due to the European diseases?",
                                  "What did Columbus believe in?",
                                  "Who or what funded Columbus’ expeditions?",
                                  "What was shipped to Spain?",
                                  "Where were Spain’s colony?",
                                  "What funded the wars for Spain?",
                                  "What did European countries want?",
                                  "What were the first slaves called?",
                                  "What closed because of the Enclosure Movement?",
                                  "What was France’s colony in America?",
                                  "Where did Christopher Columbus want to go to?",
                                  "Where did Christopher Columbus set up trading posts?",
                                  "Where did Leif Ericsson travel to?",
                                  "What were England’s colonies in America?",
                                  "What was Holland’s colony in America?",
                                  "Where did the humans evolve and migrate from?",
                                  "Where did humans migrate to?",
                                  "What was Sweden’s colony in America?",
                                  "What was the name of the largest Native American group?"};

        answers = new String[] {"The Bering Land Bridge",
                                 "10-100 million people",
                                 "1500",
                                 "1494",
                                 "100 AD",
                                 "1620",
                                 "95% of the Tenochtitlan people died",
                                 "Go East by going West",
                                 "Queen Isabella",
                                 "Gold, silver, and spices",
                                 "Present day Florida",
                                 "Vast shipments of valuable items",
                                 "Riches & colonies",
                                 "Indentured servants",
                                 "Family farms",
                                 "Queens",
                                 "Portugal and Spain",
                                 "Africa and India",
                                 "Eastern Canada",
                                 "The 13 colonies",
                                 "New Amsterdam",
                                 "East Africa",
                                 "Europe and Asia",
                                 "New Sweden",
                                 "Tenochtitlan"};

        randomNum = (int)(Math.random() * (25));

        repeatOrNot = new boolean[answers.length];
        for(int j = 0; j < repeatOrNot.length; j++)
        {
            repeatOrNot[j] = true;
        }

        question = new JTextField("Question: " + questions[randomNum]);
        question.setHorizontalAlignment(JTextField.CENTER);
        question.setEditable(false);
        question.setFont(new Font("Arial", Font.BOLD, 20));
        question.setOpaque(true);
        question.setBackground(gold);
        question.setForeground(Color.BLUE);
        add(question);

        choice1 = new JButton(answers[randomNum]);
        choice1.setForeground(Color.BLUE);
        choice1.addActionListener(this);
        add(choice1);

        choice2 = new JButton(answers[(randomNum + 1) % 25]);
        choice2.setForeground(Color.BLUE);
        choice2.addActionListener(this);
        add(choice2);

        choice3 = new JButton(answers[(randomNum + 2) % 25]);
        choice3.setForeground(Color.BLUE);
        choice3.addActionListener(this);
        add(choice3);

        choice4 = new JButton(answers[(randomNum + 3) % 25]);
        choice4.setForeground(Color.BLUE);
        choice4.addActionListener(this);
        add(choice4);

        choice5 = new JButton(answers[(randomNum + 4) % 25]);
        choice5.setForeground(Color.BLUE);
        choice5.addActionListener(this);
        add(choice5);

        back = new JButton("Back To Questions");
        back.addActionListener(this);
        add(back);
    }
    /*
     * In this method, the program is receiving information from the user, and if
     * a question is answered correctly, then the user will be awarded the
     * respective amount of points. Again, if the user answers a question wrong,
     * they will not lose any points from their overall score.
     */
    public void actionPerformed(ActionEvent e)
    {
        repeatOrNot[randomNum] = false;
        if(PlayGamePanel.getiValue() == 0)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                comingScore += 100;
            }
        }

        if(PlayGamePanel.getiValue() == 5)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                comingScore += 200;
            }
        }

        if(PlayGamePanel.getiValue() == 10)
        {
            if ((e.getActionCommand().equals(answers[randomNum])))
            {
                comingScore += 300;
            }
        }

        if(PlayGamePanel.getiValue() == 15)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                comingScore += 400;
            }
        }

        if(PlayGamePanel.getiValue() == 20)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                comingScore += 500;
            }
        }

        while (repeatOrNot[randomNum] == false)
        {
            randomNum = (int) (Math.random() * (25));
            question.setText("Question: " + questions[randomNum]);
            if(randomNum == 0 || randomNum == 4 || randomNum == 8 || randomNum == 12 || randomNum == 16 || randomNum == 20 || randomNum ==24)
            {
                choice1.setText(answers[randomNum]);
                choice2.setText(answers[(randomNum + 1) % 25]);
                choice3.setText(answers[(randomNum + 2) % 25]);
                choice4.setText(answers[(randomNum + 3) % 25]);
                choice5.setText(answers[(randomNum + 4) % 25]);
            }

            if(randomNum == 1 || randomNum == 5 || randomNum == 9 || randomNum == 13 || randomNum == 17 || randomNum == 21)
            {
                choice1.setText(answers[(randomNum + 1) % 25]);
                choice2.setText(answers[randomNum]);
                choice3.setText(answers[(randomNum + 2) % 25]);
                choice4.setText(answers[(randomNum + 3) % 25]);
                choice5.setText(answers[(randomNum + 4) % 25]);
            }

            if(randomNum == 2 || randomNum == 6 || randomNum == 10 || randomNum == 14 || randomNum == 18 || randomNum == 22)
            {
                choice1.setText(answers[(randomNum + 2) % 25]);
                choice2.setText(answers[(randomNum + 1) % 25]);
                choice3.setText(answers[randomNum]);
                choice4.setText(answers[(randomNum + 3) % 25]);
                choice5.setText(answers[(randomNum + 4) % 25]);
            }

            if(randomNum == 3 || randomNum == 7 || randomNum == 11 || randomNum == 15 || randomNum == 19 || randomNum == 23)
            {
                choice1.setText(answers[(randomNum + 3) % 25]);
                choice2.setText(answers[(randomNum + 1) % 25]);
                choice3.setText(answers[(randomNum + 2) % 25]);
                choice4.setText(answers[randomNum]);
                choice5.setText(answers[(randomNum + 4) % 25]);
            }
        }

        listOfCards.previous(primaryPanel);
    }

    public static int getComingScore() // this method returns the score that the user has earned for the coming to america unit questions
    {
        return comingScore;
    }
}