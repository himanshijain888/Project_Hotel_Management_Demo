package hotel.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Rooms() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("SHOW ROOMS DETAILS");
        setLayout(null);
        setBounds(300, 200, 1050, 600);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);

        JLabel t1 = new JLabel("Room Number");
        t1.setBounds(10, 10, 100, 20);
        add(t1);

        JLabel t2 = new JLabel("Availibility");
        t2.setBounds(120, 10, 100, 20);
        add(t2);

        JLabel t3 = new JLabel("Status");
        t3.setBounds(230, 10, 100, 20);
        add(t3);

        JLabel t4 = new JLabel("Price");
        t4.setBounds(330, 10, 100, 20);
        add(t4);
        JLabel t5 = new JLabel("Bed type");
        t5.setBounds(410, 10, 100, 20);
        add(t5);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 500, 120, 30);
        add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String ab[]) {
        new Rooms();
    }
}
