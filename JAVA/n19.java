public class n19{
    public static void main(String[] args){
        int a,b,i,j;
        a=1;
        b=3;
        for(i=1;i<=b;i++){
            for(j=1;j<=i;j++){
                System.out.print(a);
            }
            System.out.println();
        }
         for(i=b-1;i>=1;i--){
            for(j=1;j<=i;j++){
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
