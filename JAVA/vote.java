import java.util.*;
class vote 
{
public static void main(String[] args) 
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter a age: ");
int age = sc.nextInt();
int sum=0;
int diff=0;
if(age<18){
sum=18-age;
System.out.print("a person will vote after: "+sum);
}else{
diff=age-18;
System.out.print("a person started to vote since: "+diff);
}
}
}
        