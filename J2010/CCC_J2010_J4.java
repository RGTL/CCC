import java.util.*;
import java.io.*;

public class CCC_J2010_J4 {
  
  public static boolean checkPattern(int[] tgt, int[] t) {
    
    boolean ok = true;
    for (int i=0; i<tgt.length; i++) {
      if (tgt[i]!=t[i%(t.length)]) {
        ok = false;
        break;
      }
    } 
    return ok;
  }
  
  public static void main(String args[]) throws IOException {
    
    CCC_J2010_J4 j4 = new CCC_J2010_J4();
    
    Scanner scan = new Scanner(System.in); 
    
    while (true) {
      
      String a = scan.next();
      
      if (a.equals("0")) break;
      
      int num = Integer.parseInt(a);
      
      int[] l = new int[num];
      int[] k = new int[num-1];
      
      for (int i=0; i< num; i++) {
        l[i] = Integer.parseInt(scan.next());
        if (i>0)
          k[i-1] = l[i] - l[i-1];
      }
      
      //System.out.println(Arrays.toString(l));
      
      //System.out.println(Arrays.toString(k));
      
      if(num<3)
        System.out.println(num-1);
      else {
        
        for (int x=1; x< num-1; x++) {
          int[] k1 = new int[num-1-x];
          int[] k2 = new int[x];
          
          for (int i=0; i<x; i++) {
            k2[i] = k[i];
          }
          
          for (int j=x; j<num-1; j++) {
            k1[j-x] = k[j];
          }
          
          if(checkPattern(k1, k2)) {
            System.out.println(x);
            break;
          }
          
          if (x == num-2)
            //System.out.println("Not found any patern!");
            System.out.println(num-1);
          
        }
      }
      
      scan.nextLine();
    }
    
    
    
  }
  
  
}