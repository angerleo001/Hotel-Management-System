//Contact me on instagram : angerleo001

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmp extends JFrame implements ActionListener {
    JLabel l20, img10, img11, nme, age, gdr, job, salary, mail, phone;
    JTextField Txt1, Txt2, Txt3, Txt4, Txt5, Txt6;
    JRadioButton Rbm, Rbf, Rbo;
    JButton nxt;
    AddEmp(){
        //Frame size and location
        setTitle("Employee Addition");
        setLocationRelativeTo(null);//Center the frame on the screen
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

        gdr = new JLabel("Gender:");
        gdr.setForeground(Color.WHITE);
        gdr.setBounds(110,125, 120,35);
        gdr.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(gdr);

        job = new JLabel("Job:");
        job.setForeground(Color.WHITE);
        job.setBounds(110,160, 120,35);
        job.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(job);

        mail = new JLabel("Email:");
        mail.setForeground(Color.WHITE);
        mail.setBounds(110,195, 120,35);
        mail.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(mail);

        phone = new JLabel("Phone No:");
        phone.setForeground(Color.WHITE);
        phone.setBounds(110,230, 150,35);
        phone.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(phone);

        salary = new JLabel("Salary:");
        salary.setForeground(Color.WHITE);
        salary.setBounds(110,270, 120,35);
        salary.setFont(new Font("Tahoma",Font.PLAIN,30));
        img11.add(salary);

        //Text Fields
        Txt1 = new JTextField();
        Txt1.setBounds(230, 45, 200,30);
        Txt1.setFont(new Font("New Times Roman", Font.PLAIN,20));
        img11.add(Txt1);

        Txt2 = new JTextField();
        Txt2.setBounds(230, 85, 200,30);
        Txt2.setFont(new Font("New Times Roman", Font.PLAIN,20));
        img11.add(Txt2);

        Txt4 = new JTextField();
        Txt4.setBounds(230, 195, 250,30);
        Txt4.setFont(new Font("New Times Roman", Font.PLAIN,20));
        img11.add(Txt4);

        Txt5 = new JTextField();
        Txt5.setBounds(255, 232, 225,30);
        Txt5.setFont(new Font("New Times Roman", Font.PLAIN,20));
        img11.add(Txt5);

        Txt6 = new JTextField();
        Txt6.setBounds(230, 270, 250,30);
        Txt6.setFont(new Font("New Times Roman", Font.PLAIN,20));
        img11.add(Txt6);

        /*Txt3 = new JTextField();
        Txt3.setBounds(220, 145, 200,30);
        Txt3.setFont(new Font("New Times Roman", Font.PLAIN,20));
        img11.add(Txt3);*/

        //Combo box
        String list[] = {"Front Desk","Porter","Cleaner","Manager","Chef","Room Service","Waiter/Waitress","House Keeping","Kitchen Staff","Accountant"};
        JComboBox jbc = new JComboBox(list);
        jbc.setBounds(230, 160, 150,30);
        jbc.setBackground(Color.WHITE);
        img11.add(jbc);

        //Radio Button
        Rbm = new JRadioButton("Male");
        Rbm.setBounds(230,125, 70,30);
        Rbm.setBackground(Color.CYAN);
        img11.add(Rbm);

        Rbf = new JRadioButton("Female");
        Rbf.setBounds(310,125, 80,30);
        Rbf.setBackground(Color.PINK);
        img11.add(Rbf);

        Rbo = new JRadioButton("Other");
        Rbo.setBounds(400,125, 80,30);
        Rbo.setBackground(Color.ORANGE);
        img11.add(Rbo);

        //Next button
        nxt = new JButton("Next");
        nxt.setBounds(550, 400, 150, 30);
        nxt.setBackground(Color.BLACK);
        nxt.setForeground(Color.WHITE);
        nxt.addActionListener(this);
        img11.add(nxt);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == nxt){

        }
    }
    public static void main(String[] args){
        new AddEmp();
    }
}