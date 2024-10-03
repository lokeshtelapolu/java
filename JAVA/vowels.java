import java.util.*;
class vowelcounter
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("enther the statement:");
String input=sc.nextLine();
int vowelcount=0;
for(int i=0;i<input.length();i++)
{
char c=input.charAt(i);
if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' )
{
vowelcount++;
}
}
System.out.print("number of vowels: "+vowelcount);
}
}