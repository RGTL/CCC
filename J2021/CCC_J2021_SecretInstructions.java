import java.util.*;
import java.io.*;

public class CCC_J2021_SecretInstructions {
  
  List<String> instList = new ArrayList<String>();
  String preDir = "";
  
  public void addInst(String dir, String steps) {
    String newDir = "";
    if(dir == "00") 
      newDir = preDir;
    else {
      int d1 = Integer.parseInt(dir.substring(0,1));
      int d2 = Integer.parseInt(dir.substring(1));
      int d = d1 + d2;
      newDir = (d%2==0)? "right":"left";
    }
    
    instList.add(newDir + " " + steps);
  }
  
  public static void main(String args[]) throws IOException {
    
    CCC_J2021_SecretInstructions si = new CCC_J2021_SecretInstructions ();
  
    Scanner scan = new Scanner(System.in);
    System.out.println("Secret Instructions");
    while(true) {
      String inst = scan.next();
      if (inst.equals("99999")) break;
      si.addInst(inst.substring(0,2), inst.substring(2));
    }
    for (String s : si.instList) 
      System.out.println("Output: " + s);
    
  }
  
  
}