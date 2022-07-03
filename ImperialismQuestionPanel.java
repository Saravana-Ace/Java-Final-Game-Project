/*
 * ImperialismQuestionPanel.java
 *
 * In this panel you will see the question from
 * the US imperialism unit in US history and you will
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

public class ImperialismQuestionPanel extends JPanel implements ActionListener
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
    private static int imperialScore;

    public ImperialismQuestionPanel(CardLayout c, MainIntroPanel m)
    {
        Color gold = new Color(255, 221,0);
        setLayout(new GridLayout(7, 1));
        setBackground(gold);

        listOfCards = c;
        primaryPanel = m;
        imperialScore = 0;

        questions = new String[] {
                "Who were Dole and Stevens?",
                "Who captured the Philippines?",
                "Who led the filipinos against American rule?",
                "Who was the president of the USA during the Spanish-American war?",
                "Who was the Hawaiian queen who was forced to cede her power by American business?",
                "What territory near Florida did the US acquire during its imperialist period?",
                "What state was annexed by the US in 1898?",
                "What was one of the reasons why the US wanted to be imperialist?",
                "What did the New Manifest mean?",
                "What did the de Lome letter say?",
                "What was the main cause of death for US soldiers in the Spanish-American War?",
                "What did some people believe imperialism really was?",
                "What happened in the Treaty of Paris?",
                "Which country did the US invest in sugar and tobacco?",
                "Which country(ies) control trade with China?",
                "Where did the Boxer Rebellion take place?",
                "Which country did the US force to open trade with them?",
                "Where is the canal that helped link the East and West coasts?",
                "Which country did Panama gain independence from?",
                "When was the Treaty of Paris signed?",
                "When did production on the Panama Canal start?",
                "When did the manufacturing of the Panama Canal end?",
                "When did the US force Japan to open up trade with them?",
                "When was Hawaii annexed by the US?",
                "When was the Panama canal returned to Panama?"};

        answers = new String[] {
                "They were business men who usurped power from the locals",
                "Admiral Dew",
                "Emilio Aguinaldo",
                "William McKinley",
                "Lydia Liliuokalani",
                "Puerto Rico",
                "Hawaii",
                "They wanted to be a status symbol",
                "It basically said that the US had the RIGHT to intervene ANYWHERE",
                "It indirectly called the president weak",
                "New diseases from the Spanish killed 93.5% of the the US soldiers",
                "Racism, immoral, and getting caught up in someone else's business",
                "The US gains the Philippines, Guam, Puerto Rico, and Wake Island",
                "Cuba",
                "Europe & Japan",
                "China",
                "Japan",
                "Panama",
                "Columbia",
                "1898",
                "1904",
                "1914",
                "1840",
                "1898",
                "December 31, 199"};

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
        if(PlayGamePanel.getiValue() == 2)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                imperialScore += 100;
            }
        }

        if(PlayGamePanel.getiValue() == 7)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                imperialScore += 200;
            }
        }

        if(PlayGamePanel.getiValue() == 12)
        {
            if ((e.getActionCommand().equals(answers[randomNum])))
            {
                imperialScore += 300;
            }
        }

        if(PlayGamePanel.getiValue() == 17)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                imperialScore += 400;
            }
        }

        if(PlayGamePanel.getiValue() == 22)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                imperialScore += 500;
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

        for(int i = 0; i < 3; i++)
        {
            listOfCards.previous(primaryPanel);
        }
    }

    public static int getImperialScore()// this method returns the score that the user has earned for the US imperialism unit questions
    {
        return imperialScore;
    }
}