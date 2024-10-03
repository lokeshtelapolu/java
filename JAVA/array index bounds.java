public class S {
    public static void main(String[] args) {
        int n = 4; 
        int[] numbers = {1, 2, 3, 4, 5}; 
        int sum = 0;
        try {
            for (int i = 0; i <= n; i++) {
                sum += numbers[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds! Loop index exceeded array size.");
        }
        System.out.println("Sum of the numbers (before exception): " + sum);
    }
}