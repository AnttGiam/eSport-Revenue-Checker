import javax.swing.*;
import java.awt.*;

public class GuadagniGUI extends JFrame {

    private JPanel mainPanel;
    private JTextField guadagniField;
    private JButton modificaButton;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getGuadagniField() {
        return guadagniField;
    }

    public void setGuadagniField(JTextField guadagniField) {
        this.guadagniField = guadagniField;
    }

    public JButton getModificaButton() {
        return modificaButton;
    }

    public void setModificaButton(JButton modificaButton) {
        this.modificaButton = modificaButton;
    }

    public GuadagniGUI(String nome){
        super("Aggiungi Guadagni a: "+nome);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        //Label
        JLabel nomeLabel = new JLabel("Inserisci Aumento Guadagno:");
        GridBagConstraints nomeLabelLayoutConstraints = new GridBagConstraints();
        nomeLabelLayoutConstraints.gridx=0;
        nomeLabelLayoutConstraints.gridy=0;
        nomeLabelLayoutConstraints.weightx=0.25;
        nomeLabelLayoutConstraints.gridwidth=1;
        nomeLabelLayoutConstraints.insets= new Insets(10,10,10,10);
        nomeLabelLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(nomeLabel,nomeLabelLayoutConstraints);
        //TextField
        guadagniField=new JTextField();
        GridBagConstraints nomeFieldLayoutConstraints = new GridBagConstraints();
        nomeFieldLayoutConstraints.gridx=1;
        nomeFieldLayoutConstraints.gridy=0;
        nomeFieldLayoutConstraints.weightx=0.50;
        nomeFieldLayoutConstraints.gridwidth=2;
        nomeFieldLayoutConstraints.insets= new Insets(10,10,10,10);
        nomeFieldLayoutConstraints.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(guadagniField,nomeFieldLayoutConstraints);

        //Button
        modificaButton = new JButton("Modifica Giocatore");
        GridBagConstraints modificaButtonLayoutConstraints = new GridBagConstraints();
        modificaButtonLayoutConstraints.gridx=0;
        modificaButtonLayoutConstraints.gridy=1;
        modificaButtonLayoutConstraints.weightx=0.50;
        modificaButtonLayoutConstraints.gridwidth=3;
        modificaButtonLayoutConstraints.insets= new Insets(10,10,10,10);
        modificaButtonLayoutConstraints.fill=GridBagConstraints.BOTH;
        mainPanel.add(modificaButton,modificaButtonLayoutConstraints);

        this.setSize(new Dimension(350,150));
        this.setResizable(false);
        this.add(mainPanel);
        this.setVisible(true);

    }
}
