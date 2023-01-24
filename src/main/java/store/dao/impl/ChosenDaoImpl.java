package store.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import store.dao.AbstractDao;
import store.dao.ChosenDao;
import store.model.Chosen;

@Repository
public class ChosenDaoImpl extends AbstractDao<Chosen> implements ChosenDao {
    public ChosenDaoImpl(SessionFactory factory) {
        super(factory, Chosen.class);
    }
}
