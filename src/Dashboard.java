//Contact me on instagram : angerleo001
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JLabel img3, l4, l10;
    JMenuBar m1;
    JMenu mb1, mb2;
    JMenuItem mi1, mi2, mi3, ami1, ami2, ami3;

    Dashboard() {
        // Frame for Dashboard
        setTitle("Dashboard");
        //setLocationRelativeTo(null);
        setBounds(0, 0, 1366, 768);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Images
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Icons/landscape-Sun.jpg"));
        img3 = new JLabel(i5);
        img3.setBounds(0, 0, 1366, 768);
        add(img3);

        l10 = new JLabel("Welcome TO System");
        l10.setForeground(Color.CYAN);
        l10.setBounds(470,100,450,50);
        l10.setFont(new Font("Tahoma",Font.BOLD,40));
        img3.add(l10);


        // Labels
        l4 = new JLabel("Hotel Management System APS");
        l4.setBounds(15, 650, 300, 50);
        l4.setFont(new Font("Times New Roman", Font.BOLD, 15));
        l4.setForeground(Color.CYAN);
        img3.add(l4);

        //Menu Bar
        m1 = new JMenuBar();
        m1.setBounds(0,0,1366, 30);
        m1.setBackground(Color.WHITE);
        img3.add(m1);

        //Menu
        mb1 = new JMenu("HOTEL MANAGEMENT");
        mb1.setForeground((Color.RED));
        m1.add(mb1);

        mb2 = new JMenu("ADMIN");
        mb2.setForeground((Color.BLUE));
        m1.add(mb2);

        //Menu Items
        mi1 = new JMenuItem("Reception");
        mb1.add(mi1);

        ami1 = new JMenuItem("Add Employee");
        ami1.addActionListener(this);
        mb2.add(ami1);


        ami2 = new JMenuItem("Add Room");
        mb2.add(ami2);

        ami3 = new JMenuItem("Add Driver");
        mb2.add(ami3);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == ami1){
            setVisible(false);
            new AddEmp();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard l = new Dashboard();
            l.setVisible(true);
        });
    }
}