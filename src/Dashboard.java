import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    JLabel img3, l4;
    JMenuBar m1;

    Dashboard() {
        // Frame for Dashboard
        setTitle("Dashboard");
        setBounds(0, 0, 1026, 511);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Images
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Icons/landscape-Sun.jpg"));
        img3 = new JLabel(i5);
        img3.setBounds(0, 0, 1026 ,511);
        add(img3);

        // Labels
        l4 = new JLabel("Hotel Management System APS");
        l4.setBounds(15, 650, 300, 50);
        l4.setFont(new Font("Times New Roman", Font.BOLD, 15));
        l4.setForeground(Color.CYAN);
        img3.add(l4);

        //Menu Bar
        m1 = new JMenuBar();
        m1.setBounds(0,0,1026, 511);
        img3.add(m1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard l = new Dashboard();
            l.setVisible(true);
        });
    }
}
