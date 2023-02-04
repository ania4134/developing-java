package developing.tasks.dev.skill.challenge;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class OrdersAnalyzerTest {

    @Test
    public void AnalyzerTest() {
        //given
        OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();
        OrdersAnalyzer.OrderLine orderLine1 = new OrdersAnalyzer.OrderLine();
        List<OrdersAnalyzer.Order> orderList = new ArrayList<>();
        OrdersAnalyzer.Order order = new OrdersAnalyzer.Order();
        orderLine1.quantity = 3;
        orderLine1.productId = 4134;
        orderLine1.name = "creme";
        orderLine1.unitPrice = new BigDecimal(44);
        order.orderLines = new ArrayList<>();
        order.orderLines.add(orderLine1);
        order.orderId = 567;
        order.creationDate = LocalDateTime.now();
        orderList.add(order);

        //when & then
        ordersAnalyzer.totalDailySalesAi(4134, orderList);
    }
}