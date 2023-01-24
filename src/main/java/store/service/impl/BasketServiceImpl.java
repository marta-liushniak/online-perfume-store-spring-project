package store.service.impl;

import org.springframework.stereotype.Service;
import store.dao.BasketDao;
import store.dao.ChosenDao;
import store.model.Basket;
import store.model.Chosen;
import store.model.Perfume;
import store.model.User;
import store.service.BasketService;

@Service
public class BasketServiceImpl implements BasketService {
    private final BasketDao basketDao;
    private final ChosenDao chosenDao;

    public BasketServiceImpl(BasketDao basketDao, ChosenDao chosenDao) {
        this.basketDao = basketDao;
        this.chosenDao = chosenDao;
    }

    @Override
    public void registerNewBasket(User user) {
        Basket basket = new Basket();
        basket.setUser(user);
        basketDao.add(basket);
    }

    @Override
    public void addPerfume(Perfume perfume, User user) {
        Chosen chosen = new Chosen();
        chosen.setPerfume(perfume);
        chosen.setUser(user);
        Basket basket = basketDao.getByUser(user);
        chosenDao.add(chosen);
        basket.getChosen().add(chosen);
        basketDao.update(basket);
    }

    @Override
    public Basket getByUser(User user) {
        return basketDao.getByUser(user);
    }

    @Override
    public void clear(Basket basket) {
        basket.setChosen(null);
        basketDao.update(basket);
    }
}
