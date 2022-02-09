import java.util.*;
import java.io.*;

public class CCC_J2020_DogTreats {
  
  public boolean isHappy(int s, int m, int l) {
    return (s+m*2 + l*3) >=10;
  }
  
  
  public static void main(String args[]) throws IOException {
    
    Scanner scan = new Scanner(System.in);
    
    int s = Integer.parseInt(scan.next());
    int m = Integer.parseInt(scan.next());
    int l = Integer.parseInt(scan.next());
    
    CCC_J2020_DogTreats dt = new CCC_J2020_DogTreats();
    System.out.println(dt.isHappy(s, m, l)? "happy":"sad");
    
  }
  
  
}