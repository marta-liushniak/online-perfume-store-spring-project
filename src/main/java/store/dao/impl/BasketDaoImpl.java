package store.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import store.dao.AbstractDao;
import store.dao.BasketDao;
import store.exception.DataProcessingException;
import store.model.Basket;
import store.model.User;

@Repository
public class BasketDaoImpl extends AbstractDao<Basket> implements BasketDao {
    public BasketDaoImpl(SessionFactory factory) {
        super(factory, Basket.class);
    }

    @Override
    public Basket getByUser(User user) {
        try (Session session = factory.openSession()) {
            Query<Basket> getByUser = session.createQuery(
                    "SELECT DISTINCT b FROM Basket b "
                            + "left join fetch b.chosen ch "
                            + "left join fetch ch.perfume "
                            + "WHERE b.user = :user", Basket.class);
            getByUser.setParameter("user", user);
            return getByUser.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't found basket of user " + user, e);
        }
    }
}
