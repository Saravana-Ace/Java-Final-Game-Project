import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudyHere extends JPanel implements ActionListener {
    private CardLayout listOfCards;
    private MainIntroPanel primaryPanel;
    private String playerName;
    private String playerScore;
    private JSlider slider;

    public StudyHere(CardLayout c, MainIntroPanel m) {
        Color gold = new Color(255, 221, 0);
        setLayout(new BorderLayout());
        setBackground(gold);
        listOfCards = c;
        primaryPanel = m;
        playerName = "";
        playerScore = "";

        JPanel textPanelMiddle = new JPanel();
        textPanelMiddle.setLayout(new GridLayout(1, 1));
        add(textPanelMiddle, BorderLayout.CENTER);

        JTextArea textArea = new JTextArea
                ("Coming to America:\n" +
                "\n" + "How did the early humans travel to these new places?\n" +
                "Approximately how many humans migrated?\n" +
                "When did the humans migrate?\n" +
                "When was the Treaty of Tordesillas signed?\n" +
                "When did the “Vikings” migrate to the West\n" +
                "When was the earliest form of slavery introduced?\n" +
                "What happened due to the European diseases?\n" +
                "What did Columbus believe in?\n" +
                "Who funded Columbus’ expeditions?\n" +
                "What was shipped to Spain?\n" +
                "Where were Spain’s colony?\n" +
                "What funded the wars for Spain?\n" +
                "What did European countries want?\n" +
                "What were the first slaves called?\n" +
                "What closed because of the Enclosure Movement?\n" +
                "What was France’s colony in America?\n" +
                "Where did Christopher Columbus want to go to?\n" +
                "Where did Christopher Columbus set up trading posts?\n" +
                "Where did Leif Ericsson travel to?\n" +
                "What were England’s colonies in America?\n" +
                "What was Holland’s colony in America?\n" +
                "Where did the humans evolve and migrate from?\n" +
                "Where did humans migrate to?\n" +
                "What was Sweden’s colony in America?\n" +
                "What was the name of the largest Native American group?\n" +
                "\n" +
                "Prelude to the Civil War:\n" +
                "\n" +
                "Who was Dread Scott?\n" +
                "Who led the Harper Ferry Raid?\n" +
                "Who was elected as the 16th president of the USA?\n" +
                "Who was a celebrated abolitionist and free slave?\n" +
                "Who stroked fear into the South?\n" +
                "Who is a renowned underground railroad conductor?\n" +
                "What was the Dredd Scott Decision?\n" +
                "What did the US learn from the Dread Scott Decision?\n" +
                "What happened Harper's Ferry Raid?\n" +
                "What did the South want during the Civil War?\n" +
                "What happened in Bleeding Kansas?\n" +
                "What advantages did the North have?\n" +
                "What advantages did the South have?\n" +
                "What happened in the Compromise of 1850?\n" +
                "Where was Dredd Scott technically considered a free man?\n" +
                "Where was Harper's Ferry Raid take place?\n" +
                "Which state(s) seceded in 1860?\n" +
                "Which state was Frederick Douglass a slave in?\n" +
                "Where was Henry Clay's compromise signed?\n" +
                "When was Harper Ferry's raid conducted?\n" +
                "When was the Election of 1860(please get it right)?\n" +
                "When was the Confederate States of America formed?\n" +
                "When did the Confederates attack Fort Sumter?\n" +
                "When did Frederick Douglass escape from slavery?\n" +
                "When did Henry Clay's Compromise take place?\n" +
                "\n" +
                "American Imperialism:\n" +
                "\n" +
                "Who were Dole and Stevens?\n" +
                "Who captured the Philippines?\n" +
                "Who led the filipinos against American rule?\n" +
                "Who was the president of the USA during the Spanish-American war?\n" +
                "Who was the Hawaiian queen who was forced to cede her power by American business?\n" +
                "What territory near Florida did the US acquire during its imperialist period?\n" +
                "What state was annexed by the US in 1898?\n" +
                "What was one of the reasons why the US wanted to be imperialist?\n" +
                "What did the New Manifest mean?\n" +
                "What did the de Lome letter say?\n" +
                "What was the main cause of death for US soldiers in the Spanish-American War?\n" +
                "What did some people believe imperialism really was?\n" +
                "What happened in the Treaty of Paris?\n" +
                "Which country did the US invest in sugar and tobacco?\n" +
                "Which country(ies) control trade with China?\n" +
                "Where did the Boxer Rebellion take place?\n" +
                "Which country did the US force to open trade with them?\n" +
                "Where is the canal that helped link the East and West coasts?\n" +
                "Which country did Panama gain independence from?\n" +
                "When was the Treaty of Paris signed?\n" +
                "When did production on the Panama Canal start?\n" +
                "When did the manufacturing of the Panama Canal end?\n" +
                "When did the US force Japan to open up trade with them?\n" +
                "When was Hawaii annexed by the US?\n" +
                "When was the Panama canal returned to Panama?\n" +
                "\n" +
                "Women’s Suffrage:\n" +
                "\n" +
                "Who was a suffragist who organized the first convention on women's rights, held in Seneca Falls Lucretia Mott?\n" +
                "Who was a suffragist who worked closely with Elizabeth Cady Stanton to campaign for women's equality?\n" +
                "Who was the twenty eighth president of the US?\n" +
                "Who was the only signer of the Declaration of Sentiments who also lived to vote?\n" +
                "Who was the head of the National Woman's Party?\n" +
                "Who was the only African American in Seneca Falls Convention?\n" +
                "Who was a former slave who became an abolitionist and women's rights activist?\n" +
                "Who was the first woman Peace of Justice?\n" +
                "She was an American Quaker, abolitionist, and women's rights activist who helped organize the Seneca Falls Convention in New York.\n" +
                "What was Taxation without Representation?\n" +
                "What did Amelia Bloomer do?\n" +
                "What did Harry Burn do?\n" +
                "What did the Silent Sentinels do?\n" +
                "What was the Right to Assemble?\n" +
                "What was meant by Humans as Property?\n" +
                "What were Inalienable Rights?\n" +
                "What was the nineteenth amendment?\n" +
                "What was the first state to give women freedom?\n" +
                "What were major opponents to suffrage?\n" +
                "When did women receive suffrage?\n" +
                "When was the Seneca Falls Convention in New York held?\n" +
                "When was the National American Women's Suffrage Association founded?\n" +
                "Where was the Seneca Falls Convention held?\n" +
                "When was the The League of Women Voters founded?\n" +
                "When was The National Consumers League founded?\n" +
                "\n" +
                "The Harlem Renaissance:\n" +
                "\n" +
                "Who painted with a unique silhouette style of painting?\n" +
                "Who painted on the personal side of African American life?\n" +
                "Who was the founding member of the NAACP who led a parade of 10,000 African-American men in New York to protest racial violence?\n" +
                "Who studied classical art, but developed their own style?\n" +
                "Who painted with spiritual images and a different combination of African and American themes and symbols?\n" +
                "Who wrote novels that showed blacks with dignity, respect, and realism?\n" +
                "Who was a female blues singer and was one of the most famous vocalists of the decade?\n" +
                "Who founded the Universal Negro Improvement Association?\n" +
                "Who did not approve of the arts of Blue and Jazz and hated being labeled as a Black poet?\n" +
                "This person wrote stories, poetry, novels, short stories, plays, operas, and musicals.\n" +
                "This person wrote Their Eyes were Watching God(you might have read this book in literature).\n" +
                "Who started the Negritude Movement?\n" +
                "What was the Harlem Renaissance?\n" +
                "What broke racial barriers between whites and blacks?\n" +
                "What was the Great Migration?\n" +
                "What was the Cotton Club?\n" +
                "In which book did Langston Hughes tie African American music and poems about ghetto life?\n" +
                "In which book did Claude McKay show the glamour of Harlem life?\n" +
                "What was a famous black musical comedy\n" +
                "What did jazz or blues do?\n" +
                "What was the Apollo theatre?\n" +
                "When did the Harlem Renaissance begin?\n" +
                "When did the Harlem Renaissance end?\n" +
                "When was the book Cane by John Toomer written?\n" +
                "When was Their Eyes Were Watching God written?");
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setBackground(gold);
        textArea.setForeground(Color.BLUE);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        JScrollPane scroller = new JScrollPane(textArea);
        textPanelMiddle.add(scroller);

        JButton quitGame = new JButton("Back");
        quitGame.setBackground(gold);
        quitGame.setForeground(Color.BLUE);
        quitGame.setOpaque(false);
        quitGame.addActionListener(this);
        add(quitGame, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < 14; i++)
        {
            listOfCards.previous(primaryPanel);
        }
    }
}