import java.util.*;
public class Reverse
{
   public static void main(String args[])
   {
      int rev=0;
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter a number:");
      int num=sc.nextInt();
      while(num!=0)
      {
         int lastdigit=num%10;
         rev=rev*10+lastdigit;
         num=num/10;
      }
      System.out.print("The Reverse of a number is:"+rev);
   }
}