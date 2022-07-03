/*2288
 * Jeopardy.java
 * This jeopardy game is unlike other jeopardy games
 * because all the questions are randomized. This means that
 * you may receive an easy question for a $500 question box
 * or you may receive a really hard question for the $100 question box.
 * On the first panel there is a menu which has a play game, instructions,
 * and study here buttons. When you click on play game, you will start playing
 * the game. If you click on the instructions button you will be able to read
 * the instructions of the game. Lastly, if you click on the study here button, you
 * will be able to look at a list of all the questions that may be asked in
 * the jeopardy game. It is recommended that you view all of the questions
 * once you finish playing the game a couple of times. Once you start playing, you
 * won't be able to quit or leave the game, and the only way to quit/leave the game is
 * by answering all of the questions in the game panel. Have fun and please enjoy this game!
 *
 * Creator: Saravana Polisetti
 * Date: 5/22/20
 * Period: 7
*/

import javax.swing.*;
import java.awt.*;

public class Jeopardy
{
    public static void main(String[] args) // the main method runs the program
    {
        JFrame frame = new JFrame("Welcome to U.S. History Review!");
        frame.setLayout(new BorderLayout());
        MainIntroPanel panel = new MainIntroPanel();
        frame.add(panel, BorderLayout.CENTER);
        frame.setBounds(200,100,1100,650);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MainIntroPanel extends JPanel
{
    private CardLayout listOfCards;

    public MainIntroPanel()
    {
        listOfCards = new CardLayout();
        setLayout(listOfCards);

        FirstPanel first = new FirstPanel (listOfCards, this);
        add(first, "1");

        EnterNamePanel second = new EnterNamePanel(listOfCards, this);
        add(second, "2");

        PlayGamePanel third = new PlayGamePanel(listOfCards, this);
        add(third, "3");

        ComingToAmericaQuestionPanel fourth = new ComingToAmericaQuestionPanel(listOfCards, this);
        add(fourth, "4");

        PreludeQuestionPanel fifth = new PreludeQuestionPanel(listOfCards, this);
        add(fifth, "5");

        ImperialismQuestionPanel sixth = new ImperialismQuestionPanel(listOfCards, this);
        add(sixth, "6");

        SuffrageQuestionPanel seventh = new SuffrageQuestionPanel(listOfCards, this);
        add(seventh, "7");

        HarlemRenaissanceQuestionPanel eighth = new HarlemRenaissanceQuestionPanel(listOfCards, this);
        add(eighth, "8");

        FinishedGamePanel ninth = new FinishedGamePanel(listOfCards, this);
        add(ninth, "9");

        Instructions tenth = new Instructions(listOfCards,this);
        add(tenth, "10");

        NamePageInstruct eleventh = new NamePageInstruct(listOfCards, this);
        add(eleventh, "11");

        GamePanelInstruct twelfth = new GamePanelInstruct(listOfCards, this);
        add(twelfth, "12");

        ImportantGamePanelRules thirteenth = new ImportantGamePanelRules(listOfCards, this);
        add(thirteenth, "13");

        FinishedGamePanelInstruct fourteenth = new FinishedGamePanelInstruct(listOfCards, this);
        add(fourteenth, "14");

        StudyHere fifteenth = new StudyHere(listOfCards, this);
        add(fifteenth, "15");
    }
}