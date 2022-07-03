/*
 * HarlemRenaissanceQuestionPanel.java
 *
 * In this panel you will see the question from
 * the harlem renaissance unit in US history and you will
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

public class HarlemRenaissanceQuestionPanel extends JPanel implements ActionListener
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
    private static int harlemScore;

    public HarlemRenaissanceQuestionPanel(CardLayout c, MainIntroPanel m)
    {
        Color gold = new Color(255, 221,0);
        setLayout(new GridLayout(7, 1));
        setBackground(gold);

        listOfCards = c;
        primaryPanel = m;
        harlemScore = 0;

        questions = new String[] {"Who painted with a unique silhouette style of painting?",
                "Who painted on the personal side of African American life?",
                "Who was the founding member of the NAACP who led a parade of 10,000 African-American men in New York to protest racial violence?",
                "Who studied classical art, but developed their own style?",
                "Who painted with spiritual images and a different combination of African and American themes and symbols?",
                "Who wrote novels that showed blacks with dignity, respect, and realism?",
                "Who was a female blues singer and was one of the most famous vocalists of the decade?",
                "Who founded the Universal Negro Improvement Association?",
                "Who did not approve of the arts of Blue and Jazz and hated being labeled as a Black poet?",
                "This person wrote stories, poetry, novels, short stories, plays, operas, and musicals.",
                "This person wrote Their Eyes were Watching God(you might have read this book in literature).",
                "Who started the Negritude Movement?",
                "What was the Harlem Renaissance?",
                "What broke racial barriers between whites and blacks?",
                "What was the Great Migration?",
                "What was the Cotton Club?",
                "In which book did Langston Hughes tie African American music and poems about ghetto life?",
                "In which book did Claude McKay show the glamour of Harlem life?",
                "What was a famous black musical comedy",
                "What did jazz or blues do?",
                "What was the Apollo theatre?",
                "When did the Harlem Renaissance begin?",
                "When did the Harlem Renaissance end?",
                "When was the book Cane by John Toomer written?",
                "When was Their Eyes Were Watching God written?"};

        answers = new String[]
                {"Aaron Douglas",
                "Palmer Hayden",
                "W.E.B Du Bois",
                "William H. Johnson",
                "Louis Mailou Jones",
                "Jean Toomer",
                "Bessie Smith",
                "Marcus Garvey",
                "Countee Cullen",
                "Langston Hughes",
                "Zora Neale Hurston",
                "Claude McKay",
                "An era of social, political, cultural, and artistic growth in the African American community",
                "Music, especially jazz and blues",
                "Approximately 2,000,000 African Americans moved during this time",
                "This place featured all black performers although no blacks were permitted as guests",
                "The Weary Blues",
                "Harlem Shadows",
                "Shuffle Along",
                "It broke racial barriers between musicians",
                "It is a famous place that was known as the shrine of black music",
                "1920",
                "1930",
                "1923",
                "1937"};

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
        if(PlayGamePanel.getiValue() == 4)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                harlemScore += 100;
            }
        }

        if(PlayGamePanel.getiValue() == 9)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                harlemScore += 200;
            }
        }

        if(PlayGamePanel.getiValue() == 14)
        {
            if ((e.getActionCommand().equals(answers[randomNum])))
            {
                harlemScore += 300;
            }
        }

        if(PlayGamePanel.getiValue() == 19)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                harlemScore += 400;
            }
        }

        if(PlayGamePanel.getiValue() == 24)
        {
            if((e.getActionCommand().equals(answers[randomNum])))
            {
                harlemScore += 500;
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

        for(int i = 0; i < 5; i++)
        {
            listOfCards.previous(primaryPanel);
        }
    }

    public static int getHarlemScore()// this method returns the score that the user has earned for the harlem renaissance unit questions
    {
        return harlemScore;
    }
}