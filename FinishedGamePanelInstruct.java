/*
 * FinishedGamePanelInstruct.java
 *
 * This will show you the panel shown
 * once you have finished the game. You
 * will also see the functions of the buttons
 * on the final panel here.
 *
 * Creator: Saravana Polisetti
 * Date: 5/22/20
 * Period: 7
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinishedGamePanelInstruct extends JPanel implements ActionListener
{
    private CardLayout listOfCards;
    private MainIntroPanel primaryPanel;

    public FinishedGamePanelInstruct(CardLayout c, MainIntroPanel m)
    {
        Color gold = new Color(255, 221, 0);
        setLayout(new BorderLayout());
        setBackground(gold);

        listOfCards = c;
        primaryPanel = m;

        ImageIcon instruct1 = new ImageIcon("finishedpanel-1.png");
        add(new JLabel(instruct1), BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottom.setBackground(gold);
        add(bottom, BorderLayout.SOUTH);

        JButton Home = new JButton("Previous");
        Home.setFont(new Font("Arial", Font.PLAIN, 20));
        Home.setOpaque(false);
        Home.addActionListener(this);
        bottom.add(Home);

        JButton goNext = new JButton("Go Home");
        goNext.setFont(new Font("Arial", Font.PLAIN, 20));
        goNext.setOpaque(false);
        goNext.addActionListener(this);
        bottom.add(goNext);
    }

    public void actionPerformed(ActionEvent e) // the program receives the users command here and goes to the previous or it goes to the home panel
    {
        if(e.getActionCommand().equals("Previous"))
        {
            listOfCards.previous(primaryPanel);
        }

        if(e.getActionCommand().equals("Go Home"))
        {
            for(int i = 0; i < 13; i++)
            {
                listOfCards.previous(primaryPanel);
            }
        }
    }
}