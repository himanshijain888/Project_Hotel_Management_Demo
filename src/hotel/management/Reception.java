package hotel.management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener {

    JButton newcustomer, rooms, department, allemployee, Customerinfo, Managerinfo, Checkout, Updatestatus, Pickup, searchroom, logout;

    public Reception() {
        setBounds(350, 200, 800, 570);
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD RECEPTION DETAILS");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        newcustomer = new JButton("New Customer Form");
        newcustomer.setBackground(Color.WHITE);
        newcustomer.setForeground(Color.BLACK);
        newcustomer.addActionListener(this);
        newcustomer.setBounds(60, 40, 200, 30);
        add(newcustomer);

        rooms = new JButton("Rooms");
        rooms.setBackground(Color.WHITE);
        rooms.setForeground(Color.BLACK);
        rooms.addActionListener(this);
        rooms.setBounds(60, 90, 200, 30);
        add(rooms);

        department = new JButton("Department");
        department.setBackground(Color.WHITE);
        department.setForeground(Color.BLACK);
        department.addActionListener(this);

        department.setBounds(60, 140, 200, 30);
        add(department);

        allemployee = new JButton("All Employees");
        allemployee.setBackground(Color.WHITE);
        allemployee.setForeground(Color.BLACK);
        allemployee.addActionListener(this);

        allemployee.setBounds(60, 190, 200, 30);
        add(allemployee);

        Customerinfo = new JButton("Customer info");
        Customerinfo.setBackground(Color.WHITE);
        Customerinfo.setForeground(Color.BLACK);
        Customerinfo.setBounds(60, 240, 200, 30);
        Customerinfo.addActionListener(this);
        add(Customerinfo);

        Managerinfo = new JButton("Manager info");
        Managerinfo.setBackground(Color.WHITE);
        Managerinfo.setForeground(Color.BLACK);
        Managerinfo.setBounds(60, 290, 200, 30);
        Managerinfo.addActionListener(this);
        add(Managerinfo);

        Checkout = new JButton("Checkout");
        Checkout.setBackground(Color.WHITE);
        Checkout.setForeground(Color.BLACK);
        Checkout.addActionListener(this);

        Checkout.setBounds(60, 340, 200, 30);
        add(Checkout);

        Updatestatus = new JButton("Update Status");
        Updatestatus.setBackground(Color.WHITE);
        Updatestatus.setForeground(Color.BLACK);
        Updatestatus.addActionListener(this);

        Updatestatus.setBounds(60, 390, 200, 30);
        add(Updatestatus);

        Pickup = new JButton("Pickup Service");
        Pickup.setBackground(Color.WHITE);
        Pickup.setForeground(Color.BLACK);
        Pickup.addActionListener(this);

        Pickup.setBounds(60, 440, 200, 30);
        add(Pickup);

        searchroom = new JButton("Search Room");
        searchroom.setBackground(Color.WHITE);
        searchroom.setForeground(Color.BLACK);
        searchroom.addActionListener(this);
        searchroom.setBounds(60, 490, 200, 30);
        add(searchroom);

        logout = new JButton("Logout");
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);

        logout.setBounds(60, 540, 200, 30);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,800, 600);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newcustomer) {
            this.setVisible(false);
            new Addcustomer();
        } else if (ae.getSource() == rooms) {
            this.setVisible(false);
            new Rooms();
        } else if (ae.getSource() == department) {
            this.setVisible(false);
            new Department();
        } else if (ae.getSource() == allemployee) {
            this.setVisible(false);
            new employeeinfo();
        } else if (ae.getSource() == Managerinfo) {
            this.setVisible(false);
            new Managerinfo();
        } else if (ae.getSource() == Customerinfo) {
            this.setVisible(false);
            new Customerinfo();
        } else if (ae.getSource() == searchroom) {
            this.setVisible(false);
            new Searchroom();
        } else if (ae.getSource() == Checkout) {
            this.setVisible(false);
            new Checkout();
        } else if (ae.getSource() == Pickup) {
            this.setVisible(false);
            new Pickup();
        } else if (ae.getSource() == Updatestatus) {
            this.setVisible(false);
            new Updatecheck();
        } else if (ae.getSource() == logout) {
            this.setVisible(false);
            //System.exit(0);
        }
    }

    public static void main(String ab[]) {
        new Reception();
    }

}
