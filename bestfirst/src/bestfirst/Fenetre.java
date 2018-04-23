
package bestfirst;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Fenetre extends JFrame {
public Fenetre(){
   
    //Give a title to our window
this.setTitle("Best First Search");
//define the size , width=315 px, height= 338 px
this.setSize(315, 338);
//position of the object
this.setLocationRelativeTo(null);
//stop the process when exiting the window
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

this.setContentPane(new Panneau());

//make it visible
this.setVisible(true);
}
}
