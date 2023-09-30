package hotel.management;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Addcustomer extends JFrame implements ActionListener {

    JTextField tfno, tfname, tfcountry, tfdeposit;
    JComboBox cbno, cbGender, cballocation;
    JButton Next, Cancel;
    JLabel checkintime;

    public Addcustomer() {
        setBounds(450, 200, 1000, 570);
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD DRIVERS DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(60, 30, 120, 30);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblid);

        String str[] = {"Passport", "Aadhar Card"};
        cbno = new JComboBox(str);
        cbno.setBackground(Color.WHITE);
        cbno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cbno.setBounds(200, 30, 150, 30);
        add(cbno);

        JLabel lblno = new JLabel("Number");
        lblno.setBounds(60, 80, 120, 30);
        lblno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblno);

        tfno = new JTextField();
        tfno.setBounds(200, 80, 150, 30);
        add(tfno);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 130, 150, 30);
        add(tfname);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(60, 180, 120, 30);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblGender);

        String sta[] = {"MALE", "FEMALE"};
        cbGender = new JComboBox(sta);
        cbGender.setBounds(200, 180, 150, 30);
        cbGender.setBackground(Color.WHITE);
        cbGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(cbGender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(60, 230, 120, 30);
        lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 230, 150, 30);
        add(tfcountry);

        JLabel lblallocation = new JLabel("Room Number");
        lblallocation.setBounds(60, 280, 120, 30);
        lblallocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblallocation);

        String no[] = {"101", "102", "103", "104", "105"};
        cballocation = new JComboBox(no);
        cballocation.setBounds(200, 280, 150, 30);
        cballocation.setBackground(Color.WHITE);
        cballocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(cballocation);

        JLabel lblcheckintime = new JLabel("Check-in-time");
        lblcheckintime.setBounds(60, 330, 120, 30);
        lblcheckintime.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblcheckintime);

        Date date = new Date();
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 330, 150, 30);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(checkintime);

        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(60, 380, 120, 30);
        lbldeposit.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 380, 150, 30);
        add(tfdeposit);

        Next = new JButton("ADD Customer");
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);

        Next.setBounds(30, 430, 150, 30);
        add(Next);

        Cancel = new JButton("CANCEL");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);

        Cancel.setBounds(200, 430, 150, 30);
        add(Cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 370);
        add(image);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Next) {

            String gender = (String) cbGender.getSelectedItem();
            String allocation = (String) cballocation.getSelectedItem();

            String no = (String) cbno.getSelectedItem();
            String number = tfno.getText();
            String name = tfname.getText();
            String country = tfcountry.getText();
            String checkin = checkintime.getText();
            String deposit = tfdeposit.getText();

            try {
                Conn c = new Conn();
                String str = "INSERT INTO customer  values( '" + no + "','" + number + "', '" + name + "', '" + gender + "', '" + country + "','" + allocation + "','" + checkin + "','" + deposit + "')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Customer Added");
                this.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Cancel) {
            this.setVisible(false);
        }
    }

    public static void main(String ab[]) {

        new Addcustomer();
    }
}
