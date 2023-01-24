package store.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import store.dao.AbstractDao;
import store.dao.PerfumeDao;
import store.model.Perfume;

@Repository
public class PerfumeDaoImpl extends AbstractDao<Perfume> implements PerfumeDao {
    public PerfumeDaoImpl(SessionFactory factory) {
        super(factory, Perfume.class);
    }
}
