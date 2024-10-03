import java.util.*;
class M 
{
public static void main(String[] args) 
{
Scanner input = new Scanner(System.in);
System.out.print("Enter the number of elements in the array: ");
int n = input.nextInt();
int[] a = new int[n];
System.out.println("Enter the elements of the array:");
for (int i = 0; i < n; i++) 
{
a[i] = input.nextInt();
}
int sum = 0;
for (int i = 0; i < n; i++) 
{
sum += a[i];
}
double mean = (double) sum / n;
System.out.println("Mean: " + mean);
Arrays.sort(a);
double median;
if (n % 2 == 0) 
{
median = (a[n / 2 - 1] + a[n / 2]) / 2.0;
} else {
median = a[n / 2];
}
System.out.println("Median: " + median);
int maxCount = 0;
int mode = a[0];
int currentCount = 1;
for (int i = 1; i < n; i++) 
{
if (a[i] == a[i - 1]) 
{
currentCount++;
} else {
if (currentCount > maxCount) 
{
maxCount = currentCount;
mode = a[i - 1];
}
currentCount = 1;
}
}
if (currentCount > maxCount) 
{
maxCount = currentCount;
mode = a[n - 1];
}
System.out.println("Mode: " + mode);
}
}