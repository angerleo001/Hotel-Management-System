import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4, t5;
    JComboBox comboBox_1;
    JButton b1,b2;
    JLabel l10, l2, l3, l1, l7;
    JRadioButton Rbm, Rbf, Rbo;
    ButtonGroup Bg;
    public AddDriver() {
        setSize(1000,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Icons/eleven.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,30,500,370);
        add(l15);

        l10 = new JLabel("Add Drivers");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(194, 10, 120, 22);
        l10.setForeground(Color.WHITE);
        add(l10);

        l1 = new JLabel("Name");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 102, 22);
        l1.setForeground(Color.WHITE);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(174, 70, 156, 20);
        add(t1);


        l2 = new JLabel("Age");
        l2.setForeground(Color.WHITE);;
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 102, 22);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(174, 110, 156, 20);
        add(t2);

        l3 = new JLabel("Gender");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 102, 22);
        add(l3);

        //Radio Button
        Rbm = new JRadioButton("Male");
        Rbm.setBounds(145, 150, 80, 20);
        Rbm.setBackground(Color.CYAN);
        add(Rbm);

        Rbf = new JRadioButton("Female");
        Rbf.setBounds(230,150, 80,20);
        Rbf.setBackground(Color.PINK);
        add(Rbf);

        Rbo = new JRadioButton("Other");
        Rbo.setBounds(315,150, 80,20);
        Rbo.setBackground(Color.ORANGE);
        add(Rbo);

        Bg = new ButtonGroup();
        Bg.add(Rbm);
        Bg.add(Rbf);
        Bg.add(Rbo);

        JLabel l4 = new JLabel("Car Company");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 190, 102, 22);
        add(l4);

        t3 = new JTextField();
        t3.setBounds(174, 190, 156, 20);
        add(t3);

        JLabel l5 = new JLabel("Car Brand");
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 102, 22);
        add(l5);

        t4 = new JTextField();
        t4.setBounds(174, 230, 156, 20);
        add(t4);

        JLabel l6 = new JLabel("Available");
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(64, 270, 102, 22);
        add(l6);

        comboBox_1 = new JComboBox(new String[] { "Yes", "No" });
        comboBox_1.setBounds(176, 270, 154, 20);
        add(comboBox_1);

        l7 = new JLabel("Location");
        l7.setForeground(Color.WHITE);
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(64, 310, 102, 22);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(174, 310, 156, 20);
        add(t5);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64, 380, 111, 33);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(198, 380, 111, 33);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        add(b2);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == b1){
                try{
                    Connect c = new Connect();
                    String name = t1.getText();
                    String age = t2.getText();

                    String gr1 = null;
                    if (Rbm.isSelected()) {
                        gr1 = "Male";
                    } else if (Rbf.isSelected()) {
                        gr1 = "Female";
                    } else if (Rbo.isSelected()) {
                        gr1 = "Other";
                    }
                    String company  = t3.getText();
                    String brand = t4.getText();
                    String available = (String)comboBox_1.getSelectedItem();
                    String location = t5.getText();
                    String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gr1+"','"+company+"', '"+brand+"', '"+available+"','"+location+"')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    this.setVisible(false);
                    new Dashboard();

                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
                new Dashboard();
            }
        }catch(Exception eee){
            eee.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }
}