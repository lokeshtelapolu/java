public class word{
    public static void main(String[] args){
        String a="java";
String n="";
int len=a.length();
for(int i=len-1;i>=0;i--){
    n+=a.charAt(i);
       }
System.out.print(n);
    }
}
