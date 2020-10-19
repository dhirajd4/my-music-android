import static java.lang.Math.*;

class Resource
{
 char str[];

 Resource(int size)
 {
  str=new char[size];
 }

 synchronized void print(int index,char chr)
 {
  str[index]=chr;
  System.out.print("\r\t\t\t");
  System.out.print(str);
 }
}

class MyThd extends Thread
{
 char chr;
 int index;
 Resource res;

 MyThd(int index,char chr,Resource res)
 {
  this.index=index;
  this.chr=chr;
  this.res=res;

  start();
 }

 public void run()
 {
  int r;
  do
  {
   r=(int)(random()*1000)%75+48;
   res.print(index,(char)r);
   try
   {
    sleep(30);
   }
   catch(InterruptedException e){}
  }while(r!=chr);
 }

}

class CharacterMeter
{
 public static void main(String...arg) throws InterruptedException 
 {
  String str="DMATICS";

  if(arg.length>0) str=arg[0];

  Resource r=new Resource(str.length());

  System.out.println("\n");

  MyThd t[]=new MyThd[str.length()];
  for(int i=0;i<t.length;i++)
  {
   t[i]=new MyThd(i,str.charAt(i),r);
  }

  for(int i=0;i<t.length;i++)
  {
   t[i].join();
  }

  System.out.println("\n\ntask complete..\n");  
 }
}