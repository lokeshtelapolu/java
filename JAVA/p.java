public class p{
    public static void main(String[] args){
        int a=5;
        int i,j,k;
        for(i=a;i>=1;i--){
            for(j=i;j<a;j++){
                System.out.print(" ");
            }
            for(k=1;k<=2*i-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}