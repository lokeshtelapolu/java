class Armstrong
{
public static void main(String args[])
{
int n,s,x,r;
n=10;
s=0;
while(n!=0)
{
r=n%10;
x=r*r*r;
s=s+x;
n=n/10;
}
if(s==n)
{
System.out.println("The given number is an armstrong number ");
}
else
{
System.out.println("The given number is not an armstrong number ");
}
}
}
