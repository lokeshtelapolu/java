import java.util.*;
class removevowel
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("enther the statement:");
String input=sc.nextLine();
System.out.println("String after removing the vowels :");
for(int i=0;i<input.length();i++)
{
char c=input.charAt(i);
if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' )
{
continue;
}else{
System.out.print(c);
}
}
}
}