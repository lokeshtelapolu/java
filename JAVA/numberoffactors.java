1import java.util.*;
class factors
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("enter the number: ");
int num=sc.nextInt();
int count=0;
for(int i=1;i<=num;i++)
{
if(num%i==0)
{
count++;
}
}
System.out.print("number of factors: "+count);
}
}