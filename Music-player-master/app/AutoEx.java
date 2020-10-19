//Automatic exception generation and automatic handling

import java.util.Scanner;

class AutoEx
{
 public static void main(String...arg)
 {
  Scanner sc=new Scanner(System.in);
  int n,d,q;
  System.out.println();
  System.out.print("enter numerator   : ");
  n=sc.nextInt();
  System.out.print("enter denominator : ");
  d=sc.nextInt();
  q=n/d;
  System.out.println("\nResult : "+q+"\n");
 }
}