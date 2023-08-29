import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class CheckOut extends JFrame{
    JTextField t1;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckOut frame = new CheckOut();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close(){
        this.dispose();
    }
    public CheckOut() throws SQLException {
        setSize(800, 294);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(300,0,500,225);
        add(l1);

        JLabel lblCheckOut = new JLabel("Check Out ");
        lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCheckOut.setBounds(70, 11, 140, 35);
        add(lblCheckOut);

        JLabel lblName = new JLabel("Number :");
        lblName.setBounds(20, 85, 80, 14);
        add(lblName);

        c1 = new Choice();
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){ }
        c1.setBounds(130, 82, 150, 20);
        add(c1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton l2 = new JButton(i6);
        l2.setBounds(290,82,20,20);
        add(l2);

        l2.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent ae){
                System.out.println("Hi");
                try{

                    Connect c = new Connect();
                    String number = c1.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from customer where number = "+number);

                    if(rs.next()){
                        System.out.println("clicked");
                        t1.setText(rs.getString("room_number"));
                    }
                }catch(Exception e){ }
            }
        });

        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setBounds(20, 132, 86, 20);
        add(lblRoomNumber);

        t1 = new JTextField();
        t1.setBounds(130, 132, 150, 20);
        add(t1);

        JButton btnCheckOut = new JButton("Check Out");
        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = c1.getSelectedItem();
                String s1 = t1.getText();
                String deleteSQL = "Delete from customer where number = "+id;
                String q2 = "update room set availability = 'Available' where room_number = "+s1;
                Connect c = new Connect();
                try{
                    c.s.executeUpdate(deleteSQL);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Check Out Successful");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
        btnCheckOut.setBounds(50, 200, 100, 25);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        add(btnCheckOut);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 200, 100, 25);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);
    }
}