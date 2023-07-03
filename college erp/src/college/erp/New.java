
package college.erp;
import javax.swing.*;
import java.awt.*;
        
        
public class New extends JFrame implements Runnable {
    Thread th;
    New(){
        ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icon/opening img.jpg")); // set background color
       JLabel image = new JLabel(i); // jlabel is used to write something over frame
        add(image); // functionality of jf
        th = new Thread(this);
         th.start();
         getContentPane().setBackground(Color.CYAN);
        setLocation(250,50);     // alignment of frame
        setSize(1000,1000);  // size of frame 
        setVisible(true);  // to make the frame visible 
    }  // as constructer is called at the instant of object creation frame is described inside New class constructer 
     public void run(){
         try {
            Thread.sleep(5000); 
            setVisible(false);
            // next farme
            new Login();
         } catch (Exception e){    
         }
     }
    
    public static void main( String[] args){
        new  New();
        
    }
}
