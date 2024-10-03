import java.util.Arrays;
import java.util.Scanner;

public class R192224105 {
    public static void main(String[] args) {
        int[] arr = {14, 67, 48, 23, 5, 62};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();
        Arrays.sort(arr);         // Sort the array in descending order
            System.out.println(N + "th Largest number: " + arr[arr.length - N]);
    }
}