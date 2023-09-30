
package hotel.management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Adddrivers extends JFrame implements ActionListener{
    JTextField tfname,tfage,tfcarcompany,tfmodel,tflocation;
    JComboBox cbGender, cbavailable;
    JButton Next,Cancel;
    public Adddrivers()
    {
        setBounds(450,200,1000,570);
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD DRIVERS DETAILS");
            	 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
	
          		
        JLabel lblname = new JLabel("Name");
        lblname .setBounds(60,30,120,30);
        lblname .setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);
        
        tfname = new JTextField();
        tfname .setBounds(200,30,150,30);
        add(tfname);
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);
        
        
        tfage = new JTextField();
         tfage.setBounds(200,80,150,30);
        add( tfage);
        
                
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(60,130,120,30);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblGender);
        
        String str[] = {"MALE","FEMALE"};
        cbGender = new JComboBox(str);
        cbGender.setBounds(200,130,150,30);
        cbGender.setBackground(Color.WHITE);
        cbGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(cbGender);
           
         JLabel lblcarcompany = new JLabel("Car Company");
        lblcarcompany.setBounds(60, 180,120,30);
        lblcarcompany.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblcarcompany);
        
        tfcarcompany = new JTextField();
        tfcarcompany.setBounds(200,180,150,30);
        add(tfcarcompany );
      
          		
        JLabel lblmodel = new JLabel("Car Model");
        lblmodel .setBounds(60,230,120,30);
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel  .setBounds(200,230,150,30);
        add(tfmodel);
        
        
        JLabel lblavailbility = new JLabel("Available");
        lblavailbility.setBounds(60,280,120,30);
        lblavailbility.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblavailbility);
        
        String sta[] = {"Available","Busy"};
        cbavailable = new JComboBox(sta);
        cbavailable.setBounds(200,280,150,30);
        cbavailable.setBackground(Color.WHITE);
        cbavailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(cbavailable);
        
        JLabel lbllocation = new JLabel("Location");
         lbllocation  .setBounds(60,330,120,30);
        lbllocation .setFont(new Font("Tahoma", Font.PLAIN, 17));
        add( lbllocation );
        
        tflocation = new JTextField();
        tflocation.setBounds(200,330,150,30);
        add(tflocation);
         
             
         
        Next = new  JButton("ADD DRIVERS");
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        
        Next.setBounds(20,380,150,30);
        add( Next);
        
        Cancel = new  JButton("CANCEL");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
         Cancel.addActionListener(this);
        
        Cancel.setBounds(210,380,150,30);
        add(Cancel);
        
        
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,370);
        add(image);
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Next){
                    String name = tfname.getText();
                    String age = tfage.getText();
                    String carcompany= tfcarcompany.getText();
                    String carmodel= tfmodel.getText();
                    String location = tflocation.getText();
                   
                            
                    String availbility = (String)  cbavailable.getSelectedItem();
                    String Gender = (String) cbGender.getSelectedItem();
                    
                    
                    try {
                        Conn c = new Conn();
                        String str = "INSERT INTO driver  values( '"+name+"', '"+age+"', '"+Gender+"', '"+carcompany +"','"+carmodel+"','"+availbility+"','"+ location+"')";
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Driver Added");
                        this.setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
        else if(ae.getSource() == Cancel)
        {
            this.setVisible(false);
        }
    }
    
    
    public static void main(String ab[])
    {
        new Adddrivers();
    }
}
