/*
 * SuffrageQuestionPanel.java
 *
 * In this panel you will see the question from
 * the women's suffrage unit in US history and you will
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

public class SuffrageQuestionPanel extends JPanel implements ActionListener
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
    private static int suffrageScore;

    public SuffrageQuestionPanel(CardLayout c, MainIntroPanel m)
    {
        Color gold = new Color(255, 221,0);
        setLayout(new GridLayout(7, 1));
        setBackground(gold);

        listOfCards = c;
        primaryPanel = m;
        suffrageScore = 0;

        questions = new String[]
                {"Who was a suffragist who organized the first convention on women's rights, held in Seneca Falls Lucretia Mott?",
                "Who was a suffragist who worked closely with Elizabeth Cady Stanton to campaign for women's equality?",
                "Who was the twenty eighth president of the US?",
                "Who was the only signer of the Declaration of Sentiments who also lived to vote?",
                "Who was the head of the National Woman's Party?",
                "Who was the only African American in Seneca Falls Convention?",
                "Who was a former slave who became an abolitionist and women's rights activist?",
                "Who was the first woman Peace of Justice?",
                "She was an American Quaker, abolitionist, and women's rights activist who helped organize the Seneca Falls Convention in New York.",
                "What was Taxation without Representation?",
                "What did Amelia Bloomer do?",
                "What did Harry Burn do?",
                "What did the Silent Sentinels do?",
                "What was the Right to Assemble?",
                "What was meant by Humans as Property?",
                "What were Inalienable Rights?",
                "What was the nineteenth amendment?",
                "What was the first state to give women freedom?",
                "What were major opponents to suffrage?",
                "When did women receive suffrage?",
                "When was the Seneca Falls Convention in New York held?",
                "When was the National American Women's Suffrage Association founded?",
                "Where was the Seneca Falls Convention held?",
                "When was the The League of Women Voters founded?",
                "When was The National Consumers League founded?"};

        answers = new String[]
                {"Elizabeth Cady Stanton",
                "Susan B. Anthony",
                "Woodrow Wilson",
                "Charlotte Woodward",
                "Alice Paul",
                "Frederick Douglass",
                "Sojourner Truth",
                "Esther Morris",
                "Lucretia Mott",
                "Single women were taxed on their earnings and they weren't allowed to vote, so they didn't have a political representative that would represent them",
                "She revolted against the uncomfortable, long dresses women wore, and made short skirts",
                "Their vote gave the pro-suffrage legislators the number needed to ratify the 19th Amendment",
                "They were a group of women under Alice Paul who picket at the white house",
                "It was the first Amendment right that allowed people to meet and express their beliefs and ideologies in a political context",
                "Women were basically their husband's property, including what they earned and/or owned",
                "Life, Liberty, and the pursuit of happiness",
                "It granted women suffrage",
                "Wyoming",
                "Churches, big businesses, and liquor, since women were fighting for Prohibition laws",
                "1920",
                "1848",
                "1890",
                "New York",
                "1920",
                "1891"};

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
        if(PlayGamePanel.getiValue() == 3)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                suffrageScore += 100;
            }
        }

        if(PlayGamePanel.getiValue() == 8)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                suffrageScore += 200;
            }
        }

        if(PlayGamePanel.getiValue() == 13)
        {
            if ((e.getActionCommand().equals(answers[randomNum])))
            {
                suffrageScore += 300;
            }
        }

        if(PlayGamePanel.getiValue() == 18)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                suffrageScore += 400;
            }
        }

        if(PlayGamePanel.getiValue() == 23)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                suffrageScore += 500;
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

        for(int i = 0; i < 4; i++)
        {
            listOfCards.previous(primaryPanel);
        }
    }

    public static int getSuffrageScore()// this method returns the score that the user has earned for the women's suffrage unit questions
    {
        return suffrageScore;
    }
}