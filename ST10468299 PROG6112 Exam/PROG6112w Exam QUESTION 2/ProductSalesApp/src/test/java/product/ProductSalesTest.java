package product;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    @Test
    public void testTotalSales() {
        ProductSales sales = new ProductSales();
        assertEquals(300+150+700+250+200+600, sales.GetTotalSales());
    }

    @Test
    public void testAverageSales() {
        ProductSales sales = new ProductSales();
        double avg = (double)(300+150+700+250+200+600) / 6;
        assertEquals(avg, sales.GetAverageSales(), 0.01);
    }

    @Test
    public void testYearsProcessed() {
        ProductSales sales = new ProductSales();
        assertEquals(2, sales.GetProductProcessed());
    }

    @Test
    public void testSalesOverLimit() {
        ProductSales sales = new ProductSales();
        assertEquals(3, sales.GetSalesOverLimit(500)); // 700, 600 in mixing desks, 700 in year 1
    }

    @Test
    public void testSalesUnderLimit() {
        ProductSales sales = new ProductSales();
        assertEquals(3, sales.GetSalesUnderLimit(500)); // microphones & speakers all sales < 500
    }
}


















