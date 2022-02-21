import java.io.*;
import java.util.*;

public class J2022_GoodGroups {

  ArrayList<String[]> ConstSameGrp = new ArrayList<String[]>();
  ArrayList<String[]> ConstDiffGrp = new ArrayList<String[]>();
  ArrayList<String[]> ActGrp = new ArrayList<String[]>();
  
  void addGrp(String s1, String s2, boolean bInSameGrp) {
    if(bInSameGrp)
      ConstSameGrp.add(new String[]{s1, s2});
    else
      ConstDiffGrp.add(new String[]{s1, s2});
  }
  
  void addActGrp(String s1, String s2, String s3) {
    ActGrp.add(new String[] {s1, s2, s3});
  } 
  
  boolean isInDiffRule(String s1, String s2, ArrayList<String[]> l) {
    for (String[] p : l) {
     if ((s1.equals(p[0]) || s1.equals(p[1])) && (s2.equals(p[0]) || s2.equals(p[1]))) 
           return true;
    }
    return false;
  }
  
  boolean isInSameRule(ArrayList<String[]> grp, String[] sameGrpRule) {
    for (String[] g : grp) {
      if ((sameGrpRule[0].equals(g[0]) || sameGrpRule[0].equals(g[1]) || sameGrpRule[0].equals(g[1]) ) && 
          (sameGrpRule[1].equals(g[0]) || sameGrpRule[1].equals(g[1]) || sameGrpRule[1].equals(g[1]) ) )
           return true;
    }
    return false;
  }
  
  int ruleViolated() {
    int rv= 0;

    for (String[] p : ActGrp) {  // get each group
      for (int i=0; i<p.length; i++) {
        for (int j=i+1; j<p.length; j++) {
           if (isInDiffRule(p[i],p[j], ConstDiffGrp))
             rv++;
        }
      }
    }
    
    for (String[] s : ConstSameGrp) {  // get each same group rule
      if (!isInSameRule(ActGrp, s))
        rv++;
    }

    return rv;
  }
  
  public static void main(String [] args) throws Exception {
    J2022_GoodGroups gg = new J2022_GoodGroups();
    
    Scanner in = new Scanner(System.in);

    int sameGrpEnt = in.nextInt();
    for (int i=0; i<sameGrpEnt; i++) {
      gg.addGrp(in.next(), in.next(), true);
    }

    int diffGrpEnt = in.nextInt();
    for (int i=0; i<diffGrpEnt; i++) {
      gg.addGrp(in.next(), in.next(), false);
    }
    
    int actGrpEnt = in.nextInt();
    for (int i=0; i<actGrpEnt; i++) {
      gg.addActGrp(in.next(), in.next(), in.next());
    }
    
    System.out.println(gg.ruleViolated());
  }
}