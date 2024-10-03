class fibevensum{
    public static void main(String args[]){
        int n=10;
        int a=0,b=1;
        int c;
        int even_sum=0;
        System.out.print(a+" "+b+ " ");
        for(int i=1;i<=n;i++){
          c=a+b;
          a=b;
          b=c;
                  System.out.print(c+ " ");
                  if(c%2==0){
                      even_sum+=i;
                  }
        }System.out.println();
        System.out.println("even_sum:"+even_sum);
    }
}