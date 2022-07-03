import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportantGamePanelRules extends JPanel implements ActionListener
{
    private CardLayout listOfCards;
    private MainIntroPanel primaryPanel;

    public ImportantGamePanelRules(CardLayout c, MainIntroPanel m)
    {
        Color gold = new Color(255, 221, 0);
        setLayout(new BorderLayout());
        setBackground(gold);

        listOfCards = c;
        primaryPanel = m;

        ImageIcon instruct1 = new ImageIcon("gamepanelinstructions-1.png");
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

        JButton goNext = new JButton("Next");
        goNext.setFont(new Font("Arial", Font.PLAIN, 20));
        goNext.setOpaque(false);
        goNext.addActionListener(this);
        bottom.add(goNext);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Previous"))
        {
            listOfCards.previous(primaryPanel);
        }

        if(e.getActionCommand().equals("Next"))
        {
            listOfCards.next(primaryPanel);
        }
    }
}