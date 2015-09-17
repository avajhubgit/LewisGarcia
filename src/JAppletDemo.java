import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import javax.swing.tree.DefaultMutableTreeNode;

public class JAppletDemo extends JApplet implements ItemListener, ActionListener {
    JLabel jlab;
    
    @Override
    public void init(){
        try{
            SwingUtilities.invokeAndWait(this::makeGUI);
        }catch(InterruptedException | InvocationTargetException exc){
            System.out.println("Can't create because of " + exc);
        }
    }
        
    public void makeGUI(){
        setLayout(new FlowLayout());
        //create text field
        JTextField jtf = new JTextField(15);
        //ceate toogle button
        JToggleButton jtbn = new JToggleButton("On/Off");
        
        //create tabbed pane
        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Seasons", new SeasonPanel(this));
        jtp.addTab("Countries", new CountryPanel(this));
        jtp.addTab("Cities", new CitiesPanel(this));
        //create two battons
        JButton jbtnAlpha = new JButton("Alpha");
        JButton jbtnOmega = new JButton("Omega");
        //create a table
        String[] colHeads = {"Name", "Salary", "ID#"};
        Object[][] data = {
            {"Ann", "10000", "76589"},
            {"John", "25000", "32452"},
            {"Oliver", "30500", "74567"},
            {"Bill", "10000", "97589"},
            {"Richard", "30500", "54688"},
            {"Olivia", "15000", "29786"},
            {"Jane", "10500", "83478"},
            {"Mary", "25000", "90164"},
            {"Peter", "15000", "34874"},
            {"Ron", "30000", "24679"},
            {"Jimm", "15000", "68708"},
        };
        JTable table = new JTable(data, colHeads);
        JScrollPane jsp = new JScrollPane(table);
        add(jsp);
        //create tree
        JTree tree;
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Earth");
        
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("Europe");
        top.add(a);
        DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("France");
        a.add(a1);
        DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("Italy");
        a.add(a2);
        DefaultMutableTreeNode a3 = new DefaultMutableTreeNode("Germany");
        a.add(a3);
        
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("North America");
        top.add(b);
        DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("USA");
        b.add(b1);
        DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("Canada");
        b.add(b2);
        DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("Mexica");
        b.add(b3);

        DefaultMutableTreeNode c = new DefaultMutableTreeNode("Asia");
        top.add(c);
        DefaultMutableTreeNode c1 = new DefaultMutableTreeNode("China");
        c.add(c1);
        DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("India");
        c.add(c2);
        DefaultMutableTreeNode c3 = new DefaultMutableTreeNode("Japan");
        c.add(c3);

        DefaultMutableTreeNode d = new DefaultMutableTreeNode("South America");
        top.add(d);
        DefaultMutableTreeNode d1 = new DefaultMutableTreeNode("Brazil");
        d.add(d1);
        DefaultMutableTreeNode d2 = new DefaultMutableTreeNode("Chile");
        d.add(d2);
        DefaultMutableTreeNode d3 = new DefaultMutableTreeNode("Argentina");
        d.add(d3);

        DefaultMutableTreeNode e = new DefaultMutableTreeNode("Africa");
        top.add(e);
        DefaultMutableTreeNode e1 = new DefaultMutableTreeNode("Tunis");
        e.add(e1);
        DefaultMutableTreeNode e2 = new DefaultMutableTreeNode("Kongo");
        e.add(e2);
        DefaultMutableTreeNode e3 = new DefaultMutableTreeNode("Egypt");
        e.add(e3);
        
        DefaultMutableTreeNode f = new DefaultMutableTreeNode("Oceania");
        top.add(f);
        DefaultMutableTreeNode f1 = new DefaultMutableTreeNode("Australia");
        f.add(f1);
        DefaultMutableTreeNode f2 = new DefaultMutableTreeNode("New zelland");
        f.add(f2);
        
        tree = new JTree(top);
        JScrollPane jsp2 = new JScrollPane(tree);
        add(jsp);
        tree.addTreeSelectionListener(new TreeSelectionListener(){
            public void valueChanged(TreeSelectionEvent tse){
                jlab.setText("Selection on tree is " + tse.getPath());
            }
        });
        
        //create listener
        jtf.addActionListener((ActionEvent ae) -> {
            jlab.setText(jtf.getText());
        });
        jtbn.addItemListener((ItemEvent ae) -> {
            if(jtbn.isSelected()){
                jlab.setText("Toogle button is on");
            }
            else{
                jlab.setText("Toogle button is off");
            }
            showStatus(jtf.getText());
        });
        jbtnAlpha.addActionListener((ActionEvent ae) -> {
            jlab.setText("Alpha was pressed");
        });
        jbtnOmega.addActionListener((ActionEvent ae) -> {
            jlab.setText("Omega was pressed");
        });
      
        //add component on frame
        add(jtf);
        add(jtbn);
        add(jtp);
        add(jbtnAlpha);
        add(jbtnOmega);
        
        //create and add label
        jlab = new JLabel("Press a button");
        add(jlab, BorderLayout.SOUTH);
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie){
        JCheckBox cb = (JCheckBox)ie.getItem();
        if (cb.isSelected()) {
            jlab.setText(cb.getText() + " is selected");
        }
        else{
            jlab.setText(cb.getText() + " is cleared");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        jlab.setText("You selected " + ae.getActionCommand());
    }
    
    //seasons of year
    class SeasonPanel extends JPanel{
        public SeasonPanel(ActionListener al){
            //create radio buttons
            JRadioButton rb1 = new JRadioButton("winter");
            rb1.addActionListener(al);
            add(rb1);
            JRadioButton rb2 = new JRadioButton("spring");
            rb2.addActionListener(al);
            add(rb2);
            JRadioButton rb3 = new JRadioButton("summer");
            rb3.addActionListener(al);
            add(rb3);
            JRadioButton rb4 = new JRadioButton("autumn");
            rb4.addActionListener(al);
            add(rb4);
            ButtonGroup bg = new ButtonGroup();
            bg.add(rb1);
            bg.add(rb2);
            bg.add(rb3);
            bg.add(rb4);
        }
    }
    
    //countries
    class CountryPanel extends JPanel{
        public CountryPanel(ItemListener il){
            //create checkbox
            JCheckBox cb = new JCheckBox("USA");
            cb.addItemListener(il);
            add(cb);
            cb = new JCheckBox("Cananda");
            cb.addItemListener(il);
            add(cb);
            cb = new JCheckBox("France");
            cb.addItemListener(il);
            add(cb);
            cb = new JCheckBox("Italy");
            cb.addItemListener(il);
            add(cb);
            cb = new JCheckBox("Germany");
            cb.addItemListener(il);
            add(cb);
            cb = new JCheckBox("United Kingdom");
            cb.addItemListener(il);
            add(cb);
            cb = new JCheckBox("Japan15");
            cb.addItemListener(il);
            add(cb);
        }
    }

    //cities
    class CitiesPanel extends JPanel{
        public CitiesPanel(ActionListener al){
            //create array of cities
            String Cities[] = {
              "New York", "Washington", "Boston", "San Jose",
              "Seattle", "Denver", "Los Angeles", "Houston",
              "Chicago"
            };
            //create list of cities
            JList<String> jlst = new JList<>(Cities);
            jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane jscrlp = new JScrollPane(jlst);
            jscrlp.setPreferredSize(new Dimension(120, 90));
            add(jscrlp);
            jlst.addListSelectionListener((ListSelectionEvent le) -> {
                //get selected index
                int idx = jlst.getSelectedIndex();
                //if anyone choose
                if(idx != -1 ){
                    jlab.setText("Current selection city: " + Cities[idx]);
                }
                else{
                    jlab.setText("Choose a city");
                }
            });

            //create combobox
            JComboBox<String> jcb = new JComboBox<>(Cities);
            add(jcb);
            jcb.addActionListener((ActionEvent ae) -> {
            	jlab.setText("Current selection city: " + (String)jcb.getSelectedItem());
            });
        }
    }
}