package hotel.management;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Updatecheck extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfname, tfcheck, tfamountpaid, tfpending;
    JButton Update, Next, Cancel;

    Updatecheck() {
        setLayout(null);
        JLabel text = new JLabel("Update Status");
        text.setBounds(90, 20, 200, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 17));
        text.setForeground(Color.BLUE);
        add(text);
        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 17));

        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblroomnumber = new JLabel("Room Number");
        lblroomnumber.setBounds(30, 120, 180, 30);
        lblroomnumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblroomnumber);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 30);
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 100, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 170, 150, 30);
        add(tfname);

        JLabel lblcheckintime = new JLabel("Check-in-time");
        lblcheckintime.setBounds(30, 220, 180, 25);
        lblcheckintime.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblcheckintime);

        tfcheck = new JTextField();
        tfcheck.setBounds(200, 220, 150, 30);
        add(tfcheck);

        JLabel lblamountpaid = new JLabel("Amount Paid");
        lblamountpaid.setBounds(30, 270, 180, 25);
        lblamountpaid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblamountpaid);

        tfamountpaid = new JTextField();
        tfamountpaid.setBounds(200, 270, 150, 30);
        add(tfamountpaid);

        JLabel lblpendingpaid = new JLabel("Pending Amount");
        lblpendingpaid.setBounds(30, 320, 180, 25);
        lblpendingpaid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblpendingpaid);

        tfpending = new JTextField();
        tfpending.setBounds(200, 320, 150, 30);
        add(tfpending);

        Next = new JButton("Check");
        Next.addActionListener(this);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(10, 380, 150, 30);

        add(Next);

        Cancel = new JButton("Back");
        Cancel.addActionListener(this);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(180, 380, 150, 30);
        add(Cancel);

        Update = new JButton("Update");
        Update.addActionListener(this);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        Update.setBounds(350, 380, 150, 30);
        add(Update);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 370);
        add(image);

        setBounds(200, 200, 900, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Next) {
            String id = ccustomer.getSelectedItem();
            String str = "select * from customer where number = '" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(str);
                while (rs.next()) {
                    tfroom.setText(rs.getString("allocation"));
                    tfname.setText(rs.getString("name"));
                    tfcheck.setText(rs.getString("checkin"));
                    tfamountpaid.setText(rs.getString("deposit"));
                }
                ResultSet rs1 = c.s.executeQuery("select * from room where roomno = '" + tfroom.getText() + "'");
                while (rs1.next()) {
                    String price = rs1.getString("price");
                    int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfamountpaid.getText());
                    tfpending.setText("" + amountpaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Update) {
            String number = ccustomer.getSelectedItem();
            // String room = tfroom.getText();
            String name = tfname.getText();
            String check = tfcheck.getText();
            String amountpaid = tfamountpaid.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set number = '" + number + "' ,name = '" + name + "',checkin = '" + check + "' ,deposit = '" + amountpaid + "'");
                JOptionPane.showMessageDialog(null, "Customer Updated");
                this.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Cancel) {
            this.setVisible(false);
            new Reception();
        }
    }

    public static void main(String ab[]) {
        new Updatecheck();
    }
}
