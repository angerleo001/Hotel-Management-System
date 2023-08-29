import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class NewCustomer extends JFrame {
    JTextField t1,t2,t3,t5,t6,t7;
    JComboBox comboBox;
    JRadioButton Rbm,Rbf,Rbo;
    JLabel phone;
    ButtonGroup Bg;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewCustomer frame = new NewCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public NewCustomer() throws SQLException {

        setSize(850, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480,10,300,500);
        add(l1);

        JLabel lblName = new JLabel("NEW CUSTOMER FORM");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 260, 53);
        add(lblName);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 76, 200, 14);
        add(lblId);

        comboBox = new JComboBox(new String[] {"Passport", "Nagrita No", "Voter Id", "Driving license"});
        comboBox.setBounds(271, 73, 150, 20);
        add(comboBox);

        JLabel l2 = new JLabel("Id Number :");
        l2.setBounds(35, 111, 200, 14);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        add(t1);
        t1.setColumns(10);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 151, 200, 14);
        add(lblName_1);

        t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
        add(t2);
        t2.setColumns(10);


        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 191, 200, 14);
        add(lblGender);

        //Radio Button
        Rbm = new JRadioButton("Male");
        Rbm.setBounds(230,191, 70,25);
        Rbm.setBackground(Color.CYAN);
        add(Rbm);

        Rbf = new JRadioButton("Female");
        Rbf.setBounds(310,191, 80,25);
        Rbf.setBackground(Color.PINK);
        add(Rbf);

        Rbo = new JRadioButton("Other");
        Rbo.setBounds(400,191, 80,25);
        Rbo.setBackground(Color.ORANGE);
        add(Rbo);

        Bg = new ButtonGroup();
        Bg.add(Rbm);
        Bg.add(Rbf);
        Bg.add(Rbo);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 231, 200, 14);
        add(lblCountry);

        t3 = new JTextField();
        t3.setBounds(271, 231, 150, 20);
        add(t3);
        t3.setColumns(10);

        JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
        lblReserveRoomNumber.setBounds(35, 274, 200, 14);
        add(lblReserveRoomNumber);

        c1 = new Choice();
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from room");
            while(rs.next()){
                c1.add(rs.getString("room_number"));
            }
        }catch(Exception e){ }
        c1.setBounds(271, 274, 150, 20);
        add(c1);

        phone = new JLabel("Phone No:");
        phone.setBounds(35,320, 160,14);
        add(phone);

        t5 = new JTextField();
        t5.setBounds(271, 320, 150, 20);
        add(t5);
        t5.setColumns(10);

        JLabel lblCheckInStatus = new JLabel("Checked-In :");
        lblCheckInStatus.setBounds(35, 360, 200, 14);
        add(lblCheckInStatus);

        t6 = new JTextField();
        t6.setBounds(271, 360, 150, 20);
        add(t6);
        t6.setColumns(10);

        JLabel lblDeposite = new JLabel("Deposit :");
        lblDeposite.setBounds(35, 400, 200, 14);
        add(lblDeposite);

        t7 = new JTextField();
        t7.setBounds(271, 400, 150, 20);
        add(t7);
        t7.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connect c = new Connect();

                String gr1 = null;
                if (Rbm.isSelected()) {
                    gr1 = "Male";
                } else if (Rbf.isSelected()) {
                    gr1 = "Female";
                } else if (Rbo.isSelected()) {
                    gr1 = "Other";
                }

                String s6 = c1.getSelectedItem();

                try{
                    String s1 = (String)comboBox.getSelectedItem();
                    String s2 =  t1.getText();
                    String s3 =  t2.getText();
                    String s9 =  gr1;
                    String s5 =  t3.getText();
                    String s7 =  t5.getText();
                    String s8 =  t6.getText();
                    String s10=  t7.getText();
                    String q1 = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s9+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s10+"')";
                    String q2 = "update room set availability = 'Occupied' where room_number = "+s6;
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
                catch(NumberFormatException s){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
        btnNewButton.setBounds(100, 450, 120, 30);
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setForeground(Color.BLACK);
        add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 450, 120, 30);
        btnExit.setBackground(Color.WHITE);
        btnExit.setForeground(Color.BLACK);
        add(btnExit);
    }
}