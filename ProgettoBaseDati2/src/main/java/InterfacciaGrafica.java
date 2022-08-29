import javax.swing.*;
import java.awt.*;

public class InterfacciaGrafica extends JFrame {
    private JPanel mainContent;
    private JPanel viewPanel;
    private JPanel commandPanel;
    private JTextArea viewArea;
    private JPanel ricercaPanel;
    private JTextField ricercaField;
    private JButton ricercaNick;
    private JButton ricercaNazionalita;
    private JButton ricercaNome;
    private JButton ricercaCognome;
    private JButton ricercaGenere;
    private JButton ricercaGioco;
    private ManagerDB managerDB;

    public InterfacciaGrafica()
    {
        super("Progetto BD2");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,500);
        managerDB = new ManagerDB();
        this.setMinimumSize(new Dimension(1000,500));
        mainContent=new JPanel();
        viewPanel = new JPanel();
        commandPanel = new JPanel();

        //main panel
        mainContent.setSize(1000,500);
        mainContent.setBackground(Color.BLUE);
        mainContent.setLayout(new GridBagLayout());
        GridBagConstraints viewLayoutConstraints = new GridBagConstraints();
        GridBagConstraints commandLayoutConstraints = new GridBagConstraints();

        //view panel
        viewPanel.setBackground(Color.BLACK);
        viewLayoutConstraints.gridx=0;
        viewLayoutConstraints.gridy=0;
        viewLayoutConstraints.weightx=0.75;
        viewLayoutConstraints.weighty=1;
        viewLayoutConstraints.fill=GridBagConstraints.BOTH;
        viewPanel.setLayout(new BorderLayout());

        //view area
        viewArea=new JTextArea(50,100);
        JScrollPane viewScrollPane = new JScrollPane();
        viewScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        viewScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        viewScrollPane.getViewport().add(viewArea);
        for (int i=0;i<250;i++)
            viewArea.append("Ciao Sono Antonio\n");
        viewArea.setEditable(false);


        viewPanel.add(viewScrollPane,BorderLayout.CENTER);
        mainContent.add(viewPanel,viewLayoutConstraints);

        //command panel
        commandPanel.setBackground(Color.RED);
        commandLayoutConstraints.gridx=2;
        commandLayoutConstraints.gridy=0;
        commandLayoutConstraints.weightx=0.25;
        commandLayoutConstraints.weighty=1;
        commandLayoutConstraints.fill=GridBagConstraints.BOTH;
        commandPanel.setLayout(new GridLayout(3,1));

        //ricerca panel
        ricercaPanel = new JPanel(new GridBagLayout());
        ricercaField = new JTextField();
        ricercaField.setToolTipText("Inserisci un campo di ricerca");
        GridBagConstraints ricercaFieldLayoutConstraints = new GridBagConstraints();
        ricercaFieldLayoutConstraints.insets=new Insets(10,10,10,10);
        ricercaFieldLayoutConstraints.gridx=0;
        ricercaFieldLayoutConstraints.gridy=0;
        ricercaFieldLayoutConstraints.weightx=0.70;
        ricercaFieldLayoutConstraints.gridwidth=3;
        ricercaFieldLayoutConstraints.fill=GridBagConstraints.BOTH;
        ricercaPanel.add(ricercaField,ricercaFieldLayoutConstraints);


        //Bottoni
        //Bottone Nick
        ricercaNick = new JButton("Nickname");
        GridBagConstraints ricercaNickLayoutConstraints = new GridBagConstraints();
        ricercaNickLayoutConstraints.gridx=0;
        ricercaNickLayoutConstraints.gridy=1;
        ricercaNickLayoutConstraints.weightx=0.25;
        ricercaNickLayoutConstraints.gridwidth=1;
        ricercaNickLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaNickLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaNick,ricercaNickLayoutConstraints);

        //Bottone Nazionalità
        ricercaNazionalita = new JButton("Nazionalita'");
        GridBagConstraints ricercaNazionalitaLayoutConstraints = new GridBagConstraints();
        ricercaNazionalitaLayoutConstraints.gridx=1;
        ricercaNazionalitaLayoutConstraints.gridy=1;
        ricercaNazionalitaLayoutConstraints.weightx=0.25;
        ricercaNazionalitaLayoutConstraints.gridwidth=1;
        ricercaNazionalitaLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaNazionalitaLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaNazionalita,ricercaNazionalitaLayoutConstraints);

        //Bottone Nome
        ricercaNome = new JButton("Nome");
        GridBagConstraints ricercaNomeLayoutConstraints = new GridBagConstraints();
        ricercaNomeLayoutConstraints.gridx=2;
        ricercaNomeLayoutConstraints.gridy=1;
        ricercaNomeLayoutConstraints.weightx=0.25;
        ricercaNomeLayoutConstraints.gridwidth=1;
        ricercaNomeLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaNomeLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaNome,ricercaNomeLayoutConstraints);

        //Bottone Cognome
        ricercaCognome = new JButton("Cognome");
        GridBagConstraints ricercaCognomeLayoutConstraints = new GridBagConstraints();
        ricercaCognomeLayoutConstraints.gridx=0;
        ricercaCognomeLayoutConstraints.gridy=2;
        ricercaCognomeLayoutConstraints.weightx=0.25;
        ricercaCognomeLayoutConstraints.gridwidth=1;
        ricercaCognomeLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaCognomeLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaCognome,ricercaCognomeLayoutConstraints);

        //Bottone Cognome
        ricercaGioco = new JButton("Gioco");
        GridBagConstraints ricercaGiocoLayoutConstraints = new GridBagConstraints();
        ricercaGiocoLayoutConstraints.gridx=1;
        ricercaGiocoLayoutConstraints.gridy=2;
        ricercaGiocoLayoutConstraints.weightx=0.25;
        ricercaGiocoLayoutConstraints.gridwidth=1;
        ricercaGiocoLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaGiocoLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaGioco,ricercaGiocoLayoutConstraints);

        //Bottone Genere
        ricercaGenere = new JButton("Genere");
        GridBagConstraints ricercaGenereLayoutConstraints = new GridBagConstraints();
        ricercaGenereLayoutConstraints.gridx=2;
        ricercaGenereLayoutConstraints.gridy=2;
        ricercaGenereLayoutConstraints.weightx=0.25;
        ricercaGenereLayoutConstraints.gridwidth=1;
        ricercaGenereLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaGenereLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaGenere,ricercaGenereLayoutConstraints);



        commandPanel.add(ricercaPanel);
        mainContent.add(commandPanel,commandLayoutConstraints);


        this.setContentPane(mainContent);
    }

    public static void main (String[] args){
        JFrame frame = new InterfacciaGrafica();
        frame.setVisible(true);
    }
}
