package hotel.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    JComboBox cbbed;
    JCheckBox occuped;
    Choice cartype;

    public Pickup() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("SHOW CAR DETAILS");
        setLayout(null);
        setBounds(300, 200, 1000, 600);

        JLabel Text = new JLabel("Search For Room");
        Text.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Text.setBounds(400, 30, 200, 20);
        add(Text);

        JLabel c1 = new JLabel("Car Model");
        c1.setBounds(40, 100, 100, 25);
        add(c1);

        cartype = new Choice();
        cartype.setBounds(150, 100, 100, 25);
        add(cartype);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {
                cartype.add(rs.getString("carmodel"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel t1 = new JLabel("Name");
        t1.setBounds(50, 160, 350, 20);
        add(t1);
        JLabel t2 = new JLabel("Age");
        t2.setBounds(160, 160, 100, 20);
        add(t2);

        JLabel t3 = new JLabel("Gender");
        t3.setBounds(300, 160, 100, 20);
        add(t3);

        JLabel t4 = new JLabel("Car Company");
        t4.setBounds(440, 160, 100, 20);
        add(t4);

        JLabel t5 = new JLabel("Car Model");
        t5.setBounds(590, 160, 100, 20);
        add(t5);
        JLabel t6 = new JLabel("Availbility");
        t6.setBounds(730, 160, 100, 20);
        add(t6);

        JLabel t7 = new JLabel("Location");
        t7.setBounds(890, 160, 100, 20);
        add(t7);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
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
            String query = "select * from driver where  carmodel = '" + cartype.getSelectedItem() + "' ";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] ab) {
        new Pickup();
    }
}
