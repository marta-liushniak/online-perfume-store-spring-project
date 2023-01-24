package store.service;

import java.util.List;
import store.model.Perfume;

public interface PerfumeService {
    Perfume add(Perfume perfume);

    Perfume get(Long id);

    List<Perfume> getAll();
}
