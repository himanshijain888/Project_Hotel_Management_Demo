package hotel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login implements ActionListener {

    JTextField username;
    JPasswordField passname;
    JButton login, Cancel;
    JFrame frame = new JFrame("Login");

    Login() {
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/view4.jpeg"));
        JLabel image = new JLabel(i1);
         image.setBounds (250, 30, 500, 470);
       // image.setBounds(1000, 450, 500, 300);new BorderLayout(), BorderLayout.SOUTH
        panel.add(image);
        
        JLabel text = new JLabel("LOGIN DETAILS");
        text.setBounds(700, 200, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 70));
        image.add(text);

        JLabel user = new JLabel("Username");
        user.setBackground(Color.BLACK);
        user.setForeground(Color.WHITE);
        user.setFont(new Font("Tahoma", Font.PLAIN, 22));
        user.setBounds(800, 450,200, 30);
        image.add(user, BorderLayout.SOUTH);

        username = new JTextField();
        username.setBounds(1000, 450, 150, 30);
        image.add(username, BorderLayout.SOUTH);
        JLabel pass = new JLabel("Password");
        pass.setBounds(800, 500, 100, 30);
        pass.setBackground(Color.BLACK);
    
        pass.setForeground(Color.WHITE);
        pass.setFont(new Font("Tahoma", Font.PLAIN, 22));
        image.add(pass, BorderLayout.SOUTH);

        passname = new JPasswordField();
        passname.setBounds(1000, 500, 150, 30);
        image.add(passname, BorderLayout.SOUTH);
        //setBounds(500, 200, 600, 300);

        login = new JButton("Login");
      
        login.setBounds(800, 600, 130, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        image.add(login);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(1000, 600, 120, 30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        image.add(Cancel);
        frame.add(image);
        frame.setVisible(true);

       
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = passname.getText();

            try {
                Conn c = new Conn();
                String query = "select  * from login where username = '" + user + "'and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    frame.setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invaild UserName and Password");
                    frame.setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == Cancel) {
            frame.setVisible(false);
        }
    }

    public static void main(String ab[]) {
        new Login();
    }
}
