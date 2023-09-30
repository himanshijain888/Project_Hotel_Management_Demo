package hotel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagement extends JFrame implements ActionListener {

    //constructor
    public HotelManagement() {
        //setSize(1366,565);
        //setLocation(100,100);
        setBounds(0, 0, 1366, 565);
     
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/view3.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(5,0,1280, 816);
        add(image);

        JLabel text = new JLabel(" WELCOME  TO  TAJ  FATEH");
        text.setBounds(90, 60, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 70));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(550, 700, 150, 50);
        next.setBackground(Color.BLACK);
       next.setBorderPainted(false);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);

        setVisible(true);

        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {

        new HotelManagement();
    }

}
