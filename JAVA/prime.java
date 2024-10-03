public class p{
    public static void main(String[]args){
        int n=5,i,count=0;
        for(i=1;i<=n ;i++){
            if(n%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.print("prime");
        }
        else{
            System.out.print("not");
        }
    }
}