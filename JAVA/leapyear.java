import java.util.*;
class Leap 
{
public static void main(String[] args) 
{
Scanner input = new Scanner(System.in);
System.out.print("Enter Year (yyyy): ");
int year = input.nextInt();
if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) 
{
System.out.println("Given year is a Leap Year");
} else {
System.out.println("Given year is Non Leap Year");
}
}
}
