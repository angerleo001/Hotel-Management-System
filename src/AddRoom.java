import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener{
    JTextField t2,t4;
    JComboBox comboBox, comboBox_2, comboBox_3;
    JButton b1,b2;
    JLabel img21, l2;
    JPanel contentPane;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }

    public AddRoom() {
        //Frame size and location
        setTitle("Add Rooms");
        //setLocationRelativeTo(null);//Center the frame on the screen
        setSize(1366, 768);
        contentPane = new JPanel();
        setContentPane(contentPane);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Icons/img1.png"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        img21 = new JLabel(i3);
        img21.setBounds(0, 0, 1366, 768);
        add(img21);

        ImageIcon i5  = new ImageIcon(ClassLoader.getSystemResource("Icons/bed.jpg"));
        JLabel l15 = new JLabel(i5);
        l15.setBounds(600,50,600,400);
        img21.add(l15);

        //Labels
        l2 = new JLabel("Hotel Management System APS");
        l2.setBounds(15,650,300,50);
        l2.setFont(new Font("Times New Roman", Font.BOLD,15));
        l2.setForeground(Color.CYAN);
        img21.add(l2);

        JLabel l10 = new JLabel("Add Rooms");
        l10.setForeground(new Color(12, 231, 140));
        l10.setFont(new Font("Tahoma", Font.BOLD, 35));
        l10.setBounds(250, 30, 200, 40);
        img21.add(l10);

        JLabel l1 = new JLabel("Room Number:");
        l1.setForeground(new Color(16, 205, 205));
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setBounds(190, 100, 200, 30);
        img21.add(l1);

        t4 = new JTextField();
        t4.setBounds(360, 100, 200, 30);
        t4.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img21.add(t4);

        JLabel l2 = new JLabel("Availability:");
        l2.setForeground(new Color(16, 205, 205));
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        l2.setBounds(190, 150, 200, 30);
        img21.add(l2);

        comboBox = new JComboBox(new String[] { "Available", "Occupied" });
        comboBox.setBounds(360, 150, 200, 30);
        comboBox.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img21.add(comboBox);

        JLabel l3 = new JLabel("Cleaning Status:");
        l3.setForeground(new Color(16, 205, 205));
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        l3.setBounds(190, 200, 200, 30);
        img21.add(l3);

        comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
        comboBox_2.setBounds(360, 200, 200, 30);
        comboBox_2.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img21.add(comboBox_2);

        JLabel l4 = new JLabel("Price:");
        l4.setForeground(new Color(16, 205, 205));
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        l4.setBounds(190, 250, 200, 30);
        img21.add(l4);

        t2 = new JTextField();
        t2.setBounds(360, 250, 200, 30);
        t2.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img21.add(t2);

        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(new Color(16, 205, 205));
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        l5.setBounds(190, 300, 200, 30);
        img21.add(l5);

        comboBox_3 = new JComboBox(new String[] { "Single Bed","Double Bed"});
        comboBox_3.setBounds(360, 300, 200, 30);
        comboBox_3.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img21.add(comboBox_3);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(300, 400, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img21.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(450, 400, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img21.add(b2);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == b1){
                try{
                    Connect c = new Connect();
                    String room = t4.getText();
                    String available = (String)comboBox.getSelectedItem();
                    String status = (String)comboBox_2.getSelectedItem();
                    String price  = t2.getText();
                    String type = (String)comboBox_3.getSelectedItem();
                    String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    this.setVisible(false);
                    new Dashboard();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
                new Dashboard();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
