//manual exxception handler and custom handling

import java.util.Scanner;

class ManualEx
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

  try
  {
   q=n/d;
   if(d==0)
    throw new ArithmeticException();
   if(d>n)
    throw new IndexOutOfBoundsException("denominator is larger..");
 
   System.out.println("\noperation successful..\n");
  }
  catch(ArithmeticException e)
  {
   System.err.println();
   System.err.println(e);
   System.err.println("alert  : "+e.getMessage());
   System.err.println("cause  : "+e.getCause());
   System.err.println("stack trace - ");
   System.err.println();
   e.printStackTrace();
   q=0;
  }

  catch(IndexOutOfBoundsException e)
  {
   System.err.println();
   System.err.println(e);
   System.err.println("alert  : "+e.getMessage());
   System.err.println("cause  : "+e.getCause());
   System.err.println("stack trace - ");
   System.err.println();
   e.printStackTrace();
   q=-1;
  }
  
  System.out.println("\nResult : "+q+"\n");
 }
}