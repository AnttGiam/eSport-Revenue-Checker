import javax.swing.*;
import java.awt.*;

public class ModificaGUI extends JFrame
{
    private JPanel mainPanel;
    private JTextField nickField;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField guadagniField;
    private JTextField nazionalitaField;
    private JTextField giocoField;
    private JTextField genereField;
    private JButton modificaButton;

    public JTextField getNickField() {
        return nickField;
    }

    public void setNickField(JTextField nickField) {
        this.nickField = nickField;
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public void setNomeField(JTextField nomeField) {
        this.nomeField = nomeField;
    }

    public JTextField getCognomeField() {
        return cognomeField;
    }

    public void setCognomeField(JTextField cognomeField) {
        this.cognomeField = cognomeField;
    }

    public JTextField getGuadagniField() {
        return guadagniField;
    }

    public void setGuadagniField(JTextField guadagniField) {
        this.guadagniField = guadagniField;
    }

    public JTextField getNazionalitaField() {
        return nazionalitaField;
    }

    public void setNazionalitaField(JTextField nazionalitaField) {
        this.nazionalitaField = nazionalitaField;
    }

    public JTextField getGiocoField() {
        return giocoField;
    }

    public void setGiocoField(JTextField giocoField) {
        this.giocoField = giocoField;
    }

    public JTextField getGenereField() {
        return genereField;
    }

    public void setGenereField(JTextField genereField) {
        this.genereField = genereField;
    }

    public JButton getModificaButton() {
        return modificaButton;
    }

    public void setModificaButton(JButton modificaButton) {
        this.modificaButton = modificaButton;
    }

    public ModificaGUI(){
        super("Modifica Giocatore");
        //this.setSize(400,400);
        mainPanel=new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        //Nome
        //Label
        JLabel nomeLabel = new JLabel("Nome:");
        GridBagConstraints nomeLabelLayoutConstraints = new GridBagConstraints();
        nomeLabelLayoutConstraints.gridx=0;
        nomeLabelLayoutConstraints.gridy=0;
        nomeLabelLayoutConstraints.weightx=0.25;
        nomeLabelLayoutConstraints.gridwidth=1;
        nomeLabelLayoutConstraints.insets= new Insets(10,10,10,10);
        nomeLabelLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(nomeLabel,nomeLabelLayoutConstraints);
        //TextField
        nomeField=new JTextField();
        GridBagConstraints nomeFieldLayoutConstraints = new GridBagConstraints();
        nomeFieldLayoutConstraints.gridx=1;
        nomeFieldLayoutConstraints.gridy=0;
        nomeFieldLayoutConstraints.weightx=0.50;
        nomeFieldLayoutConstraints.gridwidth=2;
        nomeFieldLayoutConstraints.insets= new Insets(10,10,10,10);
        nomeFieldLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(nomeField,nomeFieldLayoutConstraints);

        //Cognome
        //Label
        JLabel cognomeLabel = new JLabel("Cognome:");
        GridBagConstraints cognomeLabelLayoutConstraints = new GridBagConstraints();
        cognomeLabelLayoutConstraints.gridx=0;
        cognomeLabelLayoutConstraints.gridy=1;
        cognomeLabelLayoutConstraints.weightx=0.25;
        cognomeLabelLayoutConstraints.gridwidth=1;
        cognomeLabelLayoutConstraints.insets= new Insets(10,10,10,10);
        cognomeLabelLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(cognomeLabel,cognomeLabelLayoutConstraints);
        //TextField
        cognomeField=new JTextField();
        GridBagConstraints cognomeFieldLayoutConstraints = new GridBagConstraints();
        cognomeFieldLayoutConstraints.gridx=1;
        cognomeFieldLayoutConstraints.gridy=1;
        cognomeFieldLayoutConstraints.weightx=0.50;
        cognomeFieldLayoutConstraints.gridwidth=2;
        cognomeFieldLayoutConstraints.insets= new Insets(10,10,10,10);
        cognomeFieldLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(cognomeField,cognomeFieldLayoutConstraints);

        //Nickname
        //Label
        JLabel nickLabel = new JLabel("Nick:");
        GridBagConstraints nickLabelLayoutConstraints = new GridBagConstraints();
        nickLabelLayoutConstraints.gridx=0;
        nickLabelLayoutConstraints.gridy=2;
        nickLabelLayoutConstraints.weightx=0.25;
        nickLabelLayoutConstraints.gridwidth=1;
        nickLabelLayoutConstraints.insets= new Insets(10,10,10,10);
        nickLabelLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(nickLabel,nickLabelLayoutConstraints);
        //TextField
        nickField=new JTextField();
        GridBagConstraints nickFieldLayoutConstraints = new GridBagConstraints();
        nickFieldLayoutConstraints.gridx=1;
        nickFieldLayoutConstraints.gridy=2;
        nickFieldLayoutConstraints.weightx=0.50;
        nickFieldLayoutConstraints.gridwidth=2;
        nickFieldLayoutConstraints.insets= new Insets(10,10,10,10);
        nickFieldLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(nickField,nickFieldLayoutConstraints);

        //Paese
        //Label
        JLabel paeseLabel = new JLabel("Paese:");
        GridBagConstraints paeseLabelLayoutConstraints = new GridBagConstraints();
        paeseLabelLayoutConstraints.gridx=0;
        paeseLabelLayoutConstraints.gridy=3;
        paeseLabelLayoutConstraints.weightx=0.25;
        paeseLabelLayoutConstraints.gridwidth=1;
        paeseLabelLayoutConstraints.insets= new Insets(10,10,10,10);
        paeseLabelLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(paeseLabel,paeseLabelLayoutConstraints);
        //TextField
        nazionalitaField=new JTextField();
        GridBagConstraints nazionalitaFieldLayoutConstraints = new GridBagConstraints();
        nazionalitaFieldLayoutConstraints.gridx=1;
        nazionalitaFieldLayoutConstraints.gridy=3;
        nazionalitaFieldLayoutConstraints.weightx=0.50;
        nazionalitaFieldLayoutConstraints.gridwidth=2;
        nazionalitaFieldLayoutConstraints.insets= new Insets(10,10,10,10);
        nazionalitaFieldLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(nazionalitaField,nazionalitaFieldLayoutConstraints);

        //Guadagni
        //Label
        JLabel guadagniLabel = new JLabel("Guadagni:");
        GridBagConstraints guadagniLabelLayoutConstraints = new GridBagConstraints();
        guadagniLabelLayoutConstraints.gridx=0;
        guadagniLabelLayoutConstraints.gridy=4;
        guadagniLabelLayoutConstraints.weightx=0.25;
        guadagniLabelLayoutConstraints.gridwidth=1;
        guadagniLabelLayoutConstraints.insets= new Insets(10,10,10,10);
        guadagniLabelLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(guadagniLabel,guadagniLabelLayoutConstraints);
        //TextField
        guadagniField=new JTextField();
        GridBagConstraints guadagniFieldLayoutConstraints = new GridBagConstraints();
        guadagniFieldLayoutConstraints.gridx=1;
        guadagniFieldLayoutConstraints.gridy=4;
        guadagniFieldLayoutConstraints.weightx=0.50;
        guadagniFieldLayoutConstraints.gridwidth=2;
        guadagniFieldLayoutConstraints.insets= new Insets(10,10,10,10);
        guadagniFieldLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(guadagniField,guadagniFieldLayoutConstraints);

        //Gioco
        //Label
        JLabel giocoLabel = new JLabel("Gioco:");
        GridBagConstraints giocoLabelLayoutConstraints = new GridBagConstraints();
        giocoLabelLayoutConstraints.gridx=0;
        giocoLabelLayoutConstraints.gridy=5;
        giocoLabelLayoutConstraints.weightx=0.25;
        giocoLabelLayoutConstraints.gridwidth=1;
        giocoLabelLayoutConstraints.insets= new Insets(10,10,10,10);
        giocoLabelLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(giocoLabel,giocoLabelLayoutConstraints);
        //TextField
        giocoField=new JTextField();
        GridBagConstraints giocoFieldLayoutConstraints = new GridBagConstraints();
        giocoFieldLayoutConstraints.gridx=1;
        giocoFieldLayoutConstraints.gridy=5;
        giocoFieldLayoutConstraints.weightx=0.50;
        giocoFieldLayoutConstraints.gridwidth=2;
        giocoFieldLayoutConstraints.insets= new Insets(10,10,10,10);
        giocoFieldLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(giocoField,giocoFieldLayoutConstraints);

        //Generi
        //Label
        JLabel genereLabel = new JLabel("Genere:");
        GridBagConstraints genereLabelLayoutConstraints = new GridBagConstraints();
        genereLabelLayoutConstraints.gridx=0;
        genereLabelLayoutConstraints.gridy=6;
        genereLabelLayoutConstraints.weightx=0.25;
        genereLabelLayoutConstraints.gridwidth=1;
        genereLabelLayoutConstraints.insets= new Insets(10,10,10,10);
        genereLabelLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(genereLabel,genereLabelLayoutConstraints);
        //TextField
        genereField=new JTextField();
        GridBagConstraints genereFieldLayoutConstraints = new GridBagConstraints();
        genereFieldLayoutConstraints.gridx=1;
        genereFieldLayoutConstraints.gridy=6;
        genereFieldLayoutConstraints.weightx=0.50;
        genereFieldLayoutConstraints.gridwidth=2;
        genereFieldLayoutConstraints.insets= new Insets(10,10,10,10);
        genereFieldLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(genereField,genereFieldLayoutConstraints);


        //Button
        modificaButton = new JButton("Modifica Giocatore");
        GridBagConstraints modificaButtonLayoutConstraints = new GridBagConstraints();
        modificaButtonLayoutConstraints.gridx=0;
        modificaButtonLayoutConstraints.gridy=7;
        modificaButtonLayoutConstraints.weightx=0.50;
        modificaButtonLayoutConstraints.gridwidth=3;
        modificaButtonLayoutConstraints.insets= new Insets(10,10,10,10);
        modificaButtonLayoutConstraints.fill=GridBagConstraints.BOTH;
        mainPanel.add(modificaButton,modificaButtonLayoutConstraints);



        this.add(mainPanel);
        this.setSize(new Dimension(400,400));
        this.setResizable(false);
        this.setVisible(true);
    }
}
