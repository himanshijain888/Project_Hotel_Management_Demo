package hotel.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;

public class Customerinfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Customerinfo() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("SHOW Customer DETAILS");
        setLayout(null);
        setBounds(300, 200, 1050, 600);

        JLabel t1 = new JLabel("Document Type");
        t1.setBounds(10, 10, 100, 20);
        add(t1);

        JLabel t2 = new JLabel("Number");
        t2.setBounds(160, 10, 100, 20);
        add(t2);

        JLabel t3 = new JLabel("Name");
        t3.setBounds(290, 10, 100, 20);
        add(t3);

        JLabel t4 = new JLabel("gender");
        t4.setBounds(410, 10, 100, 20);
        add(t4);
        JLabel t5 = new JLabel("country");
        t5.setBounds(510, 10, 100, 20);
        add(t5);
        JLabel t6 = new JLabel("Room Number");
        t6.setBounds(640, 10, 100, 20);
        add(t6);
        JLabel t7 = new JLabel("Checkin Time");
        t7.setBounds(760, 10, 100, 20);
        add(t7);
        JLabel t8 = new JLabel("Deposit");
        t8.setBounds(900, 10, 100, 20);
        add(t8);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420, 500, 120, 30);
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
        new Customerinfo();
    }

}
