import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    JLabel img3, l4;
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

        // Labels
        l4 = new JLabel("Hotel Management System APS");
        l4.setBounds(15, 650, 300, 50);
        l4.setFont(new Font("Times New Roman", Font.BOLD, 15));
        l4.setForeground(Color.BLUE);
        img3.add(l4);

        //Menu Bar
        m1 = new JMenuBar();
        m1.setBounds(0,0,1366, 30);
        img3.add(m1);

        //Menu
        mb1 = new JMenu("Hotel Management");
        mb1.setForeground((Color.CYAN));
        mb1.setBackground(Color.blue);
        m1.add(mb1);

        //Images
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/landscape-Sun.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard l = new Dashboard();
            l.setVisible(true);
        });
    }
}