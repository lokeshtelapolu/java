public class squarepattern{
    public static void main(String[] args){
        int i,j,n,s;
        n=5;
        s=1;
        for(i=1;i<=n;i++){
            for(j=1;j<=i;j++){
                System.out.print(s*s+" ");
                s++;
            }
            System.out.println();
        }
    }
}