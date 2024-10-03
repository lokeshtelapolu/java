
import java.util.*;
class compositebetweenrange
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the start point");
int m=sc.nextInt();
System.out.println("Enter the end point");
int n=sc.nextInt();
int a=m+1;
System.out.println("The composite numbers between the give range are : ");
for(int i=m+1;i<n;i++)
{
int count=0;
for(int j=1;j<=i;j++)
{
if(a%j==0)
{
count++;
}
}
if(count>2)
{
System.out.print(a+" ");
}
a++;
}
}
}