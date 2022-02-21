import java.io.*;
import java.util.*;

public class J2022_SquarePool {
  
  ArrayList<int[]> treeList = new ArrayList<int[]>();
  
  boolean isTreeInArea(int xTop, int yTop, int xBot, int yBot) {
    for(int[] treePos: treeList) {
      if (treePos[0] >= xTop && treePos[1] >= yTop &&
          treePos[0] <= xBot && treePos[1] <= yBot)
        return true;
    }
    return false;
  }
  
  boolean isPoolSizeOK(int ydSize, int poSize) {
    for(int i=0; i<=ydSize-poSize; i++) 
      for(int j=0; j<=ydSize-poSize; j++)
         if(!isTreeInArea(i, j, i+poSize-1, j+poSize-1))
            return true;
    return false;
  }
  
  public static void main(String[] args) throws Exception {
    J2022_SquarePool sp = new J2022_SquarePool();
    
    Scanner in = new Scanner(System.in);
    int ydSize=in.nextInt();
    int nTrees = in.nextInt();
    for (int i=0; i< nTrees; i++) 
      sp.treeList.add(new int[]{in.nextInt()-1, in.nextInt()-1});
    for (int poSize=ydSize - 1; poSize>1; poSize--) {
      if(sp.isPoolSizeOK(ydSize, poSize)) {
        System.out.println(poSize);
        break;
      }
    }
  }
  
}