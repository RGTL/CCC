import java.util.*;
import java.io.*;

public class CCC_J2020_Epidemiology {
  
  public int getDays(int p, int n, int r) {
    int days = 0;
    int totalCase = n;
    int newCase=totalCase;
    while(true) {
      days ++;
      newCase = newCase * r;
      totalCase += newCase;
      if (totalCase > p)
        break;
    }
    return days;
  }
  
  public static void main(String args[]) throws IOException {
    
    Scanner scan = new Scanner(System.in);
    
    int p = Integer.parseInt(scan.next());
    int n = Integer.parseInt(scan.next());
    int r = Integer.parseInt(scan.next());
    
    CCC_J2020_Epidemiology ep = new CCC_J2020_Epidemiology();
    System.out.println(ep.getDays(p, n, r));
    
  }
  
  
}