import java.util.*;
import java.io.*;

public class CCC_J2010_J5 {
  
  static List<Integer> total_steps;
  
  public static void calcSteps(int x1, int y1, int x2, int y2, int steps) {
    
    if(x1 == x2 && y1 == y2) 
        total_steps.add(steps); // found

    
    int dx, dy; 
    
    for (int i=0; i<8; i++) {
      if (i<4) {
        dx = (-1) * i%2 * 2 + 1;
        dy = ((-1) * (int)(i/2) *2 + 1) * 2;
      }
      else {
        dx = ((-1) * i%2 * 2 + 1) * 2;
        dy = (-1) * (int)((i-4)/2) * 2 + 1;
      }
        
      //System.out.println("Dx: " + dx + "Dy: " + dy);
      
      int xx = x1+dx;
      int yy = y1+dy;
      
      
      if (xx>0 && xx<=8 && yy>0 && yy<=8 && steps<10 
            && (Math.abs(x2-xx)<=Math.abs(x2-x1) || Math.abs(y2-yy)<=Math.abs(y2-y1))) 
         calcSteps(xx, yy, x2, y2, steps + 1);
      
    }
    
  }
  
  public static void main(String args[]) throws IOException {
    
    CCC_J2010_J5 j5 = new CCC_J2010_J5();
    
    Scanner scan = new Scanner(System.in); 
    
    while (true) {
      
      int x1 = Integer.parseInt(scan.next());
      if (x1 == 0) break;
      int y1 = Integer.parseInt(scan.next());
      
      scan.nextLine();

      int x2 = Integer.parseInt(scan.next());
      if (x2 == 0) break;
      int y2 = Integer.parseInt(scan.next());
      
      scan.nextLine();
      
      total_steps = new ArrayList<Integer>();
      
      calcSteps(x1, y1, x2, y2, 0);
      
      int min_steps = 100;
      for (int i=0; i<total_steps.size(); i++) {
        if ( total_steps.get(i) < min_steps)
          min_steps = total_steps.get(i);
      }
      
      System.out.println(min_steps);
      
    }
    
    
    
  }
  
  
}