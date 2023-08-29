import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class Employee extends JFrame {
    JTable table;
    JLabel lblNewLabel, lblJob, lblName,lblDepartment;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Employee frame = new Employee();
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

    public Employee() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 600);
        setVisible(true);

        table = new JTable();
        table.setBounds(0, 34, 1250, 450);
        add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Connect c = new Connect();
                    String displayCustomersql = "select * from Employee";
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

        lblName = new JLabel("Nagrita No");
        lblName.setBounds(350, 11, 86, 14);
        add(lblName);

        lblDepartment = new JLabel("Gender");
        lblDepartment.setBounds(500, 11, 86, 14);
        add(lblDepartment);

        JLabel l1 = new JLabel("Job");
        l1.setBounds(650, 11, 86, 14);
        add(l1);

        JLabel l2 = new JLabel("Email");
        l2.setBounds(800, 11, 86, 14);
        add(l2);

        JLabel l3 = new JLabel("Phone No");
        l3.setBounds(950, 11, 86, 14);
        add(l3);

        JLabel l4 = new JLabel("Salary");
        l4.setBounds(1100,11, 86,14);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(1400,11, 86,14);
        add(l5);
    }
}