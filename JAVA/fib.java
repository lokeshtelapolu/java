class fib{
    public static void main(String args[]){
        int n=10;
        int a=0,b=1;
        int c;
        System.out.print(a+" "+b+ " ");
        for(int i=1;i<=n;i++){
          c=a+b;
          a=b;
          b=c;
                  System.out.print(c+ " ");
        }
    }
}