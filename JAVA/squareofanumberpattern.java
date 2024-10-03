import java.util.*;
class numb
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("enther the number of rows n:");
int n=sc.nextInt();
int number=1;
for(int i=1;i<=n;i++)
{
for(int j=1;j<=i;j++)
{
System.out.print((number * number) + " ");
number++;
}
System.out.println();
}
}
}
 