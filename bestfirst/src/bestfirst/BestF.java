/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Khadija Elhasnaoui
 */
package bestfirst;




public class BestF {
     int puzzl[][]=new int[3][3];
    public BestF(int[][] puzzl) {
        this.puzzl=puzzl;
    }
 public static int comparer(int[][] but,int[][] puzzl){// count the tiles in the wrong position
   int h=0;
   for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
            if(but[i][j]!= puzzl[i][j])
                h++;
            }
   return h;
   }   
 public static int[] bestfirst(int[][][] OPEN,int[][] but,int[][] puzzl,int x_z,int y_z,int k){
  
      int h_test=10;
      int a,b;
      int tab[]=new int[2];
      int test[][]=new int[3][3];
      if(y_z>=0 && y_z<2){
          /* fill 'test' with the values of the puzzl*/
          for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
          test[i][j]=puzzl[i][j];
// move the tile to the right
      a=test[x_z][y_z];
      test[x_z][y_z]=test[x_z][y_z+1];
      test[x_z][y_z+1]=a;
      b=comparer(but,test);
      if(b<h_test && existe_ds_OPEN(OPEN,test,k)==false){
          tab[0]=x_z;
          tab[1]=y_z+1;
          h_test=b;
      }
      }
      if(y_z>0 && y_z<=2){
          /* fill 'test' with the values of the puzzl*/
          for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
          test[i][j]=puzzl[i][j];// move the tile to the left
      a=test[x_z][y_z];
      test[x_z][y_z]=test[x_z][y_z-1];
      test[x_z][y_z-1]=a;
      b=comparer(but,test);
      if(b<h_test && existe_ds_OPEN(OPEN,test,k)==false){
          tab[0]=x_z;
          tab[1]=y_z-1;
          h_test=b;
      }
      }
      if(x_z>=0 && x_z<2){
          /* fill 'test' with the values of the puzzl*/
          for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
          test[i][j]=puzzl[i][j];// move the tile to the top
      a=test[x_z][y_z];
      test[x_z][y_z]=test[x_z+1][y_z];
      test[x_z+1][y_z]=a;
      b=comparer(but,test);
      if(b<h_test && existe_ds_OPEN(OPEN,test,k)==false){
          tab[0]=x_z+1;
          tab[1]=y_z;
          h_test=b;
      }
      }
      if(x_z>0 && x_z<=2){
          /* fill 'test' with the values of the puzzl*/
          for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
          test[i][j]=puzzl[i][j];// move the tile to the bottom
      a=test[x_z][y_z];
      test[x_z][y_z]=test[x_z-1][y_z];
      test[x_z-1][y_z]=a;
      b=comparer(but,test);
      if(b<h_test && existe_ds_OPEN(OPEN,test,k)==false){
          tab[0]=x_z-1;
          tab[1]=y_z;
          h_test=b;
      }
      }
      
   return tab;   
  }
public static boolean existe_ds_OPEN(int[][][] OPEN,int[][] test, int k){
int t=0;
for(int i=0;i<=k;i++){
    int h=comparer(OPEN[i],test);
 if( h == 0 ){
    t=1;
    break;
 }}
if(t==0) return false;
else return true;       
}
public static void affichage(int[][] puzzl){
for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
            System.out.print(puzzl[i][j]+" ");
            System.out.print("\n");
            }
}   
public static void calculeBFS(int[][] but,int[][] puzzl,int[][][] OPEN,int[] trajet){
int h=comparer(but,puzzl);//number of tiles in the wrong position
      int x_zero=0,y_zero=0;
      int k=0;
      
while(h!=0){
      for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {// find the position of '0'
            if(puzzl[i][j]==0){
                x_zero=i;
                y_zero=j;
                break;}}
      
    // choose the best node/case
    //insert the processed case in OPEN
      for(int i=0;i<3;i++)
       for(int j=0;j<3;j++)
      OPEN[k][i][j]=puzzl[i][j];
      k++;
      int tab[]=new int[2];// index of of the tiles that we already moved
      tab=bestfirst(OPEN,but,puzzl,x_zero,y_zero,k);
      int a=tab[0],b=tab[1],t;
      trajet[k-1]=puzzl[a][b];
      t=puzzl[x_zero][y_zero];
      puzzl[x_zero][y_zero]=puzzl[a][b];
      puzzl[a][b]=t;
      h=comparer(but,puzzl);
     
      System.out.print("=>"+trajet[k-1]+"\n");
       if (h==0) break;
      }
}
}
