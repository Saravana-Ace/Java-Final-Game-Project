/*
 * PreludeQuestionPanel.java
 *
 * In this panel you will see the question from
 * the prelude to the civil war unit in US history and you will
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

public class PreludeQuestionPanel extends JPanel implements ActionListener
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
    private static int preludeScore;

    public PreludeQuestionPanel(CardLayout c, MainIntroPanel m)
    {
        Color gold = new Color(255, 221,0);
        setLayout(new GridLayout(7, 1));
        setBackground(gold);

        listOfCards = c;
        primaryPanel = m;
        preludeScore = 0;

        questions = new String[] {"Who was Dread Scott?",
                "Who led the Harper Ferry Raid?",
                "Who was elected as the 16th president of the USA?",
                "Who was a celebrated abolitionist and free slave?",
                "Who stroked fear into the South?",
                "Who is a renowned underground railroad conductor?",
                "What was the Dredd Scott Decision?",
                "What did the US learn from the Dread Scott Decision?",
                "What happened Harper's Ferry Raid?",
                "What did the South want during the Civil War?",
                "What happened in Bleeding Kansas?",
                "What advantages did the North have?",
                "What advantages did the South have?",
                "What happened in the Compromise of 1850?",
                "Where was Dredd Scott technically considered a free man?",
                "Where was Harper's Ferry Raid take place?",
                "Which state(s) seceded in 1860?",
                "Which state was Frederick Douglass a slave in?",
                "Where was Henry Clay's compromise signed?",
                "When was Harper Ferry's raid conducted?",
                "When was the Election of 1860(please get it right)?",
                "When was the Confederate States of America formed?",
                "When did the Confederates attack Fort Sumter?",
                "When did Frederick Douglass escape from slavery?",
                "When did Henry Clay's Compromise take place?"};

        answers = new String[] {
                "A slave who appealed to the Supreme Court for his freedom",
                "John Brown",
                "Abraham Lincoln",
                "Frederick Douglass",
                "Nat Turner nad John Brown",
                "Harriet Tubman",
                "The Supreme Court denied Dredd Scott's freedom",
                "The fifth amendment protected property(including slaves) so being in a free territory did not make a slave free.",
                "John Brown led his sons and a handful of followers to rally for abortive slave insurrection, which ended in a shooting.",
                "They wanted English help",
                "The state was in chaos and violence everywhere.",
                "A large population, 4/5 railroads belonged to them, had a lot of money.",
                "A great popular south, strong military tradition, and had really good generals.",
                "Texas was admitted as a slave state.",
                "Illinois and Wisconsin",
                "Virginia",
                "South Carolina",
                "Maryland",
                "Missouri",
                "1859",
                "1860",
                "1861",
                "April 12, 1861",
                "1838",
                "1850"};

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
        if(PlayGamePanel.getiValue() == 1)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                preludeScore += 100;
            }
        }

        if(PlayGamePanel.getiValue() == 6)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                preludeScore += 200;
            }
        }

        if(PlayGamePanel.getiValue() == 11)
        {
            if ((e.getActionCommand().equals(answers[randomNum])))
            {
                preludeScore += 300;
            }
        }

        if(PlayGamePanel.getiValue() == 16)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                preludeScore += 400;
            }
        }

        if(PlayGamePanel.getiValue() == 21)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                preludeScore += 500;
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

        for(int i = 0; i < 2; i++)
        {
            listOfCards.previous(primaryPanel);
        }
    }

    public static int getPreludeScore()// this method returns the score that the user has earned for the prelude to the civil war unit questions
    {
        return preludeScore;
    }
}