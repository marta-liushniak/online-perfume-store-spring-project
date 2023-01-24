package store.service;

import java.util.List;
import store.model.Basket;
import store.model.Order;
import store.model.User;

public interface OrderService {
    Order completeOrder(Basket basket);

    List<Order> getOrderHistory(User user);
}
