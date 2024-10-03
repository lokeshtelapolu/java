import java.util.*;
class I 
{
public static void main(String[] args) 
{
Scanner sc= new Scanner(System.in);
System.out.print("enter the value of n:");
int n = sc.nextInt();  
for (int i = n; i >= 1; i--) 
{
for (int j = 0; j < n - i; j++) 
{
System.out.print(" ");
}
for (int k = 1; k <= i; k++) 
{
System.out.print(" *");
}
System.out.println();
}
}
}
