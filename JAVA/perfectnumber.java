import java.util.*;
class perfect
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("enter the number: ");
int num=sc.nextInt();
int sum=0;
for(int i=1;i<=num/2;i++)
{
if(num%i==0)
{
sum=sum+i;
}
}
if(sum==num){
System.out.print("perfect number");
}else{
System.out.print("not perfect number");
}
}
}