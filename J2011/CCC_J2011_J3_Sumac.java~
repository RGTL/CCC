import java.util.*;
import java.io.*;
import java.lang.Math;

public class CCC_J2011_J3_Sumac {
  
  public static int calcSumac(int a, int b) {
    
    System.out.print(a + ",");

    while (a >= b) 
      return 1 + calcSumac(b, a-b);
     
    System.out.print(b);
    return 2;
  }
  
  public static void main(String args[]) throws IOException {
    
    Scanner scan = new Scanner(System.in); 
       
    while (true) {
         int a = Integer.parseInt(scan.next());
         if (a == -1) break;
         int b = Integer.parseInt(scan.next());
         int l = calcSumac(a,b);
         System.out.println("\nLength: " + l);
         
         scan.nextLine();
    }
  }
  
}
