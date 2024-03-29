import java.util.*;
import java.io.*;
import java.lang.Math;

public class CCC_J2011_J2_Balloon {
  
  public static int landingTime(int h, int M) {
    
    double x = 0;
    for (int t=0; t<= M; t++) {
      x = -6.0 * Math.pow(t, 4.0) + Math.pow(t, 3.0) * h + 2.0 * t*t + t;
      System.out.println("Calc: " + t + " | " + x + " | " + Math.pow(t, 4.0) + " | " + (-6.0 * Math.pow(t, 4.0)) + " | " + h * Math.pow(t, 4.0) + "\n");
      if (x<0)
        return t;
    }
    return 0;
    
  }
  
  public static void main(String args[]) throws IOException {
    
    //CCC_J2011_J2_Balloon j1 = new CCC_J2011_J2_Balloon();
    
    Scanner scan = new Scanner(System.in); 
       
    while (true) {
         int h = Integer.parseInt(scan.next());
         if (h == -1) break;
         int M = Integer.parseInt(scan.next());
         int t = landingTime(h, M);
         if (t>0)
           System.out.println("The balloon first touches ground at hour: " + t);
         else
           System.out.println("The balloon does not touch ground in the given time");
    }
  }
  
}
