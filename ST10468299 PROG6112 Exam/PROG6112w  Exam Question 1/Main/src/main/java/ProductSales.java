/**
 * Implements methods to calculate total, average, max, and min sales.
 */
public class ProductSales implements IProductSales {

    @Override
    public int totalSales(int[][] productSales) {
        int total = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public double averageSales(int[][] productSales) {
        int total = totalSales(productSales);
        int count = 0;
        for (int[] year : productSales) {
            count += year.length;
        }
        return count == 0 ? 0 : (double) total / count;
    }

    @Override
    public int maxSale(int[][] productSales) {
        int max = Integer.MIN_VALUE;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > max) max = sale;
            }
        }
        return max;
    }

    @Override
    public int minSale(int[][] productSales) {
        int min = Integer.MAX_VALUE;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale < min) min = sale;
            }
        }
        return min;
    }
}

