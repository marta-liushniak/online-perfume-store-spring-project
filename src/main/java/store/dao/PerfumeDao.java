package store.dao;

import java.util.List;
import java.util.Optional;
import store.model.Perfume;

public interface PerfumeDao {
    Perfume add(Perfume perfume);

    Optional<Perfume> get(Long id);

    List<Perfume> getAll();
}
