import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame {
    Connection Connect = null;
    JTable table;
    JLabel lblAvailability;
    JLabel lblCleanStatus;
    JLabel lblNewLabel;
    JLabel lblNewLabel_1;
    JLabel lblId;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Room frame = new Room();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Room() throws SQLException {

        setSize( 1100, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Icons/bed.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500,0,600,600);
        add(l1);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Connect c = new Connect();
                    String displayCustomersql = "select * from Room";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnLoadData.setBounds(100, 470, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        add(btnLoadData);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton.setBounds(290, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        add(btnNewButton);

        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(119, 15, 69, 14);
        add(lblAvailability);

        lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(216, 15, 76, 14);
        add(lblCleanStatus);

        lblNewLabel = new JLabel("Price");
        lblNewLabel.setBounds(330, 15, 46, 14);
        add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Bed Type");
        lblNewLabel_1.setBounds(417, 15, 76, 14);
        add(lblNewLabel_1);

        lblId = new JLabel("Room Number");
        lblId.setBounds(12, 15, 90, 14);
        add(lblId);

        getContentPane().setBackground(Color.WHITE);
    }

}