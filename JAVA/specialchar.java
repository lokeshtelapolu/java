import java.util.*;
class Special
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("enter the statement:");
String input=sc.nextLine();
String specialcharacters="";
int count=0;
for(int i=0;i<input.length();i++)
{
char c=input.charAt(i);
if(!Character.isLetterOrDigit(c) && !Character.isWhitespace(c))
 {
specialcharacters+=c;
count++;
}
}
System.out.println("Special Characters:" +specialcharacters);
System.out.println("Number of Special Characters:" +count);

}
}