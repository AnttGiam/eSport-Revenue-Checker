import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
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
    private JButton resettaButton;
    private JButton ordinaCrescenteButton;
    private JButton ordinaDecrescenteButton;
    private JButton contaGiochi;
    private JButton contaGeneri;
    private JButton allButton;

    public JButton getAllButton() {
        return allButton;
    }

    public void setAllButton(JButton allButton) {
        this.allButton = allButton;
    }

    public JButton getContaGiochi() {
        return contaGiochi;
    }

    public void setContaGiochi(JButton contaGiochi) {
        this.contaGiochi = contaGiochi;
    }

    public JButton getContaGeneri() {
        return contaGeneri;
    }

    public void setContaGeneri(JButton contaGeneri) {
        this.contaGeneri = contaGeneri;
    }

    public JButton getOrdinaCrescenteButton() {
        return ordinaCrescenteButton;
    }

    public void setOrdinaCrescenteButton(JButton ordinaCrescenteButton) {
        this.ordinaCrescenteButton = ordinaCrescenteButton;
    }

    public JButton getOrdinaDecrescenteButton() {
        return ordinaDecrescenteButton;
    }

    public void setOrdinaDecrescenteButton(JButton ordinaDecrescenteButton) {
        this.ordinaDecrescenteButton = ordinaDecrescenteButton;
    }

    public JButton getResettaButton() {
        return resettaButton;
    }

    public void setResettaButton(JButton resettaButton) {
        this.resettaButton = resettaButton;
    }

    public JPanel getMainContent() {
        return mainContent;
    }

    public void setMainContent(JPanel mainContent) {
        this.mainContent = mainContent;
    }

    public JPanel getViewPanel() {
        return viewPanel;
    }

    public void setViewPanel(JPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public JPanel getCommandPanel() {
        return commandPanel;
    }

    public void setCommandPanel(JPanel commandPanel) {
        this.commandPanel = commandPanel;
    }

    public JTextArea getViewArea() {
        return viewArea;
    }

    public void setViewArea(JTextArea viewArea) {
        this.viewArea = viewArea;
    }

    public JPanel getRicercaPanel() {
        return ricercaPanel;
    }

    public void setRicercaPanel(JPanel ricercaPanel) {
        this.ricercaPanel = ricercaPanel;
    }

    public JTextField getRicercaField() {
        return ricercaField;
    }

    public void setRicercaField(JTextField ricercaField) {
        this.ricercaField = ricercaField;
    }

    public JButton getRicercaNick() {
        return ricercaNick;
    }

    public void setRicercaNick(JButton ricercaNick) {
        this.ricercaNick = ricercaNick;
    }

    public JButton getRicercaNazionalita() {
        return ricercaNazionalita;
    }

    public void setRicercaNazionalita(JButton ricercaNazionalita) {
        this.ricercaNazionalita = ricercaNazionalita;
    }

    public JButton getRicercaNome() {
        return ricercaNome;
    }

    public void setRicercaNome(JButton ricercaNome) {
        this.ricercaNome = ricercaNome;
    }

    public JButton getRicercaCognome() {
        return ricercaCognome;
    }

    public void setRicercaCognome(JButton ricercaCognome) {
        this.ricercaCognome = ricercaCognome;
    }

    public JButton getRicercaGenere() {
        return ricercaGenere;
    }

    public void setRicercaGenere(JButton ricercaGenere) {
        this.ricercaGenere = ricercaGenere;
    }

    public JButton getRicercaGioco() {
        return ricercaGioco;
    }

    public void setRicercaGioco(JButton ricercaGioco) {
        this.ricercaGioco = ricercaGioco;
    }

    public GUI()
    {
        super("Progetto BD2");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,500);
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

        //Label
        JLabel ricercaLabel = new JLabel("Inserisci i termini di ricerca");
        GridBagConstraints ricercaLabelLayoutConstraints = new GridBagConstraints();
        ricercaLabelLayoutConstraints.insets=new Insets(10,10,0,10);
        ricercaLabelLayoutConstraints.gridx=0;
        ricercaLabelLayoutConstraints.gridy=0;
        ricercaLabelLayoutConstraints.gridwidth=1;
        ricercaLabelLayoutConstraints.fill=GridBagConstraints.BOTH;
        ricercaPanel.add(ricercaLabel,ricercaLabelLayoutConstraints);

        //AllButton
        allButton = new JButton("Tutto");
        GridBagConstraints allButtonLayoutConstraints = new GridBagConstraints();
        allButtonLayoutConstraints.gridx=1;
        allButtonLayoutConstraints.gridy=0;
        allButtonLayoutConstraints.weightx=0.25;
        allButtonLayoutConstraints.gridwidth=1;
        allButtonLayoutConstraints.insets= new Insets(10,10,0,10);
        allButtonLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(allButton,allButtonLayoutConstraints);

        //ResetButton
        resettaButton = new JButton("Reset");
        GridBagConstraints resettaButtonLayoutConstraints = new GridBagConstraints();
        resettaButtonLayoutConstraints.gridx=2;
        resettaButtonLayoutConstraints.gridy=0;
        resettaButtonLayoutConstraints.weightx=0.25;
        resettaButtonLayoutConstraints.gridwidth=1;
        resettaButtonLayoutConstraints.insets= new Insets(10,10,0,10);
        resettaButtonLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(resettaButton,resettaButtonLayoutConstraints);

        //TextField
        ricercaField = new JTextField();
        GridBagConstraints ricercaFieldLayoutConstraints = new GridBagConstraints();
        ricercaFieldLayoutConstraints.insets=new Insets(10,10,10,10);
        ricercaFieldLayoutConstraints.gridx=0;
        ricercaFieldLayoutConstraints.gridy=1;
        ricercaFieldLayoutConstraints.weightx=0.70;
        ricercaFieldLayoutConstraints.gridwidth=3;
        ricercaFieldLayoutConstraints.fill=GridBagConstraints.BOTH;
        ricercaPanel.add(ricercaField,ricercaFieldLayoutConstraints);



        //Bottoni
        //Bottone Nick
        ricercaNick = new JButton("Nickname");
        GridBagConstraints ricercaNickLayoutConstraints = new GridBagConstraints();
        ricercaNickLayoutConstraints.gridx=0;
        ricercaNickLayoutConstraints.gridy=2;
        ricercaNickLayoutConstraints.weightx=0.25;
        ricercaNickLayoutConstraints.gridwidth=1;
        ricercaNickLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaNickLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaNick,ricercaNickLayoutConstraints);

        //Bottone Nazionalità
        ricercaNazionalita = new JButton("Nazionalita'");
        GridBagConstraints ricercaNazionalitaLayoutConstraints = new GridBagConstraints();
        ricercaNazionalitaLayoutConstraints.gridx=1;
        ricercaNazionalitaLayoutConstraints.gridy=2;
        ricercaNazionalitaLayoutConstraints.weightx=0.25;
        ricercaNazionalitaLayoutConstraints.gridwidth=1;
        ricercaNazionalitaLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaNazionalitaLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaNazionalita,ricercaNazionalitaLayoutConstraints);

        //Bottone Nome
        ricercaNome = new JButton("Nome");
        GridBagConstraints ricercaNomeLayoutConstraints = new GridBagConstraints();
        ricercaNomeLayoutConstraints.gridx=2;
        ricercaNomeLayoutConstraints.gridy=2;
        ricercaNomeLayoutConstraints.weightx=0.25;
        ricercaNomeLayoutConstraints.gridwidth=1;
        ricercaNomeLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaNomeLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaNome,ricercaNomeLayoutConstraints);

        //Bottone Cognome
        ricercaCognome = new JButton("Cognome");
        GridBagConstraints ricercaCognomeLayoutConstraints = new GridBagConstraints();
        ricercaCognomeLayoutConstraints.gridx=0;
        ricercaCognomeLayoutConstraints.gridy=3;
        ricercaCognomeLayoutConstraints.weightx=0.25;
        ricercaCognomeLayoutConstraints.gridwidth=1;
        ricercaCognomeLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaCognomeLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaCognome,ricercaCognomeLayoutConstraints);

        //Bottone Cognome
        ricercaGioco = new JButton("Gioco");
        GridBagConstraints ricercaGiocoLayoutConstraints = new GridBagConstraints();
        ricercaGiocoLayoutConstraints.gridx=1;
        ricercaGiocoLayoutConstraints.gridy=3;
        ricercaGiocoLayoutConstraints.weightx=0.25;
        ricercaGiocoLayoutConstraints.gridwidth=1;
        ricercaGiocoLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaGiocoLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaGioco,ricercaGiocoLayoutConstraints);

        //Bottone Genere
        ricercaGenere = new JButton("Genere");
        GridBagConstraints ricercaGenereLayoutConstraints = new GridBagConstraints();
        ricercaGenereLayoutConstraints.gridx=2;
        ricercaGenereLayoutConstraints.gridy=3;
        ricercaGenereLayoutConstraints.weightx=0.25;
        ricercaGenereLayoutConstraints.gridwidth=1;
        ricercaGenereLayoutConstraints.insets= new Insets(10,10,10,10);
        ricercaGenereLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ricercaPanel.add(ricercaGenere,ricercaGenereLayoutConstraints);

        //ORDINA PANEL
        JPanel ordinaPanel = new JPanel();
        ordinaPanel.setLayout(new GridBagLayout());

        //Label
        JLabel ordinaLabel = new JLabel("Ordina i dati presenti nel Database");
        GridBagConstraints ordinaLabelLayoutConstraints = new GridBagConstraints();
        ordinaLabelLayoutConstraints.insets=new Insets(10,10,0,10);
        ordinaLabelLayoutConstraints.gridx=0;
        ordinaLabelLayoutConstraints.gridy=0;
        ordinaLabelLayoutConstraints.gridwidth=2;
        ordinaLabelLayoutConstraints.fill=GridBagConstraints.BOTH;
        ordinaPanel.add(ordinaLabel,ordinaLabelLayoutConstraints);

        //Ordina Crescente Button
        ordinaCrescenteButton = new JButton("Crescente");
        GridBagConstraints ordinaCrescenteLayoutConstraints = new GridBagConstraints();
        ordinaCrescenteLayoutConstraints.gridx=0;
        ordinaCrescenteLayoutConstraints.gridy=1;
        ordinaCrescenteLayoutConstraints.weightx=0.25;
        ordinaCrescenteLayoutConstraints.gridwidth=1;
        ordinaCrescenteLayoutConstraints.insets= new Insets(10,10,10,10);
        ordinaCrescenteLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ordinaPanel.add(ordinaCrescenteButton,ordinaCrescenteLayoutConstraints);

        //Ordina Decrescente Button
        ordinaDecrescenteButton = new JButton("Decrescente");
        GridBagConstraints ordinaDecrescenteLayoutConstraints = new GridBagConstraints();
        ordinaDecrescenteLayoutConstraints.gridx=1;
        ordinaDecrescenteLayoutConstraints.gridy=1;
        ordinaDecrescenteLayoutConstraints.weightx=0.25;
        ordinaDecrescenteLayoutConstraints.gridwidth=1;
        ordinaDecrescenteLayoutConstraints.insets= new Insets(10,10,10,10);
        ordinaDecrescenteLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ordinaPanel.add(ordinaDecrescenteButton,ordinaDecrescenteLayoutConstraints);

        //Label
        JLabel contaLabel = new JLabel("Conta i giocatori presenti nel Database");
        GridBagConstraints contaLabelLayoutConstraints = new GridBagConstraints();
        contaLabelLayoutConstraints.insets=new Insets(10,10,0,10);
        contaLabelLayoutConstraints.gridx=0;
        contaLabelLayoutConstraints.gridy=2;
        contaLabelLayoutConstraints.gridwidth=2;
        contaLabelLayoutConstraints.fill=GridBagConstraints.BOTH;
        ordinaPanel.add(contaLabel,contaLabelLayoutConstraints);

        //Conta per Giochi
        contaGiochi = new JButton("Giochi");
        GridBagConstraints contaGiochiLayoutConstraints = new GridBagConstraints();
        contaGiochiLayoutConstraints.gridx=0;
        contaGiochiLayoutConstraints.gridy=3;
        contaGiochiLayoutConstraints.weightx=0.25;
        contaGiochiLayoutConstraints.gridwidth=1;
        contaGiochiLayoutConstraints.insets= new Insets(10,10,10,10);
        contaGiochiLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ordinaPanel.add(contaGiochi,contaGiochiLayoutConstraints);

        //Conta per Generi
        contaGeneri = new JButton("Generi");
        GridBagConstraints contaGeneriLayoutConstraints = new GridBagConstraints();
        contaGeneriLayoutConstraints.gridx=1;
        contaGeneriLayoutConstraints.gridy=3;
        contaGeneriLayoutConstraints.weightx=0.25;
        contaGeneriLayoutConstraints.gridwidth=1;
        contaGeneriLayoutConstraints.insets= new Insets(10,10,10,10);
        contaGeneriLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        ordinaPanel.add(contaGeneri,contaGeneriLayoutConstraints);

        commandPanel.add(ricercaPanel);
        commandPanel.add(ordinaPanel);
        mainContent.add(commandPanel,commandLayoutConstraints);


        this.setContentPane(mainContent);
        this.setVisible(true);
    }

    public static void main (String[] args){
        JFrame frame = new InterfacciaGrafica();
    }
}