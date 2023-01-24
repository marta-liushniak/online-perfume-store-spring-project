package store.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import store.dao.OrderDao;
import store.model.Basket;
import store.model.Order;
import store.model.User;
import store.service.BasketService;
import store.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final BasketService basketService;

    public OrderServiceImpl(OrderDao orderDao, BasketService basketService) {
        this.orderDao = orderDao;
        this.basketService = basketService;
    }

    @Override
    public Order completeOrder(Basket basket) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setChosen(basket.getChosen());
        order.setUser(basket.getUser());
        orderDao.add(order);
        basketService.clear(basket);
        return order;
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }
}
