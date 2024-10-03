import java.util.*;
class num
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("enther the number of rows n:");
int n=sc.nextInt();
for(int i=1;i<=n;i++)
{
for(int j=1;j<=i;j++)
{
System.out.print(i +" ");
}
System.out.println();
}
}
}
 