public class reverse {
    public static void main(String[] args){
       int n,rem=0,digit;
       n=123456;
       while(n!=0){
        digit=n%10;
        rem=rem*10+digit;
        n=n/10;
       } 
       System.out.println(rem);
    }
}