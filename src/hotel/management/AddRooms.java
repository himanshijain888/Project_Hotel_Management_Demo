package hotel.management;

import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {

    JTextField tfroomno, tfprice;
    JComboBox tfavailable, tfstatus, tfbedtype;
    JButton Next, Cancel;

    AddRooms() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.BLACK);
        setTitle("ADD ROOMS DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);
         
       
        JLabel lblroomnumber = new JLabel("Room Number");
        lblroomnumber.setBounds(60, 30, 120, 30);
        lblroomnumber.setForeground(Color.BLACK);
        lblroomnumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblroomnumber);

        tfroomno = new JTextField();
        tfroomno.setBounds(200, 30, 150, 30);
        add(tfroomno);

        Next = new JButton("ADD ROOMS");
        Next.addActionListener(this);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(40, 330, 150, 30);

        add(Next);

        Cancel = new JButton("CANCEL");
        Cancel.addActionListener(this);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(220, 330, 150, 30);
        add(Cancel);

        JLabel lblprice = new JLabel("Price");
        lblprice.setForeground(Color.WHITE);
        lblprice.setBounds(60, 80, 120, 30);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200, 80, 150, 30);
        add(tfprice);

        JLabel lblavailbility = new JLabel("Availbility");
        lblavailbility.setForeground(Color.WHITE);
        lblavailbility.setBounds(60, 130, 120, 30);
        lblavailbility.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblavailbility);

        String str[] = {"Available", "Occuped"};
        tfavailable = new JComboBox(str);
        tfavailable.setBounds(200, 130, 150, 30);
        tfavailable.setBackground(Color.WHITE);
        tfavailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfavailable);

        JLabel lblstatus = new JLabel("Cleaning Status");
        lblstatus.setForeground(Color.WHITE);
       
        lblstatus.setBounds(60, 180, 120, 30);
        lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblstatus);

        String sta[] = {"clean", "dirty"};
        tfstatus = new JComboBox(sta);
        tfstatus.setBounds(200, 180, 150, 30);
        tfstatus.setBackground(Color.WHITE);
        tfstatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfstatus);

        JLabel lblbedtype = new JLabel("Bed Type");
        lblbedtype.setForeground(Color.BLACK);
       
        lblbedtype.setBounds(60, 230, 120, 30);
        lblbedtype.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblbedtype);

        String bed[] = {"single", "double"};
        tfbedtype = new JComboBox(bed);
        tfbedtype.setBounds(200, 230, 150, 30);
        tfbedtype.setBackground(Color.WHITE);
        tfbedtype.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfbedtype);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 500, 500);
        add(image);
     
          setBounds(350, 200, 650, 540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Next) {
            String roomno = tfroomno.getText();
            String price = tfprice.getText();

            String availbility = (String) tfavailable.getSelectedItem();
            String status = (String) tfstatus.getSelectedItem();
            String bedtype = (String) tfbedtype.getSelectedItem();

            try {
                Conn c = new Conn();
                String str = "INSERT INTO room values( '" + roomno + "', '" + availbility + "', '" + status + "', '" + price + "','" + bedtype + "')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Rooms Added");
                this.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Cancel) {
            this.setVisible(false);
        }
    }

    public static void main(String ab[]) {
        new AddRooms();
    }
}
