
package college.erp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, cancel;
    JTextField ip_nm,
    ip_pass;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel usnm = new JLabel("Username");
        usnm.setBounds(40, 20, 100, 20);
        add(usnm);
        
       ip_nm = new JTextField();
        ip_nm.setBounds(150, 20, 150, 20);
        add(ip_nm);
        
        JLabel lbpass = new JLabel("Password");
        lbpass.setBounds(40, 70, 100, 20);
        add(lbpass);
        
        ip_pass = new JPasswordField();
        ip_pass.setBounds(150, 70, 150, 20);
        add(ip_pass); 
        
         login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        login.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true); 
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if( ae.getSource()== login){
            String username = ip_nm.getText();
            String password = ip_pass.getText(); // extract user input to create my sql query
            String query = "select *from login where username ='"+username+"' and password ='"+password+"' ";
            
            try{
                Connectdb c = new Connectdb();  // connection withconnectdb is formed
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){ // rs.next() is bool type
                    setVisible(false);
                    new Homepage(); // login is connected with homepage using authentication from connectdb
                }
                else {
                    JOptionPane.showMessageDialog(null,"invalid username and password"); // popup
                    setVisible(false);
                }
                //c.s.sclose(); connection closed
            }
            catch (Exception e){
                e.printStackTrace();
            }
            
        }
        else if( ae.getSource()== cancel){
            setVisible(false);
        }
    }
    
    public static void main( String[] args){
        new Login();
    }
}
