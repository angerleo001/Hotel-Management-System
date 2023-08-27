import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    JLabel img3, l4, l10;
    JMenuBar m1;
    JMenu mb1;

    Dashboard() {
        // Frame for Dashboard
        setTitle("Dashboard");
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
        l4.setForeground(Color.BLACK);
        img3.add(l4);

        //Menu Bar
        m1 = new JMenuBar();
        m1.setBounds(0,0,1366, 30);
        m1.setBackground(Color.GREEN);
        m1.setForeground(Color.GREEN);
        img3.add(m1);

        //Menu
        mb1 = new JMenu("Hotel Management");
        mb1.setForeground((Color.BLACK));
        m1.add(mb1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard l = new Dashboard();
            l.setVisible(true);
        });
    }
}