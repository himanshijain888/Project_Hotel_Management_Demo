package hotel.management;

import java.awt.EventQueue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Addemployee extends JFrame {

    JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfaadhare;
    JComboBox cbjob;

    public Addemployee() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        JButton Next = new JButton("SUBMIT");
        Next.setBackground(Color.WHITE);
        Next.setForeground(Color.BLACK);
        Next.setBounds(100, 430, 150, 30);
        add(Next);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);

        JRadioButton rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        JRadioButton rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);

        String str[] = {"Front Desk Clerks", "porters", "HouseKeeping",
            "Room Service", "chefs", "Waiter/Waiters", "Accountants"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        cbjob.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(cbjob);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 380, 120, 30);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblaadhar);

        tfaadhare = new JTextField();
        tfaadhare.setBounds(200, 380, 150, 30);
        add(tfaadhare);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
        setBounds(350, 200, 650, 540);
        setVisible(true);

        Next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = tfname.getText();
                String age = tfage.getText();
                String salary = tfsalary.getText();
                String phone = tfphone.getText();
                String aadhar = tfaadhare.getText();
                String email = tfemail.getText();

                String gender = null;

                if (rbmale.isSelected()) {
                    gender = "male";

                } else if (rbfemale.isSelected()) {
                    gender = "female";
                }

                String s6 = (String) cbjob.getSelectedItem();

                try {
                    Conn c = new Conn();
                    String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + s6 + "', '" + salary + "', '" + phone + "','" + aadhar + "', '" + email + "')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {
        new Addemployee();
    }
}
