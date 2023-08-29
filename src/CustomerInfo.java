import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class CustomerInfo extends JFrame {
    Connection Connect = null;
    JLabel lblId;
    JLabel lblNewLabel;
    JLabel lblGender;
    JTable table;
    JLabel lblCountry;
    JLabel lblRoom;
    JLabel lblStatus;
    JLabel lblNewLabel_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerInfo frame = new CustomerInfo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close()
    {
        this.dispose();
    }
    public CustomerInfo() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(450, 510, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Connect c  = new Connect();

                    String displayCustomersql = "select * from Customer";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }


        });
        btnLoadData.setBounds(300, 510, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        add(btnLoadData);

        lblId = new JLabel("ID");
        lblId.setBounds(31, 11, 46, 14);
        add(lblId);

        JLabel l1 = new JLabel("Number");
        l1.setBounds(110, 11, 46, 14);
        add(l1);

        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(230, 11, 65, 14);
        add(lblNewLabel);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(320, 11, 46, 14);
        add(lblGender);

        table = new JTable();
        table.setBounds(0, 40, 900, 450);
        add(table);

        lblCountry = new JLabel("Country");
        lblCountry.setBounds(430, 11, 46, 14);
        add(lblCountry);

        lblRoom = new JLabel("Room no");
        lblRoom.setBounds(510, 11, 60, 14);
        add(lblRoom);

        lblRoom = new JLabel("Phone no");
        lblRoom.setBounds(620, 11, 60, 14);
        add(lblRoom);

        lblStatus = new JLabel("Check-in");
        lblStatus.setBounds(720, 11, 100, 14);
        add(lblStatus);

        lblNewLabel_1 = new JLabel("Deposit");
        lblNewLabel_1.setBounds(825, 11, 100, 14);
        add(lblNewLabel_1);
    }
}