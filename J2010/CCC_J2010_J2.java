import java.util.*;
import java.io.*;

public class CCC_J2010_J2 {
    
  public static void main(String args[]) throws IOException {
       Scanner scan = new Scanner(System.in); 
       int a = scan.nextInt();
       int b = scan.nextInt();
       int c = scan.nextInt();
       int d = scan.nextInt();
       int s = scan.nextInt();
       
       int n_dist=0, b_dist=0;
       int n_steps=0, b_steps=0;
       boolean n_dir=true, b_dir=true;
       
       for (int i=0; i<s; i++) {
         n_dist+=n_dir? 1: -1 ;
         n_steps ++;
         if ((n_dir && n_steps==a) || (!n_dir && n_steps==b) ){
           n_dir=!n_dir;
           n_steps = 0;
         }
             
         b_dist+=b_dir? 1: -1;
         b_steps ++;
         if ((b_dir && b_steps==c) || (!b_dir && b_steps==d)) {
           b_dir=!b_dir;
           b_steps=0;
         }
       }
       
       
       if(n_dist==b_dist)
         System.out.println("Tie");
       else if(n_dist>b_dist)
         System.out.println("Nikky");
       else
         System.out.println("Byron");

       
  }
  
}
