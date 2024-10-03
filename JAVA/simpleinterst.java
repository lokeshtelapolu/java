import java.util.*;
class Simple 
{
public static float calculateSimpleInterest(float principal, int years, boolean isSeniorCitizen) 
{
if (principal <= 0 || years <= 0) 
{
return 0; 
}
float rateOfInterest = isSeniorCitizen ? 12.0f : 10.0f;
float si = (principal * rateOfInterest * years) / 100;
return si;
}
public static void main(String[] args) 
{
Scanner input = new Scanner(System.in);
System.out.print("Enter the principal amount: ");
float principal = input.nextFloat();
System.out.print("Enter the number of years: ");
int years = input.nextInt();
System.out.print("Is customer senior citizen (y/n): ");
char seniorCitizen = input.next().charAt(0);
boolean isSeniorCitizen = (seniorCitizen == 'y' || seniorCitizen == 'Y');
float interest = calculateSimpleInterest(principal, years,isSeniorCitizen);
System.out.println("Interest: " + interest);
}
}