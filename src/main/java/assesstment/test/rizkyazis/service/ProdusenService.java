package assesstment.test.rizkyazis.service;

import assesstment.test.rizkyazis.dao.ProdusenDao;
import assesstment.test.rizkyazis.dto.ProdusenDto;
import assesstment.test.rizkyazis.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProdusenService {

    @Autowired
    private ProdusenDao dao;

    public Optional<Produsen> findId(Integer id) throws EmptyResultDataAccessException {
        return dao.findById(id);
    }

    public Iterable<Produsen> list() {
        return dao.findAll();
    }

    @Transactional
    public Produsen save(Produsen value) {
        return dao.save(value);
    }

    @Transactional
    public void update(ProdusenDto.Update value){
        dao.update(value);
    }

    @Transactional
    public void delete(Integer id){
        dao.delete(id);
    }
}
