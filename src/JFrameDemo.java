import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class JFrameDemo {
    JLabel jlab;

    public JFrameDemo() throws IOException {
        JFrame jfrm = new JFrame("An event example");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(250, 100);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create two battons
        JButton jbtnAlpha = new JButton("Alpha");
        JButton jbtnOmega = new JButton("Omega");
        //create listener
        jbtnAlpha.addActionListener((ActionEvent ae) -> {
            jlab.setText("Alpha was pressed.");
        });
        //create listener
        jbtnOmega.addActionListener((ActionEvent ae) -> {
            jlab.setText("Omega was pressed.");
        });
        
        //create image icon
        ImageIcon icon_canada = new ImageIcon("canada.png");
        JLabel label_canada = new JLabel("Canada", icon_canada, JLabel.CENTER);
        jfrm.add(label_canada);
        ImageIcon icon_france = new ImageIcon("france.png");
        JLabel label_france = new JLabel("France", icon_france, JLabel.CENTER);
        jfrm.add(label_france);
        ImageIcon icon_italy = new ImageIcon("italy.png");
        JLabel label_italy = new JLabel("Italy", icon_italy, JLabel.CENTER);
        jfrm.add(label_italy);
        ImageIcon icon_germany = new ImageIcon("germany.png");
        JLabel label_germany = new JLabel("Germany", icon_germany, JLabel.CENTER);
        jfrm.add(label_germany);
        ImageIcon icon_united_kingdom = new ImageIcon("united_kingdom.png");
        JLabel label_united_kingdom = new JLabel("United Kingdom", icon_united_kingdom, JLabel.CENTER);
        jfrm.add(label_united_kingdom);
        ImageIcon icon_united_states = new ImageIcon("united_states.png");
        JLabel label_united_states = new JLabel("United States", icon_united_states, JLabel.CENTER);
        jfrm.add(label_united_states);
        ImageIcon icon_japan = new ImageIcon("japan.png");
        JLabel label_japan = new JLabel("Japan", icon_japan, JLabel.CENTER);
        jfrm.add(label_japan);

        //add button on frame
        jfrm.add(jbtnAlpha);
        jfrm.add(jbtnOmega);
                        
        //create and add label
        jlab = new JLabel("Press a button.");
        jfrm.add(jlab);
        
        //show window
        jfrm.pack();
        jfrm.setVisible(true);
    }
}