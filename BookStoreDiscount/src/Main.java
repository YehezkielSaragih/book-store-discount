import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Title
        System.out.println("Book Store Discount");

        // Open scanner
        Scanner inputScanner = new Scanner(System.in);

        // Initialization
        // Initialization
        String[] categories = new String[5];
        double[] pricesBefore = new double[5];
        double[] pricesAfter = new double[5];
        double discountPercentage;
        double totalBeforeDiscount = 0.0;
        double totalAfterDiscount = 0.0;

        // Logic
        for (int i = 0; i < 5; i++) {

            System.out.println("\nProduk "+(i+1));

            // Input
            System.out.print("Enter category name = ");
            categories[i] = inputScanner.nextLine().toLowerCase();
            try {
                System.out.print("Enter price for " + categories[i] + " = ");
                pricesBefore[i] = inputScanner.nextDouble();
                inputScanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Price must be a number!");
                inputScanner.close();
                return;
            }

            // Disc
            discountPercentage = switch (categories[i]) {
                case "novel" -> 0.10;
                case "komik" -> 0.05;
                case "ensiklopedia" -> 0.20;
                default -> 0.0;
            };
            pricesAfter[i] = pricesBefore[i] - (pricesBefore[i] * discountPercentage);

            // Add to totals
            totalBeforeDiscount += pricesBefore[i];
            totalAfterDiscount += pricesAfter[i];
        }

        // Print
        System.out.println("\nReport\n");
        System.out.println("Items Before & After Discount:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s = Rp %,.2f > Rp %,.2f\n",
                    categories[i],
                    pricesBefore[i],
                    pricesAfter[i]);
        }
        System.out.printf("\nTotal Before Discount = Rp %,.2f\n", totalBeforeDiscount);
        System.out.printf("Total After Discount  = Rp %,.2f\n", totalAfterDiscount);

        // Close scanner
        inputScanner.close();
    }
}