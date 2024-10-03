public class R192224105 {
    public static void main(String[] args) {
        String z = "0101";
        int decimal = 0;
        int base = 1;
        for (int i = 0; i < z.length(); i++) {
            if (z.charAt(i) == '1') {
                decimal += base;
            }
            base *= 2;
        }
        System.out.println("Decimal of Reversed Binary: " + decimal);
    }
}
