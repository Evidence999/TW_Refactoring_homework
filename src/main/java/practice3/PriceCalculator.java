package practice3;

import java.math.BigDecimal;
import java.util.List;
import static java.util.Arrays.asList;

public class PriceCalculator {
    private BigDecimal subTotal;
    private BigDecimal tax;
    private BigDecimal grandTotal;
    private Order order;

    public PriceCalculator(Order order) {
        this.order = order;
        this.tax = new BigDecimal(0.1);
    }

    public BigDecimal compute() {
        BigDecimal subTotal = new BigDecimal(0);
        List<OrderLineItem> orderLineItemList = order.getItemList();
        List<BigDecimal> discounts = order.getDiscounts();

        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }

        for (BigDecimal discount : discounts) {
            subTotal = subTotal.subtract(discount);
        }

        BigDecimal tax = subTotal.multiply(this.tax);
        return subTotal.add(tax);
    }
}
