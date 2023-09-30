package hotel.management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        JLabel text = new JLabel("WELCOME  TO  TAJ  FATEH");
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        text.setBounds(200, 80, 1000, 50);
        image.add(text);

        JMenuBar ab = new JMenuBar();
        ab.setBounds(0, 0, 1550, 50);
        image.add(ab);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        hotel.setForeground(Color.MAGENTA);
        hotel.setSize(1500,500);
        ab.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setForeground(Color.MAGENTA);
        
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        admin.setForeground(Color.BLUE);

        ab.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.setForeground(Color.BLUE);
        
        admin.add(addemployee);

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.setForeground(Color.BLUE);
        
        admin.add(addrooms);

        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.setForeground(Color.BLUE);
        
        admin.add(adddrivers);

        setVisible(true);

        addemployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Addemployee();
                } catch (Exception e) {
                }
            }
        });

        addrooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddRooms();
                } catch (Exception e) {
                }
            }
        });

        adddrivers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Adddrivers();
                } catch (Exception e) {
                }
            }
        });

        reception.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Reception();
                } catch (Exception e) {
                }
            }
        });

    }

    public static void main(String[] ab) {
        new Dashboard();
    }
}
