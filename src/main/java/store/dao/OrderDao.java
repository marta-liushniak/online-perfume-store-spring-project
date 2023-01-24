package store.dao;

import java.util.List;
import store.model.Order;
import store.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrderHistory(User user);
}
