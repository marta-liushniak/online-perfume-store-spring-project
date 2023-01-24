package store.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import store.dao.PerfumeDao;
import store.model.Perfume;
import store.service.PerfumeService;

@Service
public class PerfumeServiceImpl implements PerfumeService {
    private final PerfumeDao perfumeDao;

    public PerfumeServiceImpl(PerfumeDao perfumeDao) {
        this.perfumeDao = perfumeDao;
    }

    @Override
    public Perfume add(Perfume perfume) {
        return perfumeDao.add(perfume);
    }

    @Override
    public Perfume get(Long id) {
        return perfumeDao.get(id).orElseThrow(
                () -> new RuntimeException("Can't get perfume by id " + id));
    }

    @Override
    public List<Perfume> getAll() {
        return perfumeDao.getAll();
    }
}
