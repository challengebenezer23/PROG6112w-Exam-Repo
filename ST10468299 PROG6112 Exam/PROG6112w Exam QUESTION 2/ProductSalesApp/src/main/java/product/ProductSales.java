package product;

public class ProductSales implements IProductSales {
    private final int[][] sales;
    
    // Sample sales data for 2 years with 3 products: Microphone, Speakers, Mixing Desk
    // sales[year][product]
    // Year 1: Microphone: 300, Speakers: 150, Mixing Desk: 700
    // Year 2: Microphone: 250, Speakers: 200, Mixing Desk: 600
    public ProductSales() {
        sales = new int[][] {
            {300, 150, 700},
            {250, 200, 600}
        };
    }

    @Override
    public int[][] GetProductSales() {
        return sales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] yearSales : sales) {
            for (int s : yearSales) total += s;
        }
        return total;
    }

    @Override
    public int GetSalesOverLimit(int limit) {
        int count = 0;
        for (int[] yearSales : sales) {
            for (int s : yearSales) if (s > limit) count++;
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit(int limit) {
        int count = 0;
        for (int[] yearSales : sales) {
            for (int s : yearSales) if (s < limit) count++;
        }
        return count;
    }

    @Override
    public int GetProductProcessed() {
        return sales.length;
    }

    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = sales.length * sales[0].length;
        return (double) total / count;
    }
}




