package store.dao;

import store.model.Basket;
import store.model.User;

public interface BasketDao {
    Basket add(Basket basket);

    void update(Basket basket);

    Basket getByUser(User user);
}
