package hotel.management;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.util.*;

public class Checkout extends JFrame implements ActionListener {

    Choice ccustomer;
    JLabel t1, t2, t3, t4, t5, t6, t7;
    JButton Next, Cancel;

    public Checkout() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("SHOW CHECKOUT DETAILS");
        setLayout(null);
        setBounds(400, 400, 1000, 600);

        JLabel Text = new JLabel("CHECKOUT DETAILS");
        Text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        Text.setForeground(Color.BLUE);
        Text.setBounds(100, 20, 250, 50);
        add(Text);

        JLabel t1 = new JLabel("Customer Id");
        t1.setBounds(30, 80, 150, 25);
        add(t1);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);
        setBounds(300, 200, 800, 400);
        setVisible(true);

        t2 = new JLabel("Room Number");
        t2.setBounds(30, 130, 100, 30);
        add(t2);

        t3 = new JLabel();
        t3.setBounds(200, 130, 100, 30);
        add(t3);

        t4 = new JLabel("Checkin Time");
        t4.setBounds(30, 180, 100, 30);
        add(t4);

        t5 = new JLabel();
        t5.setBounds(200, 180, 100, 30);
        add(t5);

        t6 = new JLabel("Checkout Time");
        t6.setBounds(30, 230, 100, 30);
        add(t6);

        Date date = new Date();
        t7 = new JLabel("" + date);
        t7.setBounds(200, 230, 150, 30);
        add(t7);

        Next = new JButton("CHECKOUT");
        Next.addActionListener(this);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(10, 330, 150, 30);

        add(Next);

        Cancel = new JButton("CANCEL");
        Cancel.addActionListener(this);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(180, 330, 150, 30);
        add(Cancel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
                t3.setText(rs.getString("allocation"));
                t5.setText(rs.getString("checkin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image img2 = img1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        img.setBounds(380, 60, 450, 370);
        add(img);
        setBounds(350, 200, 650, 540);
        setVisible(true);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Next) {
            String query1 = "delete from customer where no = '" + ccustomer.getSelectedItem() + "'";
            String query2 = "update room set availbility = 'Available' where roomno = '" + t3.getText() + "'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Checkout Done");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Cancel) {
            this.setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] ab) {
        new Checkout();
    }
}
