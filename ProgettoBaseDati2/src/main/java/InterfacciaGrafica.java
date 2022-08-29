import javax.swing.*;
import java.awt.*;

public class InterfacciaGrafica extends JFrame {
    private JPanel mainContent;
    private JPanel viewPanel;
    private JPanel commandPanel;
    private JTextArea viewArea;
    public InterfacciaGrafica()
    {
        super("Progetto BD2");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,500);
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
        viewArea=new JTextArea(50,100);
        JScrollPane viewScrollPane = new JScrollPane(viewArea);
        for (int i=0;i<250;i++)
            viewArea.append("Ciao Sono Antonio\n");
        viewArea.setEditable(false);
        viewPanel.add(viewArea);
        mainContent.add(viewPanel,viewLayoutConstraints);



        //resource panel
        commandPanel.setBackground(Color.RED);
        commandLayoutConstraints.gridx=2;
        commandLayoutConstraints.gridy=0;
        commandLayoutConstraints.weightx=0.25;
        commandLayoutConstraints.weighty=1;
        commandLayoutConstraints.fill=GridBagConstraints.BOTH;
        mainContent.add(commandPanel,commandLayoutConstraints);


        this.setContentPane(mainContent);
    }

    public static void main (String[] args){
        JFrame frame = new InterfacciaGrafica();
        frame.setVisible(true);
    }
}
