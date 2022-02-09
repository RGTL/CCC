import java.util.*;
import java.io.*;

public class CCC_J2020_Art {
  
  int minX=200, minY=200, maxX=0, maxY=0;
  ArrayList<int[]> listXY = new ArrayList<int[]>();
  
  public void calcXY() {
    for (int[] xy : listXY) {
      if (minX > xy[0])
        minX = xy[0];
      if (maxX < xy[0])
        maxX = xy[0];
      if (minY > xy[1])
        minY = xy[1];
      if (maxY < xy[1])
        maxY = xy[1];
    }
  }
  
  public static void main(String args[]) throws IOException {
    
    CCC_J2020_Art at = new CCC_J2020_Art();
    
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.next());
    
    for(int i=0; i<n; i++) {
      String strXY = scan.next();
      String[] xy = strXY.split(",");
      at.listXY.add(new int[]{Integer.parseInt(xy[0]), Integer.parseInt(xy[1])});
    }
    
    
    at.calcXY();
    System.out.println((at.minX-1) + "," + (at.minY-1));
    System.out.println((at.maxX+1) + "," + (at.maxY+1));
  }
  
  
}