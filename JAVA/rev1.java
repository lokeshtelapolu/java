import java.util.Scanner;
public class reverse{
public static void main(String[] args){
Scanner input=new Scanner(System.in);
System.out.println("enter a number");
int n,digit,rem=0;
n=input.nextInt();
while(n!=0){
digit=n%10;
rem=rem*10+digit;
n=n/10;
}
System.out.println(rem);
}
}