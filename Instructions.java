/*
 * Instruction.java
 *
 * This panel will show you the instructions
 * for the menu/beginning panel of the game.
 *
 * Creator: Saravana Polisetti
 * Date: 5/22/20
 * Period: 7
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JPanel implements ActionListener
{
    private CardLayout listOfCards;
    private MainIntroPanel primaryPanel;

    public Instructions(CardLayout c, MainIntroPanel m)
    {
        Color gold = new Color(255, 221, 0);
        setLayout(new BorderLayout());
        setBackground(gold);

        listOfCards = c;
        primaryPanel = m;

        ImageIcon instruct1 = new ImageIcon("firstpanelinstructions-1.png");
        add(new JLabel(instruct1), BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottom.setBackground(gold);
        add(bottom, BorderLayout.SOUTH);

        JButton Home = new JButton("Home");
        Home.setFont(new Font("Arial", Font.PLAIN, 20));
        Home.setOpaque(false);
        Home.addActionListener(this);
        bottom.add(Home);

        JButton goNext = new JButton("Next");
        goNext.setFont(new Font("Arial", Font.PLAIN, 20));
        goNext.setOpaque(false);
        goNext.addActionListener(this);
        bottom.add(goNext);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Home"))
        {
            for(int i = 0; i < 9; i++)
            {
                listOfCards.previous(primaryPanel);
            }
        }

        if(e.getActionCommand().equals("Next"))
        {
            listOfCards.next(primaryPanel);
        }
    }
}