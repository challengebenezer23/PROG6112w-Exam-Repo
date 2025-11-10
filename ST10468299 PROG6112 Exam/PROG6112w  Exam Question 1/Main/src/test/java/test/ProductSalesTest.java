package test;

import com.localretail.ProductSales;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for ProductSales functionality.
 */
public class ProductSalesTest {
    private int[][] productSalesData;
    private ProductSales productSales;

    @Before
    public void setUp() {
        productSalesData = new int[][]{
            {300, 150, 700},
            {250, 200, 600}
        };
        productSales = new ProductSales();
    }

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        int expected = 2200;
        assertEquals(expected, productSales.totalSales(productSalesData));
    }

    @Test
    public void AverageSales_ReturnAverageProductSales() {
        double expected = 2200.0 / 6;
        assertEquals(expected, productSales.averageSales(productSalesData), 0.001);
    }

    @Test
    public void MaxSale_ReturnsMaximumSale() {
        int expected = 700;
        assertEquals(expected, productSales.maxSale(productSalesData));
    }

    @Test
    public void MinSale_ReturnsMinimumSale() {
        int expected = 150;
        assertEquals(expected, productSales.minSale(productSalesData));
    }
}

