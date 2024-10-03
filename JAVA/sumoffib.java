import java.util.*;
class Evensumfib 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter the value of N: ");
int n = sc.nextInt();
int a = 0, b = 1;
int sum = 0;
for (int i = 0; i <= n; i++) 
{
if (i % 2 == 0) 
{
sum += a; 
}
int next = a + b;
a = b;
b = next;
}
System.out.println("Sum of Fibonacci numbers at even indexes: " + sum);
}
}
