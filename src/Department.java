import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class Department extends JFrame {
    JTable table;
    JLabel lblNewLabel;
    JLabel lblNewLabel_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Department frame = new Department();
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

    public Department() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        table = new JTable();
        table.setBounds(0, 40, 700, 350);
        add(table);

        JButton btnNewButton = new JButton("Load Data");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Connect c = new Connect();

                    String displayCustomersql = "select * from Department";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(170, 410, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton_1.setBounds(400, 410, 120, 30);
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);
        add(btnNewButton_1);

        lblNewLabel = new JLabel("Department");
        lblNewLabel.setBounds(145, 11, 105, 14);
        add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Budget");
        lblNewLabel_1.setBounds(431, 11, 75, 14);
        add(lblNewLabel_1);
    }

}