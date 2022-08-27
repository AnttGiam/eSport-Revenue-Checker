import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;

public class InterfacciaGrafica extends JFrame {
    private JPanel mainContent;
    private JButton button1;
    private JPanel resourcePanel;
    private JPanel commandPanel;
    public InterfacciaGrafica()
    {
        super("Progetto BD2");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,500);
        mainContent=new JPanel();
        resourcePanel=new JPanel();
        resourcePanel.setSize(1000,250);
        resourcePanel.setBackground(Color.BLACK);
        commandPanel=new JPanel();
        commandPanel.setSize(1000,250);
        commandPanel.setBackground(Color.RED);
        mainContent.setSize(1000,500);
        mainContent.setBackground(Color.BLUE);
        mainContent.add(resourcePanel);
        mainContent.add(commandPanel);
        this.setContentPane(mainContent);
        mainContent.addComponentListener(new ComponentAdapter() {
        });
    }

    public static void main (String[] args){
        JFrame frame = new InterfacciaGrafica();
        frame.setVisible(true);
    }
}
