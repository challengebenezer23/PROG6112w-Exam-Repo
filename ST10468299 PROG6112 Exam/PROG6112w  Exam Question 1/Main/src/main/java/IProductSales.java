/**
 * Interface defining operations for product sales statistics.
 */
public interface IProductSales {
    int totalSales(int[][] productSales);
    double averageSales(int[][] productSales);
    int maxSale(int[][] productSales);
    int minSale(int[][] productSales);
}

