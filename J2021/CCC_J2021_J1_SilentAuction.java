import java.util.*;
import java.io.*;

public class CCC_J2021_J1_SilentAuction {
  
  private class Bidder {
    String name;
    int bid;
    
    public Bidder(String name, int bid) {
      this.name = name;
      this.bid = bid;
    }
  }
  
  List<Bidder> bidderList = new ArrayList<Bidder>();
  
  public void addBidder(String name, int bid) {
      bidderList.add(bidderList.size(), new Bidder(name, bid));
  }
  
  public String getHighestBidder() {
    int topbid = 0;
    String topBidder="";
    for(Bidder bidder : bidderList) {
      if (bidder.bid > topbid) {
        topbid = bidder.bid;
        topBidder = bidder.name;
      }
    }
    return topBidder;    
  }
  
  public int getSeaLevel(int temp) {
    if (temp==100) return 0;
    else
      return (100 > temp) ? 1: -1;
  }
  
  public static void main(String args[]) throws IOException {
    
    CCC_J2021_J1_SilentAuction sa = new CCC_J2021_J1_SilentAuction();
  
    Scanner scan = new Scanner(System.in);
    System.out.println("Number of bids: ");
    int bids = Integer.parseInt(scan.next());
    for (int i = 0; i< bids; i++ ) {
        System.out.println("Name Amount: ");
        String name = scan.next();
        int bid = Integer.parseInt(scan.next());
        sa.addBidder(name, bid);
    }
    System.out.println("Highest Bidder: " + sa.getHighestBidder());
    
  }
  
  
}