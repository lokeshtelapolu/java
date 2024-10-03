class overload{
    private int v1;
    private int v2;
    public void assign(int a){
        v1=a;
        v2=0;
    }
    public void assign(int a,int b){
        v1=a;
        v2=b;
    }
    public void display(){
        System.out.println("value1:"+ v1);
        System.out.println("value2:"+ v2);
    }
    public static void main(String[] args){
        overload obj=new overload();
        obj.assign(8);
        obj.display();
        obj.assign(12,36);
        obj.display();
    }
}