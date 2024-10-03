import java.util.Scanner;
class Matrixadd 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter elements of 2x2 Matrix 1:");
int[][] mat1 = new int[2][2];
for (int i = 0; i < 2; i++) 
{
for (int j = 0; j < 2; j++) 
{
mat1[i][j] = sc.nextInt();
}
}
System.out.println("Enter elements of 2x2 Matrix 2:");
int[][] mat2 = new int[2][2];
for (int i = 0; i < 2; i++) 
{
for (int j = 0; j < 2; j++) 
{
mat2[i][j] = sc.nextInt();
}
}
int[][] result = new int[2][2];
for (int i = 0; i < 2; i++) 
{
for (int j = 0; j < 2; j++) 
{
result[i][j] = mat1[i][j]+ mat2[i][j];
}
}
System.out.println("Result of Matrix Multiplication:");
for (int i = 0; i < 2; i++) 
{
for (int j = 0; j < 2; j++) 
{
System.out.print(result[i][j] + " ");
}
System.out.println();
}
}
}
