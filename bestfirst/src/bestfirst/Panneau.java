package bestfirst;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import bestfirst.BestF;

public class Panneau extends JPanel implements ActionListener{
    /////////////////////////////
        int puzzl[][]=new int[3][3];//initial state
        int but[][]={{1,2,3},{4,5,6},{7,8,0}}; //final stat
        int OPEN[][][]=new int[362880][3][3];// 362880 possible cases for a puzzl 3x3///OPEN will contain the staes/case  already processed or visited
        int trajet[]=new int[362880]; // the moved tiles
        Scanner sc = new Scanner(System.in);
    ////////////////////////////
    private int nbrsc=2000;
    Timer t=new Timer(200,this);
    Image img[]=new Image[9];
     int pos[][]=new int[9][2];
    private int compt=0;
    private String tabimg[]={"zero.jpg","un.jpg","deux.jpg","trois.jpg","quatre.jpg","cinq.jpg","six.jpg","sept.jpg","huit.jpg",};
    
public void paintComponent(Graphics g){
super.paintComponent(g);
if(compt==0){
    // insert the matrix (puzzl)
for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
            System.out.print("puzzl["+i+"]["+j+"]= ");
            int a=sc.nextInt();
            puzzl[i][j]=a;
            }
// fill the table "pos"
for(int i=0;i<3;i++)
    for(int j=0;j<3;j++)
    {// give the coordinates of each picture according to the position of its value in puzzl
    int c=puzzl[i][j];
    switch(c){// i==>posY    j==>posX
        case 0 : pos[0][0]=j*100;pos[0][1]=i*100;break;
        case 1 : pos[1][0]=j*100;pos[1][1]=i*100;break;
        case 2 : pos[2][0]=j*100;pos[2][1]=i*100;break;
        case 3 : pos[3][0]=j*100;pos[3][1]=i*100;break;
        case 4 : pos[4][0]=j*100;pos[4][1]=i*100;break;
        case 5 : pos[5][0]=j*100;pos[5][1]=i*100;break;
        case 6 : pos[6][0]=j*100;pos[6][1]=i*100;break;
        case 7 : pos[7][0]=j*100;pos[7][1]=i*100;break;
        case 8 : pos[8][0]=j*100;pos[8][1]=i*100;break;
    }
    }
}
else{nbrsc=500;
}
 try {
     for(int i=0;i<9;i++)
     {
      img[i] = ImageIO.read(new File("the_path_of_the_pictures/ex:C:\\Users\\..."+tabimg[i]));
     g.drawImage(img[i], pos[i][0], pos[i][1], this);
     }
                } catch (IOException e) {
                        // 
                        e.printStackTrace();
                }
 BestF b=new BestF(puzzl);
 b.calculeBFS(but,puzzl,OPEN,trajet);
t.start();
}
public void actionPerformed(ActionEvent e){

    int a=trajet[compt];
  int b,c;
  b=pos[a][0];// reverse both positions of '0' and the tile we want to move 
  c=pos[a][1];
  pos[a][0]=pos[0][0];
  pos[a][1]=pos[0][1];
  pos[0][0]=b;
  pos[0][1]=c;
  compt++;
  repaint();
}
}