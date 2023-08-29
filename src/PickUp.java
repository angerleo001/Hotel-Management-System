import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame {
    ResultSet rs = null;
    private JTable table;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PickUp frame = new PickUp();
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

    public PickUp() throws SQLException {
        setBounds(530, 200, 800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblPickUpService = new JLabel("Pick Up Service");
        lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPickUpService.setBounds(90, 11, 158, 25);
        add(lblPickUpService);

        JLabel lblTypeOfCar = new JLabel("Type of Car");
        lblTypeOfCar.setBounds(32, 97, 89, 14);
        add(lblTypeOfCar);

        c1 = new Choice();
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("brand"));
            }
        }catch(Exception e){ }
        c1.setBounds(123, 94, 150, 25);
        add(c1);

        JLabel lblInfo = new JLabel("Name");
        lblInfo.setBounds(24, 208, 46, 14);
        add(lblInfo);

        JButton btnRegister = new JButton("Display");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String SQL = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
                try{
                    Connect c = new Connect();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (SQLException ss)
                {
                    ss.printStackTrace();
                }
            }
        });
        btnRegister.setBounds(200, 500, 120, 30);
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);
        add(btnRegister);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(420, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);

        table = new JTable();
        table.setBounds(0, 233, 800, 250);
        add(table);

        JLabel lblNewLabel = new JLabel("Age");
        lblNewLabel.setBounds(165, 208, 46, 14);
        add(lblNewLabel);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(264, 208, 46, 14);
        add(lblGender);

        JLabel lblTypeOfDriver = new JLabel("Company");
        lblTypeOfDriver.setBounds(366, 208, 80, 14);
        add(lblTypeOfDriver);

        JLabel lblDateOfThe = new JLabel("Brand");
        lblDateOfThe.setBounds(486, 208, 105, 14);
        add(lblDateOfThe);

        JLabel lblAirport = new JLabel("Available");
        lblAirport.setBounds(600, 208, 86, 14);
        add(lblAirport);

        JLabel lblAvailable = new JLabel("Location");
        lblAvailable.setBounds(700, 208, 73, 14);
        add(lblAvailable);
    }
}