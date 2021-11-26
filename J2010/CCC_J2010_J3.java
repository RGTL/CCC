import java.util.*;
import java.io.*;

public class CCC_J2010_J3 {
  
  public int A=0, B=0;
  
  public void calc(String a, String b, int cv) {
    if (b.equals("A")) {
     switch (a) {
       case "1": A=cv; break;
       case "2": System.out.println(""+ A); break;
       case "3": A = A+cv; break;
       case "4": A = A*cv; break;
       case "5": A = A-cv; break;
       case "6": A = (int) A/cv; break;
     }
    }
    else if (b.equals("B")) {
     switch (a) {
       case "1": B=cv; break;
       case "2": System.out.println(""+ B); break;
       case "3": B = B+cv; break;
       case "4": B = B*cv; break;
       case "5": B = B-cv; break;
       case "6": B = (int) B/cv; break;
     }
    }
  } 
  
  
  
  public static void main(String args[]) throws IOException {
       
    CCC_J2010_J3 j3 = new CCC_J2010_J3();
    
    Scanner scan = new Scanner(System.in); 
    while (true) {
       
      String a = scan.next();
      
      if (a.equals("7")) break;
      
      String b = scan.next();
      
      int cv = 0;
      if (!a.equals("2")) {
        String c = scan.next();
        if (c.equals("A"))
          cv = j3.A;
        else if (c.equals("B"))
          cv = j3.B;
        else 
          cv = Integer.parseInt(c);
      }
      
      j3.calc(a, b, cv);
      scan.nextLine();
    }
  }
  
}
