package product;

public interface IProductSales {
    int[][] GetProductSales();
    int GetTotalSales();
    int GetSalesOverLimit(int limit);
    int GetSalesUnderLimit(int limit);
    int GetProductProcessed();
    double GetAverageSales();
}
