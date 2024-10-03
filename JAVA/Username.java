import java.util.Scanner;
class UsernameValidator 
{
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a username: ");
String username = scanner.nextLine();
if (username.length() >= 3 && username.length() <= 15 && username.matches("[a-zA-Z0-9]+")) 
{
System.out.println("Username is valid.");
} else {
System.out.println("Username is invalid.");
}
scanner.close();
}
}