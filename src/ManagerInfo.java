import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;
public class ManagerInfo extends JFrame {
    Connection Connect = null;
    JTable table;
    JLabel lblNewLabel, lblJob, lblName, lblDepartment, l1, l2, l3, l4;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerInfo frame = new ManagerInfo();
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

    public ManagerInfo() throws SQLException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setVisible(true);
        setLayout(null);

        table = new JTable();
        table.setBounds(0, 34, 1200, 450);
        add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Connect c = new Connect();
                    String displayCustomersql = "select * from Employee where job = 'Manager'";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(350, 500, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        add(btnLoadData);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(510, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);

        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(50, 11, 46, 14);
        add(lblNewLabel);

        lblJob = new JLabel("Age");
        lblJob.setBounds(200, 11, 46, 14);
        add(lblJob);

        l3 = new JLabel("Email");
        l3.setBounds(790, 11, 46, 14);
        add(l3);

        lblName = new JLabel("Nagrita no");
        lblName.setBounds(330, 11, 86, 14);
        add(lblName);

        lblDepartment = new JLabel("Gender");
        lblDepartment.setBounds(475, 11, 86, 14);
        add(lblDepartment);

        l4 = new JLabel("Phone no");
        l4.setBounds(930, 11, 86, 14);
        add(l4);

        l2 = new JLabel("Job");
        l2.setBounds(656, 11, 86, 14);
        add(l2);

        l1 = new JLabel("Salary");
        l1.setBounds(1100, 11, 86, 14);
        add(l1);

    }
}