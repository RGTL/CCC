import java.util.*;
import java.io.*;

public class CCC_J2021_ArrangeBooks {
  
  
  public char[] bookOrder;
  public char[] bookFinal;
  
  public CCC_J2021_ArrangeBooks(char[] bookOrder) {
    this.bookOrder = bookOrder;
    bookFinal = new char[bookOrder.length];
    
    int pos = popuFinal('L', 0);
    pos = popuFinal('M', pos);
    popuFinal('S', pos);
  }
  
  public int popuFinal(char book, int pos) {
    for (char c : bookOrder) {
      if (c==book)
        bookFinal[pos++] = book;
    }
    return pos;
  }
  
  public int getMinSwap() {
    return getMinSwap(bookOrder, 0); 
  }
  
  public int getMinSwap(char[] curBookOrder, int cnt){
    //System.out.print("\n" + cnt + ": ");
    //for (char c : curBookOrder)
    //  System.out.print(c);
    
    int totalCnt = 100; 
    for (int i=0; i<curBookOrder.length; i++) {
      if (curBookOrder[i] != bookFinal[i]) {
        char curBook = curBookOrder[i];
        char rightBook = bookFinal[i];
        for (int j=i; j<curBookOrder.length; j++) {
          if (curBookOrder[j] != bookFinal[j] && curBookOrder[j] == rightBook) {  // got a swap candidate
            char[] tempBookOrder = curBookOrder.clone();  // have to use temp array, so the swap trial won't impact on next pair of swap candidate
            tempBookOrder[i]=rightBook;
            tempBookOrder[j]=curBook;  // swap 
            int newCnt = getMinSwap(tempBookOrder, cnt+1);  // continue swapping process
            if (newCnt < totalCnt)
              totalCnt = newCnt;  // get min count
          }
        }
        break; // break out loop, as long as triggered one, remaining will follow. No need to further check 
      }
    }
    if (totalCnt == 100) // all in order
      totalCnt = cnt;
    return totalCnt;
  }
    
  public static void main(String args[]) throws IOException {
    
    Scanner scan = new Scanner(System.in);
    String books = scan.next();
    
    CCC_J2021_ArrangeBooks ab = new CCC_J2021_ArrangeBooks(books.toCharArray());
        
    //for (char c : ab.bookFinal)
    //  System.out.print(c);
    
    System.out.println("\nMininum Swap: " + ab.getMinSwap());    
    
  }
  
  
}