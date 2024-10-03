import java.util.*;
class Stringtointeger
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string of digits:");
String input = sc.nextLine();
int number = 0;
for(int i=0; i<input.length();i++)
{
number=number*10+(input.charAt(i)-'0');
}
System.out.println("integer:"+number);
}
}