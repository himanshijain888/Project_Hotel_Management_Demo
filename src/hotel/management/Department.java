package hotel.management;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    public Department() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("SHOW DEPARTMENT DETAILS");
        setLayout(null);
        setBounds(300, 200, 1050, 600);

        JLabel t1 = new JLabel("Department");
        t1.setBounds(180, 10, 100, 20);
        add(t1);

        JLabel t2 = new JLabel("Budget");
        t2.setBounds(420, 10, 100, 20);
        add(t2);

        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
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
        new Department();
    }
}
