package hotel.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;

public class Searchroom extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    JComboBox cbbed;
    JCheckBox occuped;

    Searchroom() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("SHOW ROOMS DETAILS");
        setLayout(null);
        setBounds(300, 200, 1000, 600);

        JLabel Text = new JLabel("Search For Room");
        Text.setFont(new Font("Tahoma", Font.PLAIN, 22));

        Text.setBounds(400, 30, 200, 20);
        add(Text);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(50, 100, 100, 20);
        add(bed);

        String sta[] = {"Single", "double"};
        cbbed = new JComboBox(sta);
        cbbed.setBounds(150, 100, 150, 25);
        cbbed.setBackground(Color.WHITE);
        cbbed.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(cbbed);

        occuped = new JCheckBox("only display Avaliable");
        occuped.setBounds(650, 100, 180, 25);
        occuped.setBackground(Color.WHITE);
        occuped.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(occuped);

        JLabel t1 = new JLabel("Room Number");
        t1.setBounds(50, 160, 350, 20);
        add(t1);

        JLabel t2 = new JLabel("Availibility");
        t2.setBounds(270, 160, 100, 20);
        add(t2);

        JLabel t3 = new JLabel("Status");
        t3.setBounds(450, 160, 100, 20);
        add(t3);

        JLabel t4 = new JLabel("Price");
        t4.setBounds(670, 160, 100, 20);
        add(t4);
        JLabel t5 = new JLabel("Bed type");
        t5.setBounds(870, 160, 100, 20);
        add(t5);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        submit = new JButton("SUBMIT");
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150, 500, 120, 30);
        add(submit);
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(450, 500, 120, 30);
        add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        } else if (ae.getSource() == submit) {
            String query1 = "select * from room where bedtype = '" + cbbed.getSelectedItem() + "'";
            String query2 = "select * from room where availbility = 'Available'  AND   bedtype ='" + cbbed.getSelectedItem() + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                if (occuped.isSelected()) {
                    rs = c.s.executeQuery(query2);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String ab[]) {
        new Searchroom();
    }
}
