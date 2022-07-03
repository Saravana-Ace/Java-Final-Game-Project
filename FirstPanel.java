/*
 * FirstPanel.java
 *
 * In this panel you will see the menu with three options:
 * play now, instructions, and study here. A cool feature
 * about this panel is that the background changes color every
 * second.
 *
 * Creator: Saravana Polisetti
 * Date: 5/22/20
 * Period: 7
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FirstPanel extends JPanel implements MouseListener, ActionListener
{

    private int randomColor1;
    private int randomColor2;
    private int randomColor3;
    Timer timer;
    boolean userClicked;
    private JPanel welcome;
    private CardLayout listOfCards;
    private MainIntroPanel primaryPanel;

    public FirstPanel (CardLayout c, MainIntroPanel m)
    {
        listOfCards = c;
        primaryPanel = m;

        randomColor1 = 0;
        randomColor2 = 0;
        randomColor3 = 0;

        timer = new Timer(1000, this);
        timer.start();

        userClicked = false;

        addMouseListener(this);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Font myFont = new Font("Arial", Font.BOLD, 40);
        Font myFont2 = new Font("Arial", Font.BOLD, 26);

        welcome = new JPanel();
        welcome.setLayout(new GridLayout(3,5));
        welcome.setOpaque(false);
        add(welcome);

        ImageIcon image = new ImageIcon("George-Washington3.jpg");
        welcome.add(new JLabel(image));

        JLabel empty = new JLabel("");
        welcome.add(empty);

        JTextArea empty2 = new JTextArea("Welcome          To Jeopardy!");
        empty2.setLineWrap(true);
        empty2.setWrapStyleWord(true);
        empty2.setEditable(false);
        empty2.setOpaque(false);
        empty2.setFont(myFont);
        empty2.setForeground(Color.WHITE);
        welcome.add(empty2);

        JLabel empty3 = new JLabel("");
        empty3.setFont(myFont);
        welcome.add(empty3);

        ImageIcon image2 = new ImageIcon("Lincoln2-200x200.jpg");
        welcome.add(new JLabel(image2));

        JLabel empty4 = new JLabel("");
        welcome.add(empty4);

        JLabel empty5 = new JLabel("");
        welcome.add(empty5);

        JPanel introButtons = new JPanel();
        introButtons.setLayout(new GridLayout(3,1));
        introButtons.setOpaque(false);
        welcome.add(introButtons);

        JButton startGame = new JButton("Play Now");
        startGame.setFont(myFont2);
        startGame.addActionListener(this);
        startGame.setOpaque(false);
        introButtons.add(startGame);

        JButton instructions = new JButton("Instructions");
        instructions.setFont(myFont2);
        instructions.addActionListener(this);
        instructions.setOpaque(false);
        introButtons.add(instructions);

        JButton study = new JButton("Study Here");
        study.setFont(myFont2);
        study.addActionListener(this);
        study.setOpaque(false);
        introButtons.add(study);

        JLabel empty6 = new JLabel("");
        welcome.add(empty6);

        JLabel empty7 = new JLabel("");
        welcome.add(empty7);


        ImageIcon image3 = new ImageIcon("doorway-to-the-alamo-an-18th-century-mission-church-in-san-antonio-texas-64f24a-200.jpg");
        welcome.add(new JLabel(image3));

        JLabel empty13 = new JLabel("");
        welcome.add(empty13);

        JLabel empty14 = new JLabel("");
        welcome.add(empty14);

        JLabel empty15 = new JLabel("");
        welcome.add(empty15);

        ImageIcon image4 = new ImageIcon("unnamed.jpg");
        welcome.add(new JLabel(image4));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLUE);

        randomColor1 = (int) (Math.random() * 255);
        randomColor2 = (int) (Math.random() * 255);
        randomColor3 = (int) (Math.random() * 255);
        Color a = new Color(randomColor1, randomColor2, randomColor3);


        g.setColor(a);
        g.fillRect(0,0,2000,1000);
    }

    public void mouseClicked(MouseEvent e)
    {}

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    /*
     * This method repaints the background every
     * second(every second because of the timer
     * that is started in the constructor). This method also
     * gets the action command for the buttons, so that
     * if someone clicks one of the buttons, the program
     * will go to the panel that the button is referring to.
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == timer)
        {
            this.repaint();
            return;
        }

        if(e.getActionCommand().equals("Play Now"))
        {
            listOfCards.next(primaryPanel);
        }
        else if(e.getActionCommand().equals("Instructions"))
        {
            for(int i = 0; i < 9; i++)
            {
                listOfCards.next(primaryPanel);
            }
        }
        else
        {
            for(int i = 0; i < 14; i++)
            {
                listOfCards.next(primaryPanel);
            }
        }
    }
}