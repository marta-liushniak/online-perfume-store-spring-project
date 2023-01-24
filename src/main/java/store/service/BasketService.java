package store.service;

import store.model.Basket;
import store.model.Perfume;
import store.model.User;

public interface BasketService {
    void registerNewBasket(User user);

    void addPerfume(Perfume perfume, User user);

    Basket getByUser(User user);

    void clear(Basket basket);
}
