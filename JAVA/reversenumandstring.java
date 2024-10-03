import java.util.*;
class ReverseNumber 
{
public static void main(String[] args) 
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter a number: ");
String input = sc.nextLine();
StringBuilder reversedInput = new StringBuilder();
for (int i = input.length() - 1; i >= 0; i--) 
{
reversedInput.append(input.charAt(i));
}
System.out.println("Reversed Number: " + reversedInput.toString());
}
}
