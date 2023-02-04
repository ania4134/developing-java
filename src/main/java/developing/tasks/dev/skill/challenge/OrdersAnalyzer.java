package developing.tasks.dev.skill.challenge;

//1. Implement OrdersAnalyzer#totalDailySales method that  for passed orders will return a map  with a DayOfWeek as
// a key and a sum of ordered  quantity for a given product id as a value.
//2. The method should always return a map. If there are no orders for passed productId for some weekday, there might
// be no entry in the resulting map or there might be an entry with a 0 value.

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrdersAnalyzer {

    static class Order {
        int orderId;
        LocalDateTime creationDate;
        List<OrderLine> orderLines;
    }

    static class OrderLine {
        int productId;
        String name;
        int quantity;
        BigDecimal unitPrice;
    }

    public Map<DayOfWeek, Integer> totalDailySalesAi(int productId, List<OrdersAnalyzer.Order> orders) {
        Map<DayOfWeek, Integer> totalSalesPerDay = new HashMap<>();
        for (OrdersAnalyzer.Order order : orders) {
            for (OrdersAnalyzer.OrderLine orderLine : order.orderLines) {
                if (orderLine.productId == productId) {
                    DayOfWeek dayOfWeek = order.creationDate.getDayOfWeek();
                    totalSalesPerDay.put(dayOfWeek, totalSalesPerDay.getOrDefault(dayOfWeek, 0) + orderLine.quantity);
                }
            }
        }
        System.out.println(totalSalesPerDay);
        return totalSalesPerDay;
    }

    public Map<DayOfWeek, Integer> totalDailySales(int productIds, List<Order> orders) {
        Map<DayOfWeek, Integer> resultMap = new HashMap<>();
        resultMap.put(DayOfWeek.MONDAY, calculateSumOfQuantity(DayOfWeek.MONDAY, productIds, orders));
        resultMap.put(DayOfWeek.TUESDAY, calculateSumOfQuantity(DayOfWeek.TUESDAY, productIds, orders));
        resultMap.put(DayOfWeek.WEDNESDAY, calculateSumOfQuantity(DayOfWeek.WEDNESDAY, productIds, orders));
        resultMap.put(DayOfWeek.THURSDAY, calculateSumOfQuantity(DayOfWeek.THURSDAY, productIds, orders));
        resultMap.put(DayOfWeek.FRIDAY, calculateSumOfQuantity(DayOfWeek.FRIDAY, productIds, orders));
        resultMap.put(DayOfWeek.SATURDAY, calculateSumOfQuantity(DayOfWeek.SATURDAY, productIds, orders));
        resultMap.put(DayOfWeek.SUNDAY, calculateSumOfQuantity(DayOfWeek.SUNDAY, productIds, orders));
        return new HashMap<>(resultMap);
    }

    public Integer calculateSumOfQuantity(DayOfWeek dayOfWeek, int productIds, List<Order> orders) {
        return  orders.stream()
                .filter(y -> y.creationDate.getDayOfWeek() == dayOfWeek)
                .flatMap(d -> d.orderLines.stream())
                .filter(r -> r.productId == productIds)
                .collect(Collectors.summingInt(f -> f.quantity)); // strumien zle liczy
    }
}
