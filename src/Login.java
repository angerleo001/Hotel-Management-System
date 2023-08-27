import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3, img1, img2, usr, pass;
    JTextField usrn;
    JPasswordField passw;
    JButton b1, b2, b3;
    public Login(){
        //Frame size and location
        setTitle("Hotel Name");
        setLocationRelativeTo(null);//Center the frame on the screen
        setSize(1366, 768);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //Icons and Images
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Icons/lock.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        img1 = new JLabel(i3);
        img1.setBounds(0, 0, 1366, 768);
        add(img1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/landscape-Sun.jpg"));
        img2 = new JLabel(i4);
        img2.setBounds(500,90,350,491);
        img1.add(img2);

        //Labels
        l2 = new JLabel("Hotel Management System APS");
        l2.setBounds(15,650,300,50);
        l2.setFont(new Font("Times New Roman", Font.BOLD,15));
        l2.setForeground(Color.CYAN);
        img1.add(l2);

        l1 = new JLabel("Login TO System");
        l1.setForeground(Color.BLACK);
        l1.setBounds(65,50,350,50);
        l1.setFont(new Font("Osward",Font.BOLD,20));
        img2.add(l1);

        //Username label
        usr = new JLabel("User Name:");
        usr.setForeground(Color.WHITE);
        usr.setFont(new Font("Raleway", Font.BOLD, 17));
        usr.setBounds(11, 155, 200, 40);
        img2.add(usr);

        //Username text field
        usrn = new JTextField();
        usrn.setForeground(Color.BLACK);
        usrn.setBounds(125, 155, 200, 30);
        usrn.setFont(new Font("Arial", Font.BOLD, 15));
        img2.add(usrn);

        //Password label
        pass = new JLabel("Password:");
        pass.setForeground(Color.WHITE);
        pass.setFont(new Font("Raleway", Font.BOLD, 17));
        pass.setBounds(11, 205, 200, 40);
        img2.add(pass);
        //Password field
        passw = new JPasswordField();
        passw.setBounds(120, 205, 205, 30);
        passw.setFont(new Font("Arial", Font.BOLD, 15));
        img2.add(passw);

        //Login button
        b1 = new JButton("Login");
        b1.setBounds(110, 250, 90, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        img2.add(b1);

        //Clear Button
        b2 = new JButton("Clear");
        b2.setBounds(230, 250, 90, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        img2.add(b2);

        //Close button
        b3 = new JButton("Forgot Password");
        b3.setBounds(120, 290, 190, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        img2.add(b3);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            usrn.setText("");
            passw.setText("");
        } else if (ae.getSource() == b3) {
            JOptionPane.showMessageDialog(null, "Contact APS To Recover Password");
            System.exit(0);
        } else if (ae.getSource() == b1) {
            setVisible(false);// This will hide the login frame
            // Implement login logic here
            new Dashboard();

        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Login l = new Login();
            l.setVisible(true);
        });}
}
