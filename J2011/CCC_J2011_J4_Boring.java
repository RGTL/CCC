import java.util.*;
import java.io.*;
import java.lang.Math;

public class CCC_J2011_J4_Boring {
  
  static ArrayList<int[]> posList;
    
  public static boolean drive(String cmd, int dist) {
    
    boolean bSafe = true;
    
    for (int i=0; i< dist; i++) {
      
      int[] pos = new int[2];
      
      int[] lastPos = posList.get(posList.size()-1);// last element
      pos[0] = lastPos[0];
      pos[1] = lastPos[1];
    
      switch(cmd) {
        case "d":
          pos[1]-= 1;
          break;
        case "r":
          pos[0] += 1;
          break;
        case "l":
          pos[0] -= 1;
          break;
        case "u":
          pos[1] += 1;
          break;
        default:
          return bSafe;
      }
      
      //if(posList.contains(pos))

      for (int k=0; k<posList.size(); k++ ) {
        int[] p = posList.get(k);
        if(p[0]==pos[0] && p[1]==pos[1])
          bSafe=false;
      }
      
      posList.add(pos);
    }
    
    return bSafe;
  }
  
  public static void main(String args[]) throws IOException {
    
    posList = new ArrayList<int[]>();
    int[] pos = {0, -1};
    posList.add(pos);

    drive("d", 2);
    drive("r", 3);
    drive("d", 2);
    drive("r", 2);
    drive("u", 2);
    drive("r", 2);
    drive("d", 4);
    drive("l", 8);
    drive("u", 2);

    /*
    for (int i=0; i<posList.size(); i++ )
         System.out.println("[" + posList.get(i)[0] + "," + posList.get(i)[1] + "]");
    */
    
    Scanner scan = new Scanner(System.in); 
       
    while (true) {
         String cmd = scan.next();
         if (cmd.equals("q")) break;
         int dist = Integer.parseInt(scan.next());
         boolean bSafe = drive(cmd, dist);
         int[] p = posList.get(posList.size()-1);
         
         System.out.println(p[0] + " " + p[1] + (bSafe?" safe":" DANGER"));
         
         if (!bSafe)
           break;
         
         /* 
         for (int i=0; i<posList.size(); i++ )
           System.out.println("[" + posList.get(i)[0] + "," + posList.get(i)[1] + "]");
         */
             
         scan.nextLine();
    }
  }
  
}
