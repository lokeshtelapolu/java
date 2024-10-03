public class LcmGcd {
    public static void main(String[] args) {
        int a=5,b=10,gcd;
        if(a>b){
            gcd=a/b;
            System.out.println(gcd);
        }
        else{
            gcd=b/a;
            System.out.println(gcd);
        }
        int lcm=a*b/gcd;
        System.out.print(lcm);
    }
}
