//Contact me on instagram : angerleo001

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmp extends JFrame implements ActionListener {
    JLabel l20, img10, img11, nme, age, gdr, job, salary, mail, phone, nagr;
    JTextField Txtn, Txta, Txt3, Txtm, Txtp, Txts, nag;
    JRadioButton Rbm, Rbf, Rbo;
    JButton nxt;
    ButtonGroup Bg;
    JComboBox jbc;
    AddEmp(){
        //Frame size and location
        setTitle("Employee Addition");
        //setLocationRelativeTo(null);//Center the frame on the screen
        setSize(1366, 768);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //Icons and Images
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Icons/lock.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        img10 = new JLabel(i3);
        img10.setBounds(0, 0, 1366, 768);
        add(img10);

        ImageIcon i5  = new ImageIcon(ClassLoader.getSystemResource("Icons/img1.png"));
        //Image i6 = i5.getImage().getScaledInstance(1366, 768,Image.SCALE_DEFAULT);
        //ImageIcon i7 = new ImageIcon(i6);
        img11 = new JLabel(i5);
        img11.setBounds(300,100,742,448);
        img10.add(img11);

        //Labels
        l20 = new JLabel("Hotel Management System APS");
        l20.setBounds(15,650,300,50);
        l20.setFont(new Font("Times New Roman", Font.BOLD,15));
        l20.setForeground(Color.CYAN);
        img10.add(l20);

        nme = new JLabel("Name:");
        nme.setForeground(Color.WHITE);
        nme.setBounds(110,45, 120,35);
        nme.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(nme);

        age = new JLabel("Age:");
        age.setForeground(Color.WHITE);
        age.setBounds(110,85, 120,35);
        age.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(age);

        nagr = new JLabel("Nagrita No:");
        nagr.setForeground(Color.WHITE);
        nagr.setBounds(110,125,300,35);
        nagr.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(nagr);

        gdr = new JLabel("Gender:");
        gdr.setForeground(Color.WHITE);
        gdr.setBounds(110,160, 120,35);
        gdr.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(gdr);

        job = new JLabel("Job:");
        job.setForeground(Color.WHITE);
        job.setBounds(110,195, 120,35);
        job.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(job);

        mail = new JLabel("Email:");
        mail.setForeground(Color.WHITE);
        mail.setBounds(110,230, 120,35);
        mail.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(mail);

        phone = new JLabel("Phone No:");
        phone.setForeground(Color.WHITE);
        phone.setBounds(110,265, 160,35);
        phone.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(phone);

        salary = new JLabel("Salary:");
        salary.setForeground(Color.WHITE);
        salary.setBounds(110,300, 120,35);
        salary.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(salary);

        //Text Fields
        Txtn = new JTextField();
        Txtn.setBounds(230, 48, 250,25);
        Txtn.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img11.add(Txtn);

        Txta = new JTextField();
        Txta.setBounds(230, 88, 250,25);
        Txta.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img11.add(Txta);

        nag = new JTextField();
        nag.setBounds(270, 128, 250,25);
        nag.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img11.add(nag);

        Txtm = new JTextField();
        Txtm.setBounds(230, 234, 260,25);
        Txtm.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img11.add(Txtm);

        Txtp = new JTextField();
        Txtp.setBounds(255, 268, 225,25);
        Txtp.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img11.add(Txtp);

        Txts = new JTextField();
        Txts.setBounds(230, 304, 250,25);
        Txts.setFont(new Font("New Times Roman", Font.PLAIN,15));
        img11.add(Txts);

        /*Txt3 = new JTextField();
        Txt3.setBounds(220, 145, 200,30);
        Txt3.setFont(new Font("New Times Roman", Font.PLAIN,20));
        img11.add(Txt3);*/

        //Combo box
        String list[] = {"Front Desk Clerk","Porter","Cleaner","Manager","Chef","Room Service","Waiter/Waitress","House Keeping","Kitchen Staff","Accountant"};
        jbc = new JComboBox(list);
        jbc.setBounds(230, 195, 150,30);
        jbc.setBackground(Color.WHITE);
        img11.add(jbc);

        //Radio Button
        Rbm = new JRadioButton("Male");
        Rbm.setBounds(230,160, 70,30);
        Rbm.setBackground(Color.CYAN);
        img11.add(Rbm);

        Rbf = new JRadioButton("Female");
        Rbf.setBounds(310,160, 80,30);
        Rbf.setBackground(Color.PINK);
        img11.add(Rbf);

        Rbo = new JRadioButton("Other");
        Rbo.setBounds(400,160, 80,30);
        Rbo.setBackground(Color.ORANGE);
        img11.add(Rbo);

        Bg = new ButtonGroup();
        Bg.add(Rbm);
        Bg.add(Rbf);
        Bg.add(Rbo);

        //Next button
        nxt = new JButton("Submit");
        nxt.setBounds(550, 400, 150, 30);
        nxt.setBackground(Color.BLACK);
        nxt.setForeground(Color.WHITE);
        nxt.addActionListener(this);
        img11.add(nxt);
    }
    public void actionPerformed(ActionEvent ae) {
        String nm1 = Txtn.getText();
        String ag1 = Txta.getText();
        String na1 = nag.getText();
        String em1 = Txtm.getText();
        String pn1 = Txtp.getText();
        String sy1 = Txts.getText();
        String gr1 = null;
        if (Rbm.isSelected()) {
            gr1 = "Male";
        } else if (Rbf.isSelected()) {
            gr1 = "Female";
        } else if (Rbo.isSelected()) {
            gr1 = "Other";
        }
        String jo1 = (String) jbc.getSelectedItem();

        if (nm1.equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Name");
            return;
        } else if (ag1.equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Age");
            return;
        } else if (na1.equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Nagrita number");
            return;
        } else if (gr1.equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Gender");
            return;
        } else if (jo1.equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Job");
            return;
        } else if (em1.equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Email");
            return;
        } else if (pn1.equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Phone number");
            return;
        } else if (sy1.equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Salary");
            return;
        }

        try {
            Connect c = new Connect();
            String query = "insert into employee values('"+ nm1 +"','"+ ag1 +"','"+ na1 +"','"+ gr1 +"','"+ jo1 +"','"+ em1 +"','"+ pn1 +"','"+ sy1 +"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"New entry recorded to the system");
            setVisible(false);
            new Dashboard();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new AddEmp();
    }
}