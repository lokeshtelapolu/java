public class btod{
    public static void main(String[] args){
        int n=12;
      String b=Integer.toBinaryString(n);
      System.out.println(b);
      String r=new StringBuilder(b).reverse().toString();
      System.out.print(r);
}
}