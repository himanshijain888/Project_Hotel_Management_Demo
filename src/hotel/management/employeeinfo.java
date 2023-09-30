package hotel.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;

public class employeeinfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    employeeinfo() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("SHOW ALL EMPLOYEE DETAILS");
        setLayout(null);
        setBounds(300, 200, 1050, 600);

        JLabel t1 = new JLabel("Name");
        t1.setBounds(10, 10, 100, 20);
        add(t1);

        JLabel t2 = new JLabel("age");
        t2.setBounds(140, 10, 100, 20);
        add(t2);

        JLabel t3 = new JLabel("gender");
        t3.setBounds(250, 10, 100, 20);
        add(t3);

        JLabel t4 = new JLabel("job");
        t4.setBounds(390, 10, 100, 20);
        add(t4);
        JLabel t5 = new JLabel("salary");
        t5.setBounds(550, 10, 100, 20);
        add(t5);
        JLabel t6 = new JLabel("phone");
        t6.setBounds(670, 10, 100, 20);
        add(t6);
        JLabel t7 = new JLabel("email");
        t7.setBounds(800, 10, 100, 20);
        add(t7);
        JLabel t8 = new JLabel("aadhar");
        t8.setBounds(900, 10, 100, 20);
        add(t8);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
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
        new employeeinfo();
    }
}
