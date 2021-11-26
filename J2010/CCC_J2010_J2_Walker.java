import java.util.*;
import java.io.*;

public class CCC_J2010_J2_Walker
{
    int frd, bkd;
    
    CCC_J2010_J2_Walker(int frd, int bkd) {
      this.frd = frd;
      this.bkd = bkd;
    }
    
    int walk(int steps) {
      int dist = 0; 
      boolean dir = true;
      int s = 0;
      
      for (int i=0; i<steps; i++) {
         dist+=dir? 1: -1 ;
         s++;
         if ((dir && s==frd) || (!dir && s==bkd) ){
           dir=!dir;
           s = 0;
         }
      }
      return dist;
    }
    
  
  public static void main(String args[]) throws IOException {
       Scanner scan = new Scanner(System.in); 
       int a = scan.nextInt();
       int b = scan.nextInt();
       int c = scan.nextInt();
       int d = scan.nextInt();
       int s = scan.nextInt();
       
       CCC_J2010_J2_Walker nikky = new CCC_J2010_J2_Walker(a, b);
       CCC_J2010_J2_Walker byron = new CCC_J2010_J2_Walker(c, d);
       
       int n_dist = nikky.walk(s);
       int b_dist = byron.walk(s);
       
       if(n_dist==b_dist)
         System.out.println("Tied");
       else if(n_dist>b_dist)
         System.out.println("Nikky");
       else
         System.out.println("Byron");

  }
  
}
