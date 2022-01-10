import java.util.*;
import java.io.*;

public class CCC_J2011_J5_UnFriend {
  
  static ArrayList<ArrayList<Integer>> gust_combo_list = new ArrayList<ArrayList<Integer>>();  // the result
  static ArrayList<ArrayList<Integer>> new_combo_list;   // temp for adding new guest combos 
  static ArrayList<Integer> gust_combo;  // temp for holding gust combo
  
  public static void buildGustComboList(ArrayList<ArrayList<Integer>> gcList, int num) {
    
    if (num>1) 
      buildGustComboList(gcList, num-1); // recursive call, to build up list from bottom

    //System.out.println(gcList);
    
    new_combo_list = new ArrayList<ArrayList<Integer>>();  // have to use temp list, so it won't add to looping host list, which would throw ConcurrentModificationException

    for (ArrayList<Integer> ele : gcList) {
      gust_combo = new ArrayList<Integer>();
      gust_combo.addAll(ele);  // new combination is: any existing one plus the current guest#, then add guest# alone. 
      gust_combo.add(num);
      new_combo_list.add(gust_combo);
    }
    gcList.addAll(new_combo_list);
    
    gust_combo = new ArrayList<Integer>();
    gust_combo.add(num);
    gcList.add(gust_combo);
    
    return;
  }
  
  public static void enforceInvite(ArrayList<ArrayList<Integer>> gcList, int invitor, int invitee) {
    Iterator<ArrayList<Integer>> itr = gcList.iterator();
    while(itr.hasNext()) {
      ArrayList<Integer> gust_Combo = itr.next();
      if (gust_Combo.contains(invitor) && !gust_Combo.contains(invitee))
        itr.remove();  // you can only remove element from Iterator, other attempt to remove element from host list would throw ConcurrentModificationException
    }
  }
  
  public static void main(String args[]) throws IOException {
    
    Scanner scan = new Scanner(System.in); 

    ArrayList<Integer> invBy = new ArrayList<Integer>();  // element index is the guest#, starting from 1; element value is the guest's invitor
    
    int num = Integer.parseInt(scan.next());

    for (int i=0; i<num-1; i++) 
         invBy.add(Integer.parseInt(scan.next()));  // No need the last one, which is the host "Mark" 

    buildGustComboList(gust_combo_list, num-1);   // build the list of all combinations of the guests #, excluding host. The total number is C(N,N)+C(N,N-1)+C(N,N-2)+... +C(N,1)
    //System.out.println(gust_combo_list);  // this is the entire list before applying "inviting logic"
    
    int n = 1;  // guest#, starting from 1
    for (Integer p: invBy) {
      if (p != num)
        enforceInvite(gust_combo_list, p, n);  // apply the "inviting logic", i.e. if A invite B, B must be on the same list whereever A present; otherwise, it is an invalid combination that must be removed from the result
      System.out.println("$$$ " + p + " => " + n);
      System.out.println(gust_combo_list);
      n++;
    }
    //System.out.println(invBy);
    gust_combo_list.add(new ArrayList<Integer>());  // add additional empty one, which means nobody get kicked out
    
    System.out.println("Different sets of people can be removed: " + gust_combo_list.size());
    System.out.println(gust_combo_list);
  }
  
}
