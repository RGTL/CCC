import java.util.*;
import java.io.*;

public class CCC_J2010_J1 {
  
  public static int getNumWays(int a) {
    if (a>5)
      a = 10-a;
    return (int)a/2 + 1;
    
  }
  
  public static void main(String args[]) throws IOException {
       Scanner scan = new Scanner(System.in); 
       int a = scan.nextInt();
       while (a<=10 && a > 0) {
         System.out.println("" + getNumWays(a));
         a = scan.nextInt();
       }
  }
  
}
