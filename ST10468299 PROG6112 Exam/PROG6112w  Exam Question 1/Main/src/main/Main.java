/**
 * Entry-point: generates and displays the product sales report.
 */
public class Main {
    public static void main(String[] args) {
        // Product sales data: 2 years, 3 quarters each
        int[][] productSales = {
            {300, 150, 700}, // Year 1: Q1, Q2, Q3
            {250, 200, 600}  // Year 2: Q1, Q2, Q3
        };

        IProductSales sales = new ProductSales();

        int total = sales.totalSales(productSales);
        double average = sales.averageSales(productSales);
        int max = sales.maxSale(productSales);
        int min = sales.minSale(productSales);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("------------------------------");
        System.out.printf("Total sales   : %d%n", total);
        System.out.printf("Average sales : %d%n", Math.round(average));
        System.out.printf("Maximum sale  : %d%n", max);
        System.out.printf("Minimum sale  : %d%n", min);
        System.out.println("------------------------------");
    }
}
