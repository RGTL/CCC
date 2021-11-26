import java.util.*;
import java.io.*;

public class CCC_J2011_J1_Alien {
  
  public static String checkSpecies(int ant, int eye) {
    
    String s = "";
    if (ant >=3 && eye<=4)
      s+="TroyMartian\n";
    if (ant <=6 && eye>=2)
      s+="VladSaturnian\n";
    if (ant <=2 && eye<=3)
      s+="GraemeMercurian\n";
    return s;
    
  }
  
  public static void main(String args[]) throws IOException {
    
    //CCC_J2011_J1_Alien j1 = new CCC_J2011_J1_Alien();
    
    Scanner scan = new Scanner(System.in); 
       
    while (true) {
         System.out.println("How many antennas?");
         int ant = Integer.parseInt(scan.next());
         if (ant == -1) break;
         System.out.println("How many eyes?");
         int eye = Integer.parseInt(scan.next());
         
         System.out.println(checkSpecies(ant, eye));
    }
  }
  
}
