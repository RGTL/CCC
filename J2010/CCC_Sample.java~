/*  Canadian Computing Competition

    Example program to demonstrate input and output and time limit.

    Programming Language:  Java

    Specification:

       Write a program that reads several positive integers, one per
       line.  For each integer n, output the number of orderings 
       possible for a set of n distinct values.  n will not exceed 11.
       The last line of input is indicated by 0.

    Sample Input:

       1
       11
       0

    Output for Sample Input:

       1
       39916800

    Implementation:

       The answer is n! (n factorial) which is easily computed in n steps.
       But this program does it the hard way.  It uses a recursive function 
       to enumerate and count all the possible orderings.

    How to run the program:

       The program reads from "standard input" and writes to "standard output."
       Specifically, after compiling (i.e., creating Main.class), you
       can run this program with input by typing at the DOS command prompt
       (yes, you will need a Command Prompt window) in the correct
       directory (where you created the Main.class file):
                 java Main < input.txt
       where input.txt contains the test data.  

    Run-time:

       Please time the execution time of this program on your computer, 
       using the sample input.  This time is the maximum that should be
       allowed for any CCC program.

*/

import java.util.*;
import java.io.*;

public class Main {
public static int countfact(int s[], int n, int total){
   int i,r=0;
   if (n == 0)  {
      /* uncomment to print out each ordering */

     /* 
     for (int j=0; j<total; j++) System.out.print(""+s[j]+" ");
     System.out.println();
     */
     return 1;
   }

   for (i=0; i< n; i++) {
      int t = s[i];
      s[i] = s[n-1];
      s[n-1] = t;
      r += countfact(s,n-1, total);
      s[n-1] = s[i];
      s[i] = t;
   }
   return r;
}

public static void main(String args[]) throws IOException {
   int i,n;
   int[] set = new int[11];

   Scanner scan = new Scanner(System.in); 

   // initialize the set of values
   for (i=0; i < 11; i++) set[i] = i+1;
   n = 1;
   while (n > 0) {  // 0 would do nothing, and -1 is nothing to read
      n = scan.nextInt(); 
      if (n> 0) System.out.println(""+countfact(set,n,n));
   }
}
}
