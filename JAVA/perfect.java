class perfect{
    public static void main(String args[]){
        int n=6;
        int sum=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum+=i;
            }
           
        }
         if(sum==n){
            System.out.print("perfect number.");
            }
            else{
            System.out.print("not perfect");
            }
    }
}